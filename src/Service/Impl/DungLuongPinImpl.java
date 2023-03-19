/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.DungLuongPin;
import Repository.DungLuongPinRepository;
import Services.DungLuongPinService;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author trung
 */
public class DungLuongPinImpl implements DungLuongPinService{
    
    DungLuongPinRepository repository;
    
    public DungLuongPinImpl(){
        repository = new DungLuongPinRepository();
    }

    @Override
    public List<DungLuongPin> getAll() throws SQLException {
        return repository.getAll();
    }

    @Override
    public boolean them(DungLuongPin camera) throws SQLException {
        return repository.them(camera);
    }

    @Override
    public boolean sua(DungLuongPin camera, Integer id) throws SQLException {
        return repository.sua(camera,id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
        return repository.xoa(id);
    }

}
