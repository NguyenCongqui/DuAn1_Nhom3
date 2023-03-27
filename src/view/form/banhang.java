/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import DomainModel.BoNhoTrong;
import DomainModel.ChiTietHoaDonBan;
import DomainModel.KhachHang;
import DomainModel.LoaiPin;
import DomainModel.Voucher;
import Service.Impl.BanHangImpl;
import Service.Impl.BoNhoTrongImpl;
import Service.Impl.ChiTietHoaBanImpl;
import Service.Impl.ChiTietSanPhamImpl;
import Service.Impl.DanhMucIplm;
import Service.Impl.KhachHangImpl;
import Service.Impl.LoaiPinImpl;
import Service.Impl.VoucherImpl;
import Services.BanHangService;
import Services.ChiTietHoaBanService;
import Services.IBoNhoTrongService;
import Services.IChiTietSanPham;
import Services.IDanhMucService;
import ViewModel.HoaDonViewModel;
import ViewModel.SanPhamViewModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Services.IKhachHangService;
//import Services.ImeiBanHangService;
import Services.LoaiPinService;
import Services.VoucherService;
import javax.swing.DefaultComboBoxModel;
import ViewModel.HoaDonChiTietViewModel;
import java.awt.Image;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.logiin.Auth;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class banhang extends javax.swing.JPanel {

    List<KhachHang> listKhachHang = new ArrayList<>();
    DefaultTableModel model = null;
    BanHangService banHangService = new BanHangImpl();
    IKhachHangService KhachHangService = new KhachHangImpl();
    List<Voucher> ListVoucher = new ArrayList<>();
    List<DomainModel.DanhMuc> listDanhMuc = new ArrayList<>();
    List<ChiTietHoaDonBan> ListChiTietHoaDonBan = new ArrayList<>();
    List<SanPhamViewModel> sanPhams;
    VoucherService voucherService = new VoucherImpl();
    IDanhMucService danhMucService = new DanhMucIplm();
    List<BoNhoTrong> boNhoTrongs = new ArrayList<>();
    IBoNhoTrongService boNhoTrongService = new BoNhoTrongImpl();
    List<LoaiPin> loaiPins = new ArrayList<>();
    LoaiPinService loaiPinService = new LoaiPinImpl();
    ChiTietHoaBanService chiTietHoaDonService = new ChiTietHoaBanImpl();
    IChiTietSanPham chiTietSanPhamServoce = new ChiTietSanPhamImpl();
    

//    private ImeiBanHangService imeiBanHangService;
    public banhang() {
        initComponents();
        rdoAll.setSelected(true);
        model = new DefaultTableModel();
        chk_Voucher.setSelected(false);
        cbo_MaGiamGia.setVisible(false);
        txt_TongTien.setEnabled(false);
        fillComboxVoucher();
        fillComboxKhachHang();
        loadHoaDon();
        hienThiSanPham();
        fillComboxDanhMuc();
        fillComboxBoNhoTrong();
        fillComboxMauSac();
    }

//    public static void loadGioHang(DomainModel.ChiTietSanPham c) {
//        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
////        if (c.isTrangThai() == false) {
//            Object[] data = new Object[]{
//                c.getSoImei(),
//                c.getSanPham(),
//                "1",
//                c.getGiaBan()};
//
//            model.addRow(data);
////        }
//
//    }
// public static void loadSoLuongSanPham(Integer soLuong) {
//        int row = tblSanPham.getSelectedRow();
//        Integer soLuongHienTai = Integer.parseInt(tblSanPham.getValueAt(row, 5).toString());
//        if (soLuongHienTai == 0) {
//            JOptionPane.showMessageDialog(tblSanPham, "Số lượng sản phẩm đã hết !");
//            return;
//        }
//        Integer soLuongCapNhat = soLuongHienTai - soLuong;
//        tblSanPham.setValueAt(soLuongCapNhat, row, 5);
//    }
    public void fillComboxKhachHang() {

        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_KhachHang.getModel();
            cbo_KhachHang.removeAllItems();
            listKhachHang = KhachHangService.getAll();
            for (KhachHang kh : listKhachHang) {
                model.addElement(kh);   
            }
        } catch (SQLException ex) {
            Logger.getLogger(banhang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillComboxVoucher() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_MaGiamGia.getModel();
        cbo_MaGiamGia.removeAllItems();
        ListVoucher = voucherService.selectAllDate();
        for (Voucher v : ListVoucher) {
            model.addElement(v);
        }
    }

    
    public void fillComboxDanhMuc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_DanhMuc.getModel();
        cbo_DanhMuc.removeAllItems();
        listDanhMuc = danhMucService.getAll();
        for (DomainModel.DanhMuc v : listDanhMuc) {
            model.addElement(v.getTenDanhMuc());
        }
    }

    public void fillComboxMauSac() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_MauSac.getModel();
            cbo_MauSac.removeAllItems();
            loaiPins = loaiPinService.getAll();
            for (DomainModel.LoaiPin v : loaiPins) {
                model.addElement(v.getName());
            }
        } catch (SQLException ex) {
            Logger.getLogger(banhang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillComboxBoNhoTrong() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_DungLuong.getModel();
            cbo_DungLuong.removeAllItems();
            boNhoTrongs = boNhoTrongService.getAll();
            for (BoNhoTrong v : boNhoTrongs) {
                model.addElement(v.getName());
            }
        } catch (SQLException ex) {
            Logger.getLogger(banhang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadHoaDon() {
        ArrayList<HoaDonViewModel> list = banHangService.getListHoaDon();
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        for (HoaDonViewModel hoaDon : list) {
            model.addRow(new Object[]{
                model.getRowCount() + 1,
                hoaDon.getIdHDB(),
                hoaDon.getNgayTao(),
                hoaDon.getTenUser(),
                hoaDon.getTrangThai() == 0 ? "Đã thanh toán" : hoaDon.getTrangThai() == 1 ? "Chờ thanh toán" : "Đã Huỷ"
            });
        }
    }

    public void hienThiSanPham() {
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        sanPhams = banHangService.getListSP();
        for (SanPhamViewModel sanPham : sanPhams) {
            model.addRow(new Object[]{
                model.getRowCount() + 1,
                sanPham.getSoImei(),
                sanPham.getTenSp(),
                sanPham.getSoLuong(),
                sanPham.getTenDanhMuc(),
                sanPham.getTenDungLuong(),
                sanPham.getMauSac(),
                sanPham.getGiaBan(),
                sanPham.getAnh()});
        }
    }

//    public void loadGioHang(String Id) {
//        List<HoaDonChiTietViewModel> hoaDonChiTietViewModels = banHangService.getGioHang(Id);
//        model = (DefaultTableModel) tblGioHang.getModel();
//        model.setRowCount(0);
//        for (HoaDonChiTietViewModel h : hoaDonChiTietViewModels) {
//            model.addRow(new Object[]{
//                model.getRowCount() + 1, h.getSoImei(), h.getTenSp(), h.getSoLuong(), h.getDonGia()
//            });
//        }
//    }

    public void loadHoaDontt(int i) {
        List<HoaDonViewModel> hoaDonViewModels = banHangService.getListtt(i);
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        for (HoaDonViewModel hoaDon : hoaDonViewModels) {
            model.addRow(new Object[]{
                model.getRowCount() + 1,
                hoaDon.getIdHDB(),
                hoaDon.getNgayTao(),
                hoaDon.getTenUser(),
                hoaDon.getTrangThai() == 0 ? "Đã thanh toán" : hoaDon.getTrangThai() == 1 ? "Chờ thanh toán" : "Đã Huỷ"
            });
        }
    }

    public String deleteLastKey(String str) {
        if (str.charAt(str.length() - 1) == 'đ') {
            str = str.replace(str.substring(str.length() - 1), "");
            return str;
        } else {
            return str;
        }
    }

    public String fomartFloat(String txt) {
        String pattern = deleteLastKey(txt);
        return pattern = pattern.replaceAll(",", "");
    }

    public float TotalBuy() {
        float GiaBan = 0;
        int index = tblGioHang.getRowCount();
        for (int i = 0; i < index; i++) {
            GiaBan += (Float) ((tblGioHang.getValueAt(i, 4))) * (int) tblGioHang.getValueAt(i, 3);
        }
        return GiaBan;
    }

    public float MaVoucher() {
        Voucher v = (Voucher) cbo_MaGiamGia.getSelectedItem();
        float voucher = v.getGiamgia();
        return (int) TotalBuy() - (TotalBuy() * (float) (voucher / 100));
    }

    public void New() {
        txtID.setText("");
        txtNhanVien.setText("");
        txtMoTa.setText("");
        txt_TienKhachDua.setText("");
        txt_TongTien.setText("");
        txt_TienThua.setText("");
    }

    public void delete() {
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        int index = tblSanPham.getSelectedRow();
        int index2 = tblGioHang.getSelectedRow();

        if (tblGioHang.getSelectedRowCount() == 1) {
            for (int i = 0; i < tblSanPham.getRowCount(); i++) {
                if (tblSanPham.getValueAt(i, 0).equals(tblGioHang.getValueAt(index2, 0))) {
                    int ii = (int) tblSanPham.getValueAt(i, 3) + (int) tblGioHang.getValueAt(index2, 3);
                    tblSanPham.setValueAt(ii, i, 3);
                    System.out.println("okooooo" + ii);
                }
            }
            for (int j = 0; j < sanPhams.size(); j++) {
                if (sanPhams.get(j).getSoImei() == (String) tblGioHang.getValueAt(index2, 1)) {
                    model.removeRow(tblGioHang.getSelectedRow());
                    sanPhams.remove(sanPhams.get(j));
                    JOptionPane.showMessageDialog(this, "Xóa Thành Công");
                    return;
                }
            }
//            model.setRowCount(0);
//            ListChiTietHoaDonBan.clear();
//                filldata01();
        }

    }

    private void addTableGioHang(List<SanPhamViewModel> list) {
        model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);
        for (SanPhamViewModel s : list) {
            model.addRow(new Object[]{
                model.getRowCount() + 1,
                s.getSoImei(),
                s.getTenSp(),
                s.getSoLuong(),
                s.getGiaBan()
            });
        }
    }

    public DomainModel.HoaDonBan guidata() {
        DomainModel.HoaDonBan hoaDonBan = new DomainModel.HoaDonBan();
        hoaDonBan.setTrangThaiHoaDon(true);
        hoaDonBan.setTrangThaiTraTien(true);
        hoaDonBan.setGhiChu(txtMoTa.getText());
        hoaDonBan.setTongTien(TotalBuy());
        hoaDonBan.setTienKhachDua(Float.parseFloat(txt_TienKhachDua.getText()));
        hoaDonBan.setTienTraLai(Float.parseFloat(fomartFloat(txt_TienThua.getText())));
        KhachHang kh = (KhachHang) cbo_KhachHang.getSelectedItem();
        hoaDonBan.setIdKhachHang(kh.getId());
        hoaDonBan.setTenKhachHang(kh.getHoTen());
        if (!chk_Voucher.isSelected()) {
           hoaDonBan.setIdVoucher(null);
        } else {
            Voucher v = (Voucher) cbo_MaGiamGia.getSelectedItem();
            hoaDonBan.setIdVoucher(v.getIDVoucher());
        }
        hoaDonBan.setTrangThai(0);
         
       

        return hoaDonBan;
    }
     public void insertBanHang(){
           int index = tblGioHang.getRowCount();
           try {
               Float.parseFloat(txt_TienKhachDua.getText());
          } catch (Exception e) {
               JOptionPane.showMessageDialog(this,"bạn ơi tiền khách đưa phải là só nha");
               return;
          }
        if (index <= 0) {
            JOptionPane.showMessageDialog(this," bạn chưa thanh toán sản phẩm nào ");
                    
             return;
        } else {
            if (txt_TienKhachDua.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập tiền khách đưa kìa");
                return;
            }  else if (Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(TotalBuy()) < 0) {
                JOptionPane.showMessageDialog(this,"bạn ơi nhập lại số tiền khách đưa đi ạ");
                return;
            } else {
                Integer id = Integer.parseInt(txtID.getText());
                DomainModel.HoaDonBan hdbh = guidata();
                JOptionPane.showMessageDialog(this, banHangService.insert(hdbh,id)); 
                
                int index1 = tblGioHang.getRowCount();
                for (int i = 0; i < ListChiTietHoaDonBan.size(); i++) {
                    ChiTietHoaDonBan cthd = ListChiTietHoaDonBan.get(i);
                    System.out.println(cthd.getSoLuong());
                   
                    JOptionPane.showMessageDialog(this,chiTietHoaDonService.insert(cthd)); 
                    JOptionPane.showMessageDialog(this,chiTietSanPhamServoce.updateSoLuongTon(cthd.getSoLuong(),cthd.getSoImei()));
                   txt_TongTien.setText("");
                   txt_TienKhachDua.setText("");
                   txt_TienThua.setText("");
                  
                }
                hdbh.setTongTien(TotalBuy());
                JOptionPane.showMessageDialog(this, "Bán " + ListChiTietHoaDonBan.size() + " Hóa Đơn Thành công");
                
               
                try {
                    if (chk_Voucher.isSelected()) {
                    Voucher v1 =  (Voucher) cbo_MaGiamGia.getSelectedItem();
                        JOptionPane.showMessageDialog(this,voucherService.updateSoLuongTon(v1.getIDVoucher()));
                 
                } 
                } catch (Exception e) {
                    System.out.println("haha");
                }
              
                    
              
                DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
                model.setRowCount(0);
                ListChiTietHoaDonBan.clear();
//                ListBanHangViewModel = chitietsachService.getlistBanHang();
//                filldata01();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnTaoHD = new chucNang.MyButton();
        jPanel2 = new javax.swing.JPanel();
        txtID = new chucNang.TextField();
        chk_Voucher = new javax.swing.JCheckBox();
        txt_TongTien = new chucNang.TextField();
        txt_TienKhachDua = new chucNang.TextField();
        txt_TienThua = new chucNang.TextField();
        btn_BanHang = new chucNang.MyButton();
        txtNhanVien = new chucNang.TextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        cbo_KhachHang = new javax.swing.JComboBox<>();
        myButton5 = new chucNang.MyButton();
        cbo_MaGiamGia = new javax.swing.JComboBox<>();
        btn_Clear = new chucNang.MyButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new chucNang.Table01();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGioHang = new chucNang.Table01();
        btnXoa = new chucNang.MyButton();
        rdoDaHuy = new javax.swing.JRadioButton();
        rdoAll = new javax.swing.JRadioButton();
        rdoDaTT = new javax.swing.JRadioButton();
        rdoChoTT = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        cbo_DanhMuc = new javax.swing.JComboBox<>();
        cbo_MauSac = new javax.swing.JComboBox<>();
        cbo_DungLuong = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new chucNang.Table01();
        btnHuy = new chucNang.MyButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Bán Hàng");

        btnTaoHD.setText("TẠO HÓA ĐƠN");
        btnTaoHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thanh Toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setVerifyInputWhenFocusTarget(false);

        txtID.setLabelText("Hóa Đơn");
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        chk_Voucher.setText("Áp Mã Vocher ?");
        chk_Voucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_VoucherActionPerformed(evt);
            }
        });

        txt_TongTien.setLabelText("Tổng Tiền");

        txt_TienKhachDua.setLabelText("Tiền Khách Đưa");
        txt_TienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TienKhachDuaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TienKhachDuaKeyTyped(evt);
            }
        });

        txt_TienThua.setLabelText("Tiền Thừa");

        btn_BanHang.setText("Thanh Toán");
        btn_BanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BanHangActionPerformed(evt);
            }
        });

        txtNhanVien.setLabelText("Nhân Viên");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane3.setViewportView(txtMoTa);

        jLabel3.setText("Mô tả");

        myButton5.setText("+");

        cbo_MaGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_MaGiamGiaActionPerformed(evt);
            }
        });

        btn_Clear.setText("Clear");
        btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(chk_Voucher)
                                .addGap(18, 18, 18)
                                .addComponent(cbo_MaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbo_KhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(btn_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(7, 7, 7))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_KhachHang)
                    .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_Voucher)
                    .addComponent(cbo_MaGiamGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_TienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa Đơn"));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Hóa Đơn", "Ngày Tạo", "Nhân Viên Tạo", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setResizable(false);
            tblHoaDon.getColumnModel().getColumn(1).setResizable(false);
            tblHoaDon.getColumnModel().getColumn(2).setResizable(false);
            tblHoaDon.getColumnModel().getColumn(3).setResizable(false);
            tblHoaDon.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ Hàng"));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Số Imei", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblGioHang);

        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        rdoDaHuy.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoDaHuy);
        rdoDaHuy.setText("Đã Hủy");
        rdoDaHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaHuyActionPerformed(evt);
            }
        });

        rdoAll.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoAll);
        rdoAll.setText("ALL");
        rdoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllActionPerformed(evt);
            }
        });

        rdoDaTT.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoDaTT);
        rdoDaTT.setText("Đã TT");
        rdoDaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaTTActionPerformed(evt);
            }
        });

        rdoChoTT.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoChoTT);
        rdoChoTT.setText("Chờ TT");
        rdoChoTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChoTTActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));

        cbo_DanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_DanhMucMouseClicked(evt);
            }
        });
        cbo_DanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_DanhMucActionPerformed(evt);
            }
        });

        cbo_MauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_MauSacActionPerformed(evt);
            }
        });

        cbo_DungLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_DungLuongActionPerformed(evt);
            }
        });

        jLabel4.setText("Danh Mục");

        jLabel5.setText("Màu Sắc");

        jLabel6.setText("Dung Lượng");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Số Imei", "Tên Sản Phẩm", "Số Lượng", "Danh Mục", "Dung Lượng", "Màu Sắc", "GIán Bán", "Ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(282, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cbo_DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cbo_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(cbo_DungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_DanhMuc)
                    .addComponent(cbo_MauSac)
                    .addComponent(cbo_DungLuong)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnHuy.setText("HỦY");
        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Máy quét thông Tin cá nhân"));

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(40, 40, 40))
                            .addComponent(btnTaoHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(rdoAll)
                                .addGap(18, 18, 18)
                                .addComponent(rdoChoTT)
                                .addGap(38, 38, 38)
                                .addComponent(rdoDaTT)
                                .addGap(18, 18, 18)
                                .addComponent(rdoDaHuy))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoDaTT)
                            .addComponent(rdoDaHuy)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoAll)
                                .addComponent(rdoChoTT)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here:
        HoaDonViewModel hoaDon = new HoaDonViewModel();
        java.util.Date date = java.util.Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String now = format.format(date);
        hoaDon.setIdUser(Auth.user.getIdUser());
        hoaDon.setNgayTao(now);
        hoaDon.setTrangThai(1);
        banHangService.saveHoaDon(hoaDon);
        loadHoaDon();

    }//GEN-LAST:event_btnTaoHDActionPerformed


    private void chk_VoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_VoucherActionPerformed
        // TODO add your handling code here:
        try {
            if (chk_Voucher.isSelected()) {
                cbo_MaGiamGia.setVisible(true);
                if (cbo_MaGiamGia.getSelectedItem() == null) {
                    return;
                } else {
                    cbo_MaGiamGia.setSelectedIndex(0);
                    if (txt_TienKhachDua.getText().isEmpty()) {
                        return;
                    } else {
                        txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(MaVoucher())));
                    }
                }
            } else {
                cbo_MaGiamGia.setVisible(false);
                txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(TotalBuy())));
                txt_TongTien.setText(nf.format(TotalBuy()) + " đ");
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_chk_VoucherActionPerformed
    Locale lc = new Locale("vn", "VN");
    NumberFormat nf = NumberFormat.getInstance(lc);
    private void cbo_MaGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_MaGiamGiaActionPerformed
        // TODO add your handling code here:
        try {
            txt_TongTien.setText(nf.format(MaVoucher()) + " đ");
        } catch (Exception e) {
        }

    }//GEN-LAST:event_cbo_MaGiamGiaActionPerformed

//    public void tkgt(String ma) {
//        model = (DefaultTableModel) tblSanPham.getModel();
//        sanPhams = banHangService.searchDanhMuc(ma);
//        model.setRowCount(0);
//        for (SanPhamViewModel sanPham : sanPhams) {
//            model.addRow(new Object[]{
//                sanPham.getId(),
//                sanPham.getTenSp(),
//                sanPham.getTenDanhMuc(),
//                sanPham.getTenDungLuong(),
//                sanPham.getSoLuongTon(),
//                sanPham.getGiaBan()});
//        }
//    }

    private void cbo_DanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_DanhMucActionPerformed
        // TODO add your handling code here:
//        sanPhams = banHangService.searchDanhMuc(cbo_DanhMuc.getSelectedItem().toString());
//        hienThiSanPham();

//        hienThiSanPham();
//        String rdo = cbo_DanhMuc.getSelectedItem().toString();
//        if (cbo_DanhMuc.getSelectedItem().toString().equalsIgnoreCase(rdo));
//        tkgt(rdo);

    }//GEN-LAST:event_cbo_DanhMucActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txt_TienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TienKhachDuaKeyReleased
        // TODO add your handling code here:
        if (txt_TienKhachDua.getText().isEmpty()) {
            txt_TienThua.setText("");
            return;
        } else {
            if (chk_Voucher.isSelected()) {
                txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(MaVoucher())));
            } else {
                txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(TotalBuy())));
            }
        }
    }//GEN-LAST:event_txt_TienKhachDuaKeyReleased

    private void rdoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAllActionPerformed
        // TODO add your handling code here:
        loadHoaDon();
    }//GEN-LAST:event_rdoAllActionPerformed

    private void rdoChoTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChoTTActionPerformed
        // TODO add your handling code here:
        loadHoaDontt(1);
    }//GEN-LAST:event_rdoChoTTActionPerformed

    private void rdoDaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaTTActionPerformed
        // TODO add your handling code here:
        loadHoaDontt(0);
    }//GEN-LAST:event_rdoDaTTActionPerformed

    private void rdoDaHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaHuyActionPerformed
        // TODO add your handling code here:
        loadHoaDontt(2);
    }//GEN-LAST:event_rdoDaHuyActionPerformed

    private void cbo_MauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_MauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_MauSacActionPerformed

    private void cbo_DungLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_DungLuongActionPerformed
        // TODO add your handling code here:
//        sanPhams = banHangService.searchBNTrong(cbo_DungLuong.getSelectedItem().toString());
//        hienThiSanPham();
    }//GEN-LAST:event_cbo_DungLuongActionPerformed
//public void FindDM(){
//    List<SanPhamViewModel> sanPhams = banHangService.searchDanhMuc(cbo_DanhMuc.getSelectedItem().toString());
//   for (SanPhamViewModel sanPham : sanPhams) {
//            model.addRow(new Object[]{
//                sanPham.getId(),
//                sanPham.getTenSp(),
//                sanPham.getTenDanhMuc(),
//                sanPham.getTenDungLuong(),
//                sanPham.getSoLuongTon(),
//                sanPham.getGiaBan(),});
//        }
//}
    private void cbo_DanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_DanhMucMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cbo_DanhMucMouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearActionPerformed
        // TODO add your handling code here:
        New();
    }//GEN-LAST:event_btn_ClearActionPerformed

    private void btn_BanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BanHangActionPerformed
        // TODO add your handling code here:
        insertBanHang();
    }//GEN-LAST:event_btn_BanHangActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
        if (chk_Voucher.isSelected()) {
            txt_TongTien.setText(nf.format(MaVoucher()) + " đ");
            if (cbo_MaGiamGia.getSelectedItem() == null) {
                return;
            } else {
                if (txt_TienKhachDua.getText().isEmpty()) {
                    return;
                } else {

                    txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(MaVoucher())));
                }
            }
        } else {
            if (txt_TienKhachDua.getText().isEmpty()) {
                return;
            } else {

                txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(TotalBuy())));
            }
            txt_TongTien.setText(nf.format(TotalBuy()) + " đ");
            //
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txt_TienKhachDuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TienKhachDuaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TienKhachDuaKeyTyped

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        int index = tblHoaDon.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn trước khi thêm sản phẩm vào giỏ hàng !");
        } else {
            int soluongton = 1;
            int row = tblSanPham.getSelectedRow();
            if (soluongton > (int) tblSanPham.getValueAt(row, 3)) {
                JOptionPane.showMessageDialog(this, "Bạn ơi, Sản Phẩm đã có trên giỏ hàng rồi nha");
                return;
            } else {
                String soimei = (String) tblSanPham.getValueAt(row, 1);
                String tenSanPham = (String) tblSanPham.getValueAt(row, 2);
                int soLuong = (int) tblSanPham.getValueAt(row, 3);
                float giaBan = (float) tblSanPham.getValueAt(row, 7);

                model = (DefaultTableModel) tblGioHang.getModel();
                model.addRow(new Object[]{
                    model.getRowCount() + 1,
                    soimei, tenSanPham, soLuong, giaBan

                });

                SanPhamViewModel cthdv = new SanPhamViewModel();
                cthdv.setGiaBan(giaBan);
                cthdv.setSoImei(soimei);
                cthdv.setTenSp(tenSanPham);
                cthdv.setSoLuong(soLuong);
                sanPhams.add(cthdv);
                int i = ((int) tblSanPham.getValueAt(row, 3)) - soLuong;
                tblSanPham.setValueAt(i, row, 3);
                System.out.println(i);

            }
            
            if (chk_Voucher.isSelected()) {
            txt_TongTien.setText(nf.format(MaVoucher()) + " đ");
            if (cbo_MaGiamGia.getSelectedItem()== null) {
                return;
            } else {
                cbo_MaGiamGia.setSelectedIndex(0);
                if (txt_TienKhachDua.getText().isEmpty()) {
                    return;
                }else{
                    txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(MaVoucher())));
                }
            }
        } else {
            txt_TongTien.setText(nf.format(TotalBuy()) + " đ");
            if (txt_TienKhachDua.getText().isEmpty()) {
                return;
                
            }else{
                txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(TotalBuy())));
            }
        }

//            Integer idSanPham = Integer.parseInt(tblHoaDon.getValueAt(index, 0).toString());
//            imeiBanHangService.setIdSanPham(idSanPham);
//            new ImeiBanHAng().setVisible(true);
            // SanPhamViewModel cthdv = new SanPhamViewModel();
//        cthdv.setSoImei((String) tblSanPham.getValueAt(row, 1));
//        cthdv.setTenSp((String) tblSanPham.getValueAt(row, 2));
//        cthdv.setSoLuong(1);
//        cthdv.setGiaBan((float)(tblSanPham.getValueAt(row, 6)));
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        try {
            New();
            int index = tblHoaDon.getSelectedRow();
            String id = tblHoaDon.getValueAt(index, 1).toString();
//            String ma = tblHoaDon.getValueAt(index, 2).toString();
//            String ngaytao = tblHoaDon.getValueAt(index, 2).toString();
            String ten = tblHoaDon.getValueAt(index, 3).toString();

            //loadGioHang(id);
            txtID.setText(id);
//            txtMaHD.setText(ma);
//            txtNgayTao.setText(ngaytao);
            txtNhanVien.setText(ten);

            int tongTien = banHangService.getTongTien(id);
            txt_TongTien.setText(String.valueOf(tongTien));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btnHuy;
    private chucNang.MyButton btnTaoHD;
    private chucNang.MyButton btnXoa;
    private chucNang.MyButton btn_BanHang;
    private chucNang.MyButton btn_Clear;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_DanhMuc;
    private javax.swing.JComboBox<String> cbo_DungLuong;
    private javax.swing.JComboBox<String> cbo_KhachHang;
    private javax.swing.JComboBox<String> cbo_MaGiamGia;
    private javax.swing.JComboBox<String> cbo_MauSac;
    private javax.swing.JCheckBox chk_Voucher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private chucNang.MyButton myButton5;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoChoTT;
    private javax.swing.JRadioButton rdoDaHuy;
    private javax.swing.JRadioButton rdoDaTT;
    private chucNang.Table01 tblGioHang;
    private chucNang.Table01 tblHoaDon;
    private chucNang.Table01 tblSanPham;
    private chucNang.TextField txtID;
    private javax.swing.JTextArea txtMoTa;
    private chucNang.TextField txtNhanVien;
    private chucNang.TextField txt_TienKhachDua;
    private chucNang.TextField txt_TienThua;
    private chucNang.TextField txt_TongTien;
    // End of variables declaration//GEN-END:variables

}
