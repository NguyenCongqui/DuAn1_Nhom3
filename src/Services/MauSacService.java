/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.MauSac;
import DomainModel.Ram;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface MauSacService {
    public List<MauSac> getAll() throws SQLException;
     public boolean them(MauSac mauSac) throws SQLException;
     public boolean sua(MauSac mauSac,Integer id) throws SQLException;
     public boolean  xoa(Integer id) throws SQLException;
}
