/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.ChiTietSanPham;
import java.sql.SQLException;
import java.util.List;
import view.duan.model.ViewSanPham;

/**
 *
 * @author trung
 */
public interface IChiTietSanPham {

    public List<ChiTietSanPham> getAll() throws SQLException;

    public ChiTietSanPham fill(Integer idSanPham) throws SQLException;

    public boolean them(ChiTietSanPham chiTiet) throws SQLException;

    public boolean sua(ChiTietSanPham chiTiet) throws SQLException;

    public boolean xoa(Integer id) throws SQLException;
    public List<ViewSanPham> getAllSP() throws SQLException;
    public List<ChiTietSanPham> getAllImei(Integer idSP) throws SQLException;
    public boolean suaTrangThaiImei(ChiTietSanPham chiTiet ,String imei , Integer trangThai) throws SQLException ;
    public Integer count(Integer idSP) throws SQLException;
    public String updateSoLuongTon(Integer soluong, String id);
}
