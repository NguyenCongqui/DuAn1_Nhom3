/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import DomainModel.Voucher;
import Service.Impl.VoucherImpl;
import Services.VoucherService;
import ViewModel.VouchersViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.logiin.Auth;
import view.logiin.XDate;

/**
 *
 * @author ACER
 */
public class khuyenmai extends javax.swing.JPanel {

    private static final String chu = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String ChuHoa = chu.toUpperCase(); // A-Z
    private static final String sO = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = chu + ChuHoa + sO;
    DefaultTableModel tbl_model = new DefaultTableModel();
    VoucherService voucherService = new VoucherImpl();
    List<Voucher> ListVoucher = new ArrayList<>();
    List<VouchersViewModel> ListVoucherViewModel = new ArrayList<>();
    int index = 0;

    public khuyenmai() {
        initComponents();
        setOpaque(false);
        // btn_xoa.setEnabled(false);
        // btn_sua.setEnabled(false);
        tbl_model = (DefaultTableModel) tbl_khuyenMai.getModel();
        ListVoucherViewModel = voucherService.getListVouchers();
        filldata();
        txt_ID.setEnabled(false);
        btn_sua.setEnabled(false);
        btn_xoa.setEnabled(false);
        lbl_tim.setVisible(false);
    }

    public void filldata() {
        tbl_model.setRowCount(0);
        for (VouchersViewModel v : ListVoucherViewModel) {
            tbl_model.addRow(new Object[]{
                v.getIDVoucher(), v.getMaGiamGia(), v.getGiamgia(), v.getSoLuong(), v.getNgayBatDau(), v.getNgayKetThuc(), v.getNgaytao(), v.getNgaysua(), v.getTenNguoiTao(), v.isTrangThai() == true ? "Đang Hoạt Động" : "Ngừng Hoạt Động"
            });
        }

    }
    private static Random generator = new Random();

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    public Voucher guidata() {
        Voucher v = new Voucher();
        v.setMaGiamGia(randomAlphaNumeric(8));
        v.setNgayBatDau(XDate.toDate(txt_NgayBatDau.getText(), "yyyy-MM-dd"));
        v.setNgayKetThuc(XDate.toDate(txt_NgayKetThuc.getText(), "yyyy-MM-dd"));
        v.setGiamgia(Float.parseFloat(txt_giamgia.getText()));
        v.setSoLuong(Integer.parseInt(txt_soluong.getText()));
        if (rdo_DangHoatDong.isSelected()) {
            v.setTrangThai(true);
        } else {
            v.setTrangThai(false);
        }
        v.setIdUser(Auth.user.getIdUser());
        return v;
    }



    public void reset() {
        txt_NgayBatDau.setText("");
        txt_NgayKetThuc.setText("");
        txt_giamgia.setText("");
        txt_soluong.setText("");
        txt_ID.setText("");
        rdo_DangHoatDong.setSelected(true);
        btn_sua.setEnabled(false);
        btn_xoa.setEnabled(false);
    }

    public void showdeil() {
        VouchersViewModel v = ListVoucherViewModel.get(index);
        txt_ID.setText(String.valueOf(v.getIDVoucher()));
        txt_giamgia.setText(String.valueOf(v.getGiamgia()));
        txt_soluong.setText(String.valueOf(v.getSoLuong()));
        txt_NgayBatDau.setText(String.valueOf(v.getNgayBatDau()));
        txt_NgayKetThuc.setText(String.valueOf(v.getNgayKetThuc()));
        if (v.isTrangThai()) {
            rdo_DangHoatDong.setSelected(true);
        } else {
            rdo_NgungHoatDong.setSelected(true);
        }
    }

    public int getVoucher() {
        int rowindex = tbl_khuyenMai.getSelectedRow();
        if (rowindex >= 0) {
            int ID = Integer.valueOf(tbl_khuyenMai.getModel().getValueAt(rowindex, 0).toString());
            return ID;

        } else {
            return 1;
        }

    }

    public void fillTableMa() {
        DefaultTableModel model = (DefaultTableModel) tbl_khuyenMai.getModel();
        model.setRowCount(0);
        String keyString = txt_timkiem.getText();
        List<VouchersViewModel> list = voucherService.SearchTen(keyString);
        if (list.isEmpty()) {
            lbl_tim.setText("Không có Voucher nào " + keyString);
            return;
        }

        for (VouchersViewModel v : ListVoucherViewModel) {
            tbl_model.addRow(new Object[]{
                v.getIDVoucher(), v.getMaGiamGia(), v.getGiamgia(), v.getSoLuong(), v.getNgayBatDau(), v.getNgayKetThuc(), v.getNgaytao(), v.getNgaysua(), v.getTenNguoiTao(), v.isTrangThai() == true ? "Đang Hoạt Động" : "Ngừng Hoạt Động"
            });
        }

        lbl_tim.setText("");
    }

    public boolean valedate() {
        if (txt_giamgia.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi Giảm Giá Đang Trống Nha");
            return false;
        }
        if (txt_soluong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi Số Lượng Đang Trống Nha");
            return false;
        }
        try {
            Float.parseFloat(txt_giamgia.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn ơi, Giảm Giá Phải Là Số Nha");
            return false;
        }
        try {
            Float.parseFloat(txt_soluong.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn ơi, Số Lượng Phải Là Số Nha");
            return false;
        }
        if (!rdo_DangHoatDong.isSelected() && !rdo_NgungHoatDong.isSelected()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi, Trạng Thái bạn chưa chọn nha");
            return false;
        }
        return true;
    }
    public void TimTheoTen() {
        String temp = txt_timkiem.getText();
        List<VouchersViewModel> listSearch = new ArrayList<>();
        listSearch = voucherService.SearchTen(temp);
        tbl_model = (DefaultTableModel) tbl_khuyenMai.getModel();
        tbl_model.setRowCount(0); 
        if (listSearch.isEmpty()) {
            lbl_tim.setVisible(true);
            lbl_tim.setText("Không tìm thay san pham : " + temp);
            return;
        }
        for (VouchersViewModel p : listSearch) {
            tbl_model.addRow(new Object[]{
                p.getIDVoucher(),
                p.getMaGiamGia(),
                p.getGiamgia(),
                p.getSoLuong(),
                p.getNgayBatDau(),
                p.getNgayKetThuc(),
                p.getNgaytao(),
                p.getNgaysua(),
                p.getTenNguoiTao(),
                p.isTrangThai() == true ? "Hoạt Động" : "Ngừng Hoạt Động",});
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

        Date = new com.raven.datechooser.DateChooser();
        Date01 = new com.raven.datechooser.DateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txt_timkiem = new chucNang.TextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_khuyenMai = new chucNang.Table01();
        jPanel2 = new javax.swing.JPanel();
        txt_ID = new chucNang.TextField();
        txt_giamgia = new chucNang.TextField();
        txt_soluong = new chucNang.TextField();
        txt_NgayBatDau = new chucNang.TextField();
        txt_NgayKetThuc = new chucNang.TextField();
        rdo_DangHoatDong = new chucNang.RadioButtonCustom();
        rdo_NgungHoatDong = new chucNang.RadioButtonCustom();
        btn_them = new chucNang.MyButton();
        btn_sua = new chucNang.MyButton();
        btn_xoa = new chucNang.MyButton();
        btn_lammoi = new chucNang.MyButton();
        lbl_tim = new javax.swing.JLabel();

        Date.setDateFormat("yyyy-MM-dd");
        Date.setTextRefernce(txt_NgayBatDau);

        Date01.setDateFormat("yyyy-MM-dd");
        Date01.setTextRefernce(txt_NgayKetThuc);

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Khuyến mãi");

        txt_timkiem.setLabelText("tim kiem theo ma");
        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });
        txt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemActionPerformed(evt);
            }
        });

        tbl_khuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã Giảm Giá", "Giảm Giá", "Số Lượng", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Ngày Tạo", "Ngày Sửa", "Người Tạo", "Trạng Thái"
            }
        ));
        tbl_khuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_khuyenMai);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setToolTipText("");

        txt_ID.setToolTipText("");
        txt_ID.setLabelText("ID");

        txt_giamgia.setLabelText("Giảm Giả");
        txt_giamgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giamgiaActionPerformed(evt);
            }
        });

        txt_soluong.setLabelText("Số Lượng");

        txt_NgayBatDau.setToolTipText("");
        txt_NgayBatDau.setLabelText("Ngày Bắt Đầu ");

        txt_NgayKetThuc.setLabelText("Ngày Kết Thúc");

        buttonGroup1.add(rdo_DangHoatDong);
        rdo_DangHoatDong.setText("Hoạt Động");

        buttonGroup1.add(rdo_NgungHoatDong);
        rdo_NgungHoatDong.setText("Ngừng Hoạt Động");

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_lammoi.setText("Làm Mới");
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdo_DangHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(rdo_NgungHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addComponent(txt_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_giamgia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_soluong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_NgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_NgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_giamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_DangHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdo_NgungHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        lbl_tim.setForeground(new java.awt.Color(204, 0, 0));
        lbl_tim.setText("tim kiem theo ma");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_tim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_tim)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_giamgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giamgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giamgiaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        if (valedate()) {
            Voucher v = guidata();
            JOptionPane.showMessageDialog(this, voucherService.insert(v));
            ListVoucherViewModel = voucherService.getListVouchers();
            filldata();
            reset();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void tbl_khuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khuyenMaiMouseClicked
        // TODO add your handling code here:
        try {
            index = tbl_khuyenMai.getSelectedRow();
            showdeil();
            btn_sua.setEnabled(true);
            btn_xoa.setEnabled(true);
            btn_them.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " loi click");
        }
    }//GEN-LAST:event_tbl_khuyenMaiMouseClicked

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        Voucher newv = guidata();
        newv.setIDVoucher(getVoucher());
        JOptionPane.showMessageDialog(this, voucherService.DeleteVoucher(newv));
        ListVoucherViewModel = voucherService.getListVouchers();
        filldata();
        reset();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        Voucher newv = guidata();
        newv.setIDVoucher(getVoucher());
        JOptionPane.showMessageDialog(this, voucherService.updateVoucher(newv));
        ListVoucherViewModel = voucherService.getListVouchers();
        filldata();
        reset();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemActionPerformed
       
    }//GEN-LAST:event_txt_timkiemActionPerformed

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate
        TimTheoTen();
    }//GEN-LAST:event_txt_timkiemCaretUpdate

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btn_lammoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser Date;
    private com.raven.datechooser.DateChooser Date01;
    private chucNang.MyButton btn_lammoi;
    private chucNang.MyButton btn_sua;
    private chucNang.MyButton btn_them;
    private chucNang.MyButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_tim;
    private chucNang.RadioButtonCustom rdo_DangHoatDong;
    private chucNang.RadioButtonCustom rdo_NgungHoatDong;
    private chucNang.Table01 tbl_khuyenMai;
    private chucNang.TextField txt_ID;
    private chucNang.TextField txt_NgayBatDau;
    private chucNang.TextField txt_NgayKetThuc;
    private chucNang.TextField txt_giamgia;
    private chucNang.TextField txt_soluong;
    private chucNang.TextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
