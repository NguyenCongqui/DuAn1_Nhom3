/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.BaoHanhViewModel;
import ViewModel.CTHDViewModel;
import java.util.List;

/**
 *
 * @author vanhv
 */
public interface BaoHanhService {
    List<CTHDViewModel> selectById(int id);
    
    List<BaoHanhViewModel> selectDangBH();
    
    List<BaoHanhViewModel> selectDaBH();
}
