/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ManHinh;
import java.sql.*;
import Repository.ManHinhRepository;
import Services.IManHinhService;
import java.util.List;

/**
 *
 * @author hodangquan
 */
public class ManHinhImpl implements IManHinhService {

    ManHinhRepository manHinhRepository;

    public ManHinhImpl() {
        manHinhRepository = new ManHinhRepository();
    }

    @Override
    public List<ManHinh> getAll() throws SQLException {
        return manHinhRepository.getAll();
    }

    @Override
    public boolean them(ManHinh manHinh) throws SQLException {
        return manHinhRepository.them(manHinh);
    }

    @Override
    public boolean sua(ManHinh manHinh, Integer id) throws SQLException {
        return manHinhRepository.sua(manHinh, id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
        return manHinhRepository.xoa(id);
    }

}
