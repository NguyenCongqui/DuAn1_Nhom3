/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.KhachHang;
import Utilities.DBConnection;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author hodangquan
 */
public class KhachHangRepository {
    public List<KhachHang> getAll() throws SQLException{
        List<KhachHang> khachHangs = new ArrayList();
        Connection conn = (Connection) DBConnection.getConnection();
        String sql = "select IDKHACHHANG,HOTEN,NGAYSINH,GIOITINH,SODIENTHOAI,DIACHI,TRANGTHAI from KHACHHANG";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            Integer id = rs.getInt("IDKHACHHANG");
            String hoTen = rs.getString("HOTEN");
            String ngaySinh = rs.getString("NGAYSINH");
            boolean gioiTinh = rs.getBoolean("GIOITINH");
            String soDienThoai = rs.getString("SODIENTHOAI");
            String diaChi = rs.getString("DIACHI");
            boolean trangThai = rs.getBoolean("TRANGTHAI");
            
            KhachHang khachHang = new KhachHang(id, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi,trangThai);
            khachHangs.add(khachHang);
        }
        rs.close();
        ps.close();
        conn.close();
        return khachHangs;
    }
    public KhachHang fill(Integer danhmuc) throws SQLException{
        KhachHang kh = new KhachHang();
        Connection conn = (Connection) DBConnection.getConnection();
        String sql = "select IDSANPHAM,HOTEN,NGAYSINH,GIOITINH,SODIENTHOAI,DIACHI,TRANGTHAI from KHACHHANG where IDKHACHHANG = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, danhmuc);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            Integer id = rs.getInt("IDKHACHHANG");
            String hoTen = rs.getString("HOTEN");
            String ngaySinh = rs.getString("NGAYSINH");
            boolean gioiTinh = rs.getBoolean("GIOITINH");
            String soDienThoai = rs.getString("SODIENTHOAI");
            String diaChi = rs.getString("DIACHI");
            boolean trangThai = rs.getBoolean("TRANGTHAI");
            
            KhachHang khachHang = new KhachHang(id, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi,trangThai);
        }
        rs.close();
        ps.close();
        conn.close();
        return kh;
    }
    public boolean them(KhachHang khachHang) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "insert into KHACHHANG (HOTEN,NGAYSINH,GIOITINH,SODIENTHOAI,DIACHI,TRANGTHAI) values (?,?,?,?,?,0)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, khachHang.getHoTen());
        ps.setString(2,  khachHang.getNgaySinh());
        ps.setBoolean(3, khachHang.isGioiTinh());
        ps.setString(4, khachHang.getSoDienThoai());
        ps.setString(5, khachHang.getDiaChi());
        
        
        int index = ps.executeUpdate();
        if(index == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean sua(KhachHang khachHang, Integer id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "update KHACHHANG set HOTEN = ?, NGAYSINH = ?, GIOITINH = ?, SODIENTHOAI = ?, DIACHI = ? where IDKHACHHANG = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, khachHang.getHoTen());
        ps.setString(2,  khachHang.getNgaySinh());
        ps.setBoolean(3, khachHang.isGioiTinh());
        ps.setString(4, khachHang.getSoDienThoai());
        ps.setString(5, khachHang.getDiaChi());
        ps.setInt(6, id);
        int index = ps.executeUpdate();
        ps.close();
        conn.close();
        if(index == 0){
            return false;
        }else{
            return true;
        }  
    }
    public boolean xoa(Integer id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "Update KHACHHANG set TRANGTHAI = 1 where IDKHACHHANG = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int index = ps.executeUpdate();
        ps.close();
        conn.close();
        if(index == 0){
            return false;
        }else{
            return true;
        }
    }
}
