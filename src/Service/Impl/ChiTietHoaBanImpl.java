/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChiTietHoaDonBan;
import Repository.ChiTietHoaDonBanRepository;
import Services.ChiTietHoaBanService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaBanImpl implements ChiTietHoaBanService{
    ChiTietHoaDonBanRepository rep = new ChiTietHoaDonBanRepository();
    
    @Override
    public String insert(ChiTietHoaDonBan cthd) {
        return rep.insert(cthd);
    }

    @Override
    public void delete(int IdHoaDon, String soImei) {
      try {
            rep.delete(IdHoaDon, soImei);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaBanImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(ChiTietHoaDonBan HDCT) {
     try {
            rep.add(HDCT);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaBanImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
