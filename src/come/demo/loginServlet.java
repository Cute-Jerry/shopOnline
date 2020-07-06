package come.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uno = request.getParameter("uno");
        String password = request.getParameter("password");
        userDAO ud = new userDAO();
        User us = ud.userLogin(uno,password);//判断是否有该登录信息
        if(us != null)//登录成功
        {
            HttpSession session = request.getSession();//设置会话保存用户信息
            session.setAttribute("userLogin",us);
            response.sendRedirect("/shopOnline/product_list.jsp");
        }
        else
        {
            response.sendRedirect("/shopOnline/index.jsp?error=yes");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
