/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.HeDieuHanh;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author trung
 */
public class HeDieuHanhRepo {
    public List<HeDieuHanh> getAll() throws SQLException{
        List<HeDieuHanh> HDH  = new ArrayList();
        Connection conn = DBConnection.getConnection();
        String sql = "select IDHEDIEUHANH,TENHEDIEUHANH,NGAYTAO,NGAYSUA,TRANGTHAI from HEDIEUHANH order by IDHEDIEUHANH desc";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            Integer Id = rs.getInt("IDHEDIEUHANH");
            String Ten = rs.getString("TENHEDIEUHANH");
             Date ngayTao = rs.getDate("NGAYTAO");
                Date ngaySua = rs.getDate("NGAYSUA");
            boolean trangThai = rs.getBoolean("TRANGTHAI");
            HeDieuHanh heDieuHanh = new HeDieuHanh(Id, Ten, trangThai,ngayTao,ngaySua);
            HDH.add(heDieuHanh);
        }
        rs.close();
        ps.close();
        conn.close();
        return HDH;
    }
    
    public boolean them(HeDieuHanh hDH) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "insert into HEDIEUHANH(TENHEDIEUHANH,TRANGTHAI,NGAYTAO) values(?,0,GETDATE())";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, hDH.getTen());
        int index = ps.executeUpdate();
        if(index == 0 ){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean sua(HeDieuHanh heDieuHanh , Integer id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "Update HEDIEUHANH set TENHEDIEUHANH = ?,NGAYSUA = GETDATE() where IDHEDIEUHANH = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(2, id);
        ps.setString(1, heDieuHanh.getTen());
        int index = ps.executeUpdate();
        ps.close();
        conn.close();
        if(index == 0){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean  xoa(Integer id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "Update HEDIEUHANH set TRANGTHAI = 1 where IDHEDIEUHANH = ?";
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
