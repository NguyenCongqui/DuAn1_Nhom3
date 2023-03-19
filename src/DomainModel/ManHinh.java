/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author hodangquan
 */
public class ManHinh {

    private Integer Id;
    private String name;
    private boolean trangThai;

    public ManHinh(Integer Id, String name, boolean trangThai) {
        this.Id = Id;
        this.name = name;
        this.trangThai = trangThai;
    }

    public ManHinh() {
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

}
