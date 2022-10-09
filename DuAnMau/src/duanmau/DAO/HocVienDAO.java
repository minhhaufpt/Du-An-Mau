/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.DAO;

import duanmau.Help.JDBCHelper;
import duanmau.entity.HocVien;
import duanmau.entity.NguoiHoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class HocVienDAO extends MainDAO<HocVien, String> {

    String insert_sql = "Insert into HocVien(MaKH,MaNH,Grade) Values(?,?,?)";
    String update_sql = "Update HocVien set MaKH=?,MaNH=?,Grade=? where MaHV = ? ";
    String remove_sql = "Delete from HocVien where MaHV = ?";
    String select_sql = "Select * from HocVien";
    String select_id_sql = "Select * from HocVien where MaHV = ?";

    @Override
    public void Update(HocVien entity) {
        JDBCHelper.Update(update_sql, entity.getMaKH(), entity.getMaNH(), entity.getGrade(), entity.getMaHV());
    }

    @Override
    public void Insert(HocVien entity) {
        JDBCHelper.Update(insert_sql, entity.getMaKH(), entity.getMaNH(), entity.getGrade());
    }

    @Override
    public void Remove(String keytype) {
        JDBCHelper.Update(remove_sql, keytype);
    }

    @Override
    public HocVien EntytiType(String keytype) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HocVien SelectID(String id) {
        List<HocVien> list = this.SelectBySql(select_id_sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);

    }

    @Override
    public List<HocVien> SelectAll() {
        return this.SelectBySql(select_sql);
    }

    @Override
    protected List<HocVien> SelectBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<HocVien>();
        try {
            ResultSet rs = JDBCHelper.Query(sql, args);
            while (rs.next()) {
                HocVien entity = new HocVien(rs.getInt("MaHV"), rs.getInt("MaKH"), rs.getString("MaNH"), rs.getFloat("Grade"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
    public List<HocVien> selectByKhoaHoc(int makh){
        String sql = "select * from HocVien where MakH = ?";
        return this.SelectBySql(sql, makh);
    }


}
