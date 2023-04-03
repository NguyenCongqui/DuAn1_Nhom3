/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import view.duan.model.ModelCard;
import view.duan.swing.ProgressBarCustom;

/**
 *
 * @author ADMIN
 */
public class Card extends javax.swing.JPanel {

     public Color getColorGradient() {
        return colorGradient;
    }

    public void setColorGradient(Color colorGradient) {
        this.colorGradient = colorGradient;
    }
     private Color colorGradient;
    public Card() {
        initComponents();
        setOpaque(false);
        setBackground(new Color(112, 69, 246));
        colorGradient = new Color(255, 255, 255);
        pro.setBackground(new Color(255, 255, 255,100));
        pro.setForeground(Color.WHITE);
       
    }

   

   
    
public void setData(ModelCard data) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        lbl_Title.setText(data.getTitle());
        lbl_Values.setText(df.format(data.getValues()));
        lbl_Icon.setIcon(data.getIcon());
        pro.setValue(data.getPercentage());
        lbl_phanTRam.setText(df.format(data.getPercentage()) + "%");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Title = new javax.swing.JLabel();
        lbl_Values = new javax.swing.JLabel();
        lbl_Icon = new javax.swing.JLabel();
        pro = new view.duan.swing.ProgressBarCustom();
        lbl_phanTRam = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lbl_Title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_Title.setForeground(new java.awt.Color(204, 204, 204));
        lbl_Title.setText("Title");

        lbl_Values.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_Values.setForeground(new java.awt.Color(204, 204, 204));
        lbl_Values.setText("Values");

        lbl_Icon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lbl_phanTRam.setBackground(new java.awt.Color(255, 255, 255));
        lbl_phanTRam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_phanTRam.setForeground(new java.awt.Color(255, 255, 255));
        lbl_phanTRam.setText("0%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pro, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Title)
                            .addComponent(lbl_Values))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_phanTRam)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_phanTRam)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_Title)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Values))
                            .addComponent(lbl_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pro, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, getHeight(), getBackground(), getWidth(), 0, colorGradient);
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_Icon;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JLabel lbl_Values;
    private javax.swing.JLabel lbl_phanTRam;
    private view.duan.swing.ProgressBarCustom pro;
    // End of variables declaration//GEN-END:variables
}
