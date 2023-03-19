/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import java.sql.*;
import DomainModel.ManHinh;
import java.util.List;

/**
 *
 * @author hodangquan
 */
public interface IManHinhService {

    public List<ManHinh> getAll() throws SQLException;

    public boolean them(ManHinh manHinh) throws SQLException;

    public boolean sua(ManHinh manHinh, Integer id) throws SQLException;

    public boolean xoa(Integer id) throws SQLException;
}
