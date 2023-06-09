/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author vanhv
 */
public class HoaDonViewModel {
    private int idHDB;
    private int idUser,idKhachHang;
    private String ngayTao,ngayThanhToan,tenKhachHang,ghiChu;
    private float tongTien,tienKhachDua,tienTraLai;
    private int trangThai;
    private String tenUser;
    private Integer isVoucher;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(int idUser, String ngayTao, int trangThai) {
        this.idUser = idUser;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public HoaDonViewModel(int idHDB, String ngayTao, int trangThai, String tenUser) {
        this.idHDB = idHDB;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.tenUser = tenUser;
    }

    public HoaDonViewModel(int idHDB, int idUser, int idKhachHang, String ngayTao, String ngayThanhToan, String tenKhachHang, String ghiChu, float tongTien, float tienKhachDua, float tienTraLai, int trangThai, Integer isVoucher) {
        this.idHDB = idHDB;
        this.idUser = idUser;
        this.idKhachHang = idKhachHang;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenKhachHang = tenKhachHang;
        this.ghiChu = ghiChu;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.tienTraLai = tienTraLai;
        this.trangThai = trangThai;
        this.isVoucher = isVoucher;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(float tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public float getTienTraLai() {
        return tienTraLai;
    }

    public void setTienTraLai(float tienTraLai) {
        this.tienTraLai = tienTraLai;
    }

    public Integer getIsVoucher() {
        return isVoucher;
    }

    public void setIsVoucher(Integer isVoucher) {
        this.isVoucher = isVoucher;
    }
    

   

    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public int getIdHDB() {
        return idHDB;
    }

    public void setIdHDB(int idHDB) {
        this.idHDB = idHDB;
    }
    
    
}
