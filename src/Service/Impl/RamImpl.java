/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Ram;
import Repository.RamRepository;
import Services.IRamService;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author trung
 */
public class RamImpl implements IRamService{
    
    RamRepository ramRepository;
    
    public RamImpl(){
        ramRepository = new RamRepository();
    }

    @Override
    public List<Ram> getAll() throws SQLException {
        return ramRepository.getAll();
    }

    @Override
    public boolean them(Ram ram) throws SQLException {
        return ramRepository.them(ram);
    }

    @Override
    public boolean sua(Ram ram, Integer id) throws SQLException {
        return ramRepository.sua(ram,id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
        return ramRepository.xoa(id);
    }

}
