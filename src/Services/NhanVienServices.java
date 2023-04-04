/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.TaiKhoan;
import DomainModel.Users;
import ViewModel.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NhanVienServices {
    List<Users> getListNhanVienDangLam();
        List<Users> getListNhanVienKhongLam();
        String themNhanVien(Users us);
        String themTaiKhoan (TaiKhoan tk);
        String suaNhanVien(Users us);
        String xoaNhanVien(int id);
        List<NhanVienViewModel> getAll();
        String updateNgaySua(int id);
        public List<Users> searchTen(String temp);

}
