/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.LoaiPin;
import Repository.LoaiPinRepository;
import Services.LoaiPinService;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author trung
 */
public class LoaiPinImpl implements LoaiPinService{
    
    LoaiPinRepository repository;
    
    public LoaiPinImpl(){
        repository = new LoaiPinRepository();
    }

    @Override
    public List<LoaiPin> getAll() throws SQLException {
        return repository.getAll();
    }

    @Override
    public boolean them(LoaiPin camera) throws SQLException {
        return repository.them(camera);
    }

    @Override
    public boolean sua(LoaiPin camera, Integer id) throws SQLException {
        return repository.sua(camera,id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
        return repository.xoa(id);
    }

}
