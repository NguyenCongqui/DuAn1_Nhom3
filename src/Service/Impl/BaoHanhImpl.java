/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.BaoHanhRepository;
import Services.BaoHanhService;
import ViewModel.BaoHanhViewModel;
import ViewModel.CTHDViewModel;
import ViewModel.ChiTietBaoHanhViewModel;
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

    @Override
    public String insertBaoHanh(BaoHanhViewModel e) {
        return repo.insertBaoHanh(e);
    }

    @Override
    public String insertCTBH(ChiTietBaoHanhViewModel e) {
        return repo.insertCTBH(e);
    }

    @Override
    public String update(String id, BaoHanhViewModel ncc) {
          boolean update = repo.update(id, ncc);
          if (update) {
            return "Hoàn thành bảo hành id : " + id; 
    }
    return "Bảo hành thất bại";
}

    @Override
    public String updateToDB(int id,BaoHanhViewModel ban) {
        return repo.updateToDB(id, ban);
    }
}
