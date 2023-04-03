/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.HDBaoHanhRepository;
import Services.HDBaoHanhService;
import ViewModel.CTHDBaoHanhViewModel;
import ViewModel.HDBaoHanhViewModel;
import java.util.List;

/**
 *
 * @author vanhv
 */
public class HDBaoHanhImpl implements HDBaoHanhService{
    HDBaoHanhRepository repo = new HDBaoHanhRepository();
    
    @Override
    public List<HDBaoHanhViewModel> getAllTra() {
        return repo.getAllTra();
    }

    @Override
    public List<CTHDBaoHanhViewModel> selectByIdCT(int id) {
        return repo.selectByIdCT(id);
    }

    @Override
    public HDBaoHanhViewModel FindIDHdBH(Integer k) {
        return repo.FindIDHdBH(k);
    }
    
}
