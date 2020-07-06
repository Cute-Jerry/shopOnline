package come.demo;

import java.sql.*;

public class productDAO
{
    private DBUtil dbu;

    public productDAO()
    {
        dbu = new DBUtil();
    }

    public void addProduct(Product pd)//添加商品
    {
        String sql = "insert into [product](pname,pno,price,brand) values(?,?,?,?)";
        Connection conn = dbu.getConn();
        int a = 0;
        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,pd.getPname());
            pst.setInt(2,pd.getPno());
            pst.setInt(3,pd.getPrice());
            pst.setString(4,pd.getBrand());
            a = pst.executeUpdate();
            pst.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public boolean updateProduct(Product pd)//更新商品信息
    {
        Connection conn = dbu.getConn();
        String sql = "update [product] set pname=?,price=?,brand=? where pno = ?";
        int i = 0;
        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,pd.getPname());
            pst.setInt(2,pd.getPrice());
            pst.setString(3,pd.getBrand());
            pst.setInt(4,pd.getPno());
            i = pst.executeUpdate();
            pst.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return i > 0;
    }

    public boolean delProduct(Product pd)//删除商品
    {
        String sql = "delete from [product] where pno = ?";
        Connection conn = dbu.getConn();
        int i = 0;
        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,pd.getPno());
            i = pst.executeUpdate();
            pst.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return i > 0;
    }

    public Product selProduct(int Pno)//查找商品
    {
        Product prd = null;
        String sql = "select * from [product] where pno = ?";
        Connection conn = dbu.getConn();
        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,Pno);
            ResultSet rs = pst.executeQuery();
            if(rs.next())//如果查到信息就返回该对象
            {
                prd = new Product();
                prd.setPno(rs.getInt("pno"));
                prd.setPname(rs.getString("pname"));
                prd.setPrice(rs.getInt("price"));
                prd.setBrand(rs.getString("brand"));
            }
            pst.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return prd;
    }
}
