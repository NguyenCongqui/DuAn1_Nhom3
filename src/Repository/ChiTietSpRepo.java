/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietSanPham;
import Utilities.DBConnection;
import ViewModel.SanPhamViewModel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import java.util.List;
import view.duan.model.ViewSanPham;

/**
 *
 * @author trung
 */
public class ChiTietSpRepo {
DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<ChiTietSanPham> ListChiTietSach = null;
    List<SanPhamViewModel> ListSanPhamViewModel = new ArrayList<>();
    
    
    public List<ChiTietSanPham> getAll() throws SQLException {
        List<ChiTietSanPham> ChiTiet = new ArrayList();
        Connection conn = DBConnection.getConnection();
        String sql = "select SOIMEI,MOTA,SOLUONGTON,GIANHAP,GIABAN,THOIGIANBAOHANH,IDSANPHAM,IDHEDIEUHANH,IDCAMERA,IDRAM,IDKICHTHUOCMANHINH,IDCPU,IDBONHOTRONG,IDLOAIPIN,IDTANSOQUET,IDDUNGLUONGPIN,TRANGTHAI from CHITIETSANPHAM";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String SoImei = rs.getString("SOIMEI");
            String moTa = rs.getString("MOTA");
            Double giaNhap = rs.getDouble("GIANHAP");
            Double giaBan = rs.getDouble("GIABAN");
            String ThoiGianBaoHanh = rs.getString("THOIGIANBAOHANH");
            Integer SanPham = rs.getInt("IDSANPHAM");
            Integer HeDIeuHanh = rs.getInt("IDHEDIEUHANH");
            Integer Camera = rs.getInt("IDCAMERA");
            Integer Ram = rs.getInt("IDRAM");
            Integer KichThuocMan = rs.getInt("IDKICHTHUOCMANHINH");
            Integer Cpu = rs.getInt("IDCPU");
            Integer BoNhoTrong = rs.getInt("IDBONHOTRONG");
            Integer LoaiPin = rs.getInt("IDLOAIPIN");
            Integer TanSoQuet = rs.getInt("IDTANSOQUET");
            Integer DungLuongPin = rs.getInt("IDDUNGLUONGPIN");
            boolean trangThai = rs.getBoolean("TRANGTHAI");

            ChiTietSanPham c = new ChiTietSanPham(SoImei, moTa, giaNhap, giaBan, ThoiGianBaoHanh, SanPham, HeDIeuHanh, Camera, Ram, KichThuocMan, Cpu, BoNhoTrong, LoaiPin, TanSoQuet, DungLuongPin, trangThai);
            ChiTiet.add(c);
        }
        rs.close();
        ps.close();
        conn.close();
        return ChiTiet;
    }
    public List<ChiTietSanPham> getAllImei(Integer idSP) throws SQLException {
        List<ChiTietSanPham> ChiTiet = new ArrayList();
        Connection conn = DBConnection.getConnection();
        String sql = "select SOIMEI,MOTA,SOLUONGTON,GIANHAP,GIABAN,THOIGIANBAOHANH,IDSANPHAM,IDHEDIEUHANH,IDCAMERA,IDRAM,IDKICHTHUOCMANHINH,IDCPU,IDBONHOTRONG,IDLOAIPIN,IDTANSOQUET,IDDUNGLUONGPIN,TRANGTHAI from CHITIETSANPHAM where IDSANPHAM = ? AND TRANGTHAI = 0";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idSP);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String SoImei = rs.getString("SOIMEI");
            String moTa = rs.getString("MOTA");
            Double giaNhap = rs.getDouble("GIANHAP");
            Double giaBan = rs.getDouble("GIABAN");
            String ThoiGianBaoHanh = rs.getString("THOIGIANBAOHANH");
            Integer SanPham = rs.getInt("IDSANPHAM");
            Integer HeDIeuHanh = rs.getInt("IDHEDIEUHANH");
            Integer Camera = rs.getInt("IDCAMERA");
            Integer Ram = rs.getInt("IDRAM");
            Integer KichThuocMan = rs.getInt("IDKICHTHUOCMANHINH");
            Integer Cpu = rs.getInt("IDCPU");
            Integer BoNhoTrong = rs.getInt("IDBONHOTRONG");
            Integer LoaiPin = rs.getInt("IDLOAIPIN");
            Integer TanSoQuet = rs.getInt("IDTANSOQUET");
            Integer DungLuongPin = rs.getInt("IDDUNGLUONGPIN");
            boolean trangThai = rs.getBoolean("TRANGTHAI");

            ChiTietSanPham c = new ChiTietSanPham(SoImei, moTa, giaNhap, giaBan, ThoiGianBaoHanh, SanPham, HeDIeuHanh, Camera, Ram, KichThuocMan, Cpu, BoNhoTrong, LoaiPin, TanSoQuet, DungLuongPin, trangThai);
            ChiTiet.add(c);
        }
        rs.close();
        ps.close();
        conn.close();
        return ChiTiet;
    }
    public List<ViewSanPham> getAllSP() throws SQLException {
        List<ViewSanPham> ChiTiet = new ArrayList();
        Connection conn = DBConnection.getConnection();
        String sql = "Select SANPHAM.IDSANPHAM , TENSANPHAM , CHITIETSANPHAM.MOTA, Count(CHITIETSANPHAM.SOIMEI) as 'So luong' ,CHITIETSANPHAM.THOIGIANBAOHANH, CHITIETSANPHAM.GIANHAP, CHITIETSANPHAM.GIABAN ,CHITIETSANPHAM.IDHEDIEUHANH , CHITIETSANPHAM.IDCAMERA, CHITIETSANPHAM.IDRAM , CHITIETSANPHAM.IDKICHTHUOCMANHINH ,CHITIETSANPHAM.IDCPU,CHITIETSANPHAM.IDBONHOTRONG,CHITIETSANPHAM.IDLOAIPIN, CHITIETSANPHAM.IDTANSOQUET,CHITIETSANPHAM.IDDUNGLUONGPIN , SANPHAM.TRANGTHAI From SANPHAM\n" +
"Join CHITIETSANPHAM on CHITIETSANPHAM.IDSANPHAM = SANPHAM.IDSANPHAM\n" +
"Group by SANPHAM.IDSANPHAM ,TENSANPHAM , CHITIETSANPHAM.MOTA ,CHITIETSANPHAM.THOIGIANBAOHANH,CHITIETSANPHAM.GIANHAP, CHITIETSANPHAM.GIABAN,CHITIETSANPHAM.IDHEDIEUHANH , CHITIETSANPHAM.IDCAMERA, CHITIETSANPHAM.IDRAM , CHITIETSANPHAM.IDKICHTHUOCMANHINH ,CHITIETSANPHAM.IDCPU,CHITIETSANPHAM.IDBONHOTRONG,CHITIETSANPHAM.IDLOAIPIN, CHITIETSANPHAM.IDTANSOQUET,CHITIETSANPHAM.IDDUNGLUONGPIN,SANPHAM.TRANGTHAI\n" +
"";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Integer idSanPham = rs.getInt(1);
            String tenSanPham = rs.getString(2);
            String moTa = rs.getString(3);
            Integer soLuong = rs.getInt(4);
            Date thoiGianBaoHanh = rs.getDate(5);
            BigDecimal giaNhap = rs.getBigDecimal(6);
            BigDecimal giaBan = rs.getBigDecimal(7);
            Integer idHeDieuHanh = rs.getInt(8);
            Integer idCamera = rs.getInt(9);
            Integer idRam = rs.getInt(10);
            Integer idKichThuocMan = rs.getInt(11);
            Integer idCpu = rs.getInt(12);
            Integer idBoNho = rs.getInt(13);
            Integer idLoaiPin = rs.getInt(14);
            Integer idTanSoQuet = rs.getInt(15);
            Integer idDungLuongPin = rs.getInt(16);
            Boolean trangThai = rs.getBoolean(17);
            
            ViewSanPham sanPham = new ViewSanPham(idSanPham, tenSanPham, moTa, soLuong, thoiGianBaoHanh, giaNhap, giaBan, idHeDieuHanh, idCamera, idRam, idKichThuocMan, idCpu, idBoNho, idLoaiPin, idTanSoQuet, idDungLuongPin, trangThai);
            ChiTiet.add(sanPham);
        }
        rs.close();
        ps.close();
        conn.close();
        return ChiTiet;
    }
    

    public ChiTietSanPham fill(Integer idSanPham) throws SQLException {
        ChiTietSanPham Ct = new ChiTietSanPham();
        Connection conn = (Connection) DBConnection.getConnection();
        String sql = "select SOIMEI,MOTA,SOLUONGTON,GIANHAP,GIABAN,THOIGIANBAOHANH,IDSANPHAM,IDHEDIEUHANH,IDCAMERA,IDRAM,IDKICHTHUOCMANHINH,IDCPU,IDBONHOTRONG,IDLOAIPIN,IDTANSOQUET,IDDUNGLUONGPIN,TRANGTHAI from CHITIETSANPHAM where IDSANPHAM = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idSanPham);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String SoImei = rs.getString("SOIMEI");
            String moTa = rs.getString("MOTA");
            Integer soLuong = rs.getInt("SOLUONGTON");
            Double giaNhap = rs.getDouble("GIANHAP");
            Double giaBan = rs.getDouble("GIABAN");
            String ThoiGianBaoHanh = rs.getString("THOIGIANBAOHANH");
            Integer SanPham = rs.getInt("IDSANPHAM");
            Integer HeDIeuHanh = rs.getInt("IDHEDIEUHANH");
            Integer Camera = rs.getInt("IDCAMERA");
            Integer Ram = rs.getInt("IDRAM");
            Integer KichThuocMan = rs.getInt("IDKICHTHUOCMANHINH");
            Integer Cpu = rs.getInt("IDCPU");
            Integer BoNhoTrong = rs.getInt("IDBONHOTRONG");
            Integer LoaiPin = rs.getInt("IDLOAIPIN");
            Integer TanSoQuet = rs.getInt("IDTANSOQUET");
            Integer DungLuongPin = rs.getInt("IDDUNGLUONGPIN");
            boolean trangThai = rs.getBoolean("TRANGTHAI");

            Ct = new ChiTietSanPham(SoImei, moTa, giaNhap, giaBan, ThoiGianBaoHanh, SanPham, HeDIeuHanh, Camera, Ram, KichThuocMan, Cpu, BoNhoTrong, LoaiPin, TanSoQuet, DungLuongPin, trangThai);
        }
        rs.close();
        ps.close();
        conn.close();
        return Ct;
    }

    public boolean them(ChiTietSanPham chiTiet) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "insert into CHITIETSANPHAM (SOIMEI,MOTA,GIANHAP,GIABAN,THOIGIANBAOHANH,IDSANPHAM,IDHEDIEUHANH,IDCAMERA,IDRAM,IDKICHTHUOCMANHINH,IDCPU,IDBONHOTRONG,IDLOAIPIN,IDTANSOQUET,IDDUNGLUONGPIN,TRANGTHAI,SOLUONGTON,NGAYTAO) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,1, GETDATE())";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, chiTiet.getSoImei());
        ps.setString(2, chiTiet.getMoTa());
        ps.setDouble(3, chiTiet.getGiaNhap());
        ps.setDouble(4, chiTiet.getGiaBan());
        ps.setString(5,  chiTiet.getThoiGianBaoHanh());
        ps.setInt(6, chiTiet.getSanPham());
        ps.setInt(7, chiTiet.getHeDieuHanh());
        ps.setInt(8, chiTiet.getCamera());
        ps.setInt(9, chiTiet.getRam());
        ps.setInt(10, chiTiet.getKichThuocManHinh());
        ps.setInt(11, chiTiet.getCpu());
        ps.setInt(12, chiTiet.getBoNhoTrong());
        ps.setInt(13, chiTiet.getLoaiPin());
        ps.setInt(14, chiTiet.getTanSoQuet());
        ps.setInt(15, chiTiet.getDungLuongPin());

        int index = ps.executeUpdate();
        ps.close();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean sua(ChiTietSanPham chiTiet) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "update CHITIETSANPHAM set MOTA = ? ,GIANHAP = ? ,GIABAN = ? ,THOIGIANBAOHANH = ? ,IDHEDIEUHANH = ? ,IDCAMERA = ? ,IDRAM = ? ,IDKICHTHUOCMANHINH = ? ,IDCPU = ? ,IDBONHOTRONG = ? ,IDLOAIPIN = ? ,IDTANSOQUET = ? ,IDDUNGLUONGPIN = ? WHERE IDSANPHAM = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, chiTiet.getMoTa());
        ps.setDouble(2, chiTiet.getGiaNhap());
        ps.setDouble(3, chiTiet.getGiaBan());
        ps.setString(4,  chiTiet.getThoiGianBaoHanh());
        ps.setInt(5, chiTiet.getHeDieuHanh());
        ps.setInt(6, chiTiet.getCamera());
        ps.setInt(7, chiTiet.getRam());
        ps.setInt(8, chiTiet.getKichThuocManHinh());
        ps.setInt(9, chiTiet.getCpu());
        ps.setInt(10, chiTiet.getBoNhoTrong());
        ps.setInt(11, chiTiet.getLoaiPin());
        ps.setInt(12, chiTiet.getTanSoQuet());
        ps.setInt(13, chiTiet.getDungLuongPin());
        ps.setInt(14, chiTiet.getSanPham());
        int index = ps.executeUpdate();
        ps.close();
        conn.close();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }
    public boolean suaTrangThaiImei(ChiTietSanPham chiTiet ,String imei , Integer trangThai) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "update CHITIETSANPHAM set MOTA = ? ,GIANHAP = ? ,GIABAN = ? ,THOIGIANBAOHANH = ? ,IDHEDIEUHANH = ? ,IDCAMERA = ? ,IDRAM = ? ,IDKICHTHUOCMANHINH = ? ,IDCPU = ? ,IDBONHOTRONG = ? ,IDLOAIPIN = ? ,IDTANSOQUET = ? ,IDDUNGLUONGPIN = ? , TRANGTHAI = ? WHERE SOIMEI = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, chiTiet.getMoTa());
        ps.setDouble(2, chiTiet.getGiaNhap());
        ps.setDouble(3, chiTiet.getGiaBan());
        ps.setString(4,  chiTiet.getThoiGianBaoHanh());
        ps.setInt(5, chiTiet.getHeDieuHanh());
        ps.setInt(6, chiTiet.getCamera());
        ps.setInt(7, chiTiet.getRam());
        ps.setInt(8, chiTiet.getKichThuocManHinh());
        ps.setInt(9, chiTiet.getCpu());
        ps.setInt(10, chiTiet.getBoNhoTrong());
        ps.setInt(11, chiTiet.getLoaiPin());
        ps.setInt(12, chiTiet.getTanSoQuet());
        ps.setInt(13, chiTiet.getDungLuongPin());
        ps.setInt(14, trangThai);
        ps.setString(15, imei);
        int index = ps.executeUpdate();
        ps.close();
        conn.close();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }
    public Integer count(Integer idSP) throws SQLException{
        Integer count = 0 ;
         ChiTietSanPham Ct = new ChiTietSanPham();
        Connection conn = (Connection) DBConnection.getConnection();
        String sql = "Select count(SOIMEI) from CHITIETSANPHAM where IDSANPHAM = ? and TRANGTHAI = 0";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idSP);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            count = rs.getInt(1);
        }
        
        return count;
    }

    public boolean xoa(Integer id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "Update SanPham set TRANGTHAI = 1 where IDSANPHAM = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int index = ps.executeUpdate();
        ps.close();
        conn.close();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public String updateSoLuongTon(Integer soluong, String id) {
        String update = "UPDATE dbo.CHITIETSANPHAM SET SOLUONGTON = SOLUONGTON - ? WHERE SOIMEI = ?";
        try {
            pst = db.getConnection().prepareStatement(update);

            pst.setInt(1, soluong);           
            pst.setString(2, id);
            pst.executeUpdate();
            return "sua thanh cong";
        } catch (Exception e) {

        }
        return "sua khong thanh cong";
    }
    public String updateSoLuongTonVeChiTietSanPham(Integer soluong, String id) {
        String update = "UPDATE dbo.CHITIETSANPHAM SET SOLUONGTON = SOLUONGTON + ? WHERE SOIMEI = ?";
        try {
            pst = db.getConnection().prepareStatement(update);

            pst.setInt(1, soluong);           
            pst.setString(2, id);
            pst.executeUpdate();
            return "sua thanh cong";
        } catch (Exception e) {

        }
        return "sua khong thanh cong";
    }
     public List<SanPhamViewModel> search(String temp) {
         List<SanPhamViewModel> listTemp = new ArrayList<>();
        for (SanPhamViewModel x : ListSanPhamViewModel) {
            if (x.getSoImei().contains(temp)) {
                listTemp.add(x);
            }
        }
        return listTemp;
    }
}
