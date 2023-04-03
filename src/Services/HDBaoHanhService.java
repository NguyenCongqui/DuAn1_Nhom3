/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.CTHDBaoHanhViewModel;
import ViewModel.HDBaoHanhViewModel;
import java.util.List;

/**
 *
 * @author vanhv
 */
public interface HDBaoHanhService {
    List<HDBaoHanhViewModel> getAllTra() ;
    
    List<CTHDBaoHanhViewModel> selectByIdCT(int id);
    
    HDBaoHanhViewModel FindIDHdBH(Integer k);
}
