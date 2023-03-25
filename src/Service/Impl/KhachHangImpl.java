/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;
import DomainModel.KhachHang;
import Repository.KhachHangRepository;
import Services.IKhachHangService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hodangquan
 */
public class KhachHangImpl implements IKhachHangService {
    KhachHangRepository khachHangRepo;
    public KhachHangImpl(){
        khachHangRepo = new KhachHangRepository();
    }

    @Override
    public List<KhachHang> getAll() throws SQLException {
        return khachHangRepo.getAll();
    }

//    @Override
//    public KhachHang fill(Integer danhmuc) throws SQLException {
//        
//        return khachHangRepo.fill(danhmuc);
//    }

    @Override
    public boolean them(KhachHang khachHang) throws SQLException {
        return khachHangRepo.them(khachHang);
    }

    @Override
    public boolean sua(KhachHang khachHang, Integer id) throws SQLException {
        return khachHangRepo.sua(khachHang, id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
        return khachHangRepo.xoa(id);
    }
    
}
