package come.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class orderDAO
{
    private DBUtil dbu;

    public orderDAO()
    {
        dbu = new DBUtil();
    }

    public void addOrder(Order od)//添加进购物车
    {
        String sql = "insert into [order](uno,pname,price,brand,pno) values(?,?,?,?,?)";
        Connection conn = dbu.getConn();
        int a = 0;
        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,od.getUno());
            pst.setString(2,od.getPname());
            pst.setInt(3,od.getPrice());
            pst.setString(4,od.getBrand());
            pst.setInt(5,od.getPno());
            a = pst.executeUpdate();
            pst.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public boolean delOrder(String duno,int dpno)//删除购物车中的商品
    {
        String sql = "delete from [order] where pno = ? and uno = ?";
        Connection conn = dbu.getConn();
        int i = 0;
        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,dpno);
            pst.setString(2,duno);
            i = pst.executeUpdate();
            pst.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return i > 0;
    }

    public List selOrder(String uno)//查找商品
    {
        Order od = null;
        List<Order> orderList = new ArrayList();
        String sql = "select * from [order] where uno = ?";
        Connection conn = dbu.getConn();
        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,uno);
            ResultSet rs = pst.executeQuery();
            while(rs.next())//如果查到信息就返回该对象
            {
                od = new Order();
                od.setPno(rs.getInt("pno"));
                od.setPname(rs.getString("pname"));
                od.setPrice(rs.getInt("price"));
                od.setBrand(rs.getString("brand"));
                od.setUno(rs.getString("uno"));
                orderList.add(od);
            }
            pst.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return orderList;
    }
}
