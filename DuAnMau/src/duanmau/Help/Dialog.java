package duanmau.Help;


import java.awt.Component;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class Dialog {

    public static void Message(Component parent, String mess) {
        JOptionPane.showMessageDialog(parent, mess, "Hệ thống quản lí đào tạo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean Confirm(Component parent, String mess) {
        int result = JOptionPane.showConfirmDialog(parent, mess, "Hệ thống quản lí đào tạo", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    public static String Input(Component parent, String mess) {
        return JOptionPane.showInputDialog(parent, mess, "Hệ thống quản lí đào tạo", JOptionPane.QUESTION_MESSAGE);
    }
}
