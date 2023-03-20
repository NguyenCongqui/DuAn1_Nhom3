/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.TanSoQuet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author trung
 */
public interface ITanSoQuet {
    public List<TanSoQuet> getAll() throws SQLException;
    public boolean them(TanSoQuet Q) throws SQLException;
    public boolean sua(TanSoQuet Q , Integer id) throws SQLException;
    public boolean  xoa(Integer id) throws SQLException;
}
