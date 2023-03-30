/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.duan.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author trung
 */
public class ViewSanPham {
    private Integer idSanPham;
    private String tenSanPham;
    private String moTa ;
    private Integer soLuongTon ;
    private Date thoigianBaoHanh;
    private BigDecimal giaNhap ;
    private BigDecimal giaBan ;
    private Integer idHeDieuHanh;
    private Integer idcamera ;
    private Integer idRam;
    private Integer idKichThuocMan ;
    private Integer idCpu ;
    private Integer idboNhoTrong ;
    private Integer idloaiPin ;
    private Integer idTanSoQuet;
    private  Integer idungLuongPin;
    private Integer idMauSac;
    private boolean  trangThai ;

    public ViewSanPham() {
    }

    public ViewSanPham(Integer idSanPham, String tenSanPham, String moTa, Integer soLuongTon, Date thoigianBaoHanh, BigDecimal giaNhap, BigDecimal giaBan, Integer idHeDieuHanh, Integer idcamera, Integer idRam, Integer idKichThuocMan, Integer idCpu, Integer idboNhoTrong, Integer idloaiPin, Integer idTanSoQuet, Integer idungLuongPin, Integer idMauSac, boolean trangThai) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.thoigianBaoHanh = thoigianBaoHanh;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.idHeDieuHanh = idHeDieuHanh;
        this.idcamera = idcamera;
        this.idRam = idRam;
        this.idKichThuocMan = idKichThuocMan;
        this.idCpu = idCpu;
        this.idboNhoTrong = idboNhoTrong;
        this.idloaiPin = idloaiPin;
        this.idTanSoQuet = idTanSoQuet;
        this.idungLuongPin = idungLuongPin;
        this.idMauSac = idMauSac;
        this.trangThai = trangThai;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Date getThoigianBaoHanh() {
        return thoigianBaoHanh;
    }

    public void setThoigianBaoHanh(Date thoigianBaoHanh) {
        this.thoigianBaoHanh = thoigianBaoHanh;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getIdHeDieuHanh() {
        return idHeDieuHanh;
    }

    public void setIdHeDieuHanh(Integer idHeDieuHanh) {
        this.idHeDieuHanh = idHeDieuHanh;
    }

    public Integer getIdcamera() {
        return idcamera;
    }

    public void setIdcamera(Integer idcamera) {
        this.idcamera = idcamera;
    }

    public Integer getIdRam() {
        return idRam;
    }

    public void setIdRam(Integer idRam) {
        this.idRam = idRam;
    }

    public Integer getIdKichThuocMan() {
        return idKichThuocMan;
    }

    public void setIdKichThuocMan(Integer idKichThuocMan) {
        this.idKichThuocMan = idKichThuocMan;
    }

    public Integer getIdCpu() {
        return idCpu;
    }

    public void setIdCpu(Integer idCpu) {
        this.idCpu = idCpu;
    }

    public Integer getIdboNhoTrong() {
        return idboNhoTrong;
    }

    public void setIdboNhoTrong(Integer idboNhoTrong) {
        this.idboNhoTrong = idboNhoTrong;
    }

    public Integer getIdloaiPin() {
        return idloaiPin;
    }

    public void setIdloaiPin(Integer idloaiPin) {
        this.idloaiPin = idloaiPin;
    }

    public Integer getIdTanSoQuet() {
        return idTanSoQuet;
    }

    public void setIdTanSoQuet(Integer idTanSoQuet) {
        this.idTanSoQuet = idTanSoQuet;
    }

    public Integer getIdungLuongPin() {
        return idungLuongPin;
    }

    public void setIdungLuongPin(Integer idungLuongPin) {
        this.idungLuongPin = idungLuongPin;
    }

    public Integer getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Integer idMauSac) {
        this.idMauSac = idMauSac;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    }

