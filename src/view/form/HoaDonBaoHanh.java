/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import Service.Impl.HDBaoHanhImpl;
import Services.HDBaoHanhService;
import ViewModel.HDBaoHanhViewModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.duan.swing.Excel;

/**
 *
 * @author vanhv
 */
public class HoaDonBaoHanh extends javax.swing.JPanel {

    private DefaultTableModel tableModel = new DefaultTableModel();
    private HDBaoHanhService service = new HDBaoHanhImpl();
    private List<HDBaoHanhViewModel> list = new ArrayList<>();

    /**
     * Creates new form HoaDonBaoHanh
     */
    public HoaDonBaoHanh() {
        initComponents();
        setOpaque(false);
        fillData();
    }

    int page = 1;
    int rowCountPerPage = 5;
    int totalPage = 1;
    Integer totalData = 0;
    boolean flag = false;

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

        totalData = service.ThoiGian("");
        rowCountPerPage = Integer.valueOf(cbbPagination.getSelectedItem().toString());
        Double totalPageD = Math.ceil(totalData.doubleValue() / rowCountPerPage);
        totalPage = totalPageD.intValue();
        edit();

        tableModel = (DefaultTableModel) table1.getModel();
        tableModel.setRowCount(0);
        list = service.getAllTra(page, rowCountPerPage, "");
        for (HDBaoHanhViewModel i : list) {
            tableModel.addRow(new Object[]{
                i.getIdBaoHanh(),
                i.getIdHDBan(),
                i.getNgayBatDau(),
                i.getNgayKetThuc(),
                i.getTenUser(),
                i.getTenKH(),
                i.getSdt(),
                i.getGhiChu()
            });

        }
        lbl_Count.setText("Page " + page + " for " + totalPage);

    }

    public void search() {
        if (txt_timtheoma.getText().isEmpty()) {
            return;
        }
        lbl_Search.setVisible(true);
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        tableModel.setRowCount(0);
        int id = Integer.valueOf(txt_timtheoma.getText());
        HDBaoHanhViewModel i = service.FindIDHdBH(id);
        if (i == null) {
            //lbl_Search.setVisible(true);
            lbl_Search.setText("Không có đơn : " + id);
            return;
        }

        tableModel.addRow(new Object[]{
            i.getIdBaoHanh(),
            i.getIdHDBan(),
            i.getNgayBatDau(),
            i.getNgayKetThuc(),
            i.getTenUser(),
            i.getTenKH(),
            i.getSdt(),
            i.getGhiChu()
        });

        lbl_Search.setText("");
    }

    public void searchDateFillTable() {
        totalData = service.ThoiGian(txt_ThoiGian1.getText());
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
        list = service.getAllTra(page, rowCountPerPage, txt_ThoiGian1.getText());
        for (HDBaoHanhViewModel i : list) {
            tableModel.addRow(new Object[]{
                i.getIdBaoHanh(),
                i.getIdHDBan(),
                i.getNgayBatDau(),
                i.getNgayKetThuc(),
                i.getTenUser(),
                i.getTenKH(),
                i.getSdt(),
                i.getGhiChu()
            });
        }
        lbl_Count.setText("Page " + page + " for " + totalPage);

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
        txt_timtheoma = new chucNang.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new view.duan.swing.Table();
        lbl_Search = new javax.swing.JLabel();
        btn_xuat = new chucNang.MyButton();
        jPanel4 = new javax.swing.JPanel();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        cbbPagination = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnReset1 = new chucNang.MyButton();
        btn_loc1 = new chucNang.MyButton();
        txt_ThoiGian1 = new chucNang.TextField();
        jLabel3 = new javax.swing.JLabel();
        lbl_Count = new javax.swing.JLabel();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txt_ThoiGian1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Hóa Đơn Bảo Hành");

        txt_timtheoma.setLabelText("Tìm Kiếm");
        txt_timtheoma.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timtheomaCaretUpdate(evt);
            }
        });
        txt_timtheoma.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_timtheomaFocusGained(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Bảo Hành", "IDHD Bán", "Ngày bắt đầu", "Ngày kết thúc", "Nhân Viên", "Khách Hàng", "SDT", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

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
        }

        btn_xuat.setText("Xuất");
        btn_xuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnReset1.setText("Reset");
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        btn_loc1.setText("Lọc");
        btn_loc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loc1ActionPerformed(evt);
            }
        });

        txt_ThoiGian1.setLabelText("Thời Gian");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_ThoiGian1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(317, 317, 317))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btn_loc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(345, 345, 345))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbPagination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_Count, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txt_ThoiGian1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_loc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnBack)
                    .addComponent(cbbPagination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Count, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_timtheoma, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                .addGap(127, 127, 127)
                .addComponent(btn_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_timtheoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 159, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
  public void reset() {
        txt_timtheoma.setText("");
        lbl_Search.setText("");
        fillData();
    }
    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int row = table1.getSelectedRow();
            int id = (int) table1.getValueAt(row, 0);
            new HDBaoHanhCT(id, (DefaultTableModel) table1.getModel(), table1.getSelectedRow()).setVisible(true);
        }
    }//GEN-LAST:event_table1MouseClicked

    private void txt_timtheomaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timtheomaCaretUpdate
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
    }//GEN-LAST:event_txt_timtheomaCaretUpdate

    private void txt_timtheomaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timtheomaFocusGained
        // TODO add your handling code here:
        search();
        if (txt_timtheoma.getText().isEmpty()) {
            lbl_Search.setVisible(false);
            fillData();
        }
    }//GEN-LAST:event_txt_timtheomaFocusGained
    public void excelHoaDonBaoHanh() throws IOException {
        Excel.outExcel((DefaultTableModel) table1.getModel());
        JOptionPane.showMessageDialog(this, "Xuất File thành công");
    }
    private void btn_xuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatActionPerformed
        // TODO add your handling code here:
        try {
            excelHoaDonBaoHanh();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_xuatActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
       page = totalPage;
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
         page++;
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnNextActionPerformed

    private void cbbPaginationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbPaginationItemStateChanged
        // TODO add your handling code here:
       if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_cbbPaginationItemStateChanged

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
           page--;
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
          page = 1;
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        reset();
        flag = false;
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btn_loc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loc1ActionPerformed
        // TODO add your handling code here:
        searchDateFillTable();

        flag = true;
    }//GEN-LAST:event_btn_loc1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private chucNang.MyButton btnReset1;
    private chucNang.MyButton btn_loc1;
    private chucNang.MyButton btn_xuat;
    private javax.swing.JComboBox<String> cbbPagination;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Count;
    private javax.swing.JLabel lbl_Search;
    private view.duan.swing.Table table1;
    private chucNang.TextField txt_ThoiGian1;
    private chucNang.TextField txt_timtheoma;
    // End of variables declaration//GEN-END:variables
}
