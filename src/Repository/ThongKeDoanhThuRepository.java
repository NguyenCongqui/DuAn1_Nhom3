/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import Utilities.jdbcHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ThongKeDoanhThuRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;

    public ThongKeDoanhThuRepository() {
    }
     public List<Integer> selectYears() {
        String sql = "SELECT DISTINCT YEAR(ngayTao) FROM dbo.HoaDonBan ORDER BY YEAR(ngayTao) DESC";
        List<Integer> list = new ArrayList<>();
        try {
           // ResultSet rs = jdbcHelper.query(sql);
           st = db.getConnection().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
       List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
         public List<Object[]> getSalesStatisticalRevenue(Integer year) {
        String sql = "{call SanPham_DoanhThu(?)}";
        String[] cols = {"Thang", "SanPhamBan", "TongGiaBan", "TongNhapHang", "CUNGCAPDICHVU"};
        return getListOfArray(sql, cols, year);
    }
    
}
