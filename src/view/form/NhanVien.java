/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import DomainModel.Users;
import Service.Impl.NhanVienImpl;
import Service.Impl.UsersImpl;
import Services.NhanVienServices;
import Services.UsersService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.duan.swing.Excel;
import view.logiin.Auth;

/**
 *
 * @author ADMIN
 */
public class NhanVien extends javax.swing.JPanel {

    private DefaultTableModel tbl_Model;
    private List<Users> listUsers = new ArrayList<>();
    private UsersService usersService = new UsersImpl();
    NhanVienServices nhanVienService = new NhanVienImpl();
    ThemNhanVien nhanVien = new ThemNhanVien();
    ThemNhanVien themNhanVienUpdate;

    public NhanVien() {
        initComponents();
        tbl_Model = (DefaultTableModel) tbl_NhanVien.getModel();
        listUsers = nhanVienService.getListNhanVienDangLam();
        showDataDangLam();
        cbo_tinhTrang.setSelectedIndex(0);
lbl_tim.setVisible(false);
        nhanVien.addEvenFillTable(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nhanVien.insert();
                listUsers = nhanVienService.getListNhanVienDangLam();
                showDataDangLam();
            }
        });
    }
    Locale lc = new Locale("vn", "VN");
    NumberFormat nf = NumberFormat.getInstance(lc);

    public void showDataDangLam() {
        tbl_Model.setRowCount(0);
        for (Users us : listUsers) {
            Object[] row = new Object[]{
                us.getIdUser(),
                us.getSoCanCuocCongDan(),
                us.getHoTen(),
                us.isRole() == true ? "Quản Lý" : "Nhân Viên",
                us.isGioiTinh() == true ? "Nam" : "Nữ",
                us.getNgaySinh(),
                us.getDiaChi(),
                us.getSoDienThoai(),
                us.getNgayTao(),
                us.getNgaySua(),
                us.getEmail(),
                us.getLuong()};
            tbl_Model.addRow(row);
        }
    }

    public void showDataKhongLam() {
        tbl_Model.setRowCount(0);
        List<Users> ListUsers = nhanVienService.getListNhanVienKhongLam();
        for (Users us : ListUsers) {
            Object[] row = new Object[]{
                us.getIdUser(),
                us.getSoCanCuocCongDan(),
                us.getHoTen(),
                us.isRole() == true ? "Quản Lý" : "Nhân Viên",
                us.isGioiTinh() == true ? "Nam" : "Nữ",
                us.getNgaySinh(),
                us.getDiaChi(),
                us.getSoDienThoai(),
                us.getNgayTao(),
                us.getNgaySua(),
                us.getEmail(),
                us.getLuong()};
            tbl_Model.addRow(row);
        }
    }

    public void delete() {
        
             int index = tbl_NhanVien.getSelectedRow();
        int idUsers = (int) tbl_NhanVien.getValueAt(index, 0);
        if (idUsers == Auth.user.getIdUser()) {
            JOptionPane.showMessageDialog(this, "Bạn Không Thể Xóa Bạn Được ???");
            return;
        } else {
            JOptionPane.showMessageDialog(this, nhanVienService.xoaNhanVien(idUsers));
            JOptionPane.showMessageDialog(this, nhanVienService.updateNgaySua(idUsers));
            listUsers = nhanVienService.getListNhanVienDangLam();
            showDataDangLam();
        }
        
       
    }
public void fillTableTimTenNhanVien() {
       tbl_Model= (DefaultTableModel) tbl_NhanVien.getModel();
        tbl_Model.setRowCount(0);
        String keyString = txt_tim.getText();
        List<Users> list =  new ArrayList<>();
           list=nhanVienService.SearchTen(keyString);
        if (list.isEmpty()) {
            lbl_tim.setVisible(true);
            lbl_tim.setText("Không có khách hàng: " + keyString);
            return;
        }
        for (Users us : listUsers) {
            tbl_Model.addRow(new Object[]{
              us.getIdUser(),
                us.getSoCanCuocCongDan(),
                us.getHoTen(),
                us.isRole() == true ? "Quản Lý" : "Nhân Viên",
                us.isGioiTinh() == true ? "Nam" : "Nữ",
                us.getNgaySinh(),
                us.getDiaChi(),
                us.getSoDienThoai(),
                us.getNgayTao(),
                us.getNgaySua(),
                us.getEmail(),
                us.getLuong()});
        }
        
        lbl_tim.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_tim = new chucNang.TextField();
        btn_xuat = new chucNang.MyButton();
        cbo_tinhTrang = new chucNang.Combobox();
        myButton2 = new chucNang.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanVien = new chucNang.Table01();
        myButton3 = new chucNang.MyButton();
        lbl_tim = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nhân Viên");

        txt_tim.setLabelText("Tìm Theo Tên");
        txt_tim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timCaretUpdate(evt);
            }
        });

        btn_xuat.setText("Xuất");
        btn_xuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatActionPerformed(evt);
            }
        });

        cbo_tinhTrang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đang Làm Việc", "Nghỉ Làm" }));
        cbo_tinhTrang.setLabeText("");
        cbo_tinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_tinhTrangActionPerformed(evt);
            }
        });

        myButton2.setText("Thêm NHân Viên");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        tbl_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CCCD", "Họ và tên", "Chức Vụ", "Giới Tính", "Ngày Sinh ", "Địa Chỉ", "Số Điện Thoai", "Ngày Tạo", "Ngày Sửa", "Email", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_NhanVienMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_NhanVien);
        if (tbl_NhanVien.getColumnModel().getColumnCount() > 0) {
            tbl_NhanVien.getColumnModel().getColumn(0).setResizable(false);
            tbl_NhanVien.getColumnModel().getColumn(1).setResizable(false);
            tbl_NhanVien.getColumnModel().getColumn(2).setResizable(false);
            tbl_NhanVien.getColumnModel().getColumn(3).setResizable(false);
            tbl_NhanVien.getColumnModel().getColumn(4).setResizable(false);
            tbl_NhanVien.getColumnModel().getColumn(5).setResizable(false);
            tbl_NhanVien.getColumnModel().getColumn(6).setResizable(false);
            tbl_NhanVien.getColumnModel().getColumn(7).setResizable(false);
            tbl_NhanVien.getColumnModel().getColumn(8).setResizable(false);
            tbl_NhanVien.getColumnModel().getColumn(9).setResizable(false);
            tbl_NhanVien.getColumnModel().getColumn(10).setResizable(false);
            tbl_NhanVien.getColumnModel().getColumn(11).setResizable(false);
        }

        myButton3.setText("Xóa Nhân Viên");
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });

        lbl_tim.setForeground(new java.awt.Color(255, 51, 51));
        lbl_tim.setText("thong bao");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(cbo_tinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btn_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_tinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_tim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_tinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_tinhTrangActionPerformed
        // TODO add your handling code here:
        if (cbo_tinhTrang.getSelectedIndex() == 0) {
            showDataDangLam();
        } else {
            showDataKhongLam();
        }
    }//GEN-LAST:event_cbo_tinhTrangActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_myButton3ActionPerformed

    private void tbl_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanVienMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            System.out.println("hi moi nguoi");
            int index = tbl_NhanVien.getSelectedRow();
            int idUsers = (int) tbl_NhanVien.getValueAt(index, 0);
            String canCuocCongDan = tbl_NhanVien.getValueAt(index, 1).toString();
            String hoTen = tbl_NhanVien.getValueAt(index, 2).toString();
            String chucVu = tbl_NhanVien.getValueAt(index, 3).toString();
            String gioiTinh = tbl_NhanVien.getValueAt(index, 4).toString();
            String ngaySinh = tbl_NhanVien.getValueAt(index, 5).toString();
            String diaChi = tbl_NhanVien.getValueAt(index, 6).toString();
            String soDienThoai = tbl_NhanVien.getValueAt(index, 7).toString();
            String email = tbl_NhanVien.getValueAt(index, 10).toString();
            String luong = tbl_NhanVien.getValueAt(index, 11).toString();
            themNhanVienUpdate = new ThemNhanVien(canCuocCongDan, hoTen, chucVu, gioiTinh, ngaySinh, diaChi, soDienThoai, email, luong, idUsers, cbo_tinhTrang.getSelectedIndex());
            themNhanVienUpdate.setVisible(true);
        }
        if (themNhanVienUpdate == null) {
            return;
        } else {
            themNhanVienUpdate.addEvenUpdate(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    themNhanVienUpdate.update();
                    cbo_tinhTrang.setSelectedIndex(0);
                    listUsers = nhanVienService.getListNhanVienDangLam();
                    showDataDangLam();
                }
            }
            );

        }

    }//GEN-LAST:event_tbl_NhanVienMouseClicked

    private void tbl_NhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanVienMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_NhanVienMouseEntered

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
         nhanVien.setVisible(true);
    }//GEN-LAST:event_myButton2ActionPerformed
    public void excelNhanVien() throws IOException {
        Excel.outExcel((DefaultTableModel) tbl_NhanVien.getModel());
        JOptionPane.showMessageDialog(this,"Xuất File thành công");
    }
    private void btn_xuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatActionPerformed
        // TODO add your handling code here:
        try {
            excelNhanVien();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_xuatActionPerformed

    private void txt_timCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timCaretUpdate
        // TODO add your handling code here:
        fillTableTimTenNhanVien();
    }//GEN-LAST:event_txt_timCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btn_xuat;
    private chucNang.Combobox cbo_tinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_tim;
    private chucNang.MyButton myButton2;
    private chucNang.MyButton myButton3;
    private chucNang.Table01 tbl_NhanVien;
    private chucNang.TextField txt_tim;
    // End of variables declaration//GEN-END:variables
}
