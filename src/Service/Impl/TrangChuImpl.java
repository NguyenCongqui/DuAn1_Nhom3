/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.TrangChuRepository;
import Services.TrangChuService;

/**
 *
 * @author ADMIN
 */
public class TrangChuImpl implements TrangChuService{
    TrangChuRepository rep = new TrangChuRepository();
    
    @Override
    public int getTongKhachHang() {
        return rep.getTongKhachHang();
    }

    @Override
    public int getTongDoanhTHu() {
      return rep.getTongDoanhTHu();
    }

    @Override
    public int getTongSanPham() {
       return rep.getTongSanPham();
    }

    @Override
    public int getTongTonKho() {
        return rep.getTongTonKho();
    }
    
}
