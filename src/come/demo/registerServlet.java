package come.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = request.getParameter("user_name");
        String uno = request.getParameter("uno");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        User user = new User(user_name,uno,password,telephone,address);
        userDAO udao = new userDAO();
        udao.add(user);
        response.sendRedirect("/shopOnline/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
