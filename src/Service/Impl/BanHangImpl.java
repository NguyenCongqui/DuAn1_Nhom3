/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.DanhMuc;
import DomainModel.HoaDonBan;
import Repository.BanHangRepository;
import Services.BanHangService;
import ViewModel.HoaDonChiTietViewModel;
import ViewModel.HoaDonViewModel;
import ViewModel.SanPhamViewModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<SanPhamViewModel> getListSP(){
        return repo.getListSP();
    }

    @Override
    public List<HoaDonChiTietViewModel> getGioHang(int Id) {
        return repo.getGioHang(Id);
    }

    @Override
    public int getTongTien(float id) {
        return repo.getTongTien(id);
    }

    @Override
    public List<HoaDonViewModel> getListtt(int i) {
        return repo.getListtt(i);
    }

//    @Override
//    public List<SanPhamViewModel> searchDanhMuc(String temp) {
//        return repo.searchDanhMuc(temp);
//    }

//    @Override
//    public List<SanPhamViewModel> searchBNTrong(String temp) {
//        return repo.searchBNTrong(temp);
//    }
//    

    @Override
    public String insert(HoaDonBan hdbh, Integer id) {
        return repo.insert(hdbh,id);
    }

    @Override
    public String upDateTrangThaiHuy(Integer id) {
       return repo.upDateTrangThaiHuy(id);
    }

    @Override
    public List<SanPhamViewModel> search(String temp) {
       return repo.search(temp);
    }

   

   
}
