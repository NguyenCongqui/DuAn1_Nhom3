/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Users;
import Repository.ThongTinCaNhanRepository;
import Services.ThongTinCaNhanService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ThongTinCaNhanImpl implements ThongTinCaNhanService{

    ThongTinCaNhanRepository rep = new ThongTinCaNhanRepository();

    public ThongTinCaNhanImpl() {
    }

    @Override
    public Users getListUsers(Integer id) {
       return rep.getListusers(id);
    }

    @Override
    public String update(int id, Users us) {
       boolean update = rep.updateThongTin(id, us);
        if (update) {
            return "Sửa Thông Tin Thành Công";
        } else {
            return "Sửa Thông Tin Thất Bại";
        }
    }

    @Override
    public List<Users> getListThongTin() {
       return rep.getListThongTin();
    }
    
     
    
    
}
