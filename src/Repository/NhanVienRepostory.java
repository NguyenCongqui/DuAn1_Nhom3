/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.TaiKhoan;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class NhanVienRepostory {
    DBConnection db;
     ResultSet rs = null;
    Connection con = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<Users> listUsers = null;
    Users users = null;
    List<NhanVienViewModel> listNhanVienViewModel =null;

    public NhanVienRepostory() {
    }
    
    public boolean them(Users us) {
        String query = "INSERT INTO dbo.USERS\n" +
"(\n" +
"    SOCANCUOCCONGDAN,\n" +
"    HOTEN,\n" +
"    NGAYSINH,\n" +
"    GIOITINH,\n" +
"    DIACHI,\n" +
"    SODIENTHOAI,\n" +
"    EMAIL,\n" +
"    LUONG,\n" +
"    Role,\n" +
"    NGAYTAO,\n" +
"    TRANGTHAI\n" +
")\n" +
"VALUES(?,?,?,?,?,?,?,?,?,GETDATE(),?)";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, us.getSoCanCuocCongDan());
            ps.setObject(2, us.getHoTen());
            ps.setObject(3, us.getNgaySinh());
            ps.setObject(4, us.isGioiTinh());
            ps.setObject(5, us.getDiaChi());
            ps.setObject(6, us.getSoDienThoai());
            ps.setObject(7, us.getEmail());
            ps.setObject(8, us.getLuong());
            ps.setObject(9, us.isRole());
            ps.setObject(10, us.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
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
     public List<Users> getListNhanVienDangLam() {
        String select = "SELECT * FROM dbo.USERS WHERE TRANGTHAI = 1 ORDER BY IDUSERS DESC";
        listUsers = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {                
                listUsers.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getFloat(9), rs.getBoolean(10),rs.getDate(11),rs.getDate(12), rs.getBoolean(13)));
            }
            rs.close();
        } catch (Exception e) {
        }
        return listUsers;
    }
     public List<Users> getListNhanVienKhonglam() {
        String select = "SELECT * FROM dbo.USERS WHERE TRANGTHAI = 0 ORDER BY IDUSERS DESC";
        listUsers = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {                
                listUsers.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getFloat(9), rs.getBoolean(10),rs.getDate(11),rs.getDate(12), rs.getBoolean(13)));
            }
            rs.close();
        } catch (Exception e) {
        }
        return listUsers;
    }
     
       public String insertTaiKhoan (TaiKhoan tk){
        String insert = "INSERT INTO dbo.TaiKhoan\n" +
"(\n" +
"    IdUsers,\n" +
"    UserName,\n" +
"    MatKhau\n" +
")\n" +
"VALUES\n" +
"((SELECT TOP 1 IDUSERS FROM dbo.USERS ORDER BY IDUSERS DESC),?,?)";
      
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setString(1, tk.getUsersName());
            pst.setString(2, tk.getMatKhau());
            pst.executeUpdate();
            return "Thêm Nhân Viên Thành Công";
        } catch (Exception e) {
            
        }
        return "Thêm Nhân Viên Không Thành Công";
    }
       
       
       public String Delete(int t) {
        String update = "UPDATE dbo.USERS SET TRANGTHAI = 0 WHERE IDUSERS = ?";
        try {
            pst = db.getConnection().prepareStatement(update);

            pst.setInt(1, t);
           
            pst.executeUpdate();
            return "Xoa thanh cong";
        } catch (Exception e) {

        }
        return "Xoa khong thanh cong";
    }
       
       public String updateNhanVien (Users us) {
        String update = "UPDATE dbo.USERS SET SOCANCUOCCONGDAN = ?,HOTEN = ?,NGAYSINH = ?, \n" +
"GIOITINH = ?,DIACHI = ?,SODIENTHOAI = ?, EMAIL = ?, LUONG = ?, Role = ?,\n" +
"NGAYSUA = GETDATE(),TRANGTHAI = ? WHERE IDUSERS =?";
        try {
            pst = db.getConnection().prepareStatement(update);

            pst.setObject(1, us.getSoCanCuocCongDan());
            pst.setObject(2, us.getHoTen());
            pst.setObject(3, us.getNgaySinh());
            pst.setObject(4, us.isGioiTinh());
            pst.setObject(5, us.getDiaChi());
            pst.setObject(6, us.getSoDienThoai());
            pst.setObject(7, us.getEmail());
            pst.setObject(8, us.getLuong());
            pst.setObject(9, us.isRole());
            pst.setObject(10, us.isTrangThai());
            pst.setInt(11, us.getIdUser());
           
            pst.executeUpdate();
            return "Sửa Nhân Viên Thành Công";
        } catch (Exception e) {

        }
        return "Sửa Nhân Viên Không Thành Công";
    }
       
       public String updateNgaySua (int id) {
        String update = "UPDATE dbo.USERS SET NGAYSUA = GETDATE() WHERE IDUSERS = ?";
        try {
            pst = db.getConnection().prepareStatement(update);          
            pst.setInt(1, id);
           
            pst.executeUpdate();
            return "Cập Nhập Ngày Sửa Thành Công";
        } catch (Exception e) {

        }
        return "Cập Nhập Ngày Sửa Không Thành Công";
    }
       public int getIndex (int ma){
           for (int i = 0; i < listUsers.size(); i++) {
               if (listUsers.get(i).getIdUser() == ma) {
                   return i;
               }
           }
           return -3;
       }
       public List<Users> searchTen(String temp) {
        String query = " select * from USERS where HOTEN like '%" + temp +"%'";
        List<Users> listSearch = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Users vc = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getFloat(9), rs.getBoolean(10),rs.getDate(11),rs.getDate(12), rs.getBoolean(13));
               listSearch.add(vc);
            }
            return listSearch;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
//       public List<Users> searchTen(String temp) {
//        List<Users> listTemp = new ArrayList<>();
//        for (Users x : listUsers) {
//            if (x.getHoTen().contains(temp)) {
//                listTemp.add(x);
//            }
//        }
//        return listTemp;
//        
//       }
    
}
