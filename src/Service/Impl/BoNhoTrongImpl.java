/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.BoNhoTrong;
import Repository.BoNhoTrongRepository;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hodangquan
 */
public class BoNhoTrongImpl {
    BoNhoTrongRepository boNhoTrongRepository;
    
    public BoNhoTrongImpl(){
        boNhoTrongRepository= new BoNhoTrongRepository();
    }

    public List<BoNhoTrong> getAll() throws SQLException {
        return boNhoTrongRepository.getAll();
    }

    public boolean them(BoNhoTrong bonNhoTrong) throws SQLException {
        return boNhoTrongRepository.them(bonNhoTrong);
    }

    public boolean sua(BoNhoTrong bonNhoTrong, Integer id) throws SQLException {
        return boNhoTrongRepository.sua(bonNhoTrong, id);
    }

    public boolean xoa(Integer id) throws SQLException {
        return boNhoTrongRepository.xoa(id);
    }
    
}
