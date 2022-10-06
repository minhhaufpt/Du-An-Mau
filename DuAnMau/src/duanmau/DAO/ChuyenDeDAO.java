/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.DAO;

import duanmau.Help.JDBCHelper;
import duanmau.entity.ChuyenDe;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class ChuyenDeDAO extends MainDAO<ChuyenDe, String> {

    String insert_sql = "Insert into ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) Values(?,?,?,?,?,?)";
    String update_sql = "Update ChuyenDe set TenCD=?,HocPhi=?,ThoiLuong=?,Hinh=?,MoTa=? where MaCD = ? ";
    String remove_sql = "Delete from ChuyenDe where MaCD = ?";
    String select_sql = "Select * from ChuyenDe";
    String select_id_sql = "Select * from ChuyenDe where MaCD = ?";

    @Override
    public void Update(ChuyenDe entity) {
        JDBCHelper.Update(update_sql, entity.getTenCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getHinh(), entity.getMoTa(), entity.getMaCD());
    }

    @Override
    public void Insert(ChuyenDe entity) {
        JDBCHelper.Update(insert_sql, entity.getMaCD(), entity.getTenCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getHinh(), entity.getMoTa());
    }

    @Override
    public void Remove(String keytype) {
        JDBCHelper.Update(remove_sql, keytype);
    }

    @Override
    public ChuyenDe EntytiType(String keytype) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChuyenDe SelectID(String id) {
        List<ChuyenDe> list = this.SelectBySql(select_id_sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChuyenDe> SelectAll() {
       return this.SelectBySql(select_sql);
    }

    @Override
    protected List<ChuyenDe> SelectBySql(String sql, Object... args) {
       List<ChuyenDe> list = new ArrayList<ChuyenDe>();
        try {
            ResultSet rs = JDBCHelper.Query(sql, args);
            while (rs.next()) {
                ChuyenDe entity = new ChuyenDe(rs.getString("MaCD"), rs.getString("TenCD"), rs.getDouble("HocPhi"), rs.getInt("ThoiLuong"),rs.getString("Hinh"),rs.getString("MoTa"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
