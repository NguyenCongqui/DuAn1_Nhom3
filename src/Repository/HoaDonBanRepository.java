/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import ViewModel.CTHDBanViewModel;
import ViewModel.HoaDonViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.logiin.XDate;

/**
 *
 * @author vanhv
 */
public class HoaDonBanRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<CTHDBanViewModel> listCTBvmd = null;
    List<HoaDonViewModel> listViewMD = null;
    
    public List<CTHDBanViewModel> selectByIdBan(int id) {
        String sql = """
                     	SELECT dbo.CHITIETHOADONBAN.IDCHITIETHOADONBAN,CHITIETHOADONBAN.SOIMEI, dbo.SANPHAM.TENSANPHAM, dbo.KHACHHANG.HOTEN, dbo.DANHMUC.TENDANHMUC, dbo.LOAIPIN.TELOAIPIN, dbo.BONHOTRONG.TENBONHOTRONG, dbo.CHITIETHOADONBAN.DonGia
                     FROM   dbo.CHITIETHOADONBAN INNER JOIN
                                  dbo.CHITIETSANPHAM ON dbo.CHITIETHOADONBAN.SOIMEI = dbo.CHITIETSANPHAM.SOIMEI INNER JOIN
                                  dbo.HOADONBAN ON dbo.CHITIETHOADONBAN.IDHOADONBAN = dbo.HOADONBAN.IDHOADONBAN INNER JOIN
                                  dbo.SANPHAM ON dbo.CHITIETSANPHAM.IDSANPHAM = dbo.SANPHAM.IDSANPHAM INNER JOIN
                                  dbo.KHACHHANG ON dbo.HOADONBAN.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG INNER JOIN
                                  dbo.BONHOTRONG ON dbo.CHITIETSANPHAM.IDBONHOTRONG = dbo.BONHOTRONG.IDBONHOTRONG INNER JOIN
                                  dbo.DANHMUC ON dbo.SANPHAM.IDDANHMUC = dbo.DANHMUC.IDDANHMUC INNER JOIN
                                  dbo.LOAIPIN ON dbo.CHITIETSANPHAM.IDLOAIPIN = dbo.LOAIPIN.IDLOAIPIN 
                     			 WHERE CHITIETHOADONBAN.IDCHITIETHOADONBAN = ?
                     """;
                 
        try {
            //st = db.getConnection().createStatement();
            pst = db.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            listCTBvmd = new ArrayList<>();
            while (rs.next()) {
                CTHDBanViewModel de = new CTHDBanViewModel();
                de.setIdCTHoaDonBan(rs.getInt("IDCHITIETHOADONBAN"));
//                de.setSoLuong(rs.getInt("SoLuong"));
                de.setDonGia(rs.getFloat("DonGia"));
                de.setDanhMuc(rs.getString("TENDANHMUC"));
                de.setDungLuong(rs.getString("TENBONHOTRONG"));
                de.setMauSac(rs.getString("TELOAIPIN"));
                de.setTenSanPham(rs.getString("TENSANPHAM"));
                de.setTenKhachHang(rs.getString("HOTEN"));
                de.setSoImei(rs.getString("SOIMEI"));
                listCTBvmd.add(de);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBanRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCTBvmd;
    }
    
    
       public List<HoaDonViewModel> getAll(String Stringdate) {
        if (!Stringdate.isEmpty()) {
            java.util.Date date = XDate.toDate(Stringdate, "yyyy-MM-dd");
            String sql = " SELECT  * FROM dbo.HOADONBAN INNER JOIN\n" +
"dbo.KHACHHANG ON dbo.HOADONBAN.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG INNER JOIN\n" +
"dbo.USERS ON dbo.HOADONBAN.IDUSERS = dbo.USERS.IDUSERS WHERE HoaDonBan.TrangThai = 0 AND HoaDonBan.NGAYTHANHTOAN  BETWEEN '" + new java.sql.Date(date.getTime()) + " 00:00:00.000'" + "AND '" + new java.sql.Date(date.getTime()) + " 23:59:59.000' \n"
                    + "ORDER BY  HoaDonBan.NGAYTHANHTOAN DESC";
            try {
                st = db.getConnection().createStatement();
                rs = st.executeQuery(sql);
                listViewMD = new ArrayList<>();
                while (rs.next()) {
                    HoaDonViewModel i = new HoaDonViewModel();
                    i.setIdHDB(rs.getInt("IDHOADONBAN"));
                    i.setIdKhachHang(rs.getInt("IDKHACHHANG"));
                    i.setIdUser(rs.getInt("IDUSERS"));
                    i.setIsVoucher(rs.getInt("IDVOUCHER"));
                    i.setNgayThanhToan(rs.getString("NGAYTHANHTOAN"));
                    i.setGhiChu(rs.getString("GhiChu"));
//                    i.setStatusPay(rs.getBoolean("statusPay"));
//                    i.setStatusInvoice(rs.getBoolean("statusInvoice"));
                    i.setTenKhachHang(rs.getString(17));
                    i.setTenUser(rs.getString(25));
                    i.setTongTien(rs.getFloat("TONGTIEN"));
                    i.setTienKhachDua(rs.getFloat("TIENKHACHDUA"));
                    i.setTienTraLai(rs.getFloat("TIENTRALAI"));
                    listViewMD.add(i);
                }
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(HoaDonBanRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return listViewMD;
        }
        String sql = " SELECT  * FROM dbo.HOADONBAN INNER JOIN\n" +
"dbo.KHACHHANG ON dbo.HOADONBAN.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG INNER JOIN\n" +
"dbo.USERS ON dbo.HOADONBAN.IDUSERS = dbo.USERS.IDUSERS WHERE HoaDonBan.TrangThai = 0 \n" +
"ORDER BY  HoaDonBan.NGAYTHANHTOAN DESC";
       try {
                st = db.getConnection().createStatement();
                rs = st.executeQuery(sql);
                listViewMD = new ArrayList<>();
                while (rs.next()) {
                    HoaDonViewModel i = new HoaDonViewModel();
                    i.setIdHDB(rs.getInt("IDHOADONBAN"));
                    i.setIdKhachHang(rs.getInt("IDKHACHHANG"));
                    i.setIdUser(rs.getInt("IDUSERS"));
                    i.setIsVoucher(rs.getInt("IDVOUCHER"));
                    i.setNgayThanhToan(rs.getString("NGAYTHANHTOAN"));
                    i.setGhiChu(rs.getString("GhiChu"));
//                    i.setStatusPay(rs.getBoolean("statusPay"));
//                    i.setStatusInvoice(rs.getBoolean("statusInvoice"));
                    i.setTenKhachHang(rs.getString(17));
                    i.setTenUser(rs.getString(25));
                    i.setTongTien(rs.getFloat("TONGTIEN"));
                    i.setTienKhachDua(rs.getFloat("TIENKHACHDUA"));
                    i.setTienTraLai(rs.getFloat("TIENTRALAI"));
                    listViewMD.add(i);
                }
                rs.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBanRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listViewMD;
    }
       
       
         public int ThoiGian(String Stringdate) {
        ResultSet rs;
        if (!Stringdate.isEmpty()) {
            java.util.Date date = XDate.toDate(Stringdate, "yyyy-MM-dd");
            String sql = " SELECT COUNT(*) as soLuong FROM dbo.HOADONBAN WHERE NGAYTHANHTOAN BETWEEN '" + new java.sql.Date(date.getTime()) + " '" + "AND '" + new java.sql.Date(date.getTime()) + " ' ";
            try {
                pst = db.getConnection().prepareStatement(sql);
            pst.setObject(1, Stringdate);
            rs = pst.executeQuery();
                while (rs.next()) {
                    return rs.getInt("soLuong");
                }
                rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        String sql = "SELECT COUNT(*) as soLuong FROM dbo.HOADONBAN ";
        try {
             pst = db.getConnection().prepareStatement(sql);
             rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("soLuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
         
         
          public HoaDonViewModel FindHDB(int k) {
        String sql = "SELECT dbo.HOADONBAN.IDHOADONBAN, dbo.HOADONBAN.IDKHACHHANG, dbo.HOADONBAN.IDVOUCHER, dbo.HOADONBAN.NGAYTHANHTOAN, dbo.HOADONBAN.GHICHU, dbo.HOADONBAN.statusPay, dbo.HOADONBAN.statusInvoice, dbo.HOADONBAN.TONGTIEN, \n" +
"             dbo.HOADONBAN.TIENKHACHDUA, dbo.HOADONBAN.TIENTRALAI, dbo.HOADONBAN.TENKhachHang, dbo.USERS.IDUSERS, dbo.USERS.HOTEN\n" +
"FROM   dbo.HOADONBAN INNER JOIN\n" +
"             dbo.KHACHHANG ON dbo.HOADONBAN.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG INNER JOIN\n" +
"             dbo.USERS ON dbo.HOADONBAN.IDUSERS = dbo.USERS.IDUSERS where HOADONBAN.TRANGTHAI = 0 AND IDHOADONBAN = ?";
        List<HoaDonViewModel > list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, k);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HoaDonViewModel i = new HoaDonViewModel();
                i.setIdHDB(rs.getInt("IDHOADONBAN"));
                i.setIdKhachHang(rs.getInt("IDKHACHHANG"));
                i.setIdUser(rs.getInt("IDUSERS"));
                i.setIsVoucher(rs.getInt("IDVOUCHER"));
                i.setNgayThanhToan(rs.getString("NGAYTHANHTOAN"));
                i.setGhiChu(rs.getString("GHICHU"));
//                i.setStatusPay(rs.getBoolean("statusPay"));
//                i.setStatusInvoice(rs.getBoolean("statusInvoice"));
                i.setTenKhachHang(rs.getString("TENKhachHang"));
                i.setTenUser(rs.getString("HOTEN"));
                i.setTongTien(rs.getFloat("TONGTIEN"));
                i.setTienKhachDua(rs.getFloat("TIENKHACHDUA"));
                i.setTienTraLai(rs.getFloat("TIENTRALAI"));
                return i;
                // listHDNhap.add(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBanRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
