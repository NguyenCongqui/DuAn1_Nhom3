/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.logiin;

import java.awt.event.ActionListener;
import view.trangchu.trangchu;

/**
 *
 * @author ADMIN
 */
public class DangNhap extends javax.swing.JPanel {

    /**
     * Creates new form DangNhap
     */
    public DangNhap() {
        initComponents();
    }
    public void backLogin() {
       txt_users.grabFocus();
    }
public void addEventQuenMatKhau(ActionListener event){
    btn_quenMatKHau.addActionListener(event);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_users = new view.logiin.txtField();
        password1 = new view.logiin.password();
        button1 = new view.logiin.button();
        btn_quenMatKHau = new view.logiin.button();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txt_users.setToolTipText("");
        txt_users.setHint("USERNAME");
        txt_users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usersActionPerformed(evt);
            }
        });

        password1.setHint("PASSWORD");
        password1.setName(""); // NOI18N

        button1.setBackground(new java.awt.Color(104, 159, 158));
        button1.setText("Đăng Nhập");
        button1.setToolTipText("");
        button1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        btn_quenMatKHau.setBackground(new java.awt.Color(255, 255, 255));
        btn_quenMatKHau.setText("Quên Mật Khẩu");
        btn_quenMatKHau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Đăng Nhập");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1)
                .addContainerGap(172, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_quenMatKHau, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_users, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(txt_users, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_quenMatKHau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usersActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        new trangchu().setVisible(true);
                    this.setVisible(false);
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.logiin.button btn_quenMatKHau;
    private view.logiin.button button1;
    private javax.swing.JLabel jLabel1;
    private view.logiin.password password1;
    private view.logiin.txtField txt_users;
    // End of variables declaration//GEN-END:variables
}
