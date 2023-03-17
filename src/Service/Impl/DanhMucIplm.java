/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.DanhMuc;
import Repository.DanhMucRepository;
import Services.IDanhMucService;
import java.util.List;

/**
 *
 * @author Dell
 */
public class DanhMucIplm implements IDanhMucService{

    private DanhMucRepository danhMucRepo;
    
    public DanhMucIplm() {
        danhMucRepo=new DanhMucRepository();
    }
    
    
    @Override
    public List<DanhMuc> getAll() {
        try {
            return danhMucRepo.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean add(DanhMuc danhMuc) {
        return danhMucRepo.add(danhMuc);
    }

    @Override
    public boolean update(DanhMuc danhMuc, String id) {
        return danhMucRepo.update(danhMuc, id);
    }

    @Override
    public boolean delete(String id) {
        return danhMucRepo.delete(id);
    }
    
}
