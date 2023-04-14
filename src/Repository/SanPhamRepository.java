/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.SanPham;
import Service.Impl.AnhService;
import Utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trung
 */
public class SanPhamRepository {
    public List<SanPham> getAll() throws SQLException{
        List<SanPham> SanPhams = new ArrayList();
        Connection conn = (Connection) DBConnection.getConnection();
        String sql = "select IDSANPHAM,TENSANPHAM,IDDANHMUC,ANH,TRANGTHAI from SANPHAM ORDER BY NGAYTAO DESC";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            Integer id = rs.getInt("IDSANPHAM");
            String tenSp = rs.getString("TENSANPHAM");
            Integer danhMuc = Integer.parseInt(rs.getString("IDDANHMUC"));
            String anh = rs.getString("ANH");
            boolean trangThai = rs.getBoolean("TRANGTHAI");
            
            SanPham s = new SanPham(id, tenSp, danhMuc, anh, trangThai);
            SanPhams.add(s);
        }
        rs.close();
        ps.close();
        conn.close();
        return SanPhams;
    }
    public SanPham fill(Integer danhmuc) throws SQLException{
        SanPham sp = new SanPham();
        Connection conn = (Connection) DBConnection.getConnection();
        String sql = "select IDSANPHAM,TENSANPHAM,IDDANHMUC,ANH,TRANGTHAI from SANPHAM where IDSANPHAM = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, danhmuc);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            Integer id = rs.getInt("IDSANPHAM");
            String tenSp = rs.getString("TENSANPHAM");
            Integer danhMuc = Integer.parseInt(rs.getString("IDDANHMUC"));
            String anh = rs.getString("ANH");
            boolean trangThai = rs.getBoolean("TRANGTHAI");
            
            sp = new SanPham(id, tenSp, danhMuc, anh, trangThai);

        }
        rs.close();
        ps.close();
        conn.close();
        return sp;
    }
    public boolean them(SanPham sanpham) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "insert into SANPHAM (TENSANPHAM,IDDANHMUC,ANH,TRANGTHAI,NGAYTAO) values (?,?,?,0, GETDATE())";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, sanpham.getTen());
        ps.setInt(2, sanpham.getDanhMuc());
        ps.setString(3, sanpham.getAnh());
        int index = ps.executeUpdate();
        if(index == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean sua(SanPham sanpham, Integer id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "update SANPHAM set TENSANPHAM = ?, IDDANHMUC = ?, ANH = ? where IDSANPHAM = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, sanpham.getTen());
        ps.setInt(2, sanpham.getDanhMuc());
        ps.setString(3, sanpham.getAnh());
        ps.setInt(4, id);
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
        String sql = "Update SANPHAM set TRANGTHAI = 1 where IDSANPHAM = ?";
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
