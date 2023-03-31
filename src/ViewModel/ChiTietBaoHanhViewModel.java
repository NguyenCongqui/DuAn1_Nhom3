/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author vanhv
 */
public class ChiTietBaoHanhViewModel {
    private int idCTBH;
    private String soImei;
    private String tenSp;
    private String tenKH;
    private String danhMuc;
    private String dungLuong;
    private String mauSac;
    private int idBh,idCTSP;
    private String ngayTao;
    private String ngayKthuc;

    public ChiTietBaoHanhViewModel() {
    }

    public ChiTietBaoHanhViewModel(int idCTBH, String soImei, String tenSp, String tenKH, String danhMuc, String dungLuong, String mauSac, int idBh, int idCTSP, String ngayTao, String ngayKthuc) {
        this.idCTBH = idCTBH;
        this.soImei = soImei;
        this.tenSp = tenSp;
        this.tenKH = tenKH;
        this.danhMuc = danhMuc;
        this.dungLuong = dungLuong;
        this.mauSac = mauSac;
        this.idBh = idBh;
        this.idCTSP = idCTSP;
        this.ngayTao = ngayTao;
        this.ngayKthuc = ngayKthuc;
    }

    
    public int getIdCTBH() {
        return idCTBH;
    }

    public void setIdCTBH(int idCTBH) {
        this.idCTBH = idCTBH;
    }

    public String getSoImei() {
        return soImei;
    }

    public void setSoImei(String soImei) {
        this.soImei = soImei;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getIdBh() {
        return idBh;
    }

    public void setIdBh(int idBh) {
        this.idBh = idBh;
    }

    public int getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(int idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayKthuc() {
        return ngayKthuc;
    }

    public void setNgayKthuc(String ngayKthuc) {
        this.ngayKthuc = ngayKthuc;
    }
    
}
