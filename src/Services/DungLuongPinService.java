/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.DungLuongPinViewModel;
import java.util.List;

/**
 *
 * @author vanhv
 */
public interface DungLuongPinService {
     List<DungLuongPinViewModel> getAll();
    
    String insert(DungLuongPinViewModel nx);
    
    String update(String id, DungLuongPinViewModel n);
    
    String delete(String id, DungLuongPinViewModel n);
    
}
