/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.Help;

import duanmau.entity.NhanVien;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class Login {
    public static  NhanVien user = null;
    public static void clear(){
        Login.user = null;
    }
    public static boolean isCheck(){
        return Login.user != null;
    }
    public static boolean isManager(){
        return Login.isCheck()&& user.isRoles();
    }
}
