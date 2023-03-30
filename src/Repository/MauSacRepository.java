/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.MauSac;
import Utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class MauSacRepository {

    public List<MauSac> getAll() throws SQLException {
        List<MauSac> mauSac = new ArrayList();
        Connection cnn = (Connection) DBConnection.getConnection();
        String sql = "SELECT [IDMAUSAC]\n"
                + "      ,[TENMAUSAC]\n"
                + "      ,[NGAYTAO]\n"
                + "      ,[NGAYSUA]\n"
                + "      ,[TRANGTHAI]\n"
                + "  FROM [dbo].[MAUSAC]";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Integer id = rs.getInt("IDMAUSAC");
            String tenSp = rs.getString("TENMAUSAC");
            Date ngayTao = rs.getDate("NGAYTAO");
            Date ngaySua = rs.getDate("NGAYSUA");
            boolean trangThai = rs.getBoolean("TRANGTHAI");
            MauSac c = new MauSac(id, tenSp, ngayTao, ngaySua, trangThai);
            mauSac.add(c);
        }
        rs.close();
        rs.close();
        cnn.close();
        return mauSac;
    }

    public boolean them(MauSac mauSac) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO [dbo].[MAUSAC]\n"
                + "           ([TENMAUSAC]\n"
                + "           ,[NGAYTAO]\n"
                + "           ,[TRANGTHAI])\n"
                + "     VALUES\n"
                + "         (?,GETDATE(),0)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, mauSac.getName());
        int index = ps.executeUpdate();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }
//    

    public boolean sua(MauSac mauSac, Integer id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE [dbo].[MAUSAC]\n"
                + "   SET [TENMAUSAC] = ?\n"
                + "      ,[NGAYSUA] = GETDATE()\n"
                + " WHERE IDMAUSAC = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(2, id);
        ps.setString(1, mauSac.getName());
        int index = ps.executeUpdate();
        ps.close();
        conn.close();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }
//    

    public boolean xoa(Integer id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "	UPDATE [dbo].[MAUSAC]\n"
                + "					  SET [TRANGTHAI] = 1\n"
                + "					WHERE IDMAUSAC = ?";
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
