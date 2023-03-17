/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.LoaiPinViewModel;
import java.util.List;

/**
 *
 * @author vanhv
 */
public interface LoaiPinService {
     List<LoaiPinViewModel> getAll();
    
    String insert(LoaiPinViewModel nx);
    
    String update(String id, LoaiPinViewModel n);
    
    String delete(String id, LoaiPinViewModel n);
    
}
