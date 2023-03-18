/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Users;
import Utilities.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class UserRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<Users> ListUsers = null;
    Users users = null;

    public UserRepository() {
    }
    
    public Users getListUsers (int idUsers){
        String select = "SELECT * FROM dbo.USERS WHERE IDUSERS ='"+idUsers+"'";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {                
                users = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getFloat(9), rs.getBoolean(10),rs.getDate(11),rs.getDate(12), rs.getBoolean(13));
            }
            rs.close();
        } catch (Exception e) {
        }
        return users;
    }
}
