/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.TanSoQuet;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface ITanSoQuetService {

    public List<TanSoQuet> getAll();

    public boolean add(TanSoQuet tanSoQuet);

    public boolean update(TanSoQuet tanSoQuet, String id);

    public boolean delete(String id);
}
