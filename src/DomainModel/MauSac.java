/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class MauSac {
  
    private Integer Id;
    private String name;
    private Date ngayTao;
    private Date ngaySua;
    private boolean trangThai;

    public MauSac() {
    }

    public MauSac(Integer Id, String name, boolean trangThai) {
        this.Id = Id;
        this.name = name;
        this.trangThai = trangThai;
    }

    public MauSac(Integer Id, String name, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.Id = Id;
        this.name = name;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
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


