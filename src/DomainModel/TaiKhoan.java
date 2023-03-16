/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author ADMIN
 */
public class TaiKhoan {
    private int idTaiKhoan;
    private int idUsers;
    private String usersName;
    private String matKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(int idTaiKhoan, int idUsers, String usersName, String matKhau) {
        this.idTaiKhoan = idTaiKhoan;
        this.idUsers = idUsers;
        this.usersName = usersName;
        this.matKhau = matKhau;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
            
            
}
