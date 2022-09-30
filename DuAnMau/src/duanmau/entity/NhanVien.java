/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.entity;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class NhanVien {

    String MaNV;
    String Passwords;
    String Fullname;
    boolean Roles;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String Passwords, String Fullname, boolean Roles) {
        this.MaNV = MaNV;
        this.Passwords = Passwords;
        this.Fullname = Fullname;
        this.Roles = Roles;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getPasswords() {
        return Passwords;
    }

    public void setPasswords(String Passwords) {
        this.Passwords = Passwords;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public boolean isRoles() {
        return Roles;
    }

    public void setRoles(boolean Roles) {
        this.Roles = Roles;
    }

}
