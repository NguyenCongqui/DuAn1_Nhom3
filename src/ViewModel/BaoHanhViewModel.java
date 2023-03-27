/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author vanhv
 */
public class BaoHanhViewModel {
      private int idHDBH;
    private int idHDBan;
    private int idKhachHang;
//    private int IDUsers;
    private Date thoiGian;
    private String khachHang;
    private int Sdt;
//    private float tongTienHoanTra;
    private String ghiChu;

    public BaoHanhViewModel() {
    }

    public BaoHanhViewModel(int idHDBH, int idHDBan, int idKhachHang, Date thoiGian, String khachHang, int Sdt, String ghiChu) {
        this.idHDBH = idHDBH;
        this.idHDBan = idHDBan;
        this.idKhachHang = idKhachHang;
        this.thoiGian = thoiGian;
        this.khachHang = khachHang;
        this.Sdt = Sdt;
        this.ghiChu = ghiChu;
    }

    public int getIdHDBH() {
        return idHDBH;
    }

    public void setIdHDBH(int idHDBH) {
        this.idHDBH = idHDBH;
    }

    public int getIdHDBan() {
        return idHDBan;
    }

    public void setIdHDBan(int idHDBan) {
        this.idHDBan = idHDBan;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public int getSdt() {
        return Sdt;
    }

    public void setSdt(int Sdt) {
        this.Sdt = Sdt;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
    

}
