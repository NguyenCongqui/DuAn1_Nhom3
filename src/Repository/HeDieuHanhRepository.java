/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.HeDieuHanh;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Dell
 */
public class HeDieuHanhRepository {

    public List<HeDieuHanh> getAll() {
        try {
            List<HeDieuHanh> danhMucs = new ArrayList<>();
            String sql = "SELECT IDHEDIEUHANH, TENHEDIEUHANH, NGAYTAO, NGAYSUA, TRANGTHAI FROM HEDIEUHANH";
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HeDieuHanh danhMuc = new HeDieuHanh(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getBoolean(5));

                danhMucs.add(danhMuc);
            }
            rs.close();
            ps.close();
            con.close();
            return danhMucs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(HeDieuHanh heDieuHanh) {
        String sql = "INSERT INTO HEDIEUHANH(TENHEDIEUHANH)VALUES (?)";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, heDieuHanh.getTenHeDieuHanh());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(HeDieuHanh heDieuHanh, String id) {
        String sql = "UPDATE HEDIEUHANH SET TENHEDIEUHANH=? WHERE IDHEDIEUHANH=?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, heDieuHanh.getTenHeDieuHanh());
            ps.setString(2, id);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM HEDIEUHANH WHERE IDHEDIEUHANH=?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
