/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import Utilities.jdbcHelper;
import ViewModel.CTHDBaoHanhViewModel;
import ViewModel.HDBaoHanhViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.logiin.XDate;

/**
 *
 * @author vanhv
 */
public class HDBaoHanhRepository {

    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;

    protected List<HDBaoHanhViewModel> selectBySql(String sql, Object... args){
         List<HDBaoHanhViewModel> list = new ArrayList<>();
         try {
              ResultSet rs = jdbcHelper.query(sql, args);
                while (rs.next()) {
                HDBaoHanhViewModel p = new HDBaoHanhViewModel();
                p.setIdBaoHanh(rs.getInt("IDBAOHANH"));
                p.setIdHDBan(rs.getInt("IDHOADONBAN"));
                p.setNgayBatDau(rs.getDate("NGAYTAO"));
                p.setNgayKetThuc(rs.getDate("NGAYSUA"));
                p.setIdKh(rs.getInt("IDKHACHHANG"));
                p.setTenKH(rs.getString("HOTEN"));
                p.setSdt(rs.getInt("SODIENTHOAI"));
                p.setTenUser(rs.getString(21));
                p.setGhiChu(rs.getString("GHICHU"));
                list.add(p);
           }
        } catch (Exception e) {
             e.printStackTrace();
        }
          return list;
    }
    public List<HDBaoHanhViewModel> getAllTra(int page, int pageSize,String Stringdate) {
        if (!Stringdate.isEmpty()) {
             // java.util.Date date = java.util.Calendar.getInstance().getTime();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
            java.util.Date date = XDate.toDate(Stringdate, "yyyy-MM-dd");
        String sql = "SELECT * FROM dbo.BAOHANH INNER JOIN\n" +
"dbo.KHACHHANG ON dbo.BAOHANH.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG INNER JOIN\n" +
"dbo.USERS ON dbo.BAOHANH.IDUSERS = dbo.USERS.IDUSERS WHERE BAOHANH.NGAYTAO BETWEEN '" + new java.sql.Date(date.getTime()) + " 00:00:00.000'" + "AND '" + new java.sql.Date(date.getTime()) + " 23:59:59.000' \n" 
                +"ORDER BY BAOHANH.NGAYTAO DESC OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";

//        List<HDBaoHanhViewModel> listTra = new ArrayList<>();
//        try {
//            st = db.getConnection().createStatement();
//            rs = st.executeQuery(sql);
//            listTra = new ArrayList<>();
//            while (rs.next()) {
//                HDBaoHanhViewModel p = new HDBaoHanhViewModel();
//                p.setIdBaoHanh(rs.getInt("IDBAOHANH"));
//                p.setIdHDBan(rs.getInt("IDHOADONBAN"));
//                p.setNgayBatDau(rs.getDate("NGAYTAO"));
//                p.setNgayKetThuc(rs.getDate("NGAYSUA"));
//                p.setIdKh(rs.getInt("IDKHACHHANG"));
//                p.setTenKH(rs.getString("HOTEN"));
//                p.setSdt(rs.getInt("SODIENTHOAI"));
//                p.setTenUser(rs.getString(21));
//                p.setGhiChu(rs.getString("GHICHU"));
//                listTra.add(p);
//            }
//             rs.close();
//            
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
           return selectBySql(sql, (page - 1) * pageSize, pageSize);
        }
        String sql = "SELECT * FROM dbo.BAOHANH INNER JOIN\n" +
"dbo.KHACHHANG ON dbo.BAOHANH.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG INNER JOIN\n" +
"dbo.USERS ON dbo.BAOHANH.IDUSERS = dbo.USERS.IDUSERS ORDER BY BAOHANH.NGAYTAO DESC OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
         List<HDBaoHanhViewModel> listTra = new ArrayList<>();
//       try {
//            st = db.getConnection().createStatement();
//            rs = st.executeQuery(sql);
//            listTra = new ArrayList<>();
//            while (rs.next()) {
//                HDBaoHanhViewModel p = new HDBaoHanhViewModel();
//                p.setIdBaoHanh(rs.getInt("IDBAOHANH"));
//                p.setIdHDBan(rs.getInt("IDHOADONBAN"));
//                p.setNgayBatDau(rs.getDate("NGAYTAO"));
//                p.setNgayKetThuc(rs.getDate("NGAYSUA"));
//                p.setIdKh(rs.getInt("IDKHACHHANG"));
//                p.setTenKH(rs.getString("HOTEN"));
//                p.setSdt(rs.getInt("SODIENTHOAI"));
//                p.setTenUser(rs.getString(21));
//                p.setGhiChu(rs.getString("GHICHU"));
//                listTra.add(p);
//            }
//             rs.close();
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//       return null;
return selectBySql(sql, (page - 1) * pageSize, pageSize); 
    }
   public int ThoiGian(String Stringdate) {
        ResultSet rs;
        if (!Stringdate.isEmpty()) {
               //java.util.Date date = java.util.Calendar.getInstance().getTime();
            java.util.Date date = XDate.toDate(Stringdate, "yyyy-MM-dd");
            String sql = " SELECT COUNT(*) as soLuong FROM dbo.BAOHANH WHERE NGAYTAO BETWEEN '"  + new java.sql.Date(date.getTime()) + " '" + "AND '" + new java.sql.Date(date.getTime()) + "  ' ";
//            try {
//                pst = db.getConnection().prepareStatement(sql);
//            pst.setObject(1, Stringdate);
//            rs = pst.executeQuery();
//                while (rs.next()) {
//                    return rs.getInt("soLuong");
//                }
//                rs.close();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
try {
                rs = jdbcHelper.query(sql);
                while (rs.next()) {
                    return rs.getInt("soLuong");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        String sql = "SELECT COUNT(*) as soLuong FROM dbo.BAOHANH ";
//        try {
//             pst = db.getConnection().prepareStatement(sql);
//             rs = pst.executeQuery();
//            while (rs.next()) {
//                return rs.getInt("soLuong");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
try {
            rs = jdbcHelper.query(sql);
            while (rs.next()) {
                return rs.getInt("soLuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }
    public List<CTHDBaoHanhViewModel> selectByIdCT(int id) {
        String sql = " SELECT dbo.CHITIETBAOHANH.IDCHITIETBAOHANH, dbo.DANHMUC.TENDANHMUC, dbo.MAUSAC.TENMAUSAC, dbo.BONHOTRONG.TENBONHOTRONG, dbo.CHITIETBAOHANH.SOIMEI, dbo.SANPHAM.TENSANPHAM, dbo.BAOHANH.TRANGTHAI     \n"
                + "FROM   dbo.BAOHANH INNER JOIN\n"
                + "             dbo.CHITIETBAOHANH ON dbo.BAOHANH.IDBAOHANH = dbo.CHITIETBAOHANH.IDBAOHANH INNER JOIN\n"
                + "             dbo.CHITIETSANPHAM ON dbo.CHITIETBAOHANH.SOIMEI = dbo.CHITIETSANPHAM.SOIMEI INNER JOIN\n"
                + "             dbo.BONHOTRONG ON dbo.CHITIETSANPHAM.IDBONHOTRONG = dbo.BONHOTRONG.IDBONHOTRONG INNER JOIN\n"
                + "             dbo.KHACHHANG ON dbo.BAOHANH.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG INNER JOIN\n"
                + "             dbo.MAUSAC ON dbo.CHITIETSANPHAM.IDMAUSAC = dbo.MAUSAC.IDMAUSAC INNER JOIN\n"
                + "             dbo.SANPHAM ON dbo.CHITIETSANPHAM.IDSANPHAM = dbo.SANPHAM.IDSANPHAM INNER JOIN\n"
                + "             dbo.DANHMUC ON dbo.SANPHAM.IDDANHMUC = dbo.DANHMUC.IDDANHMUC WHERE CHITIETBAOHANH.IDBAOHANH = ?";
        List<CTHDBaoHanhViewModel> list = new ArrayList<>();
        try {
            pst = db.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                CTHDBaoHanhViewModel de = new CTHDBaoHanhViewModel();
                de.setIdBHCT(rs.getInt("IDCHITIETBAOHANH"));
                de.setSoImei(rs.getString("SOIMEI"));
                de.setDanhMuc(rs.getString("TENDANHMUC"));
                de.setMauSac(rs.getString("TENMAUSAC"));
                de.setDungLuong(rs.getString("TENBONHOTRONG"));
                de.setTenSp(rs.getString("TENSANPHAM"));
                de.setTrangThai(rs.getBoolean("TRANGTHAI"));
                list.add(de);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;

    }

    public HDBaoHanhViewModel FindIDHdBH(Integer k) {
        String sql = " SELECT dbo.BAOHANH.IDBAOHANH, dbo.BAOHANH.NGAYTAO, dbo.BAOHANH.NGAYSUA, dbo.BAOHANH.IDKHACHHANG, dbo.BAOHANH.IDHOADONBAN, dbo.BAOHANH.GHICHU, dbo.KHACHHANG.HOTEN, dbo.USERS.HOTEN AS TenUser, dbo.KHACHHANG.SODIENTHOAI\n"
                + "FROM   dbo.BAOHANH INNER JOIN\n"
                + "            dbo.KHACHHANG ON dbo.BAOHANH.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG INNER JOIN\n"
                + "            dbo.USERS ON dbo.BAOHANH.IDUSERS = dbo.USERS.IDUSERS WHERE IDBAOHANH = ?";
        List<HDBaoHanhViewModel> list = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, k);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HDBaoHanhViewModel p = new HDBaoHanhViewModel();
                p.setIdBaoHanh(rs.getInt("IDBAOHANH"));
                p.setIdHDBan(rs.getInt("IDHOADONBAN"));
                p.setNgayBatDau(rs.getDate("NGAYTAO"));
                p.setNgayKetThuc(rs.getDate("NGAYSUA"));
                p.setIdKh(rs.getInt("IDKHACHHANG"));
                p.setTenKH(rs.getString("HOTEN"));
                p.setSdt(rs.getInt("SODIENTHOAI"));
                p.setTenUser(rs.getString("TenUser"));
                p.setGhiChu(rs.getString("GHICHU"));
                return p;
                // listHDNhap.add(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HDBaoHanhRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
