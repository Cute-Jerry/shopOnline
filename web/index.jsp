<%--
  Created by IntelliJ IDEA.
  User: XY
  Date: 2020/6/30
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ page import="jdk.nashorn.api.scripting.NashornScriptEngineFactory" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="css/loginCSS.css"/>
</head>
<body>
<div id="login">
  <h1>网上商城</h1>
  <form action="loginServlet" method="post" name="Login">
    <input type="text" required="required" placeholder="用户名" name="uno"></input>
    <input type="password" required="required" placeholder="密码" name="password"></input>
    <button class="but" type="submit">登录</button>
    <script>
      var error ='<%=request.getParameter("error")%>';
      if(error == 'yes'){
        alert("账号或者密码错误!");
      }
    </script>
  </form>

  <form action="register.jsp" method="post">
    <button class="but" type="submit">注册</button>
  </form>
</div>
</body>
</html>
