/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.LoaiPin;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author vanhv
 */
public class LoaiPinRepository {
   public List<LoaiPin> getAll() throws SQLException{
        List<LoaiPin> cameras = new ArrayList();
        Connection cnn = (Connection) DBConnection.getConnection();
        String sql = "SELECT [IDLOAIPIN] ,[TELOAIPIN],[TRANGTHAI] FROM [dbo].[LOAIPIN]";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {        
                Integer id = rs.getInt("IDLOAIPIN");
                String tenSp = rs.getString("TELOAIPIN");
                boolean trangThai = rs.getBoolean("TRANGTHAI");
                LoaiPin c = new LoaiPin(id, tenSp, trangThai);
                cameras.add(c);
        }
        rs.close();
        rs.close();
        cnn.close();
        return cameras;
    }
    
    public boolean them(LoaiPin camera) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO [dbo].[LOAIPIN] ([TELOAIPIN],[TRANGTHAI]) VALUES (?,0)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, camera.getName());
        int index = ps.executeUpdate();
        if(index == 0 ){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean sua(LoaiPin camera , Integer id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE [dbo].[LOAIPIN] SET [TELOAIPIN] = ? WHERE IDLOAIPIN = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(2, id);
        ps.setString(1, camera.getName());
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
        String sql = "UPDATE [dbo].[LOAIPIN] SET TRANGTHAI = 1 WHERE IDLOAIPIN = ? ";
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
