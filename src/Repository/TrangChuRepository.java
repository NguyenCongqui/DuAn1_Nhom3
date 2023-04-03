/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import ViewModel.KhachHangTrangChuViewModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TrangChuRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<KhachHangTrangChuViewModel> ListkhachHang = null;

    public TrangChuRepository() {
    }
    
     public  int getTongDoanhTHu(){
        String select="""
                      SELECT CAST(SUM(dbo.CHITIETHOADONBAN.DonGia * dbo.CHITIETHOADONBAN.SoLuong) AS INT) DoanhThuMotNgay FROM dbo.CHITIETHOADONBAN 
                      JOIN dbo.HOADONBAN ON HOADONBAN.IDHOADONBAN = CHITIETHOADONBAN.IDHOADONBAN
                      WHERE YEAR(dbo.HoaDonBan.ngayTao) = YEAR(GETDATE()) AND
                      MONTH(dbo.HoaDonBan.ngayTao) = MONTH(GETDATE()) AND DAY(dbo.HoaDonBan.ngayTao) = DAY(GETDATE())
                      """;
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                return rs.getInt("DoanhThuMotNgay");
            }
        } catch (Exception e) {
        }
        return 0;
    }
      public  int getTongKhachHang(){
        String select="SELECT COUNT(IDKHACHHANG) TongKhachHang FROM dbo.KHACHHANG";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                return rs.getInt("TongKhachHang");
            }
        } catch (Exception e) {
        }
        return 0;
    }
      public  int getTongSanPham(){
        String select="SELECT SUM(SoLuong) soluong FROM dbo.HOADONBAN JOIN dbo.CHITIETHOADONBAN ON CHITIETHOADONBAN.IDHOADONBAN = HOADONBAN.IDHOADONBAN\n" +
"              WHERE YEAR(ngayTao) = YEAR(GETDATE()) AND MONTH(ngayTao) = MONTH(GETDATE()) AND DAY(ngayTao) = DAY(GETDATE())";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                return rs.getInt("soluong");
            }
        } catch (Exception e) {
        }
        return 0;
    }
      public  int getTongTonKho(){
        String select="SELECT SUM(SOLUONGTON) soluongton FROM dbo.CHITIETSANPHAM";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                return rs.getInt("soluongton");
            }
        } catch (Exception e) {
        }
        return 0;
    }
      public List<KhachHangTrangChuViewModel> getlistkhachHang(){
        ListkhachHang = new ArrayList<>();
        String select = "";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {                
                ListkhachHang.add(new KhachHangTrangChuViewModel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getBoolean(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return ListkhachHang;
    }
      
}
