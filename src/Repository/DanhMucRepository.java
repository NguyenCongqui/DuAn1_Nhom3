/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.DanhMuc;
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
public class DanhMucRepository {

    public List<DanhMuc> getAll() {
        try {
            List<DanhMuc> danhMucs = new ArrayList<>();
            String sql = "SELECT IDDANHMUC, TENDANHMUC, NGAYTAO, NGAYSUA, TRANGTHAI FROM DANHMUC";
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc danhMuc = new DanhMuc(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));

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

    public boolean add(DanhMuc danhMuc) {
        String sql = "INSERT INTO DANHMUC(TENDANHMUC) VALUES (?)";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, danhMuc.getTenDanhMuc());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(DanhMuc danhMuc, String id) {
        String sql = "UPDATE DANHMUC SET TENDANHMUC=? WHERE IDDANHMUC=?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, danhMuc.getTenDanhMuc());
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
        String sql = "DELETE FROM DANHMUC WHERE IDDANHMUC=?";
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
