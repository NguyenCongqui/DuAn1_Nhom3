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
public class TanSoQuet {
    private Integer Id;
    private String Ten;
    private boolean TrangThai;
    private Date ngaySua;
    private Date ngayTao;

    public TanSoQuet(Integer Id, String Ten, boolean TrangThai) {
        this.Id = Id;
        this.Ten = Ten;
        this.TrangThai = TrangThai;
    }

    public TanSoQuet(Integer Id, String Ten, boolean TrangThai, Date ngaySua, Date ngayTao) {
        this.Id = Id;
        this.Ten = Ten;
        this.TrangThai = TrangThai;
        this.ngaySua = ngaySua;
        this.ngayTao = ngayTao;
    }

    public TanSoQuet() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }


    
    
}
