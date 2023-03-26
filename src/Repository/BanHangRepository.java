/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.DanhMuc;
import Utilities.DBConnection;
import ViewModel.HoaDonChiTietViewModel;
import ViewModel.HoaDonViewModel;
import ViewModel.SanPhamViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.logiin.Auth;

/**
 *
 * @author vanhv
 */
public class BanHangRepository {

    private DBConnection dBConnection;

    public Boolean saveHoaDon(HoaDonViewModel hoaDon) {

        int checkInsert = 0;

        String sql
                = "INSERT INTO [dbo].[HOADONBAN] ([IDUSERS] ,[ngayTao],[TRANGTHAI])VALUES(?,?,?) ";
//               "INSERT INTO [dbo].[HOADONBAN] ([ngayTao] ,[TRANGTHAI])VALUES(?,?)";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hoaDon.getIdUser());
            ps.setObject(2, hoaDon.getNgayTao());
            ps.setObject(3, hoaDon.getTrangThai());
            checkInsert = ps.executeUpdate();
            return checkInsert > 0;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public ArrayList<HoaDonViewModel> getListHoaDon() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql
                = //                "SELECT * from HOADONBAN";
                "SELECT dbo.HOADONBAN.IDHOADONBAN, dbo.HOADONBAN.ngayTao, "
                + "dbo.HOADONBAN.TRANGTHAI, dbo.USERS.HOTEN FROM   dbo.HOADONBAN INNER JOIN dbo.USERS ON dbo.HOADONBAN.IDUSERS = dbo.USERS.IDUSERS ORDER BY dbo.HOADONBAN.ngayTao DESC";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModel hoaDon = new HoaDonViewModel();
                hoaDon.setIdHDB(rs.getInt("IDHOADONBAN"));
                hoaDon.setNgayTao(rs.getString("ngayTao"));
                hoaDon.setTrangThai(rs.getInt("TRANGTHAI"));
                hoaDon.setTenUser(rs.getString("HOTEN"));
                list.add(hoaDon);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return list;
    }

    public List<SanPhamViewModel> getListSP() {
        try {
            List<SanPhamViewModel> sanPhamBanHangs = new ArrayList<>();
            sanPhamBanHangs = new ArrayList<>();
            Connection conn = dBConnection.getConnection();
            String sql = """
SELECT dbo.CHITIETSANPHAM.SOIMEI, dbo.SANPHAM.TENSANPHAM, dbo.DANHMUC.TENDANHMUC, dbo.BONHOTRONG.TENBONHOTRONG, dbo.LOAIPIN.TELOAIPIN, dbo.SANPHAM.ANH, dbo.CHITIETSANPHAM.GIABAN
FROM   dbo.CHITIETSANPHAM INNER JOIN
             dbo.SANPHAM ON dbo.CHITIETSANPHAM.IDSANPHAM = dbo.SANPHAM.IDSANPHAM INNER JOIN
             dbo.BONHOTRONG ON dbo.CHITIETSANPHAM.IDBONHOTRONG = dbo.BONHOTRONG.IDBONHOTRONG INNER JOIN
             dbo.DANHMUC ON dbo.SANPHAM.IDDANHMUC = dbo.DANHMUC.IDDANHMUC INNER JOIN
             dbo.LOAIPIN ON dbo.CHITIETSANPHAM.IDLOAIPIN = dbo.LOAIPIN.IDLOAIPIN WHERE CHITIETSANPHAM.TRANGTHAI = 0 ORDER BY CHITIETSANPHAM.NGAYTAO DESC""";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanPhamBanHangs.add(new SanPhamViewModel(
                        rs.getString("SOIMEI"),
                        rs.getString("TENSANPHAM"),
                        rs.getString("TENDANHMUC"),
                        rs.getString("TENBONHOTRONG"),
                        rs.getString("TELOAIPIN"),
                        rs.getFloat("GIABAN"),
                        rs.getString("ANH")));
            }

            return sanPhamBanHangs;
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<HoaDonChiTietViewModel> getGioHang(String Id) {
        try {
            List<HoaDonChiTietViewModel> list = new ArrayList<>();
            Connection conn = dBConnection.getConnection();
            String sql = "			 SELECT dbo.SANPHAM.IDSANPHAM, dbo.SANPHAM.TENSANPHAM, dbo.CHITIETHOADONBAN.SoLuong, dbo.CHITIETSANPHAM.SOIMEI, dbo.CHITIETHOADONBAN.DonGia\n"
                    + "FROM   dbo.CHITIETHOADONBAN INNER JOIN\n"
                    + "             dbo.CHITIETSANPHAM ON dbo.CHITIETHOADONBAN.SOIMEI = dbo.CHITIETSANPHAM.SOIMEI INNER JOIN\n"
                    + "             dbo.HOADONBAN ON dbo.CHITIETHOADONBAN.IDHOADONBAN = dbo.HOADONBAN.IDHOADONBAN INNER JOIN\n"
                    + "             dbo.SANPHAM ON dbo.CHITIETSANPHAM.IDSANPHAM = dbo.SANPHAM.IDSANPHAM WHERE CHITIETHOADONBAN.IDHOADONBAN = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDonChiTietViewModel(rs.getString("SOIMEI"), rs.getString("TENSANPHAM"), rs.getInt("SoLuong"), rs.getInt("DonGia")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTongTien(String id) {
        try {
            int max = 0;
            Connection conn = dBConnection.getConnection();
            String sql = "			 SELECT Sum(SoLuong * DonGia) as 'TongTien' FROM CHITIETHOADONBAN where IDHOADONBAN = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                max = rs.getInt("TongTien");
            }
            return max;
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<HoaDonViewModel> getListtt(int i) {
        try {
            List<HoaDonViewModel> hoaDons = new ArrayList<>();
            Connection conn = dBConnection.getConnection();
            String sql = "SELECT dbo.HOADONBAN.IDHOADONBAN, dbo.HOADONBAN.ngayTao, \n"
                    + "dbo.HOADONBAN.TRANGTHAI, dbo.USERS.HOTEN FROM   dbo.HOADONBAN INNER JOIN \n"
                    + "dbo.USERS ON dbo.HOADONBAN.IDUSERS = dbo.USERS.IDUSERS WHERE dbo.HOADONBAN.TRANGTHAI = ? ORDER BY dbo.HOADONBAN.ngayTao DESC ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hoaDons.add(new HoaDonViewModel(
                        rs.getInt("IDHOADONBAN"),
                        rs.getString("ngayTao"),
                        rs.getInt("TRANGTHAI"),
                        rs.getString("HOTEN"))
                );
            }
            return hoaDons;
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    List<SanPhamViewModel> list;
//
//    public List<SanPhamViewModel> searchDanhMuc(String temp) {
//        try {
//            String sql = " SELECT dbo.SANPHAM.IDSANPHAM, dbo.SANPHAM.TENSANPHAM, dbo.DANHMUC.TENDANHMUC, dbo.BONHOTRONG.TENBONHOTRONG, \n" +
//"                         dbo.LOAIPIN.TELOAIPIN, dbo.CHITIETSANPHAM.SOLUONGTON, dbo.CHITIETSANPHAM.GIANHAP, dbo.CHITIETSANPHAM.GIABAN, dbo.CHITIETSANPHAM.ANH\n" +
//" FROM   dbo.BONHOTRONG INNER JOIN\n" +
//"              dbo.CHITIETSANPHAM ON dbo.BONHOTRONG.IDBONHOTRONG = dbo.CHITIETSANPHAM.IDBONHOTRONG INNER JOIN\n" +
//"              dbo.LOAIPIN ON dbo.CHITIETSANPHAM.IDLOAIPIN = dbo.LOAIPIN.IDLOAIPIN INNER JOIN\n" +
//"              dbo.SANPHAM ON dbo.CHITIETSANPHAM.IDSANPHAM = dbo.SANPHAM.IDSANPHAM INNER JOIN\n" +
//"              dbo.DANHMUC ON dbo.SANPHAM.IDDANHMUC = dbo.DANHMUC.IDDANHMUC where DANHMUC.TENDANHMUC LIKE '%"+temp+"%'  and DANHMUC.TRANGTHAI = 0\n" +
//"order by DANHMUC.TENDANHMUC asc";
//            Connection conn = dBConnection.getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            list = new ArrayList<>();
//            while (rs.next()) {
//                while (rs.next()) {
//                    list.add(new SanPhamViewModel(
//                            rs.getInt("IDSANPHAM"),
//                            rs.getString("TENSANPHAM"),
//                            rs.getString("TENDANHMUC"),
//                            rs.getString("TELOAIPIN"),
//                            rs.getString("TENBONHOTRONG"),
//                            rs.getInt("SOLUONGTON"),
//                            rs.getFloat("GIABAN"),
//                            rs.getString("ANH")));
//                }
//            }
////        List<SanPhamViewModel> listTemp 
////        for (SanPhamViewModel danhMuc : list) {
////            if (danhMuc.getTenDanhMuc().equalsIgnoreCase(temp.toLowerCase())) {
////                listTemp.add(danhMuc);
////            }
////        }
////        return listTemp;
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }

    
//     public List<SanPhamViewModel> searchBNTrong(String temp) {
//        List<SanPhamViewModel> listTemp = new ArrayList<>();
//        for (SanPhamViewModel dongSP : list) {
//            if (dongSP.getTenDungLuong().equalsIgnoreCase(temp.toLowerCase())) {
//                listTemp.add(dongSP);
//            }
//        }
//        return listTemp;
//    }
}
