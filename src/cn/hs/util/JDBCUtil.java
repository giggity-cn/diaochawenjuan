package cn.hs.util;

import java.sql.*;

/**
 * java链接数据库的通用工具类
 */
public class JDBCUtil {
    // 配置全局的变量和对象
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/questionnaires?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "root";
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getConnection(){
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //增删改功能
    public static int update(String sql,Object obj[]){
        getConnection();
        int num=0;
        try {
            ps = JDBCUtil.conn.prepareStatement(sql);
            if (obj!=null){
                for (int i=0; i<obj.length; i++){
                    ps.setObject(i+1,obj[i]);
                }
            }
            num = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return num;
    }

    //查询功能
    public static ResultSet query(String sql,Object obj[]){
        getConnection();
        try {
            ps = conn.prepareStatement(sql);
            if (obj!=null){
                for (int i=0; i<obj.length; i++){
                    ps.setObject(i+1,obj[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    //释放资源
    public static void close(){
        try {
            if (rs!=null){
                rs.close();
            }
            if (ps!=null){
                ps.close();
            }
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
