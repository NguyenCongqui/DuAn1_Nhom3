/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Users;
import Repository.UserRepository;
import Services.UsersService;

/**
 *
 * @author ADMIN
 */
public class UsersImpl implements UsersService{
    UserRepository rep = new UserRepository();
    
    @Override
    public Users getUsers(int idUsers) {
        return rep.getListUsers(idUsers);
    }
    
}
