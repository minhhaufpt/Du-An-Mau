/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.entity;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class HocVien {
    int MaHV;
    int MaKH;
    String MaNH;
    float Grade;

    public HocVien() {
    }

    public HocVien(int MaHV, int MaKH, String MaNH, float Grade) {
        this.MaHV = MaHV;
        this.MaKH = MaKH;
        this.MaNH = MaNH;
        this.Grade = Grade;
    }

    public int getMaHV() {
        return MaHV;
    }

    public void setMaHV(int MaHV) {
        this.MaHV = MaHV;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNH() {
        return MaNH;
    }

    public void setMaNH(String MaNH) {
        this.MaNH = MaNH;
    }

    public float getGrade() {
        return Grade;
    }

    public void setGrade(float Grade) {
        this.Grade = Grade;
    }

}
