<%@ page import="come.demo.orderDAO" %><%--
  Created by IntelliJ IDEA.
  User: XY
  Date: 2020/7/2
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除购物车信息</title>
    <%!
    String duno;
    int dpno;
    orderDAO oDao = new orderDAO();
    %>
    <%
        if(request.getParameter("dpno") != null)//非空则删除
        {
            dpno = Integer.parseInt(request.getParameter("dpno"));
            duno = request.getParameter("duno");
            oDao.delOrder(duno,dpno);
        }
    %>
    <a href="order_list.jsp" title="back">回到购物车</a>
</head>
<body>

</body>
</html>
