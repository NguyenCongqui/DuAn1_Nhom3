/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.util.List;

/**
 *
 * @author HANGOCHAN
 */
public class ImeiServices {
    public  static Integer check ;
    public static List<String> list ;
    public static List<String> listXoa ;
    public static List<String> listThem ;
    public static List<String> getList() {
        return list;
    }

    public static void setList(List<String> list) {
        ImeiServices.list = list;
    }
    

    public static List<String> getListXoa() {
        return listXoa;
    }

    public static void setListXoa(List<String> listXoa) {
        ImeiServices.listXoa = listXoa;
    }

    public static List<String> getListThem() {
        return listThem;
    }

    public static void setListThem(List<String> listThem) {
        ImeiServices.listThem = listThem;
    }

    public static Integer getCheck() {
        return check;
    }

    public static void setCheck(Integer check) {
        ImeiServices.check = check;
    }

    
    
    
    
    
    
    
}
