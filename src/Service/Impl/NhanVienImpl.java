/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.TaiKhoan;
import DomainModel.Users;
import Repository.NhanVienRepostory;
import Services.NhanVienServices;
import ViewModel.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */

public class NhanVienImpl implements NhanVienServices{

    
    NhanVienRepostory rep = new NhanVienRepostory();
    
    public NhanVienImpl() {
    }

    
    
     @Override
    public List<Users> getListNhanVienDangLam() {
       return rep.getListNhanVienDangLam();
    }

    @Override
    public List<Users> getListNhanVienKhongLam() {
        return rep.getListNhanVienKhonglam();
    }

    @Override
    public String themNhanVien(Users us) {
        boolean themNhanVien  = rep.them(us);
        if (themNhanVien) {
            return "Thêm Nhân Viên us thanh cong";
        } else {
            return "thêm nhân viên us khong thành cong";
        }
    }

    @Override
    public String themTaiKhoan(TaiKhoan tk) {
        return rep.insertTaiKhoan(tk);
    }

    @Override
    public String suaNhanVien(Users us) {
      return rep.updateNhanVien(us);
      
    }

    @Override
    public String xoaNhanVien(int id) {
       return rep.Delete(id);
    }

    @Override
    public List<NhanVienViewModel> getAll() {
       return rep.getAll();
    }

    @Override
    public String updateNgaySua(int id) {
        return rep.updateNgaySua(id);
    }

    @Override
    public List<Users> searchTen(String temp) {
       return rep.searchTen(temp);
    }

    
   

   

   
    
}
