/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import ViewModel.DungLuongPinViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author vanhv
 */
public class DungLuongPinRepository {
     List<DungLuongPinViewModel> list = null;
    DBConnection dbConnection;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public List<DungLuongPinViewModel> getAll(){
        try {
            String sql="SELECT [IDDUNGLUONGPIN]\n" +
"      ,[TENDUNGLUONGPIN]\n" +
"  FROM [dbo].[DUNGLUONGPIN]";
            con = dbConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            
            while(rs.next()){
                list.add(new DungLuongPinViewModel(rs.getString(1), rs.getString(2)));
            }
              return list;
        } catch (SQLException ex) {
            Logger.getLogger(DungLuongPinRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean insert(DungLuongPinViewModel lp){
        int check = 0;
        try {
            String sql = "INSERT INTO [dbo].[DUNGLUONGPIN] ([TENDUNGLUONGPIN]) VALUES(?)";
             con =dbConnection.getConnection();
            ps= con.prepareStatement(sql);
            ps.setObject(1, lp.getTen());
            check = ps.executeUpdate();
       } catch (SQLException ex) {
            Logger.getLogger(DungLuongPinRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
         return check > 0;
    }
    
    public boolean update(String id,DungLuongPinViewModel lp){
        int check = 0;
        try {
            String sql = "UPDATE [dbo].[DUNGLUONGPIN] SET [TENDUNGLUONGPIN] = ? WHERE IDDUNGLUONGPIN = ?";
            con = dbConnection.getConnection();
            ps= con.prepareStatement(sql);
             ps.setObject(1, lp.getTen());
            ps.setObject(2, id);
            check = ps.executeUpdate();
          } catch (SQLException ex) {
            Logger.getLogger(DungLuongPinRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
     public boolean delete(String id,DungLuongPinViewModel lp){
        int check = 0;
        try {
            String sql  = "DELETE FROM [dbo].[DUNGLUONGPIN]\n" +
"      WHERE IDDUNGLUONGPIN = ?";
            con = dbConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DungLuongPinRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
