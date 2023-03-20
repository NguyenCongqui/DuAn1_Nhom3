/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Cpu;
import Repository.CpuRepository;
import Services.ICpuService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hodangquan
 */
public class CpuImpl implements ICpuService{
    CpuRepository cpuRepository;
    public CpuImpl(){
        cpuRepository = new CpuRepository();
    }

    @Override
    public List<Cpu> getAll() throws SQLException {
        return cpuRepository.getAll();
    }

    @Override
    public boolean them(Cpu cpu) throws SQLException {
        return cpuRepository.them(cpu);
    }

    @Override
    public boolean sua(Cpu cpu, Integer id) throws SQLException {
        return cpuRepository.sua(cpu, id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
        return cpuRepository.xoa(id);
    }
}
