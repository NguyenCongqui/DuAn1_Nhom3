/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.BanHangRepository;
import Services.BanHangService;
import ViewModel.HoaDonViewModel;
import java.util.ArrayList;

/**
 *
 * @author vanhv
 */
public class BanHangImpl implements BanHangService{
    BanHangRepository repo = new BanHangRepository();

    @Override
    public Boolean saveHoaDon(HoaDonViewModel hoaDon) {
        return repo.saveHoaDon(hoaDon);
    }

    @Override
    public ArrayList<HoaDonViewModel> getListHoaDon() {
        return repo.getListHoaDon();
    }
    
  

    
}
