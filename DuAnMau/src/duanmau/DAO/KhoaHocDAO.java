/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.DAO;

import duanmau.Help.JDBCHelper;
import duanmau.entity.KhoaHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class KhoaHocDAO extends MainDAO<KhoaHoc, String> {

    String insert_sql = "Insert into KhoaHoc(MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV,NgayTao) Values(?,?,?,?,?,?,?)";
    String update_sql = "Update KhoaHoc set NgayKG=?,GhiChu=? where MaKH = ? ";
    String remove_sql = "Delete from KhoaHoc where MaKH = ?";
    String select_sql = "Select * from KhoaHoc";
    String select_id_sql = "Select * from KhoaHoc where MaKH = ?";

    @Override
    public void Update(KhoaHoc entity) {
        JDBCHelper.Update(update_sql, entity.getNgayKG(), entity.getGhiChu(), entity.getMaKH());
    }

    @Override
    public void Insert(KhoaHoc entity) {
        JDBCHelper.Update(insert_sql, entity.getMaCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao());
    }

    @Override
    public void Remove(String keytype) {
        JDBCHelper.Update(remove_sql, keytype);
    }

    @Override
    public KhoaHoc EntytiType(String keytype) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KhoaHoc SelectID(String id) {
        List<KhoaHoc> list = this.SelectBySql(select_id_sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhoaHoc> SelectAll() {
        return this.SelectBySql(select_sql);
    }

    @Override
    protected List<KhoaHoc> SelectBySql(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<KhoaHoc>();
        try {
            ResultSet rs = JDBCHelper.Query(sql, args);
            while (rs.next()) {
                KhoaHoc entity = new KhoaHoc(rs.getInt("MaKH"), rs.getString("MaCD"), rs.getFloat("HocPhi"), rs.getInt("ThoiLuong"), rs.getDate("NgayKG"), rs.getString("GhiChu"), rs.getString("MaNV"), rs.getDate("NgayTao"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<KhoaHoc> selectByCD(String cd) {
        String sql = "Select * from KhoaHoc where MaCD like ?";
        return this.SelectBySql(sql, cd);
    }

    public List<Integer> selectYears() {
        String sql = "select distinct year(NgayKG) as 'year' from KhoaHoc order by year Desc";
        List<Integer> lst = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.Query(sql);
            while (rs.next()) {
                lst.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return lst;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
