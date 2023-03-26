/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author vanhv
 */
public class SanPhamViewModel {
//    private int id;
    private String soImei;
    private String tenSp;
    private String tenDanhMuc;
    private String mauSac;
    private String tenDungLuong;
    private float giaBan;
    private String anh;
    private int soLuong;
    
    public SanPhamViewModel() {
    }

    public SanPhamViewModel(String soImei, String tenSp, String tenDanhMuc, String mauSac, String tenDungLuong, float giaBan, String anh) {
        this.soImei = soImei;
        this.tenSp = tenSp;
        this.tenDanhMuc = tenDanhMuc;
        this.mauSac = mauSac;
        this.tenDungLuong = tenDungLuong;
        this.giaBan = giaBan;
        this.anh = anh;
    }

    public SanPhamViewModel(String soImei, String tenSp, int soLuong,float giaBan, String anh) {
        this.soImei = soImei;
        this.tenSp = tenSp;
        this.giaBan = giaBan;
        this.anh = anh;
        this.soLuong = soLuong;
    }

  

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getSoImei() {
        return soImei;
    }

    public void setSoImei(String soImei) {
        this.soImei = soImei;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getTenDungLuong() {
        return tenDungLuong;
    }

    public void setTenDungLuong(String tenDungLuong) {
        this.tenDungLuong = tenDungLuong;
    }


    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
        
}
