/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import Service.Impl.DanhMucIplm;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.trangchu.trangchu;

/**
 *
 * @author Dell
 */
public class DanhMuc extends javax.swing.JFrame {

    private DanhMucIplm danhMucIplm;
    private DefaultTableModel dtm;

    /**
     * Creates new form DanhMuc
     */
    public DanhMuc() {
        try {
            initComponents();
            dtm = (DefaultTableModel) tbDanhMuc.getModel();
            danhMucIplm = new DanhMucIplm();
            String[] header = {"ID", "Tên danh mục"};
            dtm.setColumnIdentifiers(header);
            HienThi();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMuc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public void insert(){
        DomainModel.DanhMuc dm = new DomainModel.DanhMuc();
        if (txtTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên!");
            return;
        }
        if (txtTen.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự");
            return;
        }
        dm.setTenDanhMuc(txtTen.getText());
        dm.setTrangThai(true);
        if (danhMucIplm.add(dm)) {
            try {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                HienThi();
                load();
               
            } catch (SQLException ex) {
                Logger.getLogger(DanhMuc.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thất bại!");
            return;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table011 = new chucNang.Table01();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTen = new chucNang.TextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDanhMuc = new chucNang.Table01();
        btnAdd = new chucNang.MyButton();
        btnEdit = new chucNang.MyButton();
        btnDelete = new chucNang.MyButton();
        btnNew = new chucNang.MyButton();
        txtId = new javax.swing.JLabel();

        table011.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table011);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("DANH MỤC");

        txtTen.setLabelText("Tên danh mục");

        tbDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Tên Danh Mục", "Ngày Sửa", "Ngày Tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDanhMucMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDanhMuc);

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("Clear");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        txtId.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_btnAddActionPerformed

    private void tbDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhMucMouseClicked
        // TODO add your handling code here:
        fillData();
    }//GEN-LAST:event_tbDanhMucMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không");
        if (xacNhan != JOptionPane.YES_OPTION) {
            return;
        }
        int index = tbDanhMuc.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn!");
            return;
        }
        int kq = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa!", "Cảnh báo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.YES_OPTION);
        if (kq == JOptionPane.YES_OPTION) {
            List<DomainModel.DanhMuc> danhMucs = danhMucIplm.getAll();
            DomainModel.DanhMuc dm = danhMucs.get(index);
            try {
                String id = tbDanhMuc.getValueAt(index, 0).toString();
                danhMucIplm.delete(id);
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                HienThi();
                txtId.setText("");
                txtTen.setText("");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không");
        if (xacNhan != JOptionPane.YES_OPTION) {
            return;
        }
        int index = tbDanhMuc.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chọn để sửa!");
            return;
        }
        List<DomainModel.DanhMuc> danhMucs = danhMucIplm.getAll();
        DomainModel.DanhMuc dm = danhMucs.get(index);
        dm.setTenDanhMuc(txtTen.getText());
        try {
            String id = tbDanhMuc.getValueAt(index, 0).toString();
            danhMucIplm.update(dm, id);
            JOptionPane.showMessageDialog(this, "Update thành công!");
            HienThi();
            load();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnEditActionPerformed

    public void fillData() {
        int index = tbDanhMuc.getSelectedRow();
        String id = tbDanhMuc.getValueAt(index, 0).toString();
        String ten = tbDanhMuc.getValueAt(index, 1).toString();
        txtId.setText(id);
        txtTen.setText(ten);

    }

    public void HienThi() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tbDanhMuc.getModel();
        model.setRowCount(0);
        List<DomainModel.DanhMuc> list = danhMucIplm.getAll();

        for (DomainModel.DanhMuc camera : list) {
            Integer trangThai = 0;
            if (camera.isTrangThai() == false) {
                trangThai = 0;
            } else {
                trangThai = 1;
            }
            if (trangThai == 0) {
                Object[] data = new Object[]{
                    camera.getId(),
                    camera.getTenDanhMuc(),
                    camera.getNgayTao(),
                    camera.getNgaySua()};
                model.addRow(data);
            }
        }
    }

    public void load() {
        txtId.setText("");
        txtTen.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhMuc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btnAdd;
    private chucNang.MyButton btnDelete;
    private chucNang.MyButton btnEdit;
    private chucNang.MyButton btnNew;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private chucNang.Table01 table011;
    private chucNang.Table01 tbDanhMuc;
    private javax.swing.JLabel txtId;
    private chucNang.TextField txtTen;
    // End of variables declaration//GEN-END:variables

    void addEvenFillTable(ActionListener evt) {
       btnAdd.addActionListener(evt);
    }
}
