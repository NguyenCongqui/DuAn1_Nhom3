/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Voucher;
import Repository.VoucherRepository;
import Services.VoucherService;
import ViewModel.VouchersViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class VoucherImpl implements VoucherService{
    VoucherRepository rep = new VoucherRepository();
    @Override
    public List<VouchersViewModel> getListVouchers() {
        return rep.getLisVoucher();
    }

    @Override
    public String updateSoLuongTon(Integer idVoucher) {
        return rep.updateSoLuongTon(idVoucher);
    }

    @Override
    public String insert(Voucher v) {
        return rep.insert(v);
    }

    @Override
    public String updateVoucher(Voucher v) {
        return rep.updateVoucher(v);
    }

    @Override
    public String DeleteVoucher(Voucher v) {
       return rep.DeleteVoucher(v);
    }

    @Override
    public List<Voucher> selectAllDate() {
        return rep.selectAllDate();
    }

    @Override
    public void updateSoLuongVouchers(Integer id) {
       return;
    }

    @Override
    public List<VouchersViewModel> searchTen(String temp) {
       return rep.searchTen(temp);
    }
    
}
