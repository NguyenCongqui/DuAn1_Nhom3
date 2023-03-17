/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import ViewModel.LoaiPinViewModel;
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
public class LoaiPinRepository {
     List<LoaiPinViewModel> list = null;
    DBConnection dbConnection;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public List<LoaiPinViewModel> getAll(){
        try {
            String sql="SELECT [IDLOAIPIN] ,[TELOAIPIN] FROM [dbo].[LOAIPIN]";
            con = dbConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            
            while(rs.next()){
                list.add(new LoaiPinViewModel(rs.getString(1), rs.getString(2)));
            }
              return list;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPinRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean insert(LoaiPinViewModel lp){
        int check = 0;
        try {
            String sql = "INSERT INTO LOAIPIN ([TELOAIPIN] ) VALUES(?)";
             con =dbConnection.getConnection();
            ps= con.prepareStatement(sql);
            ps.setObject(1, lp.getTen());
            check = ps.executeUpdate();
       } catch (SQLException ex) {
            Logger.getLogger(LoaiPinRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
         return check > 0;
    }
    
    public boolean update(String id,LoaiPinViewModel lp){
        int check = 0;
        try {
            String sql = "UPDATE [dbo].[LOAIPIN] SET [TELOAIPIN] =? WHERE IDLOAIPIN = ?";
            con = dbConnection.getConnection();
            ps= con.prepareStatement(sql);
             ps.setObject(1, lp.getTen());
            ps.setObject(2, id);
            check = ps.executeUpdate();
          } catch (SQLException ex) {
            Logger.getLogger(LoaiPinRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
     public boolean delete(String id,LoaiPinViewModel lp){
        int check = 0;
        try {
            String sql  = "DELETE FROM [dbo].[LOAIPIN] WHERE IDLOAIPIN = ?";
            con = dbConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPinRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
