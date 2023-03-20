/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.TanSoQuet;
import Utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trung
 */
public class TanSoQuetRepo {
    public List<TanSoQuet> getAll() throws SQLException{
        List<TanSoQuet> Quet = new ArrayList();
            Connection conn = DBConnection.getConnection();
            String sql = "select IDTANSOQUET ,TENTANSOQUET,TRANGTHAI from TANSOQUET";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           while (rs.next()) {            
               Integer Id = rs.getInt("IDTANSOQUET");
               String Ten = rs.getString("TENTANSOQUET");
               boolean TrangThai = rs.getBoolean("TRANGTHAI");
               TanSoQuet Q = new TanSoQuet(Id, Ten, TrangThai);
               Quet.add(Q);
        }
           rs.close();
           ps.close();
           conn.close();
        return Quet;
    }
    public boolean them(TanSoQuet Q) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "insert into TANSOQUET(TENTANSOQUET,TRANGTHAI) values(?,0)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, Q.getTen());
        int index = ps.executeUpdate();
        if(index == 0 ){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean sua(TanSoQuet Q , Integer id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "Update TANSOQUET set TENTANSOQUET = ? where IDTANSOQUET = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(2, id);
        ps.setString(1, Q.getTen());
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
        String sql = "Update TANSOQUET set TRANGTHAI = 1 where IDTANSOQUET = ?";
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
