/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVienViewModel {
     private int IdUser, IDTaiKhoan;
    private String canCuocCongDan,hoten, soDienThoai, diaChi, email, userName, password;
    private boolean gioiTinh, role, trangThai;
    private Date NgaySinh,ngayTao,ngaySua;
    private Float luong;

    public NhanVienViewModel() {
    }

    public NhanVienViewModel(int IdUser, int IDTaiKhoan, String canCuocCongDan, String hoten, String soDienThoai, String diaChi, String email, String userName, String password, boolean gioiTinh, boolean role, boolean trangThai, Date NgaySinh, Date ngayTao, Date ngaySua, Float luong) {
        this.IdUser = IdUser;
        this.IDTaiKhoan = IDTaiKhoan;
        this.canCuocCongDan = canCuocCongDan;
        this.hoten = hoten;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.gioiTinh = gioiTinh;
        this.role = role;
        this.trangThai = trangThai;
        this.NgaySinh = NgaySinh;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.luong = luong;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public int getIDTaiKhoan() {
        return IDTaiKhoan;
    }

    public void setIDTaiKhoan(int IDTaiKhoan) {
        this.IDTaiKhoan = IDTaiKhoan;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        this.canCuocCongDan = canCuocCongDan;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public Float getLuong() {
        return luong;
    }

    public void setLuong(Float luong) {
        this.luong = luong;
    }
    
    
}
