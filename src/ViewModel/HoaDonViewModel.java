/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author vanhv
 */
public class HoaDonViewModel {
    private int idHDB;
    private int idUser;
    private String ngayTao;
    private int trangThai;
    private String tenUser;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(int idUser, String ngayTao, int trangThai) {
        this.idUser = idUser;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public HoaDonViewModel(int idHDB, String ngayTao, int trangThai, String tenUser) {
        this.idHDB = idHDB;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.tenUser = tenUser;
    }

   

    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public int getIdHDB() {
        return idHDB;
    }

    public void setIdHDB(int idHDB) {
        this.idHDB = idHDB;
    }
    
    
}
