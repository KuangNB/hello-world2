package tools;

import java.sql.*;

public class DBManager {
    private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/cardb?useUnicode=true&characterEncoding=utf8";
    private static final String NAME = "root";
    private static final String PWD = "11111111";

    //加载一次驱动，运行此类
    static{
        try {
            Class.forName(DRIVERNAME);
            //hh
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //连接方法
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,NAME,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭数据库方法
    public static void getClose(ResultSet rst, PreparedStatement pstm,Connection conn){
        try {
            if(rst != null)
                rst.close();
            if(pstm != null)
                pstm.close();
            if(conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
