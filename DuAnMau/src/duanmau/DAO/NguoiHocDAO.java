/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.DAO;

import duanmau.Help.JDBCHelper;
import duanmau.entity.NguoiHoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class NguoiHocDAO extends MainDAO<NguoiHoc, String> {

    String insert_sql = "Insert into NguoiHoc(MaNH,HoTen,NgaySinh,GioiTinh,DienThoai,Email,GhiChu,MaNV,NgayDK) Values(?,?,?,?,?,?,?,?,?)";
    String update_sql = "Update NguoiHoc set HoTen=?,NgaySinh=?,GioiTinh=?,DienThoai=?,Email=? ,GhiChu=? ,MaNV = ?,NgayDK=? where MaNH = ? ";
    String remove_sql = "Delete from NguoiHoc where MaNH = ?";
    String select_sql = "Select * from NguoiHoc";
    String select_id_sql = "Select * from NguoiHoc where MaNH = ?";

    @Override
    public void Update(NguoiHoc entity) {
        JDBCHelper.Update(update_sql, entity.getHoten(), entity.getNgaySinh(), entity.isGioiTinh(), entity.getDienThoai(), entity.getEmail(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayDK(), entity.getMaNH());
    }

    @Override
    public void Insert(NguoiHoc entity) {
        JDBCHelper.Update(insert_sql, entity.getMaNH(), entity.getHoten(), entity.getNgaySinh(), entity.isGioiTinh(), entity.getDienThoai(), entity.getEmail(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayDK());
    }

    @Override
    public void Remove(String keytype) {
        JDBCHelper.Update(remove_sql, keytype);
    }

    @Override
    public NguoiHoc EntytiType(String keytype) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NguoiHoc SelectID(String id) {
        List<NguoiHoc> list = this.SelectBySql(select_id_sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NguoiHoc> SelectAll() {
        return this.SelectBySql(select_sql);
    }

    @Override
    protected List<NguoiHoc> SelectBySql(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<NguoiHoc>();
        try {
            ResultSet rs = JDBCHelper.Query(sql, args);
            while (rs.next()) {
                NguoiHoc entity = new NguoiHoc(rs.getString("MaNH"), rs.getString("Hoten"), rs.getDate("NgaySinh"), rs.getBoolean("GioiTinh"), rs.getString("DienThoai"), rs.getString("Email"), rs.getString("GhiChu"), rs.getString("MaNV"), rs.getDate("NgayDK"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<NguoiHoc> SelectByKeyword(String key) {
        String select = "Select * from NguoiHoc where HoTen like ?";
        return this.SelectBySql(select, "%" + key + "%");
    }

    public List<NguoiHoc> selectNotinKhoahoc(int makh, String key) {
        String sql = "select * from NguoiHoc where Hoten like ? and MaNH not in (Select MaNH from HocVien Where MaKH = ?)";
        return this.SelectBySql(sql, "%" + key + "%", makh);
    }
}
