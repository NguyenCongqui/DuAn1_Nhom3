/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author vanhv
 */
public class HoaDonChiTietViewModel {
    private String soImei;
    private int idSP;
    private String tenSp;
    private int soLuong;
    private float donGia;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(String soImei, int idSP, String tenSp, int soLuong, float donGia) {
        this.soImei = soImei;
        this.idSP = idSP;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
public HoaDonChiTietViewModel(String soImei, String tenSp, int soLuong, float donGia) {
        this.soImei = soImei;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getSoImei() {
        return soImei;
    }

    public void setSoImei(String soImei) {
        this.soImei = soImei;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
    
    
    
}
