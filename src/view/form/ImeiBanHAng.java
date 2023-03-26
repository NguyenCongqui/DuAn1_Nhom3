/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import Service.Impl.BanHangImpl;
import Service.Impl.ChiTietSanPhamImpl;
import Services.BanHangService;
import Services.IChiTietSanPham;
import Services.ImeiBanHangService;
import ViewModel.HoaDonChiTietViewModel;
import ViewModel.HoaDonViewModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanhv
 */
public class ImeiBanHAng extends javax.swing.JFrame {

    /**
     * Creates new form ImeiBanHAng
     */
    private IChiTietSanPham iChiTietSanPham = new ChiTietSanPhamImpl();
    private ImeiBanHangService hangService ;
    private BanHangService banHangService = new BanHangImpl();
    public ImeiBanHAng() {
        try {
            initComponents();
            System.out.println(hangService.getIdSanPham());
            List<DomainModel.ChiTietSanPham> list = iChiTietSanPham.getAllImei(hangService.getIdSanPham());
            cboImei.removeAllItems();
            for (DomainModel.ChiTietSanPham chiTietSanPham : list) {
                if(chiTietSanPham.isTrangThai()==false){
                    cboImei.addItem(chiTietSanPham.getSoImei());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImeiBanHAng.class.getName()).log(Level.SEVERE, null, ex);
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

        cboImei = new javax.swing.JComboBox<>();
        btnImei = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboImei.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnImei.setText("jButton1");
        btnImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImeiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(cboImei, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnImei, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImei))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImeiActionPerformed
        // TODO add your handling code here:
       try {
            ImeiBanHangService getImeiByMaSPServices = new ImeiBanHangService();
//            banhang.loadSoLuongSanPham(1);
            String imei = (String) cboImei.getSelectedItem();
           DomainModel.ChiTietSanPham c = iChiTietSanPham.fill(Integer.parseInt(imei));
            iChiTietSanPham.suaTrangThaiImei(c, imei, 2);
//System.out.println(c.getSoImei());
//            banhang.loadGioHang(c);
//            HoaDonChiTietViewModel hdct = new HoaDonChiTietViewModel();
//            HoaDonViewModel hd = null;
//            List<HoaDonViewModel> hoaDons = banHangService.getListHoaDon();
//            for (HoaDonViewModel hoaDon : hoaDons) {
//                if (hoaDon.getIdHDB() == hangService.getIdHoaDon()) {
//                    hd = hoaDon;
//                }
//            }
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
//            ZonedDateTime now = ZonedDateTime.now();
//            Date date = new SimpleDateFormat("MM-dd-yyyy").parse(dtf.format(now));
//            
//            DomainModel.ChiTietSanPham chiTietSP = null;
//            List<DomainModel.ChiTietSanPham> chiTietSPs = iChiTietSanPham.getAll();
//            for (DomainModel.ChiTietSanPham chiTietSP1 : chiTietSPs) {
//                if (chiTietSP1.getSoImei() == imei) {
//                    chiTietSP = chiTietSP1;
//                }
//            }
//            hdct.setHoaDon(hd);
//            hdct.setSoImei(chiTietSP);
//            hdct.setSoLuong(1);
//            hdct.setDonGia(c.getGiaBan());
//            hoaDonChiTietServies.add(hdct);
//            Integer tongTien = 0;
//            String tongTienstr = "";
//            List<HoaDonChiTiet> hdcts = hoaDonChiTietServies.getALL(getImeiByMaSPServices.getMaHD());
//            for (HoaDonChiTiet hdct1 : hdcts) {
//                tongTienstr = String.valueOf(hdct1.getDonGia());
//                tongTien += Integer.parseInt(tongTienstr);
//            }
//            QLBanHangPanel.loadTongTien(String.valueOf(tongTien));
            this.dispose();
      
        } catch (SQLException ex) {
            Logger.getLogger(ImeiBanHAng.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImeiActionPerformed

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
            java.util.logging.Logger.getLogger(ImeiBanHAng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImeiBanHAng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImeiBanHAng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImeiBanHAng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImeiBanHAng().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImei;
    private javax.swing.JComboBox<String> cboImei;
    // End of variables declaration//GEN-END:variables
}
