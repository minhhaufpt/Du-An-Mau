/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.Help;

import duanmau.ConnectSQLSever.ConnectSQLSever;
import java.sql.*;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class JDBCHelper {

    private static Connection con = null;

    public JDBCHelper() throws Exception {
        ConnectSQLSever connect = new ConnectSQLSever();
        con = connect.getConnection();
    }

// Set giá trị cho câu lệnh SQL 
    public static PreparedStatement getSTMT(String sql, Object... args) throws SQLException {
        PreparedStatement STMT = null;
        if (sql.trim().startsWith("{")) {
            STMT = con.prepareCall(sql);
        } else {
            STMT = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            STMT.setObject(i + 1, args[i]);
        }
        return STMT;
    }

    public static ResultSet Query(String sql, Object... args) throws SQLException {
        PreparedStatement STMT = JDBCHelper.getSTMT(sql, args);
        try {
            return STMT.executeQuery();
        } finally {
            con.close();
        }
    }

    public static int Update(String sql, Object... args) {
        try {
            PreparedStatement STMT = JDBCHelper.getSTMT(sql, args);
            try {
                return STMT.executeUpdate();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static Object Value(String sql, Object... args) {
        try {
            ResultSet sr = JDBCHelper.Query(sql, args);
            if (sr.next()) {
                try {
                    return sr.getObject(0);
                } finally {
                    con.close();
                }
            } else {
                con.close();
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
