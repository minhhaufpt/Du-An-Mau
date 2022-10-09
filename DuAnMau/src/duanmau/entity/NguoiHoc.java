/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.entity;

import java.util.Date;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class NguoiHoc {

    String MaNH;
    String Hoten;
    Date NgaySinh;
    boolean GioiTinh;
    String DienThoai;
    String Email;
    String GhiChu;
    String MaNV;
    Date NgayDK;

    public NguoiHoc(String MaNH, String Hoten, Date NgaySinh, boolean GioiTinh, String DienThoai, String Email, String GhiChu, String MaNV, Date NgayDK) {
        this.MaNH = MaNH;
        this.Hoten = Hoten;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DienThoai = DienThoai;
        this.Email = Email;
        this.GhiChu = GhiChu;
        this.MaNV = MaNV;
        this.NgayDK = NgayDK;
    }

    public NguoiHoc() {
    }

    public NguoiHoc(int i) {
        if (i == 0) {
            this.MaNH = "";
            this.Hoten = "";
            this.NgaySinh = null;
            this.GioiTinh = true;
            this.DienThoai = "";
            this.Email = "";
            this.GhiChu = "";
            this.MaNV = "";
            this.NgayDK = null;
        }
    }

    public String getMaNH() {
        return MaNH;
    }

    public void setMaNH(String MaNH) {
        this.MaNH = MaNH;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayDK() {
        return NgayDK;
    }

    public void setNgayDK(Date NgayDK) {
        this.NgayDK = NgayDK;
    }

}
