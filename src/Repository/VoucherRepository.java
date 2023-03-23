/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Voucher;
import Utilities.DBConnection;
import ViewModel.VouchersViewModel;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import view.logiin.XDate;

/**
 *
 * @author ADMIN
 */
public class VoucherRepository {

    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<Voucher> ListVoucher = null;
    List<VouchersViewModel> ListVoucherViewModel = null;

    public VoucherRepository() {
    }

    public List<VouchersViewModel> getLisVoucher() {
        String select = "SELECT IDVOUCHER,MAGIAMGIA,GIAMGIA,VOUCHER.NGAYTAO,VOUCHER.NGAYSUA,NGAYBATDAU,\n" +
"	NGAYKETTHUC,SOLUONG,VOUCHER.TRANGTHAI,USERS.IDUSERS,HOTEN\n" +
"	FROM dbo.Voucher INNER JOIN dbo.USERS ON USERS.IDUSERS = VOUCHER.IDUSERS";
        ListVoucherViewModel = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ListVoucherViewModel.add(new VouchersViewModel(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4),rs.getString(5), rs.getDate(6),rs.getDate(7), rs.getInt(8), rs.getBoolean(9), rs.getInt(10),rs.getString(11)));
            }
            rs.close();
        } catch (Exception e) {
        }

        return ListVoucherViewModel;
    }

    public List<Voucher> selectAllDate() {
        String select = "select * from Voucher where SOLUONG > 0 AND ? BETWEEN NGAYBATDAU AND NGAYKETTHUC AND TrangThai =1";
        ListVoucher = new ArrayList<>();
        try {
            pst = db.getConnection().prepareStatement(select);
            pst.setString(1, XDate.toString(new java.util.Date(), "yyyy-MM-dd"));
            rs = pst.executeQuery();
             while (rs.next()) {
                ListVoucher.add(new Voucher(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4),rs.getString(5), rs.getDate(6),rs.getDate(7), rs.getInt(8), rs.getBoolean(9), rs.getInt(10)));
            }
            rs.close();
        } catch (Exception e) {
        }

        return ListVoucher;
    }

    public String updateSoLuongTon(Integer idVoucher) {
        String update = "UPDATE dbo.Voucher SET SOLUONG = SoLuong - 1 WHERE IdVoucher = 1";
        try {
            pst = db.getConnection().prepareStatement(update);

            pst.setInt(1, idVoucher);
            pst.executeUpdate();
            return "sua thanh cong";
        } catch (Exception e) {

        }
        return "sua khong thanh cong";
    }

    public String insert(Voucher v) {
        String insert = "INSERT INTO dbo.VOUCHER\n" +
"(\n" +
"    MAGIAMGIA,\n" +
"    GIAMGIA,\n" +
"    NGAYBATDAU,\n" +
"    NGAYKETTHUC,\n" +
"    SOLUONG,\n" +
"    TRANGTHAI,\n" +
"	IDUSERS,\n" +
"    NGAYTAO\n" +
")\n" +
"VALUES(?,?,?,?,?,?,?,GETDATE())";

        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setString(1, v.getMaGiamGia());
            pst.setFloat(2, v.getGiamgia());
            pst.setObject(3, v.getNgayBatDau());
            pst.setObject(4, v.getNgayKetThuc());
            pst.setInt(5, v.getSoLuong());
            pst.setBoolean(6, v.isTrangThai());
            pst.setInt(7, v.getIdUser());
            pst.executeUpdate();
            return "Bạn Đã Thêm Voucher Thành Công";
        } catch (Exception e) {

        }
        return "Bạn Đã Thêm Voucher Không Thành Công";
    }

    public String updateVoucher(Voucher v) {
        String update = "UPDATE dbo.Voucher SET GiamGia = ? , NGAYBATDAU = ?,NGAYKETTHUC =?, SOLUONG = ?,TrangThai= ? ,NGAYSUA =GETDATE() WHERE IdVoucher = ?";

        try {
            pst = db.getConnection().prepareStatement(update);
            pst.setFloat(1, v.getGiamgia());
            pst.setObject(2, v.getNgayBatDau());
            pst.setObject(3, v.getNgayKetThuc());
            pst.setInt(4, v.getSoLuong());
            pst.setBoolean(5, v.isTrangThai());
            pst.setInt(6, v.getIDVoucher());

            pst.executeUpdate();
            return "Sua thanh cong";
        } catch (Exception e) {

        }
        return "Sua khong thanh cong";
    }

    public String DeleteVoucher(Voucher v) {
        String Delete = "DELETE FROM dbo.Voucher WHERE IdVoucher = ?";

        try {
            pst = db.getConnection().prepareStatement(Delete);
            pst.setInt(1, v.getIDVoucher());
            pst.executeUpdate();

            return "Xoa thanh cong";
        } catch (Exception e) {

        }
        return "Xoa khong thanh cong";
    }

    public void update(Integer id) {
        String update = "UPDATE dbo.Voucher SET SOLUONG = SOLUONG - 1 WHERE IdVoucher = ?";
        try {
            pst = db.getConnection().prepareStatement(update);

            pst.setInt(1, id);

            pst.executeUpdate();

        } catch (Exception e) {

        }

    }

    public int getindex(int id) {
        for (int i = 0; i < ListVoucher.size(); i++) {
            if (ListVoucher.get(i).getIDVoucher() == id) {
                return i;
            }
        }
        return -3;
    }

    public List<Voucher> searchTen(String temp) {
        List<Voucher> listTemp = new ArrayList<>();
        for (Voucher x : ListVoucher) {
            if (x.getMaGiamGia().contains(temp)) {
                listTemp.add(x);
            }
        }
        return listTemp;
    }
}
