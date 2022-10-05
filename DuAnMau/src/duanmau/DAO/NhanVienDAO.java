/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.DAO;

import duanmau.Help.JDBCHelper;
import duanmau.entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class NhanVienDAO extends MainDAO<NhanVien, String> {

    String insert_sql = "insert into NhanVien(MaNV,Passwords,Fullname,Roles) Value(?,?,?,?)";
    String update_sql = "Update NhanVien set Passwords = ? , Fullname = ? ,Roles = ? where MaNV = ? ";
    String remove_sql = "Delete from NhanVien where MaNV = ?";
    String select_sql = "Select * from NhanVien";
    String select_id_sql = "Select * from NhanVien where MaNV = ?";

    @Override
    public void Update(NhanVien entity) {
        JDBCHelper.Update(update_sql, entity.getFullname(), entity.getPasswords(), entity.isRoles(), entity.getMaNV());
    }

    @Override
    public void Insert(NhanVien entity) {

        JDBCHelper.Update(insert_sql, entity.getMaNV(), entity.getFullname(), entity.getPasswords(), entity.isRoles());
    }

    @Override
    public void Remove(String keytype) {
        JDBCHelper.Update(remove_sql, keytype);
    }

    @Override
    public NhanVien EntytiType(String keytype) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhanVien> SelectAll() {
        return this.SelectBySql(select_sql);
    }

    @Override
    protected List<NhanVien> SelectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = JDBCHelper.Query(sql, args);
            while (rs.next()) {
//                NhanVien entity = new NhanVien();
//                entity.setMaNV(rs.getString("MaNV"));
//                entity.setFullname(rs.getString("Fullname"));
//                entity.setPasswords(rs.getString("Passwords"));
//                entity.setRoles(rs.getBoolean("Roles"));
                NhanVien entity = new NhanVien(rs.getString("MaNV"), rs.getString("Passwords"), rs.getString("Fullname"), rs.getBoolean("Roles"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public NhanVien SelectID(String id) {
        List<NhanVien> list = this.SelectBySql(select_id_sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
