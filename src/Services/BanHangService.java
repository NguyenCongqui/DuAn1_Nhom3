/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.DanhMuc;
import DomainModel.HoaDonBan;
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
public interface BanHangService {
    
   Boolean saveHoaDon(HoaDonViewModel hoaDon);
    
   ArrayList<HoaDonViewModel> getListHoaDon();
   
   List<SanPhamViewModel> getListSP();
   
   List<HoaDonChiTietViewModel> getGioHang(int Id) ;
   
//    public int getTongTien(String id);
    
    List<HoaDonViewModel> getListtt(int i);
    public String insert (HoaDonBan hdbh,Integer id);
    public String upDateTrangThaiHuy (Integer id);
    
//    List<SanPhamViewModel> searchDanhMuc(String temp);
  
//     List<SanPhamViewModel> searchBNTrong(String temp) ;

    public int getTongTien(float id);
     public List<SanPhamViewModel> search(String temp);
}
