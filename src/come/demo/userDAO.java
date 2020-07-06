package come.demo;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.sql.*;

public class userDAO
{
    private DBUtil dbu;
    public userDAO()
    {
        dbu = new DBUtil();
    }
    public void add(User user)//注册用户信息
    {
        String sql = "insert into [user](user_name,uno,password,telephone,address) values(?,?,?,?,?)";
        Connection conn = dbu.getConn();
        int a = 0;
        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,user.getUser_name());
            pst.setString(2,user.getUno());
            pst.setString(3,user.getPassword());
            pst.setString(4,user.getTelephone());
            pst.setString(5,user.getAddress());
            a = pst.executeUpdate();
            pst.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public User userLogin(String uno,String password)//返回登录的该用户信息
    {
        User us = null;
        PreparedStatement pst = null;
        Connection conn = dbu.getConn();
        String sql = "select * from [user] where uno = ? and password = ?";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1,uno);
            pst.setString(2,password);
            ResultSet rs = pst.executeQuery();
            if(rs.next())//如果查到信息就返回该User对象
            {
                us = new User();
                us.setUno(rs.getString("uno"));
                us.setPassword(rs.getString("password"));
            }
            pst.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return us;
    }
}
