/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
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

/**
 *
 * @author vanhv
 */
public class HDBaoHanhRepository {

    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;

    public List<HDBaoHanhViewModel> getAllTra() {
        String sql = "	  SELECT dbo.BAOHANH.IDBAOHANH, dbo.BAOHANH.NGAYTAO, dbo.BAOHANH.NGAYSUA, dbo.BAOHANH.IDKHACHHANG, dbo.BAOHANH.IDHOADONBAN, dbo.BAOHANH.GHICHU, dbo.KHACHHANG.HOTEN, dbo.USERS.HOTEN AS TenUser, dbo.KHACHHANG.SODIENTHOAI\n"
                + "FROM   dbo.BAOHANH INNER JOIN\n"
                + "            dbo.KHACHHANG ON dbo.BAOHANH.IDKHACHHANG = dbo.KHACHHANG.IDKHACHHANG INNER JOIN\n"
                + "            dbo.USERS ON dbo.BAOHANH.IDUSERS = dbo.USERS.IDUSERS ORDER BY IDBAOHANH DESC";

        List<HDBaoHanhViewModel> listTra = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(sql);
            listTra = new ArrayList<>();
            while (rs.next()) {
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
                listTra.add(p);
            }
            return listTra;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
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
