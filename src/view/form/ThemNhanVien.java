/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import DomainModel.TaiKhoan;
import DomainModel.Users;
import Service.Impl.NhanVienImpl;
import Services.NhanVienServices;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import view.logiin.XDate;

/**
 *
 * @author ADMIN
 */
public class ThemNhanVien extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private DefaultTableModel tbl_model;
    List<TaiKhoan> listTaiKhoan = new ArrayList<>();
    List<Users> listUsers = new ArrayList<>();
    NhanVienServices nhanVienService = new NhanVienImpl();
    private static final String Email = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6}$)";
    private WebcamPanel panel = null;
    private static Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public ThemNhanVien() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        Users us;

    }

    ThemNhanVien(String canCuocCongDan, String hoTen, String chucVu, String gioiTinh, String ngaySinh, String diaChi, String soDienThoai, String email, String luong, int idUsers, int selectedIndex) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btn_Them.setEnabled(false);
        btn_Them.setVisible(false);
        btn_lamMoi.setEnabled(false);
        btn_lamMoi.setVisible(false);

        txt_canCuocCongDan.setText(canCuocCongDan);
        txt_canCuocCongDan.setEditable(false);
        txt_hoTen.setText(hoTen);
        txt_ngaySinh.setText(ngaySinh);
        txt_luong.setText(luong);
        txt_diaChi.setText(diaChi);
        txt_soDienThoai.setText(soDienThoai);
        txt_email.setText(email);
        txt_pass.setVisible(false);
        txt_usersName.setVisible(false);
        if (gioiTinh.equalsIgnoreCase("Nam")) {
            rdo_nam.setSelected(true);
        } else if (gioiTinh.equalsIgnoreCase("Nữ")) {
            rdo_nu.setSelected(true);
        }

        if (chucVu.equalsIgnoreCase("Quản Lý")) {
            rdo_quanLy.setSelected(true);
        } else if (chucVu.equalsIgnoreCase("Nhân Viên")) {
            rdo_nhanVien.setSelected(true);
        }
        if (selectedIndex == 0) {
            rdo_dangLamViec.setSelected(true);
        } else {
            rdo_nghiLam.setSelected(true);

        }
        lbl_id.setText(idUsers + "");
    }

    public void clearForm() {
        txt_hoTen.setText("");
        txt_canCuocCongDan.setText("");
        txt_email.setText("");
        txt_luong.setText("");
        txt_ngaySinh.setText("");
        txt_diaChi.setText("");
        txt_usersName.setText("");
        txt_pass.setText("");

        txt_soDienThoai.setText("");
        rdo_dangLamViec.setSelected(false);
        rdo_nghiLam.setSelected(false);
        rdo_quanLy.setSelected(false);
        rdo_nhanVien.setSelected(false);
        rdo_nam.setSelected(false);
        rdo_nu.setSelected(false);
        btn_Them.setEnabled(true);
    }

    public Users getGuiData() {
        Users us = new Users();
        us.setSoCanCuocCongDan(txt_canCuocCongDan.getText());
        us.setHoTen(txt_hoTen.getText());
        us.setSoDienThoai(txt_soDienThoai.getText());
        us.setEmail(txt_email.getText());
        us.setLuong(Float.parseFloat(txt_luong.getText()));
        if (rdo_dangLamViec.isSelected() == true) {
            us.setTrangThai(true);
        } else {
            us.setTrangThai(false);
        }
        us.setNgaySinh(XDate.toDate(txt_ngaySinh.getText(), "dd-MM-yyyy"));
        if (rdo_nam.isSelected() == true) {
            us.setGioiTinh(true);
        } else {
            us.setGioiTinh(false);
        }
        if (rdo_quanLy.isSelected() == true) {
            us.setRole(true);
        } else {
            us.setRole(false);
        }
        us.setDiaChi(txt_diaChi.getText());
        return us;
    }

    public TaiKhoan GetGuidataTaiKhoan() {
        TaiKhoan tk = new TaiKhoan();
        tk.setUsersName(txt_usersName.getText());
        tk.setMatKhau(txt_pass.getText());
        return tk;
    }

    public void insert() {
        System.out.println("huhi");

        try {
            if (validate01()) {
                if (checkCCCD(txt_canCuocCongDan.getText()) == true) {
                    JOptionPane.showMessageDialog(this, "Bạn Ơi,Nhân Viên Này có trong hệ thống rồi nha");
                    return;
                } else if (checkDate()) {
                    if (checkSoDienThoai(txt_soDienThoai.getText()) == true) {
                        JOptionPane.showMessageDialog(this, "Bạn Ơi, Số điện thoại có trong hệ thống rồi nha");
                        return;
                    } else if (checkEmail(txt_email.getText()) == true) {
                        JOptionPane.showMessageDialog(this, "Bạn Ơi, Email có trong hệ thống rồi nha");
                        return;
                    } else if (checkUser(txt_usersName.getText()) == true) {
                        JOptionPane.showMessageDialog(this, "Bạn Ơi,Tên Users có trong hệ thống rồi nha");
                        return;
                    } else if (checksodienthoai(txt_soDienThoai.getText()) == false) {
                        JOptionPane.showMessageDialog(this, "Bạn ơi, số điện thoại không hợp lệ ");
                    } else {
                         nhanVienService.themNhanVien(getGuiData());
                      nhanVienService.themTaiKhoan(GetGuidataTaiKhoan());

                        clearForm();
                        this.dispose();

                        if (webcam == null) {
                            return;
                        }
                        webcam.close();

                    }
                }
            }
        } catch (Exception e) {
        }

    }

    public Users update() {
        Users us = new Users();

        us.setHoTen(txt_hoTen.getText());
        us.setDiaChi(txt_diaChi.getText());
        us.setEmail(txt_email.getText());
        us.setGioiTinh(rdo_nam.isSelected());
        us.setLuong(Float.parseFloat(txt_luong.getText()));
        us.setNgaySinh(XDate.toDate(txt_ngaySinh.getText(), "yyyy-MM-dd"));
        us.setRole(rdo_quanLy.isSelected());
        us.setSoDienThoai(txt_soDienThoai.getText());
        us.setTrangThai(rdo_dangLamViec.isSelected());
        us.setIdUser(Integer.parseInt(lbl_id.getText()));
        us.setSoCanCuocCongDan(txt_canCuocCongDan.getText());
        JOptionPane.showMessageDialog(this, nhanVienService.suaNhanVien(us));
        this.dispose();

        return us;
    }

    public boolean checksodienthoai(String sb) {
        boolean flag = true;
        if (txt_soDienThoai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn Ơi, số điện thoại đang trống nha");
            return false;
        }
        Pattern pattern = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})");
        Matcher matcher = pattern.matcher(txt_soDienThoai.getText());
        if (!matcher.find()) {
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    public boolean checkCCCD(String acc) {
        for (int i = 0; i < nhanVienService.getAll().size(); i++) {
            if (nhanVienService.getAll().get(i).getCanCuocCongDan().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDate() {
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.parse(txt_ngaySinh.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int years = Period.between(date, today).getYears();
        if (years < 18) {
            JOptionPane.showMessageDialog(this, "Bạn ơi trên 18 mới đc nha");
            System.out.println(years);
            return false;
        }
        System.out.println(years);
        return true;
    }

    public boolean checkUser(String acc) {
        for (int i = 0; i < nhanVienService.getAll().size(); i++) {
            if (nhanVienService.getAll().get(i).getUserName().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkEmail(String acc) {
        for (int i = 0; i < nhanVienService.getAll().size(); i++) {
            if (nhanVienService.getAll().get(i).getEmail().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkSoDienThoai(String acc) {
        for (int i = 0; i < nhanVienService.getAll().size(); i++) {
            if (nhanVienService.getAll().get(i).getSoDienThoai().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean validate01() {
        if (txt_hoTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi Họ và Tên đang trống");
            return false;
        }
        if (txt_diaChi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi Dịa Chỉ đang trống");
            return false;
        }
        if (txt_soDienThoai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi Số Điện Thoại đang trống");
            return false;
        }

        try {
            Integer.parseInt(txt_soDienThoai.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là số nha");
            return false;
        }
        if (txt_email.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi Email đang trống nha");
            return false;
        }
        if (txt_ngaySinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi Ngày Sinh đang trống");
            return false;
        }
        if (txt_pass.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi pass đang trống");
            return false;
        }
        if (txt_usersName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi users đang trống");
            return false;
        }
        if (txt_luong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi Lương đang trống");
            return false;
        }
        if (!rdo_nam.isSelected() && !rdo_nu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi chưa chọn Giới Tính ");
            return false;
        }
        if (!rdo_quanLy.isSelected() && !rdo_nhanVien.isSelected()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi chưa chọn chức Vụ ");
            return false;
        }
        if (!rdo_dangLamViec.isSelected() && !rdo_nghiLam.isSelected()) {
            JOptionPane.showMessageDialog(this, "Bạn ơi chưa Chọn Tình Trạng ");
            return false;
        }
        try {
            Float.parseFloat(txt_luong.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn ơi Lương phải là số nha");
            return false;
        }
        Matcher matcher = Pattern.compile(Email).matcher(txt_email.getText());
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(this, "Email sai định dạnh rồi nha, phải có @gmail.com");
            return false;
        }

        return true;
    }

    public static void closeCam() {
        if (webcam == null) {
            return;
        }
        webcam.close();
    }

    private void initwebcam() {
        Dimension size = WebcamResolution.QQVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel3.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 150));
        executor.execute(this);

    }

    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            if (image == null) {
                continue;
            }
            LuminanceSource soure = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(soure));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (Exception e) {
            }
            if (result != null) {
                txt_ThongTinNhanVien.setText(result.getText());

            }

        } while (true);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        date = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_hoTen = new chucNang.TextField();
        txt_canCuocCongDan = new chucNang.TextField();
        txt_soDienThoai = new chucNang.TextField();
        txt_usersName = new chucNang.TextField();
        txt_ngaySinh = new chucNang.TextField();
        txt_luong = new chucNang.TextField();
        txt_ThongTinNhanVien = new chucNang.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_diaChi = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        txt_pass = new chucNang.PasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdo_dangLamViec = new chucNang.RadioButtonCustom();
        rdo_nghiLam = new chucNang.RadioButtonCustom();
        rdo_nu = new chucNang.RadioButtonCustom();
        rdo_nhanVien = new chucNang.RadioButtonCustom();
        btn_Them = new chucNang.MyButton();
        btn_huy = new chucNang.MyButton();
        btn_lamMoi = new chucNang.MyButton();
        btn_sua = new chucNang.MyButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txt_email = new chucNang.TextField();
        rdo_quanLy = new chucNang.RadioButtonCustom();
        rdo_nam = new chucNang.RadioButtonCustom();
        jLabel5 = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        myButton1 = new chucNang.MyButton();
        myButton2 = new chucNang.MyButton();

        date.setTextRefernce(txt_ngaySinh);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Thêm Nhân Viên");

        txt_hoTen.setLabelText("Họ Và Tên");

        txt_canCuocCongDan.setLabelText("CCCD");

        txt_soDienThoai.setLabelText("Số Điện Thoại");

        txt_usersName.setLabelText("Username");

        txt_ngaySinh.setLabelText("Ngày Sinh");

        txt_luong.setLabelText("Lương");

        txt_ThongTinNhanVien.setLabelText("Thông Tin Cá Nhân");
        txt_ThongTinNhanVien.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_ThongTinNhanVienCaretUpdate(evt);
            }
        });

        txt_diaChi.setColumns(20);
        txt_diaChi.setRows(5);
        jScrollPane1.setViewportView(txt_diaChi);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Địa Chỉ");

        txt_pass.setLabelText("PassWord");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Trạng Thái");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Chức Vụ");

        buttonGroup2.add(rdo_dangLamViec);
        rdo_dangLamViec.setText("Đang Làm Việc");

        buttonGroup2.add(rdo_nghiLam);
        rdo_nghiLam.setText("Nghỉ Làm");

        buttonGroup1.add(rdo_nu);
        rdo_nu.setText("Nữ");

        buttonGroup3.add(rdo_nhanVien);
        rdo_nhanVien.setText("Nhân Viên");

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_huy.setText("hủy");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        btn_lamMoi.setText("Làm Mới");
        btn_lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamMoiActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Máy quét thông Tin cá nhân"));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        txt_email.setLabelText("Email");

        buttonGroup3.add(rdo_quanLy);
        rdo_quanLy.setText("Quản Lý");

        buttonGroup1.add(rdo_nam);
        rdo_nam.setText("Nam");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Giới Tính");

        lbl_id.setText("ID");

        myButton1.setText("Mở Camera");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        myButton2.setText("Tắt Camera");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                .addGap(48, 48, 48)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))
                            .addComponent(txt_usersName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_soDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_canCuocCongDan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdo_dangLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(rdo_nghiLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_lamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_luong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_ngaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdo_quanLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdo_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(rdo_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(41, 41, 41))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_canCuocCongDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdo_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_usersName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_dangLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdo_nghiLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdo_quanLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdo_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_suaActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        initwebcam();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JFrame jf = new JFrame();
         jf.setSize(940,604);
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
        if (webcam == null) {
            return;
        }
        webcam.close();
    }//GEN-LAST:event_myButton2ActionPerformed

    private void txt_ThongTinNhanVienCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_ThongTinNhanVienCaretUpdate
        // TODO add your handling code here:
        String t = txt_ThongTinNhanVien.getText();
        String[] txt2 = t.split("\\|");
        if (txt2.length == 7) {
            txt_canCuocCongDan.setText(txt2[0]);
            txt_hoTen.setText(txt2[2]);
            String ngaySinh = txt2[3];
            String ngay = ngaySinh.substring(0, 2);
            String thang = ngaySinh.substring(2, 4);
            String nam = ngaySinh.substring(4, 8);
            txt_diaChi.setText(txt2[5]);
            txt_ngaySinh.setText(ngay + "-" + thang + "-" + nam);
            if (txt2[4].equalsIgnoreCase("nam")) {
                rdo_nam.setSelected(true);
            } else {
                rdo_nu.setSelected(true);
            }

        }
    }//GEN-LAST:event_txt_ThongTinNhanVienCaretUpdate

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:zzzzzz
        this.dispose();
        if (webcam == null) {
            return;
        }
        webcam.close();
        //this.dispose();
        clearForm();
    }//GEN-LAST:event_btn_huyActionPerformed

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_lamMoiActionPerformed

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
            java.util.logging.Logger.getLogger(ThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btn_Them;
    private chucNang.MyButton btn_huy;
    private chucNang.MyButton btn_lamMoi;
    private chucNang.MyButton btn_sua;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_id;
    private chucNang.MyButton myButton1;
    private chucNang.MyButton myButton2;
    private chucNang.RadioButtonCustom rdo_dangLamViec;
    private chucNang.RadioButtonCustom rdo_nam;
    private chucNang.RadioButtonCustom rdo_nghiLam;
    private chucNang.RadioButtonCustom rdo_nhanVien;
    private chucNang.RadioButtonCustom rdo_nu;
    private chucNang.RadioButtonCustom rdo_quanLy;
    private chucNang.TextField txt_ThongTinNhanVien;
    private chucNang.TextField txt_canCuocCongDan;
    private javax.swing.JTextArea txt_diaChi;
    private chucNang.TextField txt_email;
    private chucNang.TextField txt_hoTen;
    private chucNang.TextField txt_luong;
    private chucNang.TextField txt_ngaySinh;
    private chucNang.PasswordField txt_pass;
    private chucNang.TextField txt_soDienThoai;
    private chucNang.TextField txt_usersName;
    // End of variables declaration//GEN-END:variables

    void addEvenUpdate(ActionListener evt) {
        btn_sua.addActionListener(evt);
    }

    void addEvenFillTable(ActionListener evt) {
        btn_Them.addActionListener(evt);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
