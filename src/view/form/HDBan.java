/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import DomainModel.KhachHang;
import Service.Impl.BaoHanhImpl;
import Service.Impl.HoaDonBanImpl;
import Service.Impl.KhachHangImpl;
import Services.BaoHanhService;
import Services.HoaDonBanService;
import Services.IKhachHangService;
import ViewModel.BaoHanhViewModel;
import ViewModel.HoaDonViewModel;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vanhv
 */
public class HDBan extends javax.swing.JPanel {
 DefaultTableModel tableModel = new DefaultTableModel();
    List<HoaDonViewModel> listCTB;
    HoaDonBanService chitiethoadonservice = new HoaDonBanImpl();
    List<KhachHang> listKHg;
    BaoHanhService baoHanhService = new BaoHanhImpl();
    
      boolean flag = false;
    /**
     * Creates new form HDBan
     */
    public HDBan() {
        initComponents();
        setOpaque(false);
    chitiethoadonservice = new HoaDonBanImpl();
        fillData();
         btnFirst.setEnabled(false);
        btnFirst.setVisible(false);
        btnBack.setEnabled(false);
        btnBack.setVisible(false);
        cbbPagination.setEnabled(false);
        cbbPagination.setVisible(false);
        btnNext.setEnabled(false);
        btnNext.setVisible(false);
        btnLast.setEnabled(false);
        btnLast.setVisible(false);
    }
    int totalPage = 1;
    int page = 1;
    Integer totalData = 0;
    int rowCountPerPage = 5;
    public void edit() {
        if (page == 1) {
            btnFirst.setEnabled(false);
            btnBack.setEnabled(false);
        } else {
            btnFirst.setEnabled(true);
            btnBack.setEnabled(true);
        }

        if (page == totalPage) {
            btnLast.setEnabled(false);
            btnNext.setEnabled(false);
        } else {
            btnLast.setEnabled(true);
            btnNext.setEnabled(true);
        }

        if (page > totalPage) {
            page = 1;
        }
    }
  public void fillData() {
        try {
            tableModel = (DefaultTableModel) table1.getModel();
            listCTB = chitiethoadonservice.getAll("");
            IKhachHangService khachHangService = new KhachHangImpl();
            listKHg = khachHangService.getAll();
            String phone = "";
            String status = "";
//        List<BaoHanhViewModel> listDangBH = baoHanhService.selectDangBH();
       List<BaoHanhViewModel> listDaBH = baoHanhService.selectDaBH();
for (HoaDonViewModel i : listCTB) {
    for (int j = 0; j < listKHg.size(); j++) {
        if (i.getIdKhachHang() == listKHg.get(j).getId()) {
            phone = listKHg.get(j).getSoDienThoai();
        }
    }
    tableModel.addRow(new Object[]{
        i.getIdHDB(),
        i.getTenKhachHang(),
        phone,
        i.getTenUser(),
        i.getTongTien() + " đ",
        i.getNgayThanhToan(),
        i.getGhiChu()
    });
}
//for (int i = 0; i < listCTB.size(); i++) {
//    for (int j = 0; j < listDangBH.size(); j++) {
//        if (listDangBH.get(j).getIdHDBan() == listCTB.get(i).getIdHDB() ) {
////                    status = "Đã trả hàng";
//table1.setValueAt("Đang bảo hành", i, 7);
//        }
//    }
//}
//for (int i = 0; i < listCTB.size(); i++) {
//    for (int z = 0; z < listDaBH.size(); z++) {
//        if (listDaBH.get(z).getIdHDBan() == listCTB.get(i).getIdHDB()) {
////                    status = "Đã đổi hàng";
//table1.setValueAt("Đã bảo hàng", i, 7);
//        }
//    }
//}
        } catch (SQLException ex) {
            Logger.getLogger(HDBan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  public void searchDateFillTable() {
        try {
            totalData = chitiethoadonservice.ThoiGian("");
            rowCountPerPage = Integer.valueOf(cbbPagination.getSelectedItem().toString());
            Double totalPageD = Math.ceil(totalData.doubleValue() / rowCountPerPage);
            totalPage = totalPageD.intValue();
            //edit();
            if (totalData == 0) {
                JOptionPane.showMessageDialog(this, "Ngày bạn chọn không có hóa đơn nào");
                return;
            }
            edit();
            tableModel = (DefaultTableModel) table1.getModel();
            tableModel.setRowCount(0);
            listCTB = chitiethoadonservice.getAll(txt_ThoiGian.getText());
            IKhachHangService khachHangService = new KhachHangImpl();
            listKHg = khachHangService.getAll();
            String phone = "";
            String status = "";
            List<BaoHanhViewModel> listDangBH = baoHanhService.selectDangBH();
            List<BaoHanhViewModel> listDaBH = baoHanhService.selectDaBH();
            for (HoaDonViewModel i : listCTB) {
                for (int j = 0; j < listKHg.size(); j++) {
                    if (i.getIdKhachHang() == listKHg.get(j).getId()) {
                        phone = listKHg.get(j).getSoDienThoai();
                    }
                }
                tableModel.addRow(new Object[]{
                    i.getIdHDB(),
                    i.getTenKhachHang(),
                    phone,
                    i.getTenUser(),
                    i.getTongTien() + " đ",
                    i.getNgayThanhToan(),
                    i.getGhiChu()
                });
            }
            for (int i = 0; i < listCTB.size(); i++) {
                for (int j = 0; j < listDangBH.size(); j++) {
                    if (listDangBH.get(j).getIdHDBan() == listCTB.get(i).getIdHDB() ) {
//                    status = "Đã trả hàng";
table1.setValueAt("Đang bảo hành", i, 7);
                    }
                }
            }
            for (int i = 0; i < listCTB.size(); i++) {
                for (int z = 0; z < listDaBH.size(); z++) {
                    if (listDaBH.get(z).getIdHDBan() == listCTB.get(i).getIdHDB()) {
//                    status = "Đã đổi hàng";
table1.setValueAt("Đã bảo hành", i, 7);
                    }
                }
            }
//            lbl_Count.setText("Page " + page + " for " + totalPage);
        } catch (SQLException ex) {
            Logger.getLogger(HDBan.class.getName()).log(Level.SEVERE, null, ex);
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

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_Search = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        cbbPagination = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnReset = new chucNang.MyButton();
        btn_loc = new chucNang.MyButton();
        txt_ThoiGian = new chucNang.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new chucNang.Table01();
        txt_timtheoma = new chucNang.TextField();
        btn_Tim = new chucNang.MyButton();

        dateChooser1.setTextRefernce(txt_ThoiGian);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Hóa Đơn Bán");

        lbl_Search.setForeground(new java.awt.Color(255, 51, 51));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnLast.setText(">>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        cbbPagination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "15", "20", "25", "30" }));
        cbbPagination.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbPaginationItemStateChanged(evt);
            }
        });

        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnFirst.setText("<<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btn_loc.setText("Lọc");
        btn_loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_locActionPerformed(evt);
            }
        });

        txt_ThoiGian.setLabelText("Thời Gian");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_ThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(317, 317, 317))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btn_loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(345, 345, 345))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbPagination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txt_ThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnBack)
                    .addComponent(cbbPagination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addGap(325, 325, 325))
        );

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma HD Ban", "Ten KH", "SDT", "Ten Nv", "Tổng Tiền", "Ngày Mua", "Ngày TT", "Ghi chú", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setResizable(false);
            table1.getColumnModel().getColumn(1).setResizable(false);
            table1.getColumnModel().getColumn(2).setResizable(false);
            table1.getColumnModel().getColumn(3).setResizable(false);
            table1.getColumnModel().getColumn(4).setResizable(false);
            table1.getColumnModel().getColumn(5).setResizable(false);
            table1.getColumnModel().getColumn(6).setResizable(false);
            table1.getColumnModel().getColumn(7).setResizable(false);
            table1.getColumnModel().getColumn(8).setResizable(false);
        }

        txt_timtheoma.setLabelText("Tìm Kiếm");

        btn_Tim.setText("Tìm");
        btn_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(124, 124, 124)
                        .addComponent(txt_timtheoma, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3034, 3034, 3034)
                .addComponent(lbl_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timtheoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimActionPerformed
        // TODO add your handling code here:
        try {
            search();
            if (txt_timtheoma.getText().isEmpty()) {
                lbl_Search.setVisible(false);
                fillData();
            }
        } catch (NumberFormatException e) {
            lbl_Search.setText("Mã phải là số ");
        }

    }//GEN-LAST:event_btn_TimActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int row =table1.getSelectedRow();
            int id = (int) table1.getValueAt(row, 0);
            new CTHoaDonBan(id, (DefaultTableModel) table1.getModel(), table1.getSelectedRow()).setVisible(true);
            //            System.out.println(table1.getValueAt(row, 5).toString());
            System.out.println(table1.getValueAt(row, 0).toString());
        }
    }//GEN-LAST:event_table1MouseClicked

    private void btn_locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_locActionPerformed
        // TODO add your handling code here:
        searchDateFillTable();
        flag = true;
    }//GEN-LAST:event_btn_locActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        lbl_Search.setVisible(false);
        txt_timtheoma.setText("");
        fillData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        page = 1;
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        page--;
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnBackActionPerformed

    private void cbbPaginationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbPaginationItemStateChanged
        // TODO add your handling code here:
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_cbbPaginationItemStateChanged

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        page++;
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        page = totalPage;
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnLastActionPerformed

     public void search() {
     try {
         if (txt_timtheoma.getText().trim().equals("")) {
             return;
         }
         lbl_Search.setVisible(true);
         tableModel = (DefaultTableModel) table1.getModel();
         tableModel.setRowCount(0);
         int id = Integer.valueOf(txt_timtheoma.getText());
         HoaDonViewModel i = chitiethoadonservice.FindHDB(id);
         
         
         IKhachHangService khachHangService = new KhachHangImpl();
         listKHg = khachHangService.getAll();
         
         if (i == null) {
             lbl_Search.setVisible(true);
             lbl_Search.setText("Không có mặt hàng : " + id);
             return;
         }
         String phone = "";
            String status = "";
          List<BaoHanhViewModel> listDangBH = baoHanhService.selectDangBH();
            List<BaoHanhViewModel> listDaBH = baoHanhService.selectDaBH();
            
         for (int j = 0; j < listKHg.size(); j++) {
             if (i.getIdKhachHang() == listKHg.get(j).getId()) {
                 phone = listKHg.get(j).getSoDienThoai();
             }
         }
        tableModel.addRow(new Object[]{
                    i.getIdHDB(),
                    i.getTenKhachHang(),
                    phone,
                    i.getTenUser(),
                    i.getTongTien() + " đ",
                    i.getNgayThanhToan(),
                    i.getGhiChu()
                });
         
         lbl_Search.setText("");
          for (int j = 0; j < listDangBH.size(); j++) {
            if (id == listDangBH.get(j).getIdHDBan()) {
                table1.setValueAt("Đang bảo hành", j, 7);
            }
        }

        for (int z = 0; z < listDaBH.size(); z++) {
            if (id == listDaBH.get(z).getIdHDBan()) {
                table1.setValueAt("Đã bảo hành", z, 7);
            }
        }

      
     } catch (SQLException ex) {
         Logger.getLogger(HDBan.class.getName()).log(Level.SEVERE, null, ex);
     }
        

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private chucNang.MyButton btnReset;
    private chucNang.MyButton btn_Tim;
    private chucNang.MyButton btn_loc;
    private javax.swing.JComboBox<String> cbbPagination;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Search;
    private chucNang.Table01 table1;
    private chucNang.TextField txt_ThoiGian;
    private chucNang.TextField txt_timtheoma;
    // End of variables declaration//GEN-END:variables
}
