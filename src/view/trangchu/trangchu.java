/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.trangchu;

import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import view.component.Header;
import view.component.menu;
import view.duan.icon.GoogleMaterialDesignIcons;
import view.duan.icon.IconFontSwing;
import view.duan.swing.MenuItem;
import view.duan1.event.EventMenuSelected;
import view.duan1.event.EventShowPopupMenu;
import view.form.BaoHanh;
import view.form.ChiTietSanPham;
import view.form.DoanhSo;
import view.form.DoanhThu;
import view.form.DoiMatKhau;
import view.form.HDBan;
import view.form.NhanVien;
import view.form.SanPham;
import view.form.ThongTinCaNhan;
import view.form.banhang;
import view.form.form_home;
import view.form.khuyenmai;
import view.form.mainform;

/**
 *
 * @author ADMIN
 */
public class trangchu extends javax.swing.JFrame {

    private MigLayout layout;
   private menu menu;
   private Header header;
   private Animator animator;
   private mainform main;
    public trangchu() {
        initComponents();
        init();
    }

     private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new menu();
        header = new Header();
        main = new mainform();
        menu.addEvent(new EventMenuSelected() {
           

            @Override
            public void menuSelect(int menuIndex, int subMenuIndex) {
               System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == -1) {
                        main.showForm(new form_home());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new form_home());
                    }
                    
                    
                }else if (menuIndex == 1) {
                    if (subMenuIndex ==0) {
                             main.showForm(new banhang() );
                        }else if (subMenuIndex == 1) {
                            main.showForm(new ChiTietSanPham());                  
                    }
                }
                // giao dich
                else if (menuIndex == 2) {
                    if (subMenuIndex ==0) {
                             main.showForm(new banhang() );
                        }else if (subMenuIndex == 1) {
                            main.showForm(new BaoHanh());                  
                    }else if (subMenuIndex == 2) {
                            main.showForm(new HDBan());                  
                    }else if (subMenuIndex == 3) {
                            main.showForm(new BaoHanh());                  
                    }
                }
                
                // khach hang
                else if (menuIndex == 3) {
                    if (subMenuIndex ==0) {
                             main.showForm(new banhang() );
                        }
                }
                // nhan vien
                else if (menuIndex == 4) {
                    if (subMenuIndex ==0) {
                             main.showForm(new NhanVien() );
                        }
                }
                // thong ke
                else if (menuIndex == 5) {
                    if (subMenuIndex ==0) {
                             main.showForm(new DoanhSo() );
                        }else if (subMenuIndex ==1) {
                             main.showForm(new DoanhThu() );
                        }
                }
                // ca nhan
                else if (menuIndex == 6) {
                    if (subMenuIndex ==0) {
                             main.showForm(new ThongTinCaNhan() );
                        }else if (subMenuIndex ==1) {
                             main.showForm(new DoiMatKhau() );
                        }
                }
                // khuyen mai
                else if (menuIndex == 7) {
                    if (subMenuIndex ==-1) {
                             main.showForm(new khuyenmai() );
                        }
                }
                
                
                
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                //PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                view.duan.swing.PopupMenu popup= new view.duan.swing.PopupMenu(trangchu.this,item.getIndex(), item.getEnventSelect(), item.getMenu().getSubMenu());
                int x = trangchu.this.getX() + 52;
                int y = trangchu.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
         IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
       main.showForm(new form_home());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 955, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trangchu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
