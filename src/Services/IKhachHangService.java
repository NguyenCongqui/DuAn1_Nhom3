/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.KhachHang;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hodangquan
 */
public interface IKhachHangService {
    public List<KhachHang> getAll()throws SQLException;
     public KhachHang fill(Integer danhmuc) throws SQLException;
     public boolean them(KhachHang khachHang)throws SQLException;
     public boolean sua(KhachHang khachHang, Integer id)throws SQLException;
     public boolean xoa(Integer id)throws SQLException;
}
