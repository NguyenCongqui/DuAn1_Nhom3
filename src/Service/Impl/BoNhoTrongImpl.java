/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.BoNhoTrong;
import Repository.BoNhoTrongRepository;
import Services.IBoNhoTrongService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hodangquan
 */
public class BoNhoTrongImpl implements IBoNhoTrongService  {
    BoNhoTrongRepository boNhoTrongRepository;
    
    public BoNhoTrongImpl(){
        boNhoTrongRepository = new BoNhoTrongRepository();
    }

    @Override
    public List<BoNhoTrong> getAll() throws SQLException {
        return boNhoTrongRepository.getAll();
    }

    @Override
    public boolean them(BoNhoTrong boNhoTrong) throws SQLException {
         return boNhoTrongRepository.them(boNhoTrong);
    }

    @Override
    public boolean sua(BoNhoTrong boNhoTrong, Integer id) throws SQLException {
        return boNhoTrongRepository.sua(boNhoTrong, id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
        return boNhoTrongRepository.xoa( id);
    }
    }

   