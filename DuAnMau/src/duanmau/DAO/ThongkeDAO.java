/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.DAO;

import duanmau.Help.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class ThongkeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JDBCHelper.Query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Object[]> getBangdiem(int makh) {
        String sql = "{CALL sp_BangDiem(?)}";
        String[] cols = {"MaNH", "Hoten", "Diem"};
        return this.getListOfArray(sql, cols, makh);
    }

    public List<Object[]> getLuongNguoiHoc() {
        String sql = "{CALL sq_ThongKeNguoiHoc}";
        String[] cols = {"Nam", "SoLuong", "DauTien", "Cuoicung"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDiemChuyenDe() {
        String sql = "{CALL sq_ThongKeDiem}";
        String[] cols = {"ChuyenDe", "SoHV", "ThapNhat", "CaoNhat", "TrungBinh"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDoanhThu(int nam) {
        String sql = "{CALL sq_ThongKeDoanhThu}";
        String[] cols = {"ChuyenDe", "SoKH", "SoHV", "DoanhThu", "CaoNhat", "TrungBinh"};
        return this.getListOfArray(sql, cols, nam);
    }
}
