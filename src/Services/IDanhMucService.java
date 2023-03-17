/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.DanhMuc;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IDanhMucService {

    public List<DanhMuc> getAll();

    public boolean add(DanhMuc danhMuc);

    public boolean update(DanhMuc danhMuc, String id);

    public boolean delete(String id);
}
