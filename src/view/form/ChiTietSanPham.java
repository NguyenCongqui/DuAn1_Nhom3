package view.form;

import DomainModel.DungLuongPin;
import DomainModel.ManHinh;
import DomainModel.SanPham;
import Service.Impl.BoNhoTrongImpl;
import Service.Impl.CameraImpl;
import Service.Impl.ChiTietSanPhamImpl;
import Service.Impl.CpuImpl;
import Service.Impl.DungLuongPinImpl;
import Service.Impl.HeDieuDanhlmpl;
import Service.Impl.LoaiPinImpl;
import Service.Impl.ManHinhImpl;
import Service.Impl.RamImpl;
import Service.Impl.SanPhamServiceImpl;
import Service.Impl.TanSoQuetLmpl;
import Services.DungLuongPinService;
import Services.IBoNhoTrongService;
import Services.ICameraService;
import Services.IChiTietSanPham;
import Services.ICpuService;
import Services.IHeDieuHanhService;
import Services.IManHinhService;
import Services.IRamService;
import Services.ITanSoQuet;
import Services.ImeiServices;
import Services.LoaiPinService;
import Services.SanPhamService;
import java.awt.Image;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.duan.model.ViewSanPham;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author trung
 */
public class ChiTietSanPham extends javax.swing.JPanel {

    private IChiTietSanPham service;
    private SanPhamService Spservice;
    private IHeDieuHanhService HdhService;
    private IRamService ramService;
    private DungLuongPinService DlPinService;
    private ITanSoQuet QuetService;
    private LoaiPinService PinService;
    private ICameraService cameraService;
    private IBoNhoTrongService BntService;
    private ICpuService CpuService;
    private IManHinhService manService;

    /**
     * Creates new form ChiTietSanPham
     */
    public ChiTietSanPham() {
        try {
            initComponents();
            service = new ChiTietSanPhamImpl();
            Spservice = new SanPhamServiceImpl();
            CbbSanPham.removeAllItems();
            CbbSoImei.removeAllItems();
            CbbSoImei.removeAllItems();;

            List<DomainModel.SanPham> sanPhams = Spservice.getAll();
            for (DomainModel.SanPham sp : sanPhams) {
                if (sp.isTrangThai() == false) {
                    CbbSanPham.addItem(sp.getTen());
                }
            }

            CbbHeDieuHanh.removeAllItems();
            HdhService = new HeDieuDanhlmpl();
            List<DomainModel.HeDieuHanh> heDieuHanh = HdhService.getAll();
            for (DomainModel.HeDieuHanh Hdh : heDieuHanh) {
                if (Hdh.isTrangThai() == false) {
                    CbbHeDieuHanh.addItem(Hdh.getTen());
                }
            }
            CbbRam.removeAllItems();
            ramService = new RamImpl();
            List<DomainModel.Ram> ram = ramService.getAll();
            for (DomainModel.Ram r : ram) {
                if (r.isTrangThai() == false) {
                    CbbRam.addItem(r.getName());
                }
            }
            CbbDungLuongPin.removeAllItems();
            DlPinService = new DungLuongPinImpl();
            List<DomainModel.DungLuongPin> dlP = DlPinService.getAll();
            for (DomainModel.DungLuongPin p : dlP) {
                if (p.isTrangThai() == false) {
                    CbbDungLuongPin.addItem(p.getName());
                }
            }

            CbbTanSoQuet.removeAllItems();
            QuetService = new TanSoQuetLmpl();
            List<DomainModel.TanSoQuet> Quet = QuetService.getAll();
            for (DomainModel.TanSoQuet q : Quet) {
                if (q.isTrangThai() == false) {
                    CbbTanSoQuet.addItem(q.getTen());
                }
            }
            CbbLoaiPin.removeAllItems();
            PinService = new LoaiPinImpl();
            List<DomainModel.LoaiPin> pin = PinService.getAll();
            for (DomainModel.LoaiPin p : pin) {
                if (p.isTrangThai() == false) {
                    CbbLoaiPin.addItem(p.getName());
                }
            }
            CbbCamera.removeAllItems();
            cameraService = new CameraImpl();
            List<DomainModel.Camera> cam = cameraService.getAll();
            for (DomainModel.Camera c : cam) {
                if (c.isTrangThai() == false) {
                    CbbCamera.addItem(c.getName());
                }
            }
            CbbBoNho.removeAllItems();
            BntService = new BoNhoTrongImpl();
            List<DomainModel.BoNhoTrong> boNhoTrong = BntService.getAll();
            for (DomainModel.BoNhoTrong bnt : boNhoTrong) {
                if (bnt.isTrangThai() == false) {
                    CbbBoNho.addItem(bnt.getName());
                }
            }
            CbbCpu.removeAllItems();
            CpuService = new CpuImpl();
            List<DomainModel.Cpu> cpu = CpuService.getAll();
            for (DomainModel.Cpu c : cpu) {
                if (c.isTrangThai() == false) {
                    CbbCpu.addItem(c.getName());
                }
            }
            CbbKichThuocMan.removeAllItems();
            manService = new ManHinhImpl();
            List<DomainModel.ManHinh> Man = manService.getAll();
            for (DomainModel.ManHinh Hdh : Man) {
                if (Hdh.isTrangThai() == false) {
                    CbbKichThuocMan.addItem(Hdh.getName());
                }
            }
            HienThi();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void HienThi() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tbChiTiet.getModel();
        model.setRowCount(0);
        List<ViewSanPham> list = service.getAllSP();
        for (ViewSanPham viewSanPham : list) {
            if (viewSanPham.isTrangThai() == false) {
               
                String tenHDH = "";
                List<DomainModel.HeDieuHanh> listHDH = HdhService.getAll();
                for (DomainModel.HeDieuHanh heDieuHanh : listHDH) {
                    if (viewSanPham.getIdHeDieuHanh() == heDieuHanh.getId()) {
                        tenHDH = heDieuHanh.getTen();
                    }
                }
                String tenCamera = "";
                List<DomainModel.Camera> listCam = cameraService.getAll();
                for (DomainModel.Camera camera : listCam) {
                    if (viewSanPham.getIdcamera() == camera.getId()) {
                        tenCamera = camera.getName();
                    }
                }
                String tenRam = "";
                List<DomainModel.Ram> listram = ramService.getAll();
                for (DomainModel.Ram ram : listram) {
                    if (viewSanPham.getIdRam() == ram.getId()) {
                        tenRam = ram.getName();
                    }
                }
                String tenKT = "";
                List<DomainModel.ManHinh> listKT = manService.getAll();
                for (DomainModel.ManHinh man : listKT) {
                    if (viewSanPham.getIdKichThuocMan() == man.getId()) {
                        tenKT = man.getName();
                    }
                }
                String tenCpu = "";
                List<DomainModel.Cpu> listc = CpuService.getAll();
                for (DomainModel.Cpu cpu : listc) {
                    if (viewSanPham.getIdCpu() == cpu.getId()) {
                        tenCpu = cpu.getName();
                    }
                }
                String tenBoNho = "";
                List<DomainModel.BoNhoTrong> listb = BntService.getAll();
                for (DomainModel.BoNhoTrong bnt : listb) {
                    if (viewSanPham.getIdboNhoTrong() == bnt.getId()) {
                        tenBoNho = bnt.getName();
                    }
                }

                String tenLoaiPin = "";
                List<DomainModel.LoaiPin> listloaipin = PinService.getAll();
                for (DomainModel.LoaiPin loaipin : listloaipin) {
                    if (viewSanPham.getIdloaiPin() == loaipin.getId()) {
                        tenLoaiPin = loaipin.getName();
                    }
                }
                String tenTanSoQuet = "";
                List<DomainModel.TanSoQuet> listanSoQuet = QuetService.getAll();
                for (DomainModel.TanSoQuet tsq : listanSoQuet) {
                    if (viewSanPham.getIdTanSoQuet() == tsq.getId()) {
                        tenTanSoQuet = tsq.getTen();
                    }
                }
                String tenDungLuongPin = "";
                List<DomainModel.DungLuongPin> listDungLuong = DlPinService.getAll();
                for (DomainModel.DungLuongPin dl : listDungLuong) {
                    if (viewSanPham.getIdungLuongPin() == dl.getId()) {
                        tenDungLuongPin = dl.getName();
                    }
                }
                Object[] data = new Object[]{
                    viewSanPham.getIdSanPham(),
                    viewSanPham.getTenSanPham(),
                    viewSanPham.getMoTa(),
                    service.count(viewSanPham.getIdSanPham()),
                    viewSanPham.getThoigianBaoHanh(),
                    viewSanPham.getGiaNhap(),
                    viewSanPham.getGiaBan(),
                    tenHDH,
                    tenCamera,
                    tenRam,
                    tenKT,
                    tenCpu,
                    tenBoNho,
                    tenLoaiPin,
                    tenTanSoQuet,
                    tenDungLuongPin,};
                model.addRow(data);
            }
        }
//          CbbSanPham.removeAllItems();
//          List<DomainModel.SanPham> sanPhams = Spservice.getAll();
//          for (SanPham sanPham : sanPhams) {
//            CbbSanPham.addItem(sanPham.getTen());
//        }
        ImeiServices imeiServices = new ImeiServices();
        imeiServices.setListThem(null);
    }

    public static void cbbImei(List<String> items) {
        CbbSoImei.removeAllItems();
        for (String item : items) {
            CbbSoImei.addItem(item);
        }
    }

    public static void txtSoLuong(String sl) {
        txtSoLuongTon.setText(sl);
    }

    public void fill() {
        try {
            int index = tbChiTiet.getSelectedRow();
            String idSP = tbChiTiet.getValueAt(index, 0).toString();
            String tenSp = tbChiTiet.getValueAt(index, 1).toString();
            String moTa = tbChiTiet.getValueAt(index, 2).toString();
            String soLuongTon = tbChiTiet.getValueAt(index, 3).toString();
            String thoiGianBaoHanh = tbChiTiet.getValueAt(index, 4).toString();
            String giaNhap = tbChiTiet.getValueAt(index, 5).toString();

            String giaBan = tbChiTiet.getValueAt(index, 6).toString();
            String hdh = tbChiTiet.getValueAt(index, 7).toString();
            String cam = tbChiTiet.getValueAt(index, 8).toString();
            String ram = tbChiTiet.getValueAt(index, 9).toString();
            String kichThuoc = tbChiTiet.getValueAt(index, 10).toString();
            String cpu = tbChiTiet.getValueAt(index, 11).toString();
            String boNho = tbChiTiet.getValueAt(index, 12).toString();
            String loaiPin = tbChiTiet.getValueAt(index, 13).toString();
            String tanso = tbChiTiet.getValueAt(index, 14).toString();
            String dlPin = tbChiTiet.getValueAt(index, 15).toString();

            CbbSoImei.removeAllItems();
            List<DomainModel.ChiTietSanPham> list = service.getAllImei(Integer.parseInt(idSP));
            System.out.println(list.size());
            for (DomainModel.ChiTietSanPham chiTietSanPham : list) {
                
                    CbbSoImei.addItem(chiTietSanPham.getSoImei());
                
            }
            
            CbbSanPham.setSelectedItem(tenSp);
            CbbHeDieuHanh.setSelectedItem(hdh);
            CbbCamera.setSelectedItem(cam);
            CbbRam.setSelectedItem(ram);
            CbbKichThuocMan.setSelectedItem(kichThuoc);
            CbbCpu.setSelectedItem(cpu);
            CbbBoNho.setSelectedItem(boNho);
            CbbLoaiPin.setSelectedItem(loaiPin);
            CbbTanSoQuet.setSelectedItem(tanso);
            CbbDungLuongPin.setSelectedItem(dlPin);
            txtGhiChu.setText(moTa);
//        String idHeDieuHanh = tbChiTiet.getValueAt(index, 7).toString();
//        String camera = tbChiTiet.getValueAt(index, 8).toString();
//        String ram = tbChiTiet.getValueAt(index, 9).toString();
//        String kichThuocMan =  tbChiTiet.getValueAt(index, 10).toString();
//        String idCpu = tbChiTiet.getValueAt(index, 11).toString();
//        String BoNhoTrong = tbChiTiet.getValueAt(index, 12).toString();
//        String LoaiPin = tbChiTiet.getValueAt(index, 13).toString();
//        String tanSoQuet = tbChiTiet.getValueAt(index, 14).toString();
//        String dungLuongPin= tbChiTiet.getValueAt(index, 15).toString();

            txtGhiChu.setText(moTa);
            txtSoLuongTon.setText(soLuongTon);
            txtGiaNhap.setText(giaNhap);
            txtGiaBan.setText(giaBan);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(thoiGianBaoHanh);
            txtThoiGianBh.setDate(date);
//        CbbHeDieuHanh.setSelectedItem(idHeDieuHanh);
//        CbbCamera.setSelectedItem(camera);
//        CbbRam.setSelectedItem(ram);
//        CbbKichThuocMan.setSelectedItem(kichThuocMan);
//        CbbCpu.setSelectedItem(idCpu);
//        CbbBoNho.setSelectedItem(BoNhoTrong);
//        CbbLoaiPin.setSelectedItem(LoaiPin);
//        CbbTanSoQuet.setSelectedItem(tanSoQuet);
//        CbbDungLuongPin.setSelectedItem(dungLuongPin);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ChiTietSanPham.class.getName()).log(Level.SEVERE, null, ex);
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
        CbbSoImei = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        CbbSanPham = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        CbbHeDieuHanh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        CbbDungLuongPin = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        CbbTanSoQuet = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        CbbLoaiPin = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        CbbBoNho = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        CbbCpu = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        CbbKichThuocMan = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        CbbRam = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        CbbCamera = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChiTiet = new chucNang.Table01();
        btnThem = new chucNang.MyButton();
        btnSua = new chucNang.MyButton();
        btnXoa = new chucNang.MyButton();
        btnLoad = new chucNang.MyButton();
        txtSoLuongTon = new javax.swing.JLabel();
        txtThoiGianBh = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Chi Tiết Sản Phẩm");

        CbbSoImei.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Số Imei");

        jTextField1.setText("Icon");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        CbbSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbbSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbSanPhamActionPerformed(evt);
            }
        });

        jLabel5.setText("Sản Phẩm");

        jTextField2.setText("Icon");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField2MousePressed(evt);
            }
        });

        CbbHeDieuHanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbbHeDieuHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbHeDieuHanhActionPerformed(evt);
            }
        });

        jLabel6.setText("Hệ điều hành");

        jTextField3.setText("Icon");

        CbbDungLuongPin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Dung Lượng Pin");

        jTextField4.setText("Icon");

        CbbTanSoQuet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Tần số quét");

        jTextField5.setText("Icon");

        CbbLoaiPin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Loại Pin");

        jTextField6.setText("Icon");

        CbbBoNho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Bộ Nhớ Trong");

        jTextField7.setText("Icon");

        CbbCpu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("CPU");

        jTextField8.setText("Icon");

        CbbKichThuocMan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Kích thước màn hình");

        jTextField9.setText("Icon");

        CbbRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbbRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbRamActionPerformed(evt);
            }
        });

        jLabel13.setText("Ram");

        jTextField10.setText("Icon");

        CbbCamera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Camera");

        jTextField11.setText("Icon");

        jLabel15.setText("Giá Nhập");

        txtGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaNhapActionPerformed(evt);
            }
        });

        jLabel16.setText("Giá Bán");

        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        jLabel17.setText("Số Lượng Tồn");

        txtGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuActionPerformed(evt);
            }
        });

        jLabel18.setText("Ghi Chú");

        jLabel19.setText("Thời Gian Bảo Hành");

        tbChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IDSP", "Tên SP", "Mô tả", "Số lượng tồn", "Thời gian bảo hành", "Giá nhập", "Giá bán", "Hệ Điều hành", "Camera", "Ram", "Kích thước màn", "Cpu", "Bộ nhớ trong", "Loại pin", "Tần số quét", "Dung lượng pin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbChiTietMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbChiTiet);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa ");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        txtSoLuongTon.setText("0");

        txtThoiGianBh.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(CbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CbbCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CbbSoImei, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(CbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(CbbHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(CbbDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(CbbTanSoQuet, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel9)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(CbbLoaiPin, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtThoiGianBh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(95, 95, 95)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CbbBoNho, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CbbCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel12)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CbbKichThuocMan, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtSoLuongTon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtThoiGianBh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbbDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbbTanSoQuet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbbLoaiPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbbSoImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbbHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbbBoNho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbbCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbbKichThuocMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbbCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CbbHeDieuHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbHeDieuHanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbbHeDieuHanhActionPerformed

    private void CbbRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbRamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbbRamActionPerformed

    private void txtGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaNhapActionPerformed

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void txtGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            // TODO add your handling code here:
            int index = tbChiTiet.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa !");
            }
            int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa ?");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            String id = tbChiTiet.getValueAt(index, 0).toString();
            if (service.xoa(Integer.parseInt(id)) == true) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                HienThi();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadActionPerformed

    private void CbbSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbSanPhamActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_CbbSanPhamActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:

        ImeiServices services = new ImeiServices();
        List<String> list = new ArrayList();
        String imei = "";
        for (int i = 0; i < CbbSoImei.getItemCount(); i++) {
            imei = CbbSoImei.getItemAt(i);
            list.add(imei);
            services.setList(list);
        }
        new SoImei().setVisible(true);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       
        
        
        try {
            Integer idSP1 = 0;
        List<SanPham> sanPhams1 = Spservice.getAll();
        for (SanPham sanPham : sanPhams1) {
            if (sanPham.getTen().equals(CbbSanPham.getSelectedItem())) {
                idSP1 = sanPham.getId();
            }
        }
        
            DomainModel.ChiTietSanPham ctsp1 = service.fill(idSP1);
            if (ctsp1.getSanPham() != null) {
                JOptionPane.showMessageDialog(this, "Bạn không thể thêm vì sản phẩm đã tồn tại ! vui lòng chọn chức năng sửa !!");
                return;
            }
            // TODO add your handling code here:
            Integer mangImei = CbbSoImei.getItemCount();
            for (int i = 0; i < mangImei; i++) {
                try {
                    String imei = CbbSoImei.getItemAt(i);
                    String moTa = txtGhiChu.getText();
                    double giaNhapDb = Double.parseDouble(txtGiaNhap.getText());
                    BigDecimal giaNhap = BigDecimal.valueOf(giaNhapDb);
                    double giabanDb = Double.parseDouble(txtGiaBan.getText());
                    BigDecimal giaBan = BigDecimal.valueOf(giabanDb);
                    String pattern = "MM-dd-yyyy";

                    DateFormat df = new SimpleDateFormat(pattern);
                    Date date = txtThoiGianBh.getDate();
                    String thoiGianBH = df.format(date);
                    Integer idSP = null;
                    List<SanPham> sanPhams = Spservice.getAll();
                    for (SanPham sanPham : sanPhams) {
                        if (sanPham.getTen().equals(CbbSanPham.getSelectedItem())) {
                            idSP = sanPham.getId();
                        }
                    }
                    Integer idHDH = null;
                    List<DomainModel.HeDieuHanh> heDieuHanhs = HdhService.getAll();
                    for (DomainModel.HeDieuHanh heDieuHanh : heDieuHanhs) {
                        if (heDieuHanh.getTen().equals(CbbHeDieuHanh.getSelectedItem())) {
                            idHDH = heDieuHanh.getId();
                        }
                    }
                    Integer idCam = null;
                    List<DomainModel.Camera> cameras = cameraService.getAll();
                    for (DomainModel.Camera camera : cameras) {
                        if (camera.getName().equals(CbbCamera.getSelectedItem())) {
                            idCam = camera.getId();
                        }
                    }
                    Integer idram = null;
                    List<DomainModel.Ram> rams = ramService.getAll();
                    for (DomainModel.Ram ram : rams) {
                        if (ram.getName().equals(CbbRam.getSelectedItem())) {
                            idram = ram.getId();
                        }
                    }
                    Integer idKTMan = null;
                    List<DomainModel.ManHinh> manHinhs = manService.getAll();
                    for (DomainModel.ManHinh manHinh : manHinhs) {
                        if (manHinh.getName().equals(CbbKichThuocMan.getSelectedItem())) {
                            idKTMan = manHinh.getId();
                        }
                    }
                    Integer idCpu = null;
                    List<DomainModel.Cpu> cpus = CpuService.getAll();
                    for (DomainModel.Cpu cpu : cpus) {
                        if (cpu.getName().equals(CbbCpu.getSelectedItem())) {
                            idCpu = cpu.getId();
                        }
                    }
                    Integer idBoNhoTrong = null;
                    List<DomainModel.BoNhoTrong> boNhoTrongs = BntService.getAll();
                    for (DomainModel.BoNhoTrong boNhoTrong : boNhoTrongs) {
                        if (boNhoTrong.getName().equals(CbbBoNho.getSelectedItem())) {
                            idBoNhoTrong = boNhoTrong.getId();
                        }
                    }
                    Integer idLoaiPin = null;
                    List<DomainModel.LoaiPin> loaiPins = PinService.getAll();
                    for (DomainModel.LoaiPin loaiPin : loaiPins) {
                        if (loaiPin.getName().equals(CbbLoaiPin.getSelectedItem())) {
                            idLoaiPin = loaiPin.getId();
                        }
                    }
                    Integer idTanSoQuet = null;
                    List<DomainModel.TanSoQuet> tanSoQuets = QuetService.getAll();
                    for (DomainModel.TanSoQuet tanSoQuet : tanSoQuets) {
                        if (tanSoQuet.getTen().equals(CbbTanSoQuet.getSelectedItem())) {
                            idTanSoQuet = tanSoQuet.getId();
                        }
                    }
                    Integer idDlPin = null;
                    List<DomainModel.DungLuongPin> dungLuongPins = DlPinService.getAll();
                    for (DomainModel.DungLuongPin dungLuongPin : dungLuongPins) {
                        if (dungLuongPin.getName().equals(CbbDungLuongPin.getSelectedItem())) {
                            idDlPin = dungLuongPin.getId();
                        }
                    }
                    DomainModel.ChiTietSanPham ctsp = new DomainModel.ChiTietSanPham(imei, moTa, giaNhapDb, giabanDb, thoiGianBH, idSP, idHDH, idCam, idram, idKTMan, idCpu, idBoNhoTrong, idLoaiPin, idTanSoQuet, idDlPin, false);
                    service.them(ctsp);
                    HienThi();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            JOptionPane.showMessageDialog(this, "Them thanh cong");
            HienThi();

        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed
    public DomainModel.ChiTietSanPham layTTSuaSanPham() throws SQLException {
        Integer mangImei = CbbSoImei.getItemCount();
        String imei = "";
        for (int i = 0; i < mangImei; i++) {

            imei = CbbSoImei.getItemAt(i);
        }
        String moTa = txtGhiChu.getText();
        double giaNhapDb = Double.parseDouble(txtGiaNhap.getText());
        BigDecimal giaNhap = BigDecimal.valueOf(giaNhapDb);
        double giabanDb = Double.parseDouble(txtGiaBan.getText());
        BigDecimal giaBan = BigDecimal.valueOf(giabanDb);
        String pattern = "MM-dd-yyyy";

        DateFormat df = new SimpleDateFormat(pattern);
        Date date = txtThoiGianBh.getDate();
        String thoiGianBH = df.format(date);
        Integer idSP = null;
        List<SanPham> sanPhams = Spservice.getAll();
        for (SanPham sanPham : sanPhams) {
            if (sanPham.getTen().equals(CbbSanPham.getSelectedItem())) {
                idSP = sanPham.getId();
            }
        }
        Integer idHDH = null;
        List<DomainModel.HeDieuHanh> heDieuHanhs = HdhService.getAll();
        for (DomainModel.HeDieuHanh heDieuHanh : heDieuHanhs) {
            if (heDieuHanh.getTen().equals(CbbHeDieuHanh.getSelectedItem())) {
                idHDH = heDieuHanh.getId();
            }
        }
        Integer idCam = null;
        List<DomainModel.Camera> cameras = cameraService.getAll();
        for (DomainModel.Camera camera : cameras) {
            if (camera.getName().equals(CbbCamera.getSelectedItem())) {
                idCam = camera.getId();
            }
        }
        Integer idram = null;
        List<DomainModel.Ram> rams = ramService.getAll();
        for (DomainModel.Ram ram : rams) {
            if (ram.getName().equals(CbbRam.getSelectedItem())) {
                idram = ram.getId();
            }
        }
        Integer idKTMan = null;
        List<DomainModel.ManHinh> manHinhs = manService.getAll();
        for (DomainModel.ManHinh manHinh : manHinhs) {
            if (manHinh.getName().equals(CbbKichThuocMan.getSelectedItem())) {
                idKTMan = manHinh.getId();
            }
        }
        Integer idCpu = null;
        List<DomainModel.Cpu> cpus = CpuService.getAll();
        for (DomainModel.Cpu cpu : cpus) {
            if (cpu.getName().equals(CbbCpu.getSelectedItem())) {
                idCpu = cpu.getId();
            }
        }
        Integer idBoNhoTrong = null;
        List<DomainModel.BoNhoTrong> boNhoTrongs = BntService.getAll();
        for (DomainModel.BoNhoTrong boNhoTrong : boNhoTrongs) {
            if (boNhoTrong.getName().equals(CbbBoNho.getSelectedItem())) {
                idBoNhoTrong = boNhoTrong.getId();
            }
        }
        Integer idLoaiPin = null;
        List<DomainModel.LoaiPin> loaiPins = PinService.getAll();
        for (DomainModel.LoaiPin loaiPin : loaiPins) {
            if (loaiPin.getName().equals(CbbLoaiPin.getSelectedItem())) {
                idLoaiPin = loaiPin.getId();
            }
        }
        Integer idTanSoQuet = null;
        List<DomainModel.TanSoQuet> tanSoQuets = QuetService.getAll();
        for (DomainModel.TanSoQuet tanSoQuet : tanSoQuets) {
            if (tanSoQuet.getTen().equals(CbbTanSoQuet.getSelectedItem())) {
                idTanSoQuet = tanSoQuet.getId();
            }
        }
        Integer idDlPin = null;
        List<DomainModel.DungLuongPin> dungLuongPins = DlPinService.getAll();
        for (DomainModel.DungLuongPin dungLuongPin : dungLuongPins) {
            if (dungLuongPin.getName().equals(CbbDungLuongPin.getSelectedItem())) {
                idDlPin = dungLuongPin.getId();
            }
        }
        DomainModel.ChiTietSanPham ctsp = new DomainModel.ChiTietSanPham(imei, moTa, giaNhapDb, giabanDb, thoiGianBH, idram, idHDH, idCam, idram, idKTMan, idCpu, idBoNhoTrong, idLoaiPin, idTanSoQuet, idDlPin, false);
        return ctsp;

    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            ImeiServices imeiServices = new ImeiServices();
            
            DomainModel.ChiTietSanPham c = layTTSuaSanPham();
            int row = CbbSoImei.getItemCount();
            String Imei = "";
//            chiTietSPServices.xoaImei(c.getSanPham().getMaSP());
            List<DomainModel.ChiTietSanPham> list = service.getAllImei(c.getSanPham());
            List<String> listImei = new ArrayList<>();
             List<String> listThem = imeiServices.getListThem();
                if (listThem != null) {
                    
                    for (String string : listThem) {
                        
                        System.out.println(string);
                    DomainModel.ChiTietSanPham c3 = layTTSuaSanPham();
                    c3.setSoImei(string);
                    service.them(c3);
              
                }
                }
            for (int i = 0; i < row; i++) {
                Imei = CbbSoImei.getItemAt(i);

//                 DomainModel.ChiTietSanPham c1 = layTTSuaSanPham();
//                c1.setSoImei(Imei);
//                service.them(c1);
               
                
//  
                DomainModel.ChiTietSanPham c4 = layTTSuaSanPham();
                c4.setSoImei(Imei);
                service.sua(c4);

//                
                List<String> listXoa = imeiServices.getListXoa();
                if (listXoa != null) {
                    for (String string : listXoa) {
                        service.suaTrangThaiImei(c4, string, 1);
                    }
                }
            }

            //                c1.setAnh(c.getAnh());
            JOptionPane.showMessageDialog(this, "Sửa thành công !");
            HienThi();

        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbChiTietMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiTietMousePressed
        // TODO add your handling code here:
        fill();
    }//GEN-LAST:event_tbChiTietMousePressed

    private void jTextField2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbBoNho;
    private javax.swing.JComboBox<String> CbbCamera;
    private javax.swing.JComboBox<String> CbbCpu;
    private javax.swing.JComboBox<String> CbbDungLuongPin;
    private javax.swing.JComboBox<String> CbbHeDieuHanh;
    private javax.swing.JComboBox<String> CbbKichThuocMan;
    private javax.swing.JComboBox<String> CbbLoaiPin;
    private javax.swing.JComboBox<String> CbbRam;
    private javax.swing.JComboBox<String> CbbSanPham;
    private static javax.swing.JComboBox<String> CbbSoImei;
    private javax.swing.JComboBox<String> CbbTanSoQuet;
    private chucNang.MyButton btnLoad;
    private chucNang.MyButton btnSua;
    private chucNang.MyButton btnThem;
    private chucNang.MyButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private chucNang.Table01 tbChiTiet;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private static javax.swing.JLabel txtSoLuongTon;
    private com.toedter.calendar.JDateChooser txtThoiGianBh;
    // End of variables declaration//GEN-END:variables
}
