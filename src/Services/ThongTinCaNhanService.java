/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.Users;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ThongTinCaNhanService {
    Users getListUsers(Integer id);
    String update (int id, Users us);
    List<Users> getListThongTin();
}
