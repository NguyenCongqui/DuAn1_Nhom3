/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.Camera;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author trung
 */
public interface ICameraService {
    public List<Camera> getAll() throws SQLException;
     public boolean them(Camera camera) throws SQLException;
     public boolean sua(Camera camera,Integer id) throws SQLException;
     public boolean  xoa(Integer id) throws SQLException;
}
