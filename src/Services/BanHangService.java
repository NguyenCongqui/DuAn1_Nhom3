/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.HoaDonViewModel;
import java.util.ArrayList;

/**
 *
 * @author vanhv
 */
public interface BanHangService {
    
   Boolean saveHoaDon(HoaDonViewModel hoaDon);
    
   ArrayList<HoaDonViewModel> getListHoaDon();
}
