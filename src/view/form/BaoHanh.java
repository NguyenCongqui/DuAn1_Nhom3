/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import Service.Impl.BaoHanhImpl;
import Services.BaoHanhService;
import ViewModel.BaoHanhViewModel;
import ViewModel.CTHDViewModel;
import ViewModel.ChiTietBaoHanhViewModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.logiin.Auth;
import view.logiin.XDate;

/**
 *
 * @author vanhv
 */
public class BaoHanh extends javax.swing.JPanel {

    DefaultTableModel model = null;
    DefaultTableModel modelList = null;
    List<CTHDViewModel> listBH;
    BaoHanhService baoHanhService = new BaoHanhImpl();
    List<ChiTietBaoHanhViewModel> listCTBH = new ArrayList<>();

    /**
     * Creates new form BaoHanh
     */
    public BaoHanh() {
        initComponents();
        model = new DefaultTableModel();

        txtKhachHang.disable();
        txtHoaDon.disable();
        btnBaoHanh.setVisible(false);
        btnHTBH.setVisible(false);
    }

    public boolean ShearchKeyFillTable(int id) {
        model = (DefaultTableModel) tbl1.getModel();
        model.setRowCount(0);

        listBH = baoHanhService.selectById(id);
        for (CTHDViewModel d : listBH) {
            model.addRow(new Object[]{
                d.getIdHoaDon(),
                d.getSoImei(),
                d.getTenSP(),
                d.getDanhMuc(),
                d.getDungLuong(),
                d.getMauSac(),
                d.getSoLuong(),
                d.getDonGia()
            });
            txtKhachHang.setText(d.getTenKH());
            txtHoaDon.setText(d.getIdHoaDon() + "");
            txtImei.setText(d.getSoImei());
        }
        if (listBH.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkDayReturn() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date sDate = sdf.parse(listBH.get(0).getNgayTao());
            Date eDate = sdf.parse(XDate.toString(new Date(), "yyyy-MM-dd"));
            long sValue = sDate.getTime();
            long eValue = eDate.getTime();
            long tmp = Math.abs(sValue - eValue);
            long result = tmp / (24 * 60 * 60 * 1000);
            System.out.println(result);
            if (result > 2) {
                lblSearch.setText("Hoá đơn đã quá hạn bảo hành");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    public boolean checkDangBH() {
        List<BaoHanhViewModel> list = baoHanhService.selectDangBH();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdHDBan() == Integer.parseInt(txtTimKiem.getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDaBH() {
        List<BaoHanhViewModel> list = baoHanhService.selectDaBH();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdHDBan() == Integer.parseInt(txtTimKiem.getText())) {
                return false;
            }
        }
        return true;
    }

    public void fillTableIn4Invoice() {
        try {
            int index = tbl1.getSelectedRow();
            if (index == 2) {
                int slg = 1;
                int row = tbl1.getSelectedRow();
                if (slg > (int) tbl1.getValueAt(row, 6));
                return;
            } else {
                boolean flag = false;
                int row = tbl1.getSelectedRow();
                int idHDBan = (int) tbl1.getValueAt(row, 0);
                String soImei = (String) tbl1.getValueAt(row, 1);
                String tenSP = (String) tbl1.getValueAt(row, 2);
                String DanhMuc = (String) tbl1.getValueAt(row, 3);
                String DungLuong = (String) tbl1.getValueAt(row, 4);
                String MauSac = (String) tbl1.getValueAt(row, 5);
                int slg = (int) tbl1.getValueAt(row, 6);
                float gia = (float) tbl1.getValueAt(row, 7);

                modelList = (DefaultTableModel) tbl2.getModel();
                modelList.addRow(new Object[]{
                    idHDBan, soImei, tenSP, DanhMuc, DungLuong, MauSac, slg, gia
                });
                ChiTietBaoHanhViewModel dir = new ChiTietBaoHanhViewModel();
                dir.setSoImei(soImei);
//                dir.setIdCTSP(idHDBan);
                listCTBH.add(dir);
                tbl1.clearSelection();
                int i = ((int) tbl1.getValueAt(row, 6)) - slg;
                tbl1.setValueAt(i, row, 6);
//                System.out.println(i);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn ơi, Sản Phẩm này đã được chọn ");
        }

    }

    public BaoHanhViewModel getInvoiceReturn() {
        BaoHanhViewModel ir = new BaoHanhViewModel();
        ir.setGhiChu(txtGhiChu.getText());
        ir.setIdHDBan(Integer.valueOf(txtHoaDon.getText()));
        ir.setIDUsers(Auth.user.getIdUser());

        List<CTHDViewModel> items = baoHanhService.selectById(Integer.valueOf(txtTimKiem.getText()));
        for (CTHDViewModel p : items) {
            ir.setIdKhachHang(p.getIdKH());
            ir.setKhachHang(p.getTenKH());
            break;
        }

        return ir;
    }

    public void insertInvoiceReturn() {
        BaoHanhViewModel ir = getInvoiceReturn();
        System.out.println(baoHanhService.insertBaoHanh(ir));
        JOptionPane.showMessageDialog(this, "Bạn đã bảo hành thành công!!!");
        int row = tbl2.getRowCount();
        for (int i = 0; i < listCTBH.size(); i++) {
            ChiTietBaoHanhViewModel de = listCTBH.get(i);
            System.out.println(baoHanhService.insertCTBH(de));
        }
    }

    public BaoHanhViewModel update() {
        BaoHanhViewModel ir = new BaoHanhViewModel();
        ir.setGhiChu(txtGhiChu.getText());
        ir.setIdHDBan(Integer.valueOf(txtHoaDon.getText()));
//        ir.setIDUsers(Auth.user.getIdUser());

        return ir;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();
        btn_Xoa = new chucNang.MyButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new chucNang.TextField();
        jLabel2 = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        btnHTBH = new chucNang.MyButton();
        jPanel3 = new javax.swing.JPanel();
        txtHoaDon = new chucNang.TextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        txtKhachHang = new chucNang.TextField();
        btnBaoHanh = new chucNang.MyButton();
        txtImei = new chucNang.TextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Sản Phẩm"));

        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Số Imei", "Tên SP", "Danh Mục", "Dung Lượng", "Màu Sắc", "Số Lượng", "Đơn Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl2MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl2);
        if (tbl2.getColumnModel().getColumnCount() > 0) {
            tbl2.getColumnModel().getColumn(0).setResizable(false);
            tbl2.getColumnModel().getColumn(1).setResizable(false);
            tbl2.getColumnModel().getColumn(2).setResizable(false);
            tbl2.getColumnModel().getColumn(3).setResizable(false);
            tbl2.getColumnModel().getColumn(4).setResizable(false);
            tbl2.getColumnModel().getColumn(5).setResizable(false);
            tbl2.getColumnModel().getColumn(6).setResizable(false);
            tbl2.getColumnModel().getColumn(7).setResizable(false);
        }

        btn_Xoa.setText("Clear");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Hóa Đơn"));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDHD", "Số Imei", "Tên SP", "Danh Mục", "Dung Lượng", "Màu Sắc", "Số lượng", "Đơn Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl1);
        if (tbl1.getColumnModel().getColumnCount() > 0) {
            tbl1.getColumnModel().getColumn(0).setResizable(false);
            tbl1.getColumnModel().getColumn(1).setResizable(false);
            tbl1.getColumnModel().getColumn(2).setResizable(false);
            tbl1.getColumnModel().getColumn(3).setResizable(false);
            tbl1.getColumnModel().getColumn(4).setResizable(false);
            tbl1.getColumnModel().getColumn(5).setResizable(false);
            tbl1.getColumnModel().getColumn(6).setResizable(false);
            tbl1.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("BẢO HÀNH");

        txtTimKiem.setLabelText("Hóa Đơn");
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel2.setText("Tìm Kiếm :");

        lblSearch.setForeground(new java.awt.Color(255, 0, 0));

        btnHTBH.setText("Hoàn thành");
        btnHTBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHTBHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHTBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(btnHTBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 1));

        txtHoaDon.setLabelText("Hóa Đơn");
        txtHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoaDonActionPerformed(evt);
            }
        });

        jLabel3.setText("Ghi chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane3.setViewportView(txtGhiChu);

        txtKhachHang.setLabelText("Khách Hàng");
        txtKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhachHangActionPerformed(evt);
            }
        });

        btnBaoHanh.setText("Bảo Hành");
        btnBaoHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoHanhActionPerformed(evt);
            }
        });

        txtImei.setLabelText("Imei");
        txtImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImeiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtImei, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtImei, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl2MouseClicked

    public void reset() {
        txtImei.setText("");
        txtGhiChu.setText("");
        txtKhachHang.setText("");
        txtTimKiem.setText("");
        lblSearch.setText("");
        model.setRowCount(0);
        modelList.setRowCount(0);
        btnHTBH.setVisible(false);
        btnBaoHanh.setVisible(false);
    }
    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        // TODO add your handling code here:
        if (checkDangBH() == false) {
            btnHTBH.setVisible(true);

            return;
        } else if (evt.getClickCount() == 2) {

            if (checkDayReturn() == false) {
                JOptionPane.showMessageDialog(this, "Hoá đơn đã quá hạn bảo hành");
                btnHTBH.setVisible(false);
                btnBaoHanh.setVisible(false);
                return;
            } else if (checkDangBH() == false) {
                JOptionPane.showMessageDialog(this, "Hoá đơn đang bảo hành");

                btnHTBH.setVisible(true);
                btnBaoHanh.setVisible(false);
                return;
            } else if (checkDaBH() == false) {
                JOptionPane.showMessageDialog(this, "Hoá đơn đã bảo hành");
                btnHTBH.setVisible(false);
                btnBaoHanh.setVisible(false);
                return;
            } else {
                btnHTBH.setVisible(false);
                btnBaoHanh.setVisible(true);
                try {
                    int index = tbl1.getSelectedRow();
                    if (index != -1) {
//                        JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn trước khi thêm sản phẩm vào giỏ hàng !");
//                    } else {
                        int soluongton = 1;
                        int row = tbl1.getSelectedRow();
                        if (soluongton > (int) tbl1.getValueAt(row, 6)) {
//                            JOptionPane.showMessageDialog(this, "Bạn ơi,  Sản Phẩm này đã được chọn ");
                            return;
                        } else {
                            fillTableIn4Invoice();
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Bạn ơi, Lỗi ");
                }
            }
        }

    }//GEN-LAST:event_tbl1MouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoaDonActionPerformed

    private void txtKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhachHangActionPerformed

//    public void deleteRowInTableTemp() {
//
//        DefaultTableModel model = (DefaultTableModel) tbl2.getModel();
//        int row = tbl1.getSelectedRow();
//        int rowTemp = tbl2.getSelectedRow();
//
//        if (tbl2.getSelectedRowCount() == 1) {
//            for (int i = 0; i < tbl1.getRowCount(); i++) {
//                if (tbl1.getValueAt(i, 0).equals(tbl2.getValueAt(rowTemp, 0))) {
//                    int ii = (int) tbl1.getValueAt(i, 6) + (int) tbl2.getValueAt(rowTemp, 6);
//                    tbl1.setValueAt(ii, i, 6);
//                }
//            }
//
//             for (int j = 0; j < CTBHVModels.size(); j++) {
//                if (CTBHVModels.get(j).getIdBh()== (int) tbl2.getValueAt(rowTemp, 0)) {
//                    model.removeRow(tbl2.getSelectedRow());
//                    CTBHVModels.remove(CTBHVModels.get(j));
//                    return;
//                }
//            }
//        }
//    }
    public void deleteRow() {
        int row = tbl2.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbl2.getModel();
        int rowTemp = tbl2.getSelectedRow();

        if (tbl2.getSelectedRowCount() == 1) {
            for (int i = 0; i < tbl1.getRowCount(); i++) {
                if (tbl1.getValueAt(i, 0).equals(tbl2.getValueAt(rowTemp, 0))) {
                    int ii = (int) tbl1.getValueAt(i, 6) + (int) tbl2.getValueAt(rowTemp, 6);
                    tbl1.setValueAt(ii, i, 6);
                }
            }
            for (int i = 0; i < tbl2.getRowCount(); i++) {
//            if (row == i) {
                model.removeRow(tbl2.getSelectedRow());
                listBH.remove(listBH.get(i));
                JOptionPane.showMessageDialog(this, "Xóa Mặt Hàng Thành Công");
                //btn_xoa.setEnabled(false);
                return;
            }
//        }
        }
    }
    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        deleteRow();
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btnBaoHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoHanhActionPerformed
        // TODO add your handling code here:
        try {
            insertInvoiceReturn();
            model.setRowCount(0);
            modelList.setRowCount(0);
            lblSearch.setText("");
            txtKhachHang.setText("");
            txtHoaDon.setText("");
            txtGhiChu.setText("");
            txtTimKiem.setText("");
        } catch (Exception e) {
            System.out.println("Mời nhập lại");
        }
    }//GEN-LAST:event_btnBaoHanhActionPerformed

    private void txtImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImeiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImeiActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
       
        if (txtTimKiem.getText().isEmpty()) {
            txtKhachHang.setText("");
            txtHoaDon.setText("");
            lblSearch.setText("");
            model.setRowCount(0);
//           modelList.setRowCount(0);
            btnHTBH.setVisible(false);
            btnBaoHanh.setVisible(false);
            return;
        }
         try {
            if (ShearchKeyFillTable(Integer.valueOf(txtTimKiem.getText())) == false) {
                lblSearch.setText("Hoá đơn không tồn tại");
                btnHTBH.setVisible(false);
                btnBaoHanh.setVisible(false);
                return;
            } else {
                lblSearch.setText("");

            }
            if (checkDangBH() == false) {
                lblSearch.setText("Hoá đơn đang bảo hành");
                btnHTBH.setVisible(true);
                btnBaoHanh.setVisible(false);
                return;
            }
            if (checkDaBH() == false) {
                lblSearch.setText("Hoá đơn đã bảo hành");
                btnHTBH.setVisible(false);
                btnBaoHanh.setVisible(false);
                return;
            }
            if (checkDayReturn() == false) {
                return;
            }
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            lblSearch.setText("Vui lòng nhập lại số");
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        // TODO add your handling code here:
        lblSearch.setText("");
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void btnHTBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHTBHActionPerformed
        // TODO add your handling code here:

        JOptionPane.showMessageDialog(this, baoHanhService.updateToDB(Integer.parseInt(txtHoaDon.getText()), update()));
        reset();
    }//GEN-LAST:event_btnHTBHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btnBaoHanh;
    private chucNang.MyButton btnHTBH;
    private chucNang.MyButton btn_Xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblSearch;
    private static javax.swing.JTable tbl1;
    private static javax.swing.JTable tbl2;
    private javax.swing.JTextArea txtGhiChu;
    private chucNang.TextField txtHoaDon;
    private chucNang.TextField txtImei;
    private chucNang.TextField txtKhachHang;
    private chucNang.TextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
