/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Cpu;
import Utilities.DBConnection;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hodangquan
 */
public class CpuRepository {
    public List<Cpu> getAll() throws SQLException{
        List<Cpu> cpu = new ArrayList();
        Connection cnn = (Connection) DBConnection.getConnection();
        String sql = "select IDCPU ,TENCPU,TRANGTHAI from CPU   order by IDCPU desc";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {        
                Integer id = rs.getInt("IDCPU");
                String tenSp = rs.getString("TENCPU");
                boolean trangThai = rs.getBoolean("TRANGTHAI");
                Cpu c = new Cpu(id, tenSp, trangThai);
                cpu.add(c);
        }
        rs.close();
        rs.close();
        cnn.close();
        return cpu;
    }
    
    public boolean them(Cpu cpu) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "insert into CPU(TENCPU,TRANGTHAI) values(?,0)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cpu.getName());
        int index = ps.executeUpdate();
        if(index == 0 ){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean sua(Cpu cpu , Integer id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "Update CPU set TENCPU = ? where IDCPU = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(2, id);
        ps.setString(1, cpu.getName());
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
        String sql = "Update CPU set TRANGTHAI = 1 where IDCPU = ?";
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
