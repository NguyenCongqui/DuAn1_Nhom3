/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Ram;
import Utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trung
 */
public class RamRepository {

    public List<Ram> getAll() throws SQLException {
        List<Ram> rams = new ArrayList();
        Connection cnn = (Connection) DBConnection.getConnection();
        String sql = "SELECT [IDRAM]\n"
                + "      ,[TENRAM]\n"
                + "      ,NGAYTAO,NGAYSUA,[TRANGTHAI]\n"
                + "  FROM [dbo].[RAM]"
                + "order by IDRAM desc";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Integer id = rs.getInt("IDRAM");
            String tenSp = rs.getString("TENRAM");
              Date ngayTao = rs.getDate("NGAYTAO");
                Date ngaySua = rs.getDate("NGAYSUA");
            boolean trangThai = rs.getBoolean("TRANGTHAI");
            Ram c = new Ram(id, tenSp, trangThai,ngayTao,ngaySua);
            rams.add(c);
        }
        rs.close();
        rs.close();
        cnn.close();
        return rams;
    }

    public boolean them(Ram ram) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO [dbo].[RAM]\n"
                + "           ([TENRAM]\n"
                + "           ,[TRANGTHAI],NGAYTAO)\n"
                + "     VALUES\n"
                + "           (?,0,GETDATE())";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, ram.getName());
        int index = ps.executeUpdate();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean sua(Ram ram, Integer id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE [dbo].[RAM]\n"
                + "   SET [TENRAM] = ? ,NGAYSUA = GETDATE() \n"
                + " WHERE IDRAM = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(2, id);
        ps.setString(1, ram.getName());
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
        String sql = "UPDATE [dbo].[RAM]\n"
                + "   SET [TRANGTHAI] = 1\n"
                + " WHERE IDRAM = ?";
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
