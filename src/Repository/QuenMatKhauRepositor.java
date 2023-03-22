/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Users;
import Utilities.DBConnection;
import ViewModel.NhanVienViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class QuenMatKhauRepositor {
      DBConnection db;
     ResultSet rs = null;
    Connection con = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<NhanVienViewModel> listNhanVienViewModel =null;

    public QuenMatKhauRepositor() {
    }
       public List<NhanVienViewModel> getAll(){
        String sql = "SELECT TaiKhoan.IdUsers,IdTaiKhoan,SOCANCUOCCONGDAN,HOTEN,SODIENTHOAI,DIACHI,EMAIL,UserName,MatKhau,GIOITINH,Role,TRANGTHAI,NGAYSINH,NGAYTAO,NGAYSUA,LUONG \n" +
"FROM dbo.TaiKhoan INNER JOIN dbo.USERS ON USERS.IDUSERS = TaiKhoan.IdUsers";
        try {
           // pst = db.getConnection().prepareStatement(sql);
            con = db.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            listNhanVienViewModel = new ArrayList<>();

            while (rs.next()) {
                listNhanVienViewModel.add(new NhanVienViewModel(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getDate(13),rs.getDate(14),rs.getDate(15),rs.getFloat(16)));
            }
            rs.close();
        } catch (SQLException ex) {
           
        }
        return listNhanVienViewModel;
    }
        public String update(NhanVienViewModel nv){
        String update ="UPDATE dbo.TaiKhoan SET MatKhau = ?  FROM dbo.TaiKhoan INNER JOIN dbo.USERS ON USERS.IDUSERS = TaiKhoan.IdUsers\n" +
"	WHERE UserName = ?";
        try {
            pst = db.getConnection().prepareStatement(update);
            pst.setNString(1, nv.getPassword());
            pst.setString(2, nv.getUserName());
           // System.out.println(ListNhaXuatBan.size());
           pst.executeUpdate();
            return "Đổi Mật Khẩu Thành Công";
        } catch (Exception e) {
            
        }
        return "Đổi Mật Khẩu Không Thành Công";
    }
}
