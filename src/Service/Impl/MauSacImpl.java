/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.MauSac;
import DomainModel.Ram;
import Repository.MauSacRepository;
import Services.MauSacService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ACER
 */
public class MauSacImpl implements MauSacService{
    MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getAll() throws SQLException {
       return mauSacRepository.getAll();
    }

    @Override
    public boolean them(MauSac mauSac) throws SQLException {
      return mauSacRepository.them(mauSac);
    }

    @Override
    public boolean sua(MauSac mauSac, Integer id) throws SQLException {
        return mauSacRepository.sua(mauSac, id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
       return mauSacRepository.xoa(id);
    }

  
}
