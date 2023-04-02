/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author ADMIN
 */
public class HoaDonBan {
    private int idHDB;
    private int idUser,idKhachHang;
    private String ngayTao,ngayThanhToan,tenKhachHang,ghiChu;
    private boolean TrangThaiTraTien,TrangThaiHoaDon;
    private float tongTien,tienKhachDua,tienTraLai,tongCongTienPhaiTra,tienApVoucher;
    private int trangThai;
    private Integer idVoucher;

    public HoaDonBan() {
    }

    public HoaDonBan(int idHDB, int idUser, int idKhachHang, String ngayTao, String ngayThanhToan, String tenKhachHang, String ghiChu, boolean TrangThaiTraTien, boolean TrangThaiHoaDon, float tongTien, float tienKhachDua, float tienTraLai, int trangThai, Integer idVoucher) {
        this.idHDB = idHDB;
        this.idUser = idUser;
        this.idKhachHang = idKhachHang;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenKhachHang = tenKhachHang;
        this.ghiChu = ghiChu;
        this.TrangThaiTraTien = TrangThaiTraTien;
        this.TrangThaiHoaDon = TrangThaiHoaDon;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.tienTraLai = tienTraLai;
        this.trangThai = trangThai;
        this.idVoucher = idVoucher;
    }

    public HoaDonBan(int idHDB, int idUser, int idKhachHang, String ngayTao, String ngayThanhToan, String tenKhachHang, String ghiChu, boolean TrangThaiTraTien, boolean TrangThaiHoaDon, float tongTien, float tienKhachDua, float tienTraLai, float tongCongTienPhaiTra, float tienApVoucher, int trangThai, Integer idVoucher) {
        this.idHDB = idHDB;
        this.idUser = idUser;
        this.idKhachHang = idKhachHang;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenKhachHang = tenKhachHang;
        this.ghiChu = ghiChu;
        this.TrangThaiTraTien = TrangThaiTraTien;
        this.TrangThaiHoaDon = TrangThaiHoaDon;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.tienTraLai = tienTraLai;
        this.tongCongTienPhaiTra = tongCongTienPhaiTra;
        this.tienApVoucher = tienApVoucher;
        this.trangThai = trangThai;
        this.idVoucher = idVoucher;
    }

    public boolean isTrangThaiTraTien() {
        return TrangThaiTraTien;
    }

    public void setTrangThaiTraTien(boolean TrangThaiTraTien) {
        this.TrangThaiTraTien = TrangThaiTraTien;
    }

    public boolean isTrangThaiHoaDon() {
        return TrangThaiHoaDon;
    }

    public void setTrangThaiHoaDon(boolean TrangThaiHoaDon) {
        this.TrangThaiHoaDon = TrangThaiHoaDon;
    }

    public float getTongCongTienPhaiTra() {
        return tongCongTienPhaiTra;
    }

    public void setTongCongTienPhaiTra(float tongCongTienPhaiTra) {
        this.tongCongTienPhaiTra = tongCongTienPhaiTra;
    }

    public float getTienApVoucher() {
        return tienApVoucher;
    }

    public void setTienApVoucher(float tienApVoucher) {
        this.tienApVoucher = tienApVoucher;
    }

   

    public int getIdHDB() {
        return idHDB;
    }

    public void setIdHDB(int idHDB) {
        this.idHDB = idHDB;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(float tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public float getTienTraLai() {
        return tienTraLai;
    }

    public void setTienTraLai(float tienTraLai) {
        this.tienTraLai = tienTraLai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }
    
    
    
}
