/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.BaoHanhRepository;
import Services.BaoHanhService;
import ViewModel.BaoHanhViewModel;
import ViewModel.CTHDViewModel;
import java.util.List;

/**
 *
 * @author vanhv
 */
public class BaoHanhImpl implements BaoHanhService{
    BaoHanhRepository repo = new BaoHanhRepository();
    
    @Override
    public List<CTHDViewModel> selectById(int id) {
        return repo.selectById(id);
    }

    @Override
    public List<BaoHanhViewModel> selectDangBH() {
        return repo.selectDangBH();
    }

    @Override
    public List<BaoHanhViewModel> selectDaBH() {
        return repo.selectDaBH();
    }
    
}