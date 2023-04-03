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
public class HDBaoHanhViewModel {
    private int IdBaoHanh;
    private int IdHDBan;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int IdKh;
    private String tenKH;
    private int Sdt;
    private String ghiChu;
    private String tenUser;
    
    public HDBaoHanhViewModel() {
    }

    public int getIdBaoHanh() {
        return IdBaoHanh;
    }

    public void setIdBaoHanh(int IdBaoHanh) {
        this.IdBaoHanh = IdBaoHanh;
    }

    public int getIdHDBan() {
        return IdHDBan;
    }

    public void setIdHDBan(int IdHDBan) {
        this.IdHDBan = IdHDBan;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getIdKh() {
        return IdKh;
    }

    public void setIdKh(int IdKh) {
        this.IdKh = IdKh;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }
    
    
}
