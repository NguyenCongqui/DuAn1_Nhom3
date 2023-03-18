/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.SanPham;
import Repository.SanPhamRepository;
import Services.SanPhamService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author trung
 */
public class SanPhamServiceImpl implements SanPhamService{
    SanPhamRepository sanPhamRepo;
    public SanPhamServiceImpl(){
        sanPhamRepo = new SanPhamRepository();
    }

    @Override
    public List<SanPham> getAll() throws SQLException {
        return sanPhamRepo.getAll();
    }

    @Override
    public boolean them(SanPham sanpham) throws SQLException {
        return sanPhamRepo.them(sanpham);
    }

    @Override
    public boolean sua(SanPham sanpham, Integer id) throws SQLException {
       return sanPhamRepo.sua(sanpham, id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
      return sanPhamRepo.xoa(id);
    }

    @Override
    public SanPham fill(Integer danhmuc) throws SQLException {
        return sanPhamRepo.fill(danhmuc);
    }
}
