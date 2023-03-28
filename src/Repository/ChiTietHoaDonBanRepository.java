/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietHoaDonBan;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDonBanRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<ChiTietHoaDonBan> ListchitietHoaDon = null;
    
    public String insert(ChiTietHoaDonBan cthd) {
        String insert = "INSERT INTO dbo.CHITIETHOADONBAN(\n" +
"			      IDHOADONBAN,\n" +
"			      SOIMEI,\n" +
"				    SoLuong,\n" +
"				    DonGia\n" +
"			)\n" +
"				VALUES((SELECT TOP 1 IDHOADONBAN FROM dbo.HOADONBAN ORDER BY IDHOADONBAN DESC),?,?,?)";
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setString(1, cthd.getSoImei());
            pst.setInt(2, cthd.getSoLuong());
            pst.setFloat(3, cthd.getDonGia());
            pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {

        }
        return "Them khong thanh cong";
    }
    
     public void add(ChiTietHoaDonBan HDCT) throws SQLException {
        Connection conn = db.getConnection();
        String sql = """
                     INSERT INTO dbo.CHITIETHOADONBAN
                     (
                         IDHOADONBAN,
                         SOIMEI,
                         SoLuong,
                         DonGia
                     )
                     VALUES(?,?,?,?)
                     """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, HDCT.getIDHoaDonBan());
        ps.setString(2, HDCT.getSoImei());
        ps.setInt(3, HDCT.getSoLuong());
        ps.setFloat(4, HDCT.getDonGia());
        ps.executeUpdate();
    }

    public void delete(int IdHoaDon, String soImei) throws SQLException {
        Connection conn = db.getConnection();
        String sql = "DELETE FROM dbo.CHITIETHOADONBAN WHERE IDHOADONBAN =? AND SOIMEI = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, IdHoaDon);
        ps.setString(2, soImei);
        ps.executeUpdate();

    }
}
