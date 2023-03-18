/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.SanPham;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author trung
 */
public interface SanPhamService {
     public List<SanPham> getAll()throws SQLException;
     public SanPham fill(Integer danhmuc) throws SQLException;
     public boolean them(SanPham sanpham)throws SQLException;
     public boolean sua(SanPham sanpham, Integer id)throws SQLException;
     public boolean xoa(Integer id)throws SQLException;
}
