/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author trung
 */
public class SanPham {
    private  Integer Id;
    private String Ten;
    private Integer DanhMuc;
    private String Anh;
    private boolean TrangThai;

    public SanPham() {
    }

    public SanPham(Integer Id, String Ten, Integer DanhMuc, String Anh, boolean TrangThai) {
        this.Id = Id;
        this.Ten = Ten;
        this.DanhMuc = DanhMuc;
        this.Anh = Anh;
        this.TrangThai = TrangThai;
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

    public Integer getDanhMuc() {
        return DanhMuc;
    }

    public void setDanhMuc(Integer DanhMuc) {
        this.DanhMuc = DanhMuc;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
   
    
    
}
