/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Camera;
import Utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author trung
 */
public class CameraRepository {
    public List<Camera> getAll() throws SQLException{
        List<Camera> cameras = new ArrayList();
        Connection cnn = (Connection) DBConnection.getConnection();
        String sql = "select IDCAMERA ,TENCAMERA,NGAYTAO,NGAYSUA,TRANGTHAI from CAMERA  order by IDCAMERA desc";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {        
                Integer id = rs.getInt("IDCAMERA");
                String tenSp = rs.getString("TENCAMERA");
                Date ngayTao = rs.getDate("NGAYTAO");
                Date ngaySua = rs.getDate("NGAYSUA");
                boolean trangThai = rs.getBoolean("TRANGTHAI");
                Camera c = new Camera(id, tenSp, trangThai,ngaySua,ngayTao);
                cameras.add(c);
        }
        rs.close();
        rs.close();
        cnn.close();
        return cameras;
    }
    
    public boolean them(Camera camera) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "insert into CAMERA(TENCAMERA,TRANGTHAI,NGAYTAO) values(?,0,GETDATE())";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, camera.getName());
        int index = ps.executeUpdate();
        if(index == 0 ){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean sua(Camera camera , Integer id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "Update CAMERA set TENCAMERA = ? ,NGAYSUA = GETDATE() where IDCAMERA = ?";
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
        String sql = "Update CAMERA set TRANGTHAI = 1 where IDCAMERA = ?";
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
