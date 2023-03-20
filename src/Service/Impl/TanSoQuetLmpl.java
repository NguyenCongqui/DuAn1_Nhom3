/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.TanSoQuet;
import Repository.TanSoQuetRepo;
import Services.ITanSoQuet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author trung
 */
public class TanSoQuetLmpl implements ITanSoQuet{
    private TanSoQuetRepo tanSoRepo;
    
    public TanSoQuetLmpl (){
        tanSoRepo = new TanSoQuetRepo();
    }

    @Override
    public List<TanSoQuet> getAll() throws SQLException {
        return tanSoRepo.getAll();
    }

    @Override
    public boolean them(TanSoQuet Q) throws SQLException {
        return tanSoRepo.them(Q);
    }

    @Override
    public boolean sua(TanSoQuet Q, Integer id) throws SQLException {
        return tanSoRepo.sua(Q, id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
        return tanSoRepo.xoa(id);
    }
}
