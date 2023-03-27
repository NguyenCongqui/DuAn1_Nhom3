/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.Voucher;
import ViewModel.VouchersViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface VoucherService {
    List<VouchersViewModel> getListVouchers();
    String updateSoLuongTon(Integer idVoucher);
    String insert(Voucher v);
    String updateVoucher(Voucher v);
    String DeleteVoucher(Voucher v);
    List<Voucher> selectAllDate();
    public void updateSoLuongVouchers (Integer id);
    List<VouchersViewModel> searchTen(String temp) ;
}
