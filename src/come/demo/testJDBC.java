package come.demo;

import java.sql.*;
public class testJDBC
{
    public static void main(String[] args)
    {
        System.out.println("database example:");
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; DatabaseName=shopdb"; //student为数据库名
            String user = "sa";
            String password = "2711055a"; // 用户名和密码；
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            String sql = "select * from [user]";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception ex) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception ex) {
                }
            }
        }
        System.out.println("End");
    }
}
