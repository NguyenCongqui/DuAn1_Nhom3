/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.TanSoQuet;
import Repository.TanSoQuetRepository;
import Services.ITanSoQuetService;
import java.util.List;

/**
 *
 * @author Dell
 */
public class TanSoQuetIplm implements ITanSoQuetService {

    private TanSoQuetRepository tanSoQuetRepo;

    public TanSoQuetIplm() {
        tanSoQuetRepo = new TanSoQuetRepository();
    }

    @Override
    public List<TanSoQuet> getAll() {
        try {
            return tanSoQuetRepo.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean add(TanSoQuet tanSoQuet) {
        return tanSoQuetRepo.add(tanSoQuet);
    }

    @Override
    public boolean update(TanSoQuet tanSoQuet, String id) {
        return tanSoQuetRepo.update(tanSoQuet, id);
    }

    @Override
    public boolean delete(String id) {
        return tanSoQuetRepo.delete(id);
    }

}
