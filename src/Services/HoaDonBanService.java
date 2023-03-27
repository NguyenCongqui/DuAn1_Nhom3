/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.CTHDBanViewModel;
import ViewModel.HoaDonViewModel;
import java.util.List;

/**
 *
 * @author vanhv
 */
public interface HoaDonBanService {
    List<CTHDBanViewModel> selectByIdBan(int id);
    
    List<HoaDonViewModel> getAll(String Stringdate) ;
    
     int ThoiGian(String Stringdate) ;
     
     HoaDonViewModel FindHDB(int k);
}
