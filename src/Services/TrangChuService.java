/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.KhachHangTrangChuViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface TrangChuService {
    int getTongKhachHang();
    int getTongDoanhTHu();
    int getTongSanPham();
    int getTongTonKho();
   public List<KhachHangTrangChuViewModel> getlistkhachHang();
}
