/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.HeDieuHanh;
import Repository.HeDieuHanhRepository;
import Services.IHeDieuHanhService;
import java.util.List;

/**
 *
 * @author Dell
 */
public class HeDieuHanhIplm implements IHeDieuHanhService{
    private HeDieuHanhRepository HeDieuHanhRepo ;

    public HeDieuHanhIplm() {
        this.HeDieuHanhRepo = new HeDieuHanhRepository();
    }
    
    @Override
    public List<HeDieuHanh> getAll() {
        try {
            return HeDieuHanhRepo.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean add(HeDieuHanh heDieuHanh) {
        return HeDieuHanhRepo.add(heDieuHanh);
    }

    @Override
    public boolean update(HeDieuHanh heDieuHanh, String id) {
        return HeDieuHanhRepo.update(heDieuHanh, id);
    }

    @Override
    public boolean delete(String id) {
        return HeDieuHanhRepo.delete(id);
    }
    
}
