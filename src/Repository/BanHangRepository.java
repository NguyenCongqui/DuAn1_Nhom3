/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.DanhMuc;
import DomainModel.HoaDonBan;
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
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<HoaDonBan> ListHoaDon = null;
    List<SanPhamViewModel> sanPhamBanHangs = null;

    public Boolean saveHoaDon(HoaDonViewModel hoaDon) {

        int checkInsert = 0;

        String sql
                = "INSERT INTO [dbo].[HOADONBAN] ([IDUSERS] ,[ngayTao],[TRANGTHAI])VALUES(?,?,?) ";
//               "INSERT INTO [dbo].[HOADONBAN] ([ngayTao] ,[TRANGTHAI])VALUES(?,?)";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
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

    public String insert(HoaDonBan hdbh, Integer id) {
        String insert = "UPDATE dbo.HOADONBAN SET IDKHACHHANG = ?,IDVOUCHER = ?,NGAYTHANHTOAN = GETDATE(),\n"
                + "					 TENKhachHang = ?,statusPay=?,statusInvoice = ?,TONGTIEN = ?,TIENKHACHDUA = ?,\n"
                + "					 TIENTRALAI = ?, TRANGTHAI = ?,GHICHU = ?,TONGCONGTIENPHAITRA = ? , TIENVOUCHER = ? WHERE IDHOADONBAN = ?";

        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setInt(1, hdbh.getIdKhachHang());
            pst.setObject(2, hdbh.getIdVoucher());

            pst.setString(3, hdbh.getTenKhachHang());
            pst.setBoolean(4, hdbh.isTrangThaiTraTien());
            pst.setBoolean(5, hdbh.isTrangThaiHoaDon());
            pst.setFloat(6, hdbh.getTongTien());
            pst.setFloat(7, hdbh.getTienKhachDua());
            pst.setFloat(8, hdbh.getTienTraLai());
            pst.setInt(9, hdbh.getTrangThai());
            pst.setString(10, hdbh.getGhiChu());
            pst.setFloat(11, hdbh.getTongCongTienPhaiTra());
            pst.setFloat(12, hdbh.getTienApVoucher());
            pst.setInt(13, id);
            pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {

        }
        return "Them khong thanh cong";
    }

    public String upDateTrangThaiHuy(Integer id) {
        String insert = "UPDATE dbo.HOADONBAN SET TRANGTHAI = 2 WHERE IDHOADONBAN = ?";

        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setInt(1, id);

            pst.executeUpdate();
            return "Hủy Hóa Đơn Thành Công";
        } catch (Exception e) {

        }
        return "Hủy Hóa Đơn Không Thành Công";
    }

// gọi list hoa don 
    public ArrayList<HoaDonViewModel> getListHoaDon() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql
                = //                "SELECT * from HOADONBAN";
                "SELECT dbo.HOADONBAN.IDHOADONBAN, dbo.HOADONBAN.ngayTao, "
                + "dbo.HOADONBAN.TRANGTHAI, dbo.USERS.HOTEN FROM   "
                + "dbo.HOADONBAN INNER JOIN dbo.USERS ON dbo.HOADONBAN.IDUSERS = "
                + "dbo.USERS.IDUSERS ORDER BY dbo.HOADONBAN.ngayTao DESC";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
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
            sanPhamBanHangs = new ArrayList<>();
            sanPhamBanHangs = new ArrayList<>();
            Connection conn = dBConnection.getConnection();
            String sql = """
                
SELECT dbo.CHITIETSANPHAM.SOIMEI, dbo.SANPHAM.TENSANPHAM,SOLUONGTON ,dbo.DANHMUC.TENDANHMUC, dbo.BONHOTRONG.TENBONHOTRONG, TENMAUSAC ,dbo.CHITIETSANPHAM.GIABAN
FROM   dbo.CHITIETSANPHAM INNER JOIN
             dbo.SANPHAM ON dbo.CHITIETSANPHAM.IDSANPHAM = dbo.SANPHAM.IDSANPHAM INNER JOIN
             dbo.BONHOTRONG ON dbo.CHITIETSANPHAM.IDBONHOTRONG = dbo.BONHOTRONG.IDBONHOTRONG INNER JOIN
             dbo.DANHMUC ON dbo.SANPHAM.IDDANHMUC = dbo.DANHMUC.IDDANHMUC INNER JOIN
             dbo.MAUSAC ON MAUSAC.IDMAUSAC = CHITIETSANPHAM.IDMAUSAC
			 WHERE
			 CHITIETSANPHAM.TRANGTHAI = 0 and CHITIETSANPHAM.SOLUONGTON =1 ORDER BY CHITIETSANPHAM.NGAYTAO DESC
                         """;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanPhamBanHangs.add(new SanPhamViewModel(
                        rs.getString("SOIMEI"),
                        rs.getString("TENSANPHAM"),
                        rs.getString("TENDANHMUC"),
                        rs.getString("TENMAUSAC"),
                        rs.getString("TENBONHOTRONG"),
                        rs.getFloat("GIABAN"),
                        rs.getInt("SOLUONGTON")));

            }

            return sanPhamBanHangs;
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<HoaDonChiTietViewModel> getGioHang(int Id) {
        try {
            List<HoaDonChiTietViewModel> list = new ArrayList<>();
            Connection conn = dBConnection.getConnection();
            String sql = "			 SELECT dbo.SANPHAM.IDSANPHAM, dbo.SANPHAM.TENSANPHAM, dbo.CHITIETHOADONBAN.SoLuong, dbo.CHITIETSANPHAM.SOIMEI, dbo.CHITIETHOADONBAN.DonGia\n"
                    + "FROM   dbo.CHITIETHOADONBAN INNER JOIN\n"
                    + "             dbo.CHITIETSANPHAM ON dbo.CHITIETHOADONBAN.SOIMEI = dbo.CHITIETSANPHAM.SOIMEI INNER JOIN\n"
                    + "             dbo.HOADONBAN ON dbo.CHITIETHOADONBAN.IDHOADONBAN = dbo.HOADONBAN.IDHOADONBAN INNER JOIN\n"
                    + "             dbo.SANPHAM ON dbo.CHITIETSANPHAM.IDSANPHAM = dbo.SANPHAM.IDSANPHAM WHERE CHITIETHOADONBAN.IDHOADONBAN = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Id);
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

    public int getTongTien(float id) {
        try {
            int max = 0;
            Connection conn = dBConnection.getConnection();
            String sql = "			 SELECT Sum(SoLuong * DonGia) as 'TongTien' FROM CHITIETHOADONBAN where IDHOADONBAN = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, id);
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
                    + "dbo.USERS ON dbo.HOADONBAN.IDUSERS = dbo.USERS.IDUSERS WHERE dbo.HOADONBAN.TRANGTHAI = ?"
                    + " ORDER BY dbo.HOADONBAN.ngayTao DESC ";
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

    public List<SanPhamViewModel> search(String temp) {
        List<SanPhamViewModel> listTemp = new ArrayList<>();
        for (SanPhamViewModel x : sanPhamBanHangs) {
            if (x.getSoImei().contains(temp)) {
                listTemp.add(x);
            }
        }
        return listTemp;
    }

    public List<SanPhamViewModel> searchDanhMuc(String temp) {
        List<SanPhamViewModel> listTemp = new ArrayList<>();
        for (SanPhamViewModel x : sanPhamBanHangs) {
            if (x.getTenDanhMuc().contains(temp)) {
                listTemp.add(x);
            }
        }
        return listTemp;
    }

    public List<SanPhamViewModel> searchMauSac(String temp) {
        List<SanPhamViewModel> listTemp = new ArrayList<>();
        for (SanPhamViewModel x : sanPhamBanHangs) {
            if (x.getMauSac().contains(temp)) {
                listTemp.add(x);
            }
        }
        return listTemp;
    }

    public List<SanPhamViewModel> searchDungLuong(String temp) {
        List<SanPhamViewModel> listTemp = new ArrayList<>();
        for (SanPhamViewModel x : sanPhamBanHangs) {
            if (x.getTenDungLuong().contains(temp)) {
                listTemp.add(x);
            }
        }
        return listTemp;
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
