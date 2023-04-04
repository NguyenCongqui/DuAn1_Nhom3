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
import Service.Impl.MauSacImpl;
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
import Services.MauSacService;
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
import javax.swing.JButton;
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
    private MauSacImpl mauSacService;

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
            CbbMauSac.removeAllItems();
            mauSacService = new MauSacImpl();
            List<DomainModel.MauSac> mausac = mauSacService.getAll();
            for (DomainModel.MauSac mau : mausac) {
                if (mau.isTrangThai() == false) {
                    CbbMauSac.addItem(mau.getName());
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
            Long giaNhap = null;
            Long giaBan =null;
            if (viewSanPham.isTrangThai() == false) {
                String giaNhapStr  = String.valueOf(viewSanPham.getGiaNhap());
                String giaBanstr = String.valueOf(viewSanPham.getGiaBan());
                giaNhap = (long) Double.parseDouble(giaNhapStr);
                giaBan = (long) Double.parseDouble(giaBanstr);
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
                String tenMauSac = "";
                List<DomainModel.MauSac> listMauSac = mauSacService.getAll();
                for (DomainModel.MauSac mS : listMauSac) {
                    if (viewSanPham.getIdMauSac() == mS.getId()) {
                        tenMauSac = mS.getName();
                    }
                }
                Object[] data = new Object[]{
                    viewSanPham.getIdSanPham(),
                    viewSanPham.getTenSanPham(),
                    viewSanPham.getMoTa(),
                    service.count(viewSanPham.getIdSanPham()),
                    viewSanPham.getThoigianBaoHanh(),
                    giaNhap,
                    giaBan,
                    tenHDH,
                    tenCamera,
                    tenRam,
                    tenKT,
                    tenCpu,
                    tenBoNho,
                    tenLoaiPin,
                    tenTanSoQuet,
                    tenDungLuongPin,
                    tenMauSac,};
                model.addRow(data);
            }
        }
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
            String mauSac = tbChiTiet.getValueAt(index, 16).toString();
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
            CbbMauSac.setSelectedItem(mauSac);
//        String idHeDieuHanh = tbChiTiet.getValueAt(index, 7).toString();
//        String camera = tbChiTiet.getValueAt(index, 8).toString();
//        String ram = tbChiTiet.getValueAt(index, 9).toString();
//        String kichThuocMan =  tbChiTiet.getValueAt(index, 10).toString();
//        String idCpu = tbChiTiet.getValueAt(index, 11).toString();
//        String BoNhoTrong = tbChiTiet.getValueAt(index, 12).toString();
//        String LoaiPin = tbChiTiet.getValueAt(index, 13).toString();
//        String tanSoQuet = tbChiTiet.getValueAt(index, 14).toString();
//        String dungLuongPin= tbChiTiet.getValueAt(index, 15).toString();
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

    public void clear() {
        txtGiaNhap.setText("");
        txtGiaBan.setText("");
        txtThoiGianBh.setDate(null);
        txtGhiChu.setText("");
        txtSoLuongTon.setText("");
        CbbSanPham.setSelectedIndex(0);
        CbbHeDieuHanh.setSelectedIndex(0);
        CbbRam.setSelectedIndex(0);
        CbbDungLuongPin.setSelectedIndex(0);
        CbbTanSoQuet.setSelectedIndex(0);
        CbbLoaiPin.setSelectedIndex(0);
        CbbCamera.setSelectedIndex(0);
        CbbBoNho.setSelectedIndex(0);
        CbbCpu.setSelectedIndex(0);
        CbbKichThuocMan.setSelectedIndex(0);
        CbbMauSac.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField10 = new chucNang.TextField();
        jLabel1 = new javax.swing.JLabel();
        CbbSoImei = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
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
        CbbCamera = new chucNang.Combobox();
        CbbRam = new chucNang.Combobox();
        CbbHeDieuHanh = new chucNang.Combobox();
        CbbSanPham = new chucNang.Combobox();
        CbbDungLuongPin = new chucNang.Combobox();
        CbbTanSoQuet = new chucNang.Combobox();
        CbbLoaiPin = new chucNang.Combobox();
        CbbBoNho = new chucNang.Combobox();
        CbbCpu = new chucNang.Combobox();
        CbbKichThuocMan = new chucNang.Combobox();
        btnRam = new chucNang.MyButton();
        btnHeDieuHanh = new chucNang.MyButton();
        btnDungLuongPin = new chucNang.MyButton();
        btnTanSoQuet = new chucNang.MyButton();
        btnLoaiPin = new chucNang.MyButton();
        btnCamera = new chucNang.MyButton();
        btnBoNhoTrong = new chucNang.MyButton();
        btnCpu = new chucNang.MyButton();
        btnKichThuocMan = new chucNang.MyButton();
        CbbMauSac = new chucNang.Combobox();
        btnMauSac = new chucNang.MyButton();
        txtGiaNhap = new chucNang.TextField();
        txtGiaBan = new chucNang.TextField();
        btnImei = new chucNang.MyButton();

        textField10.setText("textField1");

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Chi Tiết Sản Phẩm");

        CbbSoImei.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Số Imei");

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
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IDSP", "Tên SP", "Mô tả", "Số lượng tồn", "Thời gian bảo hành", "Giá nhập", "Giá bán", "Hệ Điều hành", "Camera", "Ram", "Kích thước màn", "Cpu", "Bộ nhớ trong", "Loại pin", "Tần số quét", "Dung lượng pin", "Màu Sắc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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

        btnLoad.setText("Clear");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        txtSoLuongTon.setText("0");

        txtThoiGianBh.setDateFormatString("dd/MM/yyyy");

        CbbCamera.setLabeText("Camera");

        CbbRam.setLabeText("Ram");

        CbbHeDieuHanh.setLabeText("Hệ Điều Hành");
        CbbHeDieuHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbHeDieuHanhActionPerformed(evt);
            }
        });

        CbbSanPham.setLabeText("Sản Phẩm");

        CbbDungLuongPin.setLabeText("Dung Lượng Pin");

        CbbTanSoQuet.setLabeText("Tần Số Quét");

        CbbLoaiPin.setLabeText("Loại Pin");

        CbbBoNho.setLabeText("Bộ Nhớ Trong");

        CbbCpu.setLabeText("Cpu");

        CbbKichThuocMan.setLabeText("Kích Thước Màn Hình");

        btnRam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnRam.setBorderColor(new java.awt.Color(255, 255, 255));
        btnRam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRamMouseClicked(evt);
            }
        });

        btnHeDieuHanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnHeDieuHanh.setBorderColor(new java.awt.Color(255, 255, 255));
        btnHeDieuHanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHeDieuHanhMouseClicked(evt);
            }
        });
        btnHeDieuHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeDieuHanhActionPerformed(evt);
            }
        });

        btnDungLuongPin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnDungLuongPin.setBorderColor(new java.awt.Color(255, 255, 255));
        btnDungLuongPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDungLuongPinMouseClicked(evt);
            }
        });

        btnTanSoQuet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnTanSoQuet.setBorderColor(new java.awt.Color(255, 255, 255));
        btnTanSoQuet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTanSoQuetMouseClicked(evt);
            }
        });

        btnLoaiPin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnLoaiPin.setBorderColor(new java.awt.Color(255, 255, 255));
        btnLoaiPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoaiPinMouseClicked(evt);
            }
        });

        btnCamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnCamera.setBorderColor(new java.awt.Color(255, 255, 255));
        btnCamera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCameraMouseClicked(evt);
            }
        });

        btnBoNhoTrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnBoNhoTrong.setBorderColor(new java.awt.Color(255, 255, 255));
        btnBoNhoTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBoNhoTrongMouseClicked(evt);
            }
        });

        btnCpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnCpu.setBorderColor(new java.awt.Color(255, 255, 255));
        btnCpu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCpuMouseClicked(evt);
            }
        });

        btnKichThuocMan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnKichThuocMan.setBorderColor(new java.awt.Color(255, 255, 255));
        btnKichThuocMan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKichThuocManMouseClicked(evt);
            }
        });

        CbbMauSac.setLabeText("Màu Sắc");

        btnMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnMauSac.setBorderColor(new java.awt.Color(255, 255, 255));
        btnMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMauSacMouseClicked(evt);
            }
        });

        txtGiaNhap.setLabelText("Giá Nhập");

        txtGiaBan.setLabelText("Giá Bán");

        btnImei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/icon/icons8_Plus_32.png"))); // NOI18N
        btnImei.setBorderColor(new java.awt.Color(255, 255, 255));
        btnImei.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImeiMouseClicked(evt);
            }
        });
        btnImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImeiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(183, 183, 183))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(CbbSoImei, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(CbbHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(CbbRam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(btnRam, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnImei, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(CbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(23, 23, 23)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtThoiGianBh, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(376, 376, 376))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CbbDungLuongPin, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(CbbLoaiPin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CbbTanSoQuet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CbbCamera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnTanSoQuet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLoaiPin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CbbBoNho, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(CbbKichThuocMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CbbMauSac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CbbCpu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnKichThuocMan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBoNhoTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(txtThoiGianBh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txtSoLuongTon)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CbbSoImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CbbDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CbbBoNho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBoNhoTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImei, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CbbTanSoQuet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(CbbCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCpu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnTanSoQuet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CbbHeDieuHanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CbbLoaiPin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoaiPin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CbbKichThuocMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKichThuocMan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbbCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnRam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCamera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không");
            if (xacnhan != JOptionPane.YES_OPTION) {
                return;
            }
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
        clear();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        try {
            String checkSo = "^[0-9]*$";
            if (txtGiaNhap.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống giá nhập");
                return;
            };
            if (txtGiaBan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống giá bán");
                return;
            };
            if (txtGhiChu.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống ghi chú");
                return;
            };
            String giaNhapString = txtGiaNhap.getText().trim();
            String giaBanString = txtGiaBan.getText().trim();
            String ghiChu = txtGhiChu.getText().trim();
            if (!giaBanString.matches(checkSo) || !giaNhapString.matches(checkSo)) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập và giá bán là số !");
                return;
            }
            if (giaNhapString.length() > 10 || giaBanString.length() > 10) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập hoặc giá bán nhỏ hơn 9999999999 !");
                return;
            }
            Double giaNhap1 = Double.parseDouble(txtGiaNhap.getText());
           
            Double giaBan1 = Double.parseDouble(txtGiaBan.getText());
            
            if (giaNhap1 > giaBan1) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập nhỏ hơn hoặc bằng giá bán !");
                return;
            }
            if (giaNhap1 <= 0 || giaBan1 <= 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập hoặc giá bán lớn hơn 0 !");
                return;
            }
            if (ghiChu.length() > 255) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập ghi chú nhỏ hơn 255 kí tự !");
                return;
            }
            if (txtThoiGianBh.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn thời gian bảo hành");
                return;
            }
            if (CbbSoImei.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có số imei nào");
                return;
            }
            if (CbbSanPham.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có sản phẩm nào");
                return;
            }
            if (CbbHeDieuHanh.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có hệ điều hành nào");
                return;
            }
            if (CbbRam.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có ram nào");
                return;
            }
            if (CbbDungLuongPin.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có dung lượng pin nào");
                return;
            }
            if (CbbTanSoQuet.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có tần số quét nào");
                return;
            }
            if (CbbLoaiPin.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không loại pin nào");
                return;
            }
            if (CbbCamera.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có camera nào");
                return;
            }
            if (CbbBoNho.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có bộ nhớ trong nào");
                return;
            }
            if (CbbCpu.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có cpu nào");
                return;
            }
            if (CbbKichThuocMan.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có kích thước màn nào");
                return;
            }
            if (CbbMauSac.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có màu sắc nào");
                return;
            }
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
                    Integer idMauSac = null;
                    List<DomainModel.MauSac> maus = mauSacService.getAll();
                    for (DomainModel.MauSac mau : maus) {
                        if (mau.getName().equals(CbbMauSac.getSelectedItem())) {
                            idMauSac = mau.getId();
                        }
                    }
                    DomainModel.ChiTietSanPham ctsp = new DomainModel.ChiTietSanPham(imei, moTa, giaNhapDb, giabanDb, thoiGianBH, idSP, idHDH, idCam, idram, idLoaiPin, idCpu, idBoNhoTrong, idLoaiPin, idTanSoQuet, idLoaiPin, idMauSac, true);
                    service.them(ctsp);
                    HienThi();
                    clear();
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
        Integer idMauSac = null;
        List<DomainModel.MauSac> mausacs = mauSacService.getAll();
        for (DomainModel.MauSac mau : mausacs) {
            if (mau.getName().equals(CbbMauSac.getSelectedItem())) {
                idMauSac = mau.getId();
            }
        }
        DomainModel.ChiTietSanPham ctsp = new DomainModel.ChiTietSanPham(imei, moTa, giaNhapDb, giabanDb, thoiGianBH, idSP, idHDH, idCam, idram, idLoaiPin, idCpu, idBoNhoTrong, idLoaiPin, idTanSoQuet, idLoaiPin, idMauSac, false);
        return ctsp;

    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không");
            if (xacnhan != JOptionPane.YES_OPTION) {
                return;
            }
            String checkSo = "^[0-9]*$";
            if (txtGiaNhap.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống giá nhập");
                return;
            };
            if (txtGiaBan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống giá bán");
                return;
            };
            if (txtGhiChu.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống ghi chú");
                return;
            };
            String giaNhapString = txtGiaNhap.getText().trim();
            String giaBanString = txtGiaBan.getText().trim();
            String ghiChu = txtGhiChu.getText().trim();
            if (!giaBanString.matches(checkSo) || !giaNhapString.matches(checkSo)) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập và giá bán là số tự nhiên !");
                return;
            }
            if (giaNhapString.length() > 10 || giaBanString.length() > 10) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập hoặc giá bán nhỏ hơn 9999999999 !");
                return;
            }
            Double giaNhap1 = Double.parseDouble(txtGiaNhap.getText());
            Double giaBan1 = Double.parseDouble(txtGiaBan.getText());
            if (giaNhap1 > giaBan1) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập nhỏ hơn hoặc bằng giá bán !");
                return;
            }
            if (giaNhap1 <= 0 || giaBan1 <= 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập hoặc giá bán lớn hơn 0 !");
                return;
            }
            if (ghiChu.length() > 255) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập ghi chú nhỏ hơn 255 kí tự !");
                return;
            }
            if (txtThoiGianBh.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn thời gian bảo hành");
                return;
            }
            if (CbbSoImei.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có số imei nào");
                return;
            }
            if (CbbSanPham.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có sản phẩm nào");
                return;
            }
            if (CbbHeDieuHanh.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có hệ điều hành nào");
                return;
            }
            if (CbbRam.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có ram nào");
                return;
            }
            if (CbbDungLuongPin.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có dung lượng pin nào");
                return;
            }
            if (CbbTanSoQuet.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có tần số quét nào");
                return;
            }
            if (CbbLoaiPin.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không loại pin nào");
                return;
            }
            if (CbbCamera.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có camera nào");
                return;
            }
            if (CbbBoNho.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có bộ nhớ trong nào");
                return;
            }
            if (CbbCpu.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có cpu nào");
                return;
            }
            if (CbbKichThuocMan.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có kích thước màn nào");
                return;
            }
            if (CbbMauSac.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có màu sắc nào");
                return;
            }

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
            clear();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbChiTietMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiTietMousePressed
        // TODO add your handling code here:
        fill();
    }//GEN-LAST:event_tbChiTietMousePressed

    private void CbbHeDieuHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbHeDieuHanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbbHeDieuHanhActionPerformed

    private void btnHeDieuHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeDieuHanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHeDieuHanhActionPerformed

    private void btnHeDieuHanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHeDieuHanhMouseClicked
        // TODO add your handling code here:
        new HeDieuHanh().setVisible(true);
    }//GEN-LAST:event_btnHeDieuHanhMouseClicked

    private void btnRamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRamMouseClicked
        // TODO add your handling code here:
        new RamForm().setVisible(true);
    }//GEN-LAST:event_btnRamMouseClicked

    private void btnDungLuongPinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDungLuongPinMouseClicked
        // TODO add your handling code here:
        new DungLuongPinForm().setVisible(true);
    }//GEN-LAST:event_btnDungLuongPinMouseClicked

    private void btnTanSoQuetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTanSoQuetMouseClicked
        // TODO add your handling code here:
        new TanSoQuet().setVisible(true);
    }//GEN-LAST:event_btnTanSoQuetMouseClicked

    private void btnLoaiPinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoaiPinMouseClicked
        // TODO add your handling code here:
        new LoaiPinForm().setVisible(true);
    }//GEN-LAST:event_btnLoaiPinMouseClicked

    private void btnCameraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCameraMouseClicked
        // TODO add your handling code here:
        new CameraForm().setVisible(true);
    }//GEN-LAST:event_btnCameraMouseClicked

    private void btnBoNhoTrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoNhoTrongMouseClicked
        // TODO add your handling code here:
        new BoNhoTrongForm().setVisible(true);
    }//GEN-LAST:event_btnBoNhoTrongMouseClicked

    private void btnCpuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCpuMouseClicked
        // TODO add your handling code here:
        new CpuForm().setVisible(true);
    }//GEN-LAST:event_btnCpuMouseClicked

    private void btnKichThuocManMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKichThuocManMouseClicked
        // TODO add your handling code here:
        new ManHinhForm().setVisible(true);
    }//GEN-LAST:event_btnKichThuocManMouseClicked

    private void btnMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMauSacMouseClicked
        // TODO add your handling code here:
        new MauSac().setVisible(true);
    }//GEN-LAST:event_btnMauSacMouseClicked

    private void btnImeiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImeiMouseClicked
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
    }//GEN-LAST:event_btnImeiMouseClicked

    private void btnImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImeiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImeiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.Combobox CbbBoNho;
    private chucNang.Combobox CbbCamera;
    private chucNang.Combobox CbbCpu;
    private chucNang.Combobox CbbDungLuongPin;
    private chucNang.Combobox CbbHeDieuHanh;
    private chucNang.Combobox CbbKichThuocMan;
    private chucNang.Combobox CbbLoaiPin;
    private chucNang.Combobox CbbMauSac;
    private chucNang.Combobox CbbRam;
    private chucNang.Combobox CbbSanPham;
    private static javax.swing.JComboBox<String> CbbSoImei;
    private chucNang.Combobox CbbTanSoQuet;
    private chucNang.MyButton btnBoNhoTrong;
    private chucNang.MyButton btnCamera;
    private chucNang.MyButton btnCpu;
    private chucNang.MyButton btnDungLuongPin;
    private chucNang.MyButton btnHeDieuHanh;
    private chucNang.MyButton btnImei;
    private chucNang.MyButton btnKichThuocMan;
    private chucNang.MyButton btnLoad;
    private chucNang.MyButton btnLoaiPin;
    private chucNang.MyButton btnMauSac;
    private chucNang.MyButton btnRam;
    private chucNang.MyButton btnSua;
    private chucNang.MyButton btnTanSoQuet;
    private chucNang.MyButton btnThem;
    private chucNang.MyButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private chucNang.Table01 tbChiTiet;
    private chucNang.TextField textField10;
    private javax.swing.JTextField txtGhiChu;
    private chucNang.TextField txtGiaBan;
    private chucNang.TextField txtGiaNhap;
    private static javax.swing.JLabel txtSoLuongTon;
    private com.toedter.calendar.JDateChooser txtThoiGianBh;
    // End of variables declaration//GEN-END:variables
}
