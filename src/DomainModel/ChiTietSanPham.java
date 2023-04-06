/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author trung
 */
public class ChiTietSanPham {
    private String SoImei;
    private String moTa;
    private Double giaNhap;
    private Double giaBan;
    private Integer sanPham;
    private Integer heDieuHanh;
    private Integer camera;
    private Integer ram;
    private Integer KichThuocManHinh;
    private Integer Cpu;
    private Integer boNhoTrong;
    private Integer loaiPin;
    private Integer tanSoQuet;
    private Integer dungLuongPin;
    private Integer mauSac;
    private boolean trangThai;
    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String SoImei, String moTa, Double giaNhap, Double giaBan, Integer sanPham, Integer heDieuHanh, Integer camera, Integer ram, Integer KichThuocManHinh, Integer Cpu, Integer boNhoTrong, Integer loaiPin, Integer tanSoQuet, Integer dungLuongPin, Integer mauSac, boolean trangThai) {
        this.SoImei = SoImei;
        this.moTa = moTa;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.sanPham = sanPham;
        this.heDieuHanh = heDieuHanh;
        this.camera = camera;
        this.ram = ram;
        this.KichThuocManHinh = KichThuocManHinh;
        this.Cpu = Cpu;
        this.boNhoTrong = boNhoTrong;
        this.loaiPin = loaiPin;
        this.tanSoQuet = tanSoQuet;
        this.dungLuongPin = dungLuongPin;
        this.mauSac = mauSac;
        this.trangThai = trangThai;
    }

    public String getSoImei() {
        return SoImei;
    }

    public void setSoImei(String SoImei) {
        this.SoImei = SoImei;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSanPham() {
        return sanPham;
    }

    public void setSanPham(Integer sanPham) {
        this.sanPham = sanPham;
    }

    public Integer getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(Integer heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public Integer getCamera() {
        return camera;
    }

    public void setCamera(Integer camera) {
        this.camera = camera;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getKichThuocManHinh() {
        return KichThuocManHinh;
    }

    public void setKichThuocManHinh(Integer KichThuocManHinh) {
        this.KichThuocManHinh = KichThuocManHinh;
    }

    public Integer getCpu() {
        return Cpu;
    }

    public void setCpu(Integer Cpu) {
        this.Cpu = Cpu;
    }

    public Integer getBoNhoTrong() {
        return boNhoTrong;
    }

    public void setBoNhoTrong(Integer boNhoTrong) {
        this.boNhoTrong = boNhoTrong;
    }

    public Integer getLoaiPin() {
        return loaiPin;
    }

    public void setLoaiPin(Integer loaiPin) {
        this.loaiPin = loaiPin;
    }

    public Integer getTanSoQuet() {
        return tanSoQuet;
    }

    public void setTanSoQuet(Integer tanSoQuet) {
        this.tanSoQuet = tanSoQuet;
    }

    public Integer getDungLuongPin() {
        return dungLuongPin;
    }

    public void setDungLuongPin(Integer dungLuongPin) {
        this.dungLuongPin = dungLuongPin;
    }

    public Integer getMauSac() {
        return mauSac;
    }

    public void setMauSac(Integer mauSac) {
        this.mauSac = mauSac;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

   
}
