/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author trung
 */
public class HeDieuHanh {
    private Integer Id;
    private String Ten;
    private boolean TrangThai;

    public HeDieuHanh() {
    }

    public HeDieuHanh(Integer Id, String Ten, boolean TrangThai) {
        this.Id = Id;
        this.Ten = Ten;
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

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
