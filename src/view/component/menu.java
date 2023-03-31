/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import view.duan.model.ModelMenu;
import view.duan.swing.MenuAnimation;
import view.duan.swing.MenuItem;
import view.duan1.event.EventMenu;
import view.duan1.event.EventMenuSelected;
import view.duan1.event.EventShowPopupMenu;

import view.duan1.event.ScrollBarCustom;
import view.logiin.Auth;

/**
 *
 * @author ADMIN
 */
public class menu extends javax.swing.JPanel {

    private final MigLayout layout;
//   private final Animator animator;
    private EventShowPopupMenu eventShowPopup;
    private EventMenuSelected event;
    private boolean enableMenu = true;
    private boolean showMenu = true;

    public EventShowPopupMenu getEventShowPopup() {
        return eventShowPopup;
    }

    public void setEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    public boolean isEnableMenu() {
        return enableMenu;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public EventMenuSelected getEvent() {
        return event;
    }

    public void setEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public boolean isShowMenu() {
        return showMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JScrollPane getSp() {
        return sp;
    }

    public void setSp(JScrollPane sp) {
        this.sp = sp;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    public menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
//        TimingTarget target = new TimingTargetAdapter(){
//            
//        }
    }

    public void initMenuItem() {

        if (Auth.isManager()) {
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/1.png")), "Trang Chủ"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/12.png")), "Quản Lý Điện Thoại", "Sản Phẩm", "Chi Tiết Sản Phẩm"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/4.png")), "Giao Dịch", "Bán Hàng", "Bảo Hành", "Hóa Đơn Bán", "Hóa Đơn Bảo Hành"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/10.png")), "Khách Hàng", "Danh sách Khách Hàng"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/5.png")), "Nhân Viên", "Danh Sách Nhân Viên"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/1.png")), "Thống kê", "Doanh Thu", "Doanh Số"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/canhan.png")), "Cá Nhân", "Thông Tin", "Đổi Mật Khẩu"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/1.png")), "Khuyến Mãi"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/18.png")), "Đăng Xuất"));

        } else {
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/1.png")), "Trang Chủ"));         
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/4.png")), "Giao Dịch", "Bán Hàng", "Bảo Hành", "Hóa Đơn Bán", "Hóa Đơn Bảo Hành"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/10.png")), "Khách Hàng", "Danh sách Khách Hàng"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/canhan.png")), "Cá Nhân", "Thông Tin", "Đổi Mật Khẩu"));  
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/duan1/icon/18.png")), "Đăng Xuất"));
            
        }

    }

    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMeu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMeu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
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

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile1 = new view.component.Profile();

        setBackground(new java.awt.Color(204, 204, 204));

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 239, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
            .addGroup(layout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(33, 105, 249), getWidth(), 0, new Color(93, 58, 196));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private view.component.Profile profile1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
