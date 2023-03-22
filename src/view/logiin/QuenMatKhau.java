/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.logiin;

import Service.Impl.QuenMatKhauImpl;
import Services.QuenMatKhauService;
import ViewModel.NhanVienViewModel;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import static java.lang.ProcessBuilder.Redirect.to;


/**
 *
 * @author ADMIN
 */
public class QuenMatKhau extends javax.swing.JPanel {
    QuenMatKhauService quenMatKhauSevice = new QuenMatKhauImpl();
     private  static final String Email = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6}$)";
    int randomCode;
     
     public QuenMatKhau() {
        initComponents();
        txt_verify.setEnabled(false);
        txt_MatKhau.setEnabled(false);
        txt_VerifyMatKhau.setEnabled(false);
        btn_Verify.setEnabled(false);
        btn_Reset.setEnabled(false);
        lblTime.setText("");
        lbl_chuong.hide();
    }
    public void register() {
        txt_USERS.grabFocus();
    }
public void addEventQuenMatKhau(ActionListener event){
    btn_thoat.addActionListener(event);
}

 public void reset(){
     txt_MatKhau.setText("");
     txt_USERS.setText("");
     txt_verify.setText("");
     txt_VerifyMatKhau.setText("");
     txt_email.setText("");
     txt_verify.setEnabled(false);
        txt_MatKhau.setEnabled(false);
        txt_VerifyMatKhau.setEnabled(false);
        btn_Verify.setEnabled(false);
        btn_Reset.setEnabled(false);
        btn_Send.setEnabled(true);
//        lblTime.setText("");
//        lbl_chuong.hide();
 }
 public boolean checkUser(String acc) {
        for (int i = 0; i < quenMatKhauSevice.Getlist().size(); i++) {
            if (quenMatKhauSevice.Getlist().get(i).getUserName().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }
 public boolean checkEmail(String acc) {
        for (int i = 0; i < quenMatKhauSevice.Getlist().size(); i++) {
            if (quenMatKhauSevice.Getlist().get(i).getEmail().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }
 NhanVienViewModel getForm() {
        NhanVienViewModel nvModel = new NhanVienViewModel();
        nvModel.setPassword(new String(txt_VerifyMatKhau.getPassword()));
        nvModel.setUserName(txt_USERS.getText());
        return nvModel;
    }
 
  Thread time;
  public void countDown() {
        time = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 60; i >= 0; i--) {
                    lblTime.setText("" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                txt_verify.setEnabled(false);
                btn_Send.setEnabled(true);
                btn_Verify.setEnabled(false);
            }
        });
        time.start();
    }
  public void sendCode() {
        try {
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            String host = "smtp.gmail.com";
            String user = "quincph23871@fpt.edu.vn";
            String pass = "";
           String to = txt_email.getText();
            String subject = "Reseting Code";
            String message = "Your reset code is " + randomCode;
            boolean sessionDebug = false;
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.starttls.required", "true");
            pros.put("mail.smtp.host", host);
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.auth", "true");
       java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(pros, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setText(message);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(null, "Code đã gửi đến Email");
        } catch (Exception e) {
            e.printStackTrace();
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
        txt_USERS = new view.logiin.txtField();
        txt_email = new view.logiin.txtField();
        txt_verify = new view.logiin.txtField();
        btn_Send = new view.logiin.button();
        btn_Verify = new view.logiin.button();
        btn_Reset = new view.logiin.button();
        btn_thoat = new view.logiin.button();
        lbl_chuong = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        txt_MatKhau = new view.logiin.password();
        txt_VerifyMatKhau = new view.logiin.password();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Quên Mật Khẩu");

        txt_USERS.setHint("USERSNAME");

        txt_email.setHint("EMAIL");

        txt_verify.setHint("Verify");

        btn_Send.setBackground(new java.awt.Color(104, 159, 158));
        btn_Send.setText("Gửi Mã Code");
        btn_Send.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SendActionPerformed(evt);
            }
        });

        btn_Verify.setBackground(new java.awt.Color(104, 159, 158));
        btn_Verify.setText("Verify");
        btn_Verify.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VerifyActionPerformed(evt);
            }
        });

        btn_Reset.setBackground(new java.awt.Color(104, 159, 158));
        btn_Reset.setText("Đổi Mật Khẩu Mới");
        btn_Reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResetActionPerformed(evt);
            }
        });

        btn_thoat.setBackground(new java.awt.Color(255, 255, 255));
        btn_thoat.setText("Back");
        btn_thoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_chuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/chuong_32.png"))); // NOI18N

        lblTime.setText("Thoi Gian");

        txt_MatKhau.setHint("PassWord");

        txt_VerifyMatKhau.setHint("Venrify Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_VerifyMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_MatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_USERS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_verify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Verify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_thoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_chuong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(txt_USERS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_verify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_chuong)
                    .addComponent(lblTime))
                .addGap(18, 18, 18)
                .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_VerifyMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_Send, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Verify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_thoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SendActionPerformed
        // TODO add your handling code here:
        if (txt_USERS.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi, Bạn chưa nhập Usres dể quên mật khẩu kìa!");
            return;
            
        }
        if (txt_email.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi, Bạn chưa nhập Email dể quên mật khẩu kìa!");
            return;
            
        }
        if (checkUser(txt_USERS.getText())== false) {
            JOptionPane.showMessageDialog(this,"Users này không tồn tại trên hệ thống bạn ơi!");
            return;
        }
        if (checkEmail(txt_email.getText())== false) {
            JOptionPane.showMessageDialog(this,"Email này không tồn tại trên hệ thống bạn ơi!");
            return;
        }
        Matcher matcher = Pattern.compile(Email).matcher(txt_email.getText());
         if (!matcher.matches()) {
             JOptionPane.showMessageDialog(this,"Email sai định dạnh");
             return;
        }
         sendCode();
        btn_Send.setEnabled(false);
            btn_Verify.setEnabled(true);
            txt_verify.setEnabled(true);
            lbl_chuong.setVisible(true);
        countDown();
         
    }//GEN-LAST:event_btn_SendActionPerformed

    private void btn_VerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VerifyActionPerformed
        // TODO add your handling code here:
             if (txt_verify.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn chưa nhập Mã Code nha");
            return;
        }
        if (Integer.valueOf(txt_verify.getText()) == randomCode) {
            lblTime.setText("");
            lbl_chuong.hide();
            time.stop();
            txt_MatKhau.setEnabled(true);
            txt_VerifyMatKhau.setEnabled(true);
            btn_Verify.setEnabled(false);
            lbl_chuong.setIcon(null);
            btn_Reset.setEnabled(true);
//            time.stop();
//            btnReset.setEnabled(false);
            
        } else {
            JOptionPane.showMessageDialog(this,"Code Không Đúng Với Gmail,Vui lòng nhập lại");
        }
    }//GEN-LAST:event_btn_VerifyActionPerformed

    private void btn_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResetActionPerformed
        // TODO add your handling code here:
                if (txt_MatKhau.getText().isEmpty() ){
            JOptionPane.showMessageDialog(this, "Bạn ơi, Mật khẩu đang trống nha");
        } else 
       
        if (new String(txt_MatKhau.getPassword()).equals(new String(txt_VerifyMatKhau.getPassword()))) {
            NhanVienViewModel nv = getForm();
            JOptionPane.showMessageDialog(this,quenMatKhauSevice.Update(nv));
//                this.dispose();
//                new Login().setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this,"Mật khẩu không khớp");
        }
        reset();
    }//GEN-LAST:event_btn_ResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.logiin.button btn_Reset;
    private view.logiin.button btn_Send;
    private view.logiin.button btn_Verify;
    private view.logiin.button btn_thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lbl_chuong;
    private view.logiin.password txt_MatKhau;
    private view.logiin.txtField txt_USERS;
    private view.logiin.password txt_VerifyMatKhau;
    private view.logiin.txtField txt_email;
    private view.logiin.txtField txt_verify;
    // End of variables declaration//GEN-END:variables
}
