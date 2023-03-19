/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.LoaiPin;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author trung
 */
public interface LoaiPinService {
    public List<LoaiPin> getAll() throws SQLException;
     public boolean them(LoaiPin camera) throws SQLException;
     public boolean sua(LoaiPin camera,Integer id) throws SQLException;
     public boolean  xoa(Integer id) throws SQLException;
}
