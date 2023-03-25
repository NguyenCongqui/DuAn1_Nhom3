/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import DomainModel.KhachHang;
import Service.Impl.KhachHangImpl;
import Services.IKhachHangService;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.logiin.XDate;

/**
 *
 * @author hodangquan
 */
public class KhachHangForm extends javax.swing.JPanel {
    private IKhachHangService service;
    /**
     * Creates new form KhachHangForm2
     */
    public KhachHangForm() {
    try {
            initComponents();
            service = new KhachHangImpl();
            HienThi();
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void HienThi() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();
        model.setRowCount(0);
        List<KhachHang> list = service.getAll();

        for (KhachHang khachHang : list) {
            Integer trangThai = 0;
            if (khachHang.isTrangThai() == false) {
                trangThai = 0;
            } else {
                trangThai = 1;
            }
            String gioiTinh = "Nam";
            if (khachHang.isGioiTinh() == false) {
                gioiTinh = "Nữ";
            }
            if (trangThai == 0) {
                Object[] data = new Object[]{
                    khachHang.getId(),
                    khachHang.getHoTen(),
                    khachHang.getNgaySinh(),
                    gioiTinh,
                    khachHang.getSoDienThoai(),
                    khachHang.getDiaChi(),};
                model.addRow(data);
            }
        }
    }

    public KhachHang LayTT() throws ParseException {
        String ten = txtTenKhachHang.getText();
        //String ngaySinh = "MM-dd-yyyy";
        //DateFormat df = new SimpleDateFormat(ngaySinh);
        Date ngaySinhs = (XDate.toDate(txtNgaySinh.getText(), "yyyy-MM-dd"));;
        //String ngaySinhs = df.format(date);
        Boolean gioiTinh = true;
        if (rbNam.isSelected() == true) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }
        String sdt = txtSodienthoai.getText();
        String diaChi = txtDiaChi.getText();
        KhachHang kh = new KhachHang(0, ten, ngaySinhs, gioiTinh, sdt, diaChi, true);
        return kh;
    }
    public void fill(){
       
        try {
            int index = tbKhachHang.getSelectedRow();
            String id = tbKhachHang.getValueAt(index, 0).toString();
            String ten = tbKhachHang.getValueAt(index, 1).toString();
            String ngaySinh = tbKhachHang.getValueAt(index, 2).toString();
            String gioiTinh = tbKhachHang.getValueAt(index, 3).toString();
            String sdt = tbKhachHang.getValueAt( index, 4).toString();
            String diaChi = tbKhachHang.getValueAt( index, 5).toString();
            
            
            txtIdKhachHang.setText(id);
            txtTenKhachHang.setText(ten);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh);
            //txtNgaySinh.setDate(date);
            if (gioiTinh.equals("Nam")) {
                rbNam.setSelected(true);
            }
            else{
                rbNam.setSelected(false);
            }
            txtSodienthoai.setText(sdt);
            txtDiaChi.setText(diaChi);
        } catch (ParseException ex) {
            Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new chucNang.Table01();
        jPanel1 = new javax.swing.JPanel();
        txtIdKhachHang = new chucNang.TextField();
        txtTenKhachHang = new chucNang.TextField();
        rbNam = new chucNang.RadioButtonCustom();
        rbNu = new chucNang.RadioButtonCustom();
        txtGioiTinh = new javax.swing.JLabel();
        txtDiaChi = new chucNang.TextField();
        btnThem = new chucNang.MyButton();
        btnSua = new chucNang.MyButton();
        btnXoa = new chucNang.MyButton();
        btnCrear = new chucNang.MyButton();
        txtSodienthoai = new chucNang.TextField();
        txtNgaySinh = new chucNang.TextField();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txtNgaySinh);

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Khách Hàng");

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Khách Hàng", "Tên Khách Hàng", "Ngày Sinh", "Giới Tính", "Số Điện Thoại", "Địa Chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbKhachHangMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhachHang);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtIdKhachHang.setLabelText("ID Khách Hàng\n");
        txtIdKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdKhachHangActionPerformed(evt);
            }
        });

        txtTenKhachHang.setLabelText("Tên Khách Hàng");
        txtTenKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhachHangActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbNam);
        rbNam.setText("Nam");

        buttonGroup1.add(rbNu);
        rbNu.setText("Nữ");

        txtGioiTinh.setText("Giới Tính");

        txtDiaChi.setLabelText("Địa chỉ\n");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa ");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCrear.setText("Clear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        txtSodienthoai.setLabelText("Số điện thoại");
        txtSodienthoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSodienthoaiActionPerformed(evt);
            }
        });

        txtNgaySinh.setEditable(false);
        txtNgaySinh.setLabelText("Ngày Sinh");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(rbNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtSodienthoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txtIdKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtGioiTinh)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKhachHangActionPerformed

    private void txtTenKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhachHangActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            // TODO add your handling code here:
            KhachHang kh = LayTT();
            if (service.them(kh) == true) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                HienThi();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        } catch (ParseException ex) {
            Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            int index = tbKhachHang.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Vui long chon ban ghi can sua");
                return;
            }
            // TODO add your handling code here:
            KhachHang kh = LayTT() ;
            Integer id = Integer.parseInt(tbKhachHang.getValueAt(index, 0).toString());
            if (service.sua(kh,id) == true) {
                JOptionPane.showMessageDialog(this, "Sua thanh cong");
                HienThi();
            }
            else{
                JOptionPane.showMessageDialog(this, "sua that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        Integer id = Integer.parseInt(txtIdKhachHang.getText());
        try {
            if (service.xoa(id)) {
                JOptionPane.showMessageDialog(this, "Xoa thanh cong");
                HienThi();
                
            } else {
                JOptionPane.showMessageDialog(this, "Xoa that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        txtIdKhachHang.setText("");
        txtTenKhachHang.setText("");
        txtNgaySinh.setToolTipText("");
        txtGioiTinh.setText("");
        txtSodienthoai.setText("");
        txtDiaChi.setText("");
    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtSodienthoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSodienthoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSodienthoaiActionPerformed

    private void tbKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMousePressed
        // TODO add your handling code here:
        fill();
    }//GEN-LAST:event_tbKhachHangMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btnCrear;
    private chucNang.MyButton btnSua;
    private chucNang.MyButton btnThem;
    private chucNang.MyButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private chucNang.RadioButtonCustom rbNam;
    private chucNang.RadioButtonCustom rbNu;
    private chucNang.Table01 tbKhachHang;
    private chucNang.TextField txtDiaChi;
    private javax.swing.JLabel txtGioiTinh;
    private chucNang.TextField txtIdKhachHang;
    private chucNang.TextField txtNgaySinh;
    private chucNang.TextField txtSodienthoai;
    private chucNang.TextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
