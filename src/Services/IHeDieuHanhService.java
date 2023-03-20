/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModel.HeDieuHanh;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author trung
 */
public interface IHeDieuHanhService {
     public List<HeDieuHanh> getAll() throws SQLException;
     public boolean them(HeDieuHanh hDH) throws SQLException;
     public boolean sua(HeDieuHanh heDieuHanh , Integer id) throws SQLException;
     public boolean  xoa(Integer id) throws SQLException;
}
