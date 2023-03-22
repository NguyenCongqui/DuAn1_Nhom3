/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface QuenMatKhauService {
    List<NhanVienViewModel> Getlist();
    String Update (NhanVienViewModel nv);
}
