/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietHoaDonBan;
import Utilities.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
