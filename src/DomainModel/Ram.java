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
public class Ram {

    private Integer Id;
    private String name;
    private boolean trangThai;
    private Date ngaySua;
    private Date ngayTao;

    public Ram() {
    }

    public Ram(Integer Id, String name, boolean trangThai, Date ngaySua, Date ngayTao) {
        this.Id = Id;
        this.name = name;
        this.trangThai = trangThai;
        this.ngaySua = ngaySua;
        this.ngayTao = ngayTao;
    }

    public Ram(Integer Id, String name, boolean trangThai) {
        this.Id = Id;
        this.name = name;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
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
