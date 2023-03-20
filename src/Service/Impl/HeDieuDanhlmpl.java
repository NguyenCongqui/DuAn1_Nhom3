/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.HeDieuHanh;
import Repository.HeDieuHanhRepo;
import Services.IHeDieuHanhService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author trung
 */
public class HeDieuDanhlmpl implements IHeDieuHanhService{
    HeDieuHanhRepo heDieuHanhRepo;
    
    public HeDieuDanhlmpl(){
        heDieuHanhRepo = new HeDieuHanhRepo();
    }

    @Override
    public List<HeDieuHanh> getAll() throws SQLException {
      return heDieuHanhRepo.getAll();
    }

    @Override
    public boolean them(HeDieuHanh hDH) throws SQLException {
       return heDieuHanhRepo.them(hDH);
    }

    @Override
    public boolean sua(HeDieuHanh heDieuHanh, Integer id) throws SQLException {
       return heDieuHanhRepo.sua(heDieuHanh, id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
       return heDieuHanhRepo.xoa(id);
    }
}
