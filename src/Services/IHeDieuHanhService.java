/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.HeDieuHanh;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IHeDieuHanhService {
    
    public List<HeDieuHanh> getAll();

    public boolean add(HeDieuHanh heDieuHanh);

    public boolean update(HeDieuHanh heDieuHanh, String id);

    public boolean delete(String id);
}
