/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChiTietHoaDonBan;
import Repository.ChiTietHoaDonBanRepository;
import Services.ChiTietHoaBanService;

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
    
}
