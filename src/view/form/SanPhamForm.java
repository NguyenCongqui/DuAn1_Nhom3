/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import DomainModel.SanPham;
import Service.Impl.AnhService;
import Service.Impl.DanhMucIplm;
import Service.Impl.SanPhamServiceImpl;
import Services.IDanhMucService;
import Services.SanPhamService;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author trung
 */
public class SanPhamForm extends javax.swing.JPanel {
    private SanPhamService service;
    private IDanhMucService dmservice ;
    private AnhService anhService;
    /**
     * Creates new form SanPham
     */
    public SanPhamForm() {
        initComponents();
        service = new SanPhamServiceImpl();
        dmservice = new DanhMucIplm();
        List<DomainModel.DanhMuc> danhMucs = dmservice.getAll();
        for (DomainModel.DanhMuc danhMuc : danhMucs) {
            if (danhMuc.isTrangThai() == false) {
                txtDanhMuc.addItem(danhMuc.getTenDanhMuc());
            }
        }
        
        try {
            HienThi();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void HienThi() throws SQLException{
        TbSanPham.getColumn("Ảnh").setCellRenderer(new myTableCellRender());
        DefaultTableModel model = (DefaultTableModel) TbSanPham.getModel();
        model.setRowCount(0);
        List<SanPham> list = service.getAll();
         List<DomainModel.DanhMuc> danhMucs = dmservice.getAll();
         String tenDM = "";
        for (SanPham sanPham : list) {
            if(sanPham.isTrangThai() == false){
                 JLabel label = new JLabel();
                ImageIcon icon = new ImageIcon(sanPham.getAnh());
                Image img = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(img));
                for (DomainModel.DanhMuc danhMuc : danhMucs) {
                    if (Integer.parseInt(danhMuc.getId()) == sanPham.getDanhMuc()) {
                        tenDM = danhMuc.getTenDanhMuc();
                    }
                }
                  Object[] data = new Object[]{
                    sanPham.getId(),
                    sanPham.getTen(),
                    label,
                    tenDM
                };
                model.addRow(data);
            }
        }
    }
    public SanPham layTT(){
        String ten = txtTenSp.getText();
        String danhMuc1 = (String) txtDanhMuc.getSelectedItem();
        Integer dm = 0;
        List<DomainModel.DanhMuc> danhMucs = dmservice.getAll();
        for (DomainModel.DanhMuc danhMuc : danhMucs) {
            if (danhMuc.isTrangThai() == false) {
                if (danhMuc1.equals(danhMuc.getTenDanhMuc())) {
                    dm = Integer.parseInt(danhMuc.getId());
                }
            }
        }
        
        AnhService anhservice = new AnhService();
         String anh = anhservice.getAnh();
        return new SanPham(0, ten, dm, anh, true);
    };
    
      class myTableCellRender implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            TbSanPham.setRowHeight(70);

            return (Component) value;
        }
    }
    public void fill(){
        try {
            int index = TbSanPham.getSelectedRow();
            String id = TbSanPham.getValueAt(index, 0).toString();
            String ten = TbSanPham.getValueAt(index, 1).toString();
            String danhMuc = TbSanPham.getValueAt(index, 3).toString();
            String anh = TbSanPham.getValueAt(index, 2).toString();
            SanPham c = service.fill(Integer.parseInt(id));
            if (c.getAnh() == null) {
                lbAnh.setIcon(null);
            } else {
                ImageIcon icon = new ImageIcon(c.getAnh());
                Image image = icon.getImage().getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon m = new ImageIcon(image);
                lbAnh.setIcon(m);
            }
            anhService.setAnh(c.getAnh());
            txtId.setText(id);
            txtTenSp.setText(ten);
            txtDanhMuc.setSelectedItem(danhMuc);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbSanPham = new chucNang.Table01();
        jPanel1 = new javax.swing.JPanel();
        txtId = new chucNang.TextField();
        txtTenSp = new chucNang.TextField();
        txtDanhMuc = new chucNang.Combobox();
        btnNew = new chucNang.MyButton();
        btnXoa = new chucNang.MyButton();
        btnSua = new chucNang.MyButton();
        btnThem = new chucNang.MyButton();
        lbAnh = new javax.swing.JLabel();
        btnDungLuongPin = new chucNang.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Sản Phẩm");

        TbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Sản Phẩm", "Tên Sản Phẩm", "Ảnh", "Danh Mục"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TbSanPhamMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TbSanPham);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtId.setFocusable(false);
        txtId.setLabelText("ID Sản Phẩm");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtTenSp.setLabelText("Tên Sản Phẩm");
        txtTenSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSpActionPerformed(evt);
            }
        });

        txtDanhMuc.setLabeText("Danh Mục");

        btnNew.setText("Clear");
        btnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNewMousePressed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnXoaMousePressed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSuaMousePressed(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnThemMousePressed(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        lbAnh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbAnh.setText("Image");
        lbAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbAnhMousePressed(evt);
            }
        });

        btnDungLuongPin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnDungLuongPin.setBorderColor(new java.awt.Color(255, 255, 255));
        btnDungLuongPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDungLuongPinMouseClicked(evt);
            }
        });
        btnDungLuongPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDungLuongPinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtTenSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSpActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void TbSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbSanPhamMousePressed
        // TODO add your handling code here:
        fill();
    }//GEN-LAST:event_TbSanPhamMousePressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void lbAnhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnhMousePressed
        // TODO add your handling code here:
         // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser("D:\\PRO1041");
        int check = chooser.showOpenDialog(null);
        if (check == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File s = chooser.getSelectedFile();
        String fileType = chooser.getTypeDescription(s);
        if (!fileType.equals("JPG File") && !fileType.equals("PNG File")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn file JPG hoặc PNG !");
            return;
        }
        String fileName = s.getAbsolutePath();
        AnhService anhService = new AnhService();
        anhService.setAnh(fileName);
        Image getAbso = null;
        ImageIcon icon = new ImageIcon(fileName);
        Image image = icon.getImage().getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon m = new ImageIcon(image);
        lbAnh.setIcon(m);
    }//GEN-LAST:event_lbAnhMousePressed

    private void btnThemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMousePressed
        // TODO add your handling code here:
        
        SanPham sp = layTT() ;
        try {
            if (service.them(sp) == true) {
                JOptionPane.showMessageDialog(this, "Them thanh cong");
                HienThi();
            }
            else{
                JOptionPane.showMessageDialog(this, "Them that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemMousePressed

    private void btnXoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMousePressed
        try {
            // TODO add your handling code here:
            int index = TbSanPham.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Vui long chon ban ghi can xoa");
                return;
            }
            Integer id = Integer.parseInt(TbSanPham.getValueAt(index, 0).toString());
            if (service.xoa(id) == true) {
                JOptionPane.showMessageDialog(this, "Xoa thanh cong");
                HienThi();
            }
            else{
                JOptionPane.showMessageDialog(this, "Xoa that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaMousePressed

    private void btnSuaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMousePressed
        try {
            // TODO add your handling code here:
            int index = TbSanPham.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Vui long chon ban ghi can sua");
                return;
            }
            SanPham sp = layTT() ;
            Integer id = Integer.parseInt(TbSanPham.getValueAt(index, 0).toString());
            if (service.sua(sp,id) == true) {
                JOptionPane.showMessageDialog(this, "Sua thanh cong");
                HienThi();
            }
            else{
                JOptionPane.showMessageDialog(this, "sua that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaMousePressed

    private void btnNewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMousePressed
        // TODO add your handling code here:
        txtId.setText("");
        txtDanhMuc.setSelectedIndex(0);
        txtTenSp.setText("");
        lbAnh.setIcon(null);
    }//GEN-LAST:event_btnNewMousePressed

    private void btnDungLuongPinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDungLuongPinMouseClicked
        // TODO add your handling code here:
        new DanhMuc().setVisible(true);
    }//GEN-LAST:event_btnDungLuongPinMouseClicked

    private void btnDungLuongPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDungLuongPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDungLuongPinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.Table01 TbSanPham;
    private chucNang.MyButton btnDungLuongPin;
    private chucNang.MyButton btnNew;
    private chucNang.MyButton btnSua;
    private chucNang.MyButton btnThem;
    private chucNang.MyButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAnh;
    private chucNang.Combobox txtDanhMuc;
    private chucNang.TextField txtId;
    private chucNang.TextField txtTenSp;
    // End of variables declaration//GEN-END:variables
}
