/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.HoaDonBanRepository;
import Services.HoaDonBanService;
import ViewModel.CTHDBanViewModel;
import ViewModel.HoaDonViewModel;
import java.util.List;

/**
 *
 * @author vanhv
 */
public class HoaDonBanImpl implements HoaDonBanService{
    HoaDonBanRepository repo = new HoaDonBanRepository();
    @Override
    public List<CTHDBanViewModel> selectByIdBan(int id) {
    return repo.selectByIdBan(id);
    }

    @Override
    public List<HoaDonViewModel> getAll(String Stringdate) {
        return repo.getAll(Stringdate );
    }

    @Override
    public int ThoiGian(String Stringdate) {
           return repo.ThoiGian(Stringdate);
    }

    @Override
    public HoaDonViewModel FindHDB(int k) {
        return repo.FindHDB(k);
    }
    
}
