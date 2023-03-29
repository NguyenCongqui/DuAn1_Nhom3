/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChiTietSanPham;
import Repository.ChiTietSpRepo;
import Services.IChiTietSanPham;
import ViewModel.SanPhamViewModel;
import java.sql.SQLException;
import java.util.List;
import view.duan.model.ViewSanPham;

/**
 *
 * @author trung
 */

public class ChiTietSanPhamImpl implements IChiTietSanPham{
    ChiTietSpRepo ChiTietRepo;
    
    public ChiTietSanPhamImpl(){
        ChiTietRepo = new ChiTietSpRepo();
    }

    @Override
    public List<ChiTietSanPham> getAll() throws SQLException {
        return ChiTietRepo.getAll();
    }

    @Override
    public ChiTietSanPham fill(Integer idSanPham) throws SQLException {
        return ChiTietRepo.fill(idSanPham);
    }

    @Override
    public boolean them(ChiTietSanPham chiTiet) throws SQLException {
        return ChiTietRepo.them(chiTiet);
    }

    @Override
    public boolean sua(ChiTietSanPham chiTiet) throws SQLException {
        return ChiTietRepo.sua(chiTiet);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
        return ChiTietRepo.xoa(id);
    }

    @Override
    public List<ViewSanPham> getAllSP() throws SQLException {
        return  ChiTietRepo.getAllSP();
    }

    @Override
    public List<ChiTietSanPham> getAllImei(Integer idSP)throws SQLException {
       return ChiTietRepo.getAllImei(idSP);
    }

    @Override
    public boolean suaTrangThaiImei(ChiTietSanPham chiTiet ,String imei , Integer trangThai) throws SQLException {
        return  ChiTietRepo.suaTrangThaiImei(chiTiet, imei, trangThai);
    }

    @Override
    public Integer count(Integer idSP) throws SQLException {
        return ChiTietRepo.count(idSP);
    }

    @Override
    public String updateSoLuongTon(Integer soluong, String id) {
       return ChiTietRepo.updateSoLuongTon(soluong, id);
    }

    @Override
    public String updateSoLuongTonVeChiTietSanPham(Integer soluong, String id) {
      return ChiTietRepo.updateSoLuongTonVeChiTietSanPham(soluong, id);
    }

    @Override
    public List<SanPhamViewModel> search(String temp) {
      return ChiTietRepo.search(temp);
    }

  
}
