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
    List<SanPhamViewModel> ListSanPhamViewModel = null;
    
    
    public List<ChiTietSanPham> getAll() throws SQLException {
        List<ChiTietSanPham> ChiTiet = new ArrayList();
        Connection conn = DBConnection.getConnection();
        String sql = "select SOIMEI,MOTA,SOLUONGTON,GIANHAP,GIABAN,IDSANPHAM,IDHEDIEUHANH,IDCAMERA,IDRAM,IDKICHTHUOCMANHINH,IDCPU,IDBONHOTRONG,IDLOAIPIN,IDTANSOQUET,IDDUNGLUONGPIN,IDMAUSAC,TRANGTHAI from CHITIETSANPHAM";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String SoImei = rs.getString("SOIMEI");
            String moTa = rs.getString("MOTA");
            Double giaNhap = rs.getDouble("GIANHAP");
            Double giaBan = rs.getDouble("GIABAN");
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
            Integer MauSac = rs.getInt("IDMAUSAC");
            boolean trangThai = rs.getBoolean("TRANGTHAI");

            ChiTietSanPham c = new ChiTietSanPham(SoImei, moTa, giaNhap, giaBan, SanPham, HeDIeuHanh, Camera, Ram, KichThuocMan, Cpu, BoNhoTrong, LoaiPin, TanSoQuet, DungLuongPin,MauSac, trangThai);
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
        String sql = "select SOIMEI,MOTA,SOLUONGTON,GIANHAP,GIABAN,IDSANPHAM,IDHEDIEUHANH,IDCAMERA,IDRAM,IDKICHTHUOCMANHINH,IDCPU,IDBONHOTRONG,IDLOAIPIN,IDTANSOQUET,IDDUNGLUONGPIN,IDMAUSAC,TRANGTHAI from CHITIETSANPHAM where IDSANPHAM = ? AND TRANGTHAI = 0";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idSP);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String SoImei = rs.getString("SOIMEI");
            String moTa = rs.getString("MOTA");
            Double giaNhap = rs.getDouble("GIANHAP");
            Double giaBan = rs.getDouble("GIABAN");
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
            Integer mauSac = rs.getInt("IDMAUSAC");
            boolean trangThai = rs.getBoolean("TRANGTHAI");

            ChiTietSanPham c = new ChiTietSanPham(SoImei, moTa, giaNhap, giaBan , SanPham, HeDIeuHanh, Camera, Ram, KichThuocMan, Cpu, BoNhoTrong, LoaiPin, TanSoQuet, DungLuongPin, mauSac, trangThai);
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
        String sql = "Select SANPHAM.IDSANPHAM , TENSANPHAM , CHITIETSANPHAM.MOTA, Count(CHITIETSANPHAM.SOIMEI) as 'So luong' , CHITIETSANPHAM.GIANHAP, CHITIETSANPHAM.GIABAN ,CHITIETSANPHAM.IDHEDIEUHANH , CHITIETSANPHAM.IDCAMERA, CHITIETSANPHAM.IDRAM , CHITIETSANPHAM.IDKICHTHUOCMANHINH ,CHITIETSANPHAM.IDCPU,CHITIETSANPHAM.IDBONHOTRONG,CHITIETSANPHAM.IDLOAIPIN, CHITIETSANPHAM.IDTANSOQUET,CHITIETSANPHAM.IDDUNGLUONGPIN,CHITIETSANPHAM.IDMAUSAC , SANPHAM.TRANGTHAI  From SANPHAM\n" +
"Join CHITIETSANPHAM on CHITIETSANPHAM.IDSANPHAM = SANPHAM.IDSANPHAM\n" +
"Group by SANPHAM.IDSANPHAM ,TENSANPHAM , CHITIETSANPHAM.MOTA ,CHITIETSANPHAM.GIANHAP, CHITIETSANPHAM.GIABAN,CHITIETSANPHAM.IDHEDIEUHANH , CHITIETSANPHAM.IDCAMERA, CHITIETSANPHAM.IDRAM , CHITIETSANPHAM.IDKICHTHUOCMANHINH ,CHITIETSANPHAM.IDCPU,CHITIETSANPHAM.IDBONHOTRONG,CHITIETSANPHAM.IDLOAIPIN, CHITIETSANPHAM.IDTANSOQUET,CHITIETSANPHAM.IDDUNGLUONGPIN,CHITIETSANPHAM.IDMAUSAC ,SANPHAM.TRANGTHAI\n" +
"";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Integer idSanPham = rs.getInt(1);
            String tenSanPham = rs.getString(2);
            String moTa = rs.getString(3);
            Integer soLuong = rs.getInt(4);
            BigDecimal giaNhap = rs.getBigDecimal(5);
            BigDecimal giaBan = rs.getBigDecimal(6);
            Integer idHeDieuHanh = rs.getInt(7);
            Integer idCamera = rs.getInt(8);
            Integer idRam = rs.getInt(9);
            Integer idKichThuocMan = rs.getInt(10);
            Integer idCpu = rs.getInt(11);
            Integer idBoNho = rs.getInt(12);
            Integer idLoaiPin = rs.getInt(13);
            Integer idTanSoQuet = rs.getInt(14);
            Integer idDungLuongPin = rs.getInt(15);
            Integer idMauSac = rs.getInt(16);
            Boolean trangThai = rs.getBoolean(17);
            
            ViewSanPham sanPham = new ViewSanPham(idSanPham, tenSanPham, moTa, soLuong, giaNhap, giaBan, idHeDieuHanh, idCamera, idRam, idKichThuocMan, idCpu, idBoNho, idLoaiPin, idTanSoQuet, idDungLuongPin, idMauSac, trangThai);
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
        String sql = "select SOIMEI,MOTA,SOLUONGTON,GIANHAP,GIABAN,IDSANPHAM,IDHEDIEUHANH,IDCAMERA,IDRAM,IDKICHTHUOCMANHINH,IDCPU,IDBONHOTRONG,IDLOAIPIN,IDTANSOQUET,IDDUNGLUONGPIN,IDMAUSAC,TRANGTHAI from CHITIETSANPHAM where IDSANPHAM = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idSanPham);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String SoImei = rs.getString("SOIMEI");
            String moTa = rs.getString("MOTA");
            Integer soLuong = rs.getInt("SOLUONGTON");
            Double giaNhap = rs.getDouble("GIANHAP");
            Double giaBan = rs.getDouble("GIABAN");
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
            Integer MauSac = rs.getInt("IDMAUSAC");
            boolean trangThai = rs.getBoolean("TRANGTHAI");

            Ct = new ChiTietSanPham(SoImei, moTa, giaNhap, giaBan, SanPham, HeDIeuHanh, Camera, Ram, KichThuocMan, Cpu, BoNhoTrong, LoaiPin, TanSoQuet, DungLuongPin, MauSac, trangThai);
        }
        rs.close();
        ps.close();
        conn.close();
        return Ct;
    }

    public boolean them(ChiTietSanPham chiTiet) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "insert into CHITIETSANPHAM (SOIMEI,MOTA,GIANHAP,GIABAN,IDSANPHAM,IDHEDIEUHANH,IDCAMERA,IDRAM,IDKICHTHUOCMANHINH,IDCPU,IDBONHOTRONG,IDLOAIPIN,IDTANSOQUET,IDDUNGLUONGPIN,IDMAUSAC,TRANGTHAI,SOLUONGTON,NGAYTAO) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,1,GETDATE())";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, chiTiet.getSoImei());
        ps.setString(2, chiTiet.getMoTa());
        ps.setDouble(3, chiTiet.getGiaNhap());
        ps.setDouble(4, chiTiet.getGiaBan());
        ps.setInt(5, chiTiet.getSanPham());
        ps.setInt(6, chiTiet.getHeDieuHanh());
        ps.setInt(7, chiTiet.getCamera());
        ps.setInt(8, chiTiet.getRam());
        ps.setInt(9, chiTiet.getKichThuocManHinh());
        ps.setInt(10, chiTiet.getCpu());
        ps.setInt(11, chiTiet.getBoNhoTrong());
        ps.setInt(12, chiTiet.getLoaiPin());
        ps.setInt(13, chiTiet.getTanSoQuet());
        ps.setInt(14, chiTiet.getDungLuongPin());
        ps.setInt(15, chiTiet.getMauSac());
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
        String sql = "update CHITIETSANPHAM set MOTA = ? ,GIANHAP = ? ,GIABAN = ? ,IDHEDIEUHANH = ? ,IDCAMERA = ? ,IDRAM = ? ,IDKICHTHUOCMANHINH = ? ,IDCPU = ? ,IDBONHOTRONG = ? ,IDLOAIPIN = ? ,IDTANSOQUET = ? ,IDDUNGLUONGPIN = ? ,IDMAUSAC = ? WHERE IDSANPHAM = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, chiTiet.getMoTa());
        ps.setDouble(2, chiTiet.getGiaNhap());
        ps.setDouble(3, chiTiet.getGiaBan());
        ps.setInt(4, chiTiet.getHeDieuHanh());
        ps.setInt(5, chiTiet.getCamera());
        ps.setInt(6, chiTiet.getRam());
        ps.setInt(7, chiTiet.getKichThuocManHinh());
        ps.setInt(8, chiTiet.getCpu());
        ps.setInt(9, chiTiet.getBoNhoTrong());
        ps.setInt(10, chiTiet.getLoaiPin());
        ps.setInt(11, chiTiet.getTanSoQuet());
        ps.setInt(12, chiTiet.getDungLuongPin());
        ps.setInt(13, chiTiet.getMauSac());
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
        String sql = "update CHITIETSANPHAM set MOTA = ? ,GIANHAP = ? ,GIABAN = ? ,IDHEDIEUHANH = ? ,IDCAMERA = ? ,IDRAM = ? ,IDKICHTHUOCMANHINH = ? ,IDCPU = ? ,IDBONHOTRONG = ? ,IDLOAIPIN = ? ,IDTANSOQUET = ? ,IDDUNGLUONGPIN = ? ,IDMAUSAC = ?, TRANGTHAI = ? WHERE SOIMEI = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, chiTiet.getMoTa());
        ps.setDouble(2, chiTiet.getGiaNhap());
        ps.setDouble(3, chiTiet.getGiaBan());
        ps.setInt(4, chiTiet.getHeDieuHanh());
        ps.setInt(5, chiTiet.getCamera());
        ps.setInt(6, chiTiet.getRam());
        ps.setInt(7, chiTiet.getKichThuocManHinh());
        ps.setInt(8, chiTiet.getCpu());
        ps.setInt(9, chiTiet.getBoNhoTrong());
        ps.setInt(10, chiTiet.getLoaiPin());
        ps.setInt(11, chiTiet.getTanSoQuet());
        ps.setInt(12, chiTiet.getDungLuongPin());
        ps.setInt(13, chiTiet.getMauSac());
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
