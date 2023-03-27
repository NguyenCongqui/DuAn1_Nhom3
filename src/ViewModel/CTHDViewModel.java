/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author vanhv
 */
public class CTHDViewModel {
    private int idHoaDon;
    private String soImei;
    private String tenSP;
    private Float DonGia;
    private int SoLuong;
    private String DanhMuc;
    private String MauSac;
    private String DungLuong;
    private String tenKH;
    private int idKH;
    private String NgayTao;

    public CTHDViewModel() {
    }

    public CTHDViewModel(int idHoaDon, String soImei, String tenSP, Float DonGia, int SoLuong, String DanhMuc, String MauSac, String DungLuong, String tenKH, int idKH, String NgayTao) {
        this.idHoaDon = idHoaDon;
        this.soImei = soImei;
        this.tenSP = tenSP;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.DanhMuc = DanhMuc;
        this.MauSac = MauSac;
        this.DungLuong = DungLuong;
        this.tenKH = tenKH;
        this.idKH = idKH;
        this.NgayTao = NgayTao;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

   

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getSoImei() {
        return soImei;
    }

    public void setSoImei(String soImei) {
        this.soImei = soImei;
    }

    public Float getDonGia() {
        return DonGia;
    }

    public void setDonGia(Float DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDanhMuc() {
        return DanhMuc;
    }

    public void setDanhMuc(String DanhMuc) {
        this.DanhMuc = DanhMuc;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getDungLuong() {
        return DungLuong;
    }

    public void setDungLuong(String DungLuong) {
        this.DungLuong = DungLuong;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }
    
    
}
