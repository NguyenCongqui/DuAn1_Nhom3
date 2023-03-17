/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Camera;
import Repository.CameraRepository;
import Services.ICameraService;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author trung
 */
public class CameraImpl implements ICameraService{
    
    CameraRepository cameraRepository;
    
    public CameraImpl(){
        cameraRepository = new CameraRepository();
    }

    @Override
    public List<Camera> getAll() throws SQLException {
        return cameraRepository.getAll();
    }

    @Override
    public boolean them(Camera camera) throws SQLException {
        return cameraRepository.them(camera);
    }

    @Override
    public boolean sua(Camera camera, Integer id) throws SQLException {
        return cameraRepository.sua(camera,id);
    }

    @Override
    public boolean xoa(Integer id) throws SQLException {
        return cameraRepository.xoa(id);
    }

}
