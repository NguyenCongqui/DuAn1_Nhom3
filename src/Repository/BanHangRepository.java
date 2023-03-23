/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import ViewModel.HoaDonViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.logiin.Auth;

/**
 *
 * @author vanhv
 */
public class BanHangRepository {
 
    private DBConnection dBConnection;

    public Boolean saveHoaDon(HoaDonViewModel hoaDon) {

        int checkInsert = 0;

        String sql = 
              "INSERT INTO [dbo].[HOADONBAN] ([IDUSERS] ,[ngayTao],[TRANGTHAI])VALUES(?,?,?)";
//               "INSERT INTO [dbo].[HOADONBAN] ([ngayTao] ,[TRANGTHAI])VALUES(?,?)";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hoaDon.getIdUser());
            ps.setObject(1, hoaDon.getNgayTao());
            ps.setObject(2, hoaDon.getTrangThai());
            checkInsert = ps.executeUpdate();
            return checkInsert > 0;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public ArrayList<HoaDonViewModel> getListHoaDon() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql =
                "SELECT * from HOADONBAN";
//                "SELECT dbo.HOADONBAN.IDHOADONBAN, dbo.HOADONBAN.ngayTao, "
//                + "dbo.HOADONBAN.TRANGTHAI, dbo.USERS.HOTEN FROM   dbo.HOADONBAN INNER JOIN dbo.USERS ON dbo.HOADONBAN.IDUSERS = dbo.USERS.IDUSERS";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModel hoaDon = new HoaDonViewModel();
                hoaDon.setIdHDB(rs.getInt("IDHOADONBAN"));
                hoaDon.setNgayTao(rs.getString("ngayTao"));
                hoaDon.setTrangThai(rs.getInt("TRANGTHAI"));
//                hoaDon.setTenUser(rs.getString("HOTEN"));
                list.add(hoaDon);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return list;
    }
}
    
