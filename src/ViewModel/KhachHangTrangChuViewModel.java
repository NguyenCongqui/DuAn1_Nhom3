/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author ADMIN
 */
public class KhachHangTrangChuViewModel {
    private String hoTen,tenSanPham,mauSac,boNhoTrong;
    private boolean gioiTinh;
    private int soLuong;
    private String diaChi,soDienThoai,ngayMua;

    public KhachHangTrangChuViewModel() {
    }

    public KhachHangTrangChuViewModel(String hoTen, String tenSanPham, String mauSac, String boNhoTrong, boolean gioiTinh, int soLuong, String diaChi, String soDienThoai, String ngayMua) {
        this.hoTen = hoTen;
        this.tenSanPham = tenSanPham;
        this.mauSac = mauSac;
        this.boNhoTrong = boNhoTrong;
        this.gioiTinh = gioiTinh;
        this.soLuong = soLuong;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.ngayMua = ngayMua;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }


    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getBoNhoTrong() {
        return boNhoTrong;
    }

    public void setBoNhoTrong(String boNhoTrong) {
        this.boNhoTrong = boNhoTrong;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
    
}
