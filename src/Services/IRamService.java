/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.Ram;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author trung
 */
public interface IRamService {
    public List<Ram> getAll() throws SQLException;
     public boolean them(Ram ram) throws SQLException;
     public boolean sua(Ram ram,Integer id) throws SQLException;
     public boolean  xoa(Integer id) throws SQLException;
}
