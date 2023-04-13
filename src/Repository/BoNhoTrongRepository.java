/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.BoNhoTrong;
import Utilities.DBConnection;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hodangquan
 */
public class BoNhoTrongRepository {
     public List<BoNhoTrong> getAll() throws SQLException{
        List<BoNhoTrong> bonNhoTrong = new ArrayList();
        Connection cnn = (Connection) DBConnection.getConnection();
        String sql = "select IDBONHOTRONG ,TENBONHOTRONG,NGAYTAO,NGAYSUA,TRANGTHAI from BONHOTRONG   order by IDBONHOTRONG desc";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {        
                Integer id = rs.getInt("IDBONHOTRONG");
                String tenSp = rs.getString("TENBONHOTRONG");
                Date ngayTao = rs.getDate("NGAYTAO");
                Date ngaySua = rs.getDate("NGAYSUA");
                boolean trangThai = rs.getBoolean("TRANGTHAI");
                BoNhoTrong bnt = new BoNhoTrong(id, tenSp, trangThai,ngaySua,ngayTao);
                bonNhoTrong.add(bnt);
        }
        rs.close();
        rs.close();
        cnn.close();
        return bonNhoTrong;
    }
    
    public boolean them(BoNhoTrong bonNhoTrong) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "insert into BONHOTRONG(TENBONHOTRONG, TRANGTHAI,NGAYTAO) values(?,0,GETDATE())";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, bonNhoTrong.getName());
        int index = ps.executeUpdate();
        if(index == 0 ){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean sua(BoNhoTrong boNhoTrong, Integer id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "Update BONHOTRONG set TENBONHOTRONG = ? ,NGAYSUA = GETDATE() where IDBONHOTRONG = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(2, id);
        ps.setString(1, boNhoTrong.getName());
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
        String sql = "Update BONHOTRONG set TRANGTHAI = 1 where IDBONHOTRONG = ?";
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
