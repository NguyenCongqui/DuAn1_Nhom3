/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.DungLuongPin;
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
public class DungLuongPinRepository {

    public List<DungLuongPin> getAll() throws SQLException {
        List<DungLuongPin> cameras = new ArrayList();
        Connection cnn = (Connection) DBConnection.getConnection();
        String sql = "SELECT [IDDUNGLUONGPIN]\n"
                + "      ,[TENDUNGLUONGPIN]\n"
                + "      ,[TRANGTHAI]\n"
                + "  FROM [dbo].[DUNGLUONGPIN]"
                + "order by IDDUNGLUONGPIN desc";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Integer id = rs.getInt("IDDUNGLUONGPIN");
            String tenSp = rs.getString("TENDUNGLUONGPIN");
            boolean trangThai = rs.getBoolean("TRANGTHAI");
            DungLuongPin c = new DungLuongPin(id, tenSp, trangThai);
            cameras.add(c);
        }
        rs.close();
        rs.close();
        cnn.close();
        return cameras;
    }

    public boolean them(DungLuongPin camera) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO [dbo].[DUNGLUONGPIN] ([TENDUNGLUONGPIN],[TRANGTHAI]) VALUES(?,0)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, camera.getName());
        int index = ps.executeUpdate();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean sua(DungLuongPin camera, Integer id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE [dbo].[DUNGLUONGPIN] SET [TENDUNGLUONGPIN] = ? WHERE IDDUNGLUONGPIN = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(2, id);
        ps.setString(1, camera.getName());
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
        String sql = "UPDATE [dbo].[DUNGLUONGPIN] SET TRANGTHAI = 1 WHERE IDDUNGLUONGPIN = ?";
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
