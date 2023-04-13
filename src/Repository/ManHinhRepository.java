/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ManHinh;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hodangquan
 */
public class ManHinhRepository {

    public List<ManHinh> getAll() throws SQLException {
        List<ManHinh> manHinh = new ArrayList();
        Connection cnn = (Connection) DBConnection.getConnection();
        String sql = "select IDKICHTHUOCMANHINH ,TENKICHTHUOCMANHINH,NGAYTAO,NGAYSUA,TRANGTHAI from KICHTHUOCMANHINH order by IDKICHTHUOCMANHINH desc";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Integer id = rs.getInt("IDKICHTHUOCMANHINH");
            String tenSp = rs.getString("TENKICHTHUOCMANHINH");
             Date ngayTao = rs.getDate("NGAYTAO");
                Date ngaySua = rs.getDate("NGAYSUA");
            boolean trangThai = rs.getBoolean("TRANGTHAI");
            ManHinh mh = new ManHinh(id, tenSp, trangThai,ngayTao,ngaySua);
            manHinh.add(mh);
        }
        rs.close();
        rs.close();
        cnn.close();
        return manHinh;
    }

    public boolean them(ManHinh manHinh) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "insert into KICHTHUOCMANHINH(TENKICHTHUOCMANHINH,TRANGTHAI,NGAYTAO) values(?,0,GETDATE())";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, manHinh.getName());
        int index = ps.executeUpdate();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean sua(ManHinh manHinh, Integer id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "Update KICHTHUOCMANHINH set TENKICHTHUOCMANHINH = ? ,NGAYSUA = GETDATE() where IDKICHTHUOCMANHINH = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(2, id);
        ps.setString(1, manHinh.getName());
        int index = ps.executeUpdate();
        ps.close();
        conn.close();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean xoa(Integer id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "Update KICHTHUOCMANHINH set TRANGTHAI = 1 where IDKICHTHUOCMANHINH = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int index = ps.executeUpdate();
        ps.close();
        conn.close();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }

}
