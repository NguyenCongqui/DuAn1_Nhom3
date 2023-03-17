/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;


import Repository.DungLuongPinRepository;
import Services.DungLuongPinService;
import ViewModel.DungLuongPinViewModel;
import java.util.List;

/**
 *
 * @author vanhv
 */
public class DungLuongPinServiceImpl implements DungLuongPinService {

    private DungLuongPinRepository repository = new DungLuongPinRepository();

    @Override
    public List<DungLuongPinViewModel> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(DungLuongPinViewModel nx) {
        boolean addChucVu = repository.insert(nx);
        if (addChucVu) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(String id, DungLuongPinViewModel n) {
        boolean updateChucVu = repository.update(id, n);
        if (updateChucVu) {
            return "Sửa thành công id : " + id;
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id, DungLuongPinViewModel n) {
        boolean deleteChucVu = repository.delete(id, n);
        if (deleteChucVu) {
            return "Xóa thành công id : " + id;
        }
        return "Xóa thất bại";

    }

}
