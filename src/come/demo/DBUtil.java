package come.demo;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;

public class DBUtil
{
    private String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String dbURL="jdbc:sqlserver://localhost:1433; databaseName=shopdb";
    private String userName="sa";
    private String userPwd="2711055a";
    public Connection getConn()//连接数据库
    {
        Connection conn = null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
            conn = DriverManager.getConnection(dbURL,userName,userPwd);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
