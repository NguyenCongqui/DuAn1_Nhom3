/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class TanSoQuet {

    private String id, tenTanSoQuet;
    private Date ngayTao, ngaySua;
    private boolean trangThai;

    public TanSoQuet() {
    }

    public TanSoQuet(String id, String tenTanSoQuet, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.id = id;
        this.tenTanSoQuet = tenTanSoQuet;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenTanSoQuet() {
        return tenTanSoQuet;
    }

    public void setTenTanSoQuet(String tenTanSoQuet) {
        this.tenTanSoQuet = tenTanSoQuet;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
