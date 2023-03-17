/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.LoaiPinRepository;
import Services.LoaiPinService;
import ViewModel.LoaiPinViewModel;
import java.util.List;

/**
 *
 * @author vanhv
 */
public class LoaiPinServiceImpl implements LoaiPinService {

    private LoaiPinRepository repository = new LoaiPinRepository();

    @Override
    public List<LoaiPinViewModel> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(LoaiPinViewModel nx) {
        boolean addChucVu = repository.insert(nx);
        if (addChucVu) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(String id, LoaiPinViewModel n) {
        boolean updateChucVu = repository.update(id, n);
        if (updateChucVu) {
            return "Sửa thành công id : " + id;
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id, LoaiPinViewModel n) {
        boolean deleteChucVu = repository.delete(id, n);
        if (deleteChucVu) {
            return "Xóa thành công id : " + id;
        }
        return "Xóa thất bại";

    }

}
