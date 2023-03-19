/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.DungLuongPin;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author trung
 */
public interface DungLuongPinService {
    public List<DungLuongPin> getAll() throws SQLException;
     public boolean them(DungLuongPin camera) throws SQLException;
     public boolean sua(DungLuongPin camera,Integer id) throws SQLException;
     public boolean  xoa(Integer id) throws SQLException;
}
