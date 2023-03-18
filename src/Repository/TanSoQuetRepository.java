/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.TanSoQuet;
import Utilities.DBConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class TanSoQuetRepository {

    public List<TanSoQuet> getAll() {
        List<TanSoQuet> tanSoQuets = new ArrayList<>();
        String sql = "SELECT IDTANSOQUET, TENTANSOQUET, NGAYTAO, NGAYSUA, TRANGTHAI FROM TANSOQUET";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TanSoQuet tanSoQuet = new TanSoQuet(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getBoolean(5));

                tanSoQuets.add(tanSoQuet);
            }
            rs.close();
            ps.close();
            con.close();
            return tanSoQuets;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(TanSoQuet tanSoQuet) {
        String sql = "INSERT INTO TANSOQUET(TENTANSOQUET) VALUES(?)";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tanSoQuet.getTenTanSoQuet());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(TanSoQuet tanSoQuet, String id) {
        String sql = "UPDATE TANSOQUET SET TENTANSOQUET=? WHERE IDTANSOQUET=?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tanSoQuet.getTenTanSoQuet());
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
        String sql = "DELETE FROM TANSOQUET WHERE IDTANSOQUET=?";
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
