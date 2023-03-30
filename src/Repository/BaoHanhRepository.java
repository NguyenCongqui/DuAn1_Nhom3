/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import ViewModel.BaoHanhViewModel;
import ViewModel.CTHDViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanhv
 */
public class BaoHanhRepository {

    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;

    public List<CTHDViewModel> selectById(int id) {
        String sql = "SELECT dbo.HOADONBAN.IDHOADONBAN, dbo.CHITIETHOADONBAN.IDCHITIETHOADONBAN, dbo.SANPHAM.TENSANPHAM, dbo.CHITIETHOADONBAN.SoLuong, dbo.DANHMUC.TENDANHMUC, dbo.BONHOTRONG.TENBONHOTRONG, dbo.MAUSAC.TENMAUSAC, \n" +
"             dbo.CHITIETHOADONBAN.DonGia, dbo.KHACHHANG.HOTEN, dbo.KHACHHANG.IDKHACHHANG, dbo.HOADONBAN.NGAYTHANHTOAN, dbo.CHITIETHOADONBAN.SOIMEI\n" +
"FROM   dbo.BONHOTRONG INNER JOIN\n" +
"             dbo.CHITIETSANPHAM ON dbo.BONHOTRONG.IDBONHOTRONG = dbo.CHITIETSANPHAM.IDBONHOTRONG INNER JOIN\n" +
"             dbo.CHITIETHOADONBAN ON dbo.CHITIETSANPHAM.SOIMEI = dbo.CHITIETHOADONBAN.SOIMEI INNER JOIN\n" +
"             dbo.HOADONBAN ON dbo.CHITIETHOADONBAN.IDHOADONBAN = dbo.HOADONBAN.IDHOADONBAN INNER JOIN\n" +
"             dbo.KHACHHANG ON dbo.HOADONBAN.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG INNER JOIN\n" +
"             dbo.MAUSAC ON dbo.CHITIETSANPHAM.IDMAUSAC = dbo.MAUSAC.IDMAUSAC INNER JOIN\n" +
"             dbo.SANPHAM ON dbo.CHITIETSANPHAM.IDSANPHAM = dbo.SANPHAM.IDSANPHAM INNER JOIN\n" +
"             dbo.DANHMUC ON dbo.SANPHAM.IDDANHMUC = dbo.DANHMUC.IDDANHMUC";
        List<CTHDViewModel> list = new ArrayList<>();
        try {
            //st = db.getConnection().createStatement();
            pst = db.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                CTHDViewModel p = new CTHDViewModel();
                p.setIdHoaDon(rs.getInt("IDHOADONBAN"));
                p.setSoImei(rs.getString("SOIMEI"));
                p.setTenSP(rs.getString("TENSANPHAM"));
                p.setDonGia(rs.getFloat("DonGia"));
                p.setSoLuong(rs.getInt("SoLuong"));
                p.setDanhMuc(rs.getString("TENDANHMUC"));
                p.setMauSac(rs.getString("TENMAUSAC"));
                p.setDungLuong(rs.getString("TENBONHOTRONG"));
                p.setTenKH(rs.getString("TENKhachHang"));
                p.setIdKH(rs.getInt("IDKHACHHANG"));
                p.setNgayTao(rs.getString("NGAYTHANHTOAN"));
                list.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaoHanhRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
     public List<BaoHanhViewModel> selectDangBH() {
        String sql = "SELECT dbo.BAOHANH.IDBAOHANH, dbo.BAOHANH.NGAYTAO, dbo.BAOHANH.NGAYBAOHANH, dbo.BAOHANH.NGAYSUA, dbo.BAOHANH.IDUSERS, dbo.BAOHANH.IDKHACHHANG, dbo.BAOHANH.TRANGTHAI, dbo.BAOHANH.GHICHU, dbo.BAOHANH.IDHOADONBAN, \n" +
"dbo.KHACHHANG.HOTEN FROM   dbo.BAOHANH INNER JOIN\n" +
"dbo.KHACHHANG ON dbo.BAOHANH.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG WHERE BAOHANH.TRANGTHAI = 0 ORDER BY IDBAOHANH DESC";
        List<BaoHanhViewModel> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaoHanhViewModel p = new BaoHanhViewModel();
                p.setIdHDBH(rs.getInt("IDBAOHANH"));
                p.setIdHDBan(rs.getInt("IDHOADONBAN"));
                p.setThoiGian(rs.getDate("NGAYTAO"));
                p.setIdKhachHang(rs.getInt("IDKHACHHANG"));
                p.setGhiChu(rs.getString("GHICHU"));
                p.setKhachHang(rs.getString("HOTEN"));

                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
     
      public List<BaoHanhViewModel> selectDaBH() {
        String sql = "SELECT dbo.BAOHANH.IDBAOHANH, dbo.BAOHANH.NGAYTAO, dbo.BAOHANH.NGAYBAOHANH, dbo.BAOHANH.NGAYSUA, dbo.BAOHANH.IDUSERS, dbo.BAOHANH.IDKHACHHANG, dbo.BAOHANH.TRANGTHAI, dbo.BAOHANH.GHICHU, dbo.BAOHANH.IDHOADONBAN, \n" +
"dbo.KHACHHANG.HOTEN FROM   dbo.BAOHANH INNER JOIN\n" +
"dbo.KHACHHANG ON dbo.BAOHANH.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG WHERE BAOHANH.TRANGTHAI = 1 ORDER BY IDBAOHANH DESC";
        List<BaoHanhViewModel> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaoHanhViewModel p = new BaoHanhViewModel();
                p.setIdHDBH(rs.getInt("IDBAOHANH"));
                p.setIdHDBan(rs.getInt("IDHOADONBAN"));
                p.setThoiGian(rs.getDate("NGAYTAO"));
                p.setIdKhachHang(rs.getInt("IDKHACHHANG"));
                p.setGhiChu(rs.getString("GHICHU"));
                p.setKhachHang(rs.getString("HOTEN"));

                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
