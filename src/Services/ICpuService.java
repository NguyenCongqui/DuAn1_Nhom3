/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.Cpu;
import java.util.List;
import java.sql.*;

/**
 *
 * @author hodangquan
 */
public interface ICpuService  {
     public List<Cpu> getAll() throws SQLException;
     public boolean them(Cpu cpu) throws SQLException;
     public boolean sua(Cpu cpu,Integer id) throws SQLException;
     public boolean  xoa(Integer id) throws SQLException;
}
