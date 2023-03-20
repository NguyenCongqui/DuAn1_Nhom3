/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.BoNhoTrong;
import java.util.List;
import java.sql.*;

/**
 *
 * @author hodangquan
 */
public interface IBoNhoTrongService {
    public List<BoNhoTrong> getAll() throws SQLException;
     public boolean them(BoNhoTrong boNhoTrong) throws SQLException;
     public boolean sua(BoNhoTrong boNhoTrong,Integer id) throws SQLException;
     public boolean  xoa(Integer id) throws SQLException;
}
