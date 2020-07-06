<%--
  Created by IntelliJ IDEA.
  User: XY
  Date: 2020/6/30
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/loginCSS.css"/>
</head>
<body>
<div id="login">
    <h1>网上商城注册页面</h1>
    <form action="registerServlet" method="post" name="register">
        <input type="text" required="required" placeholder="用户名" name="uno"></input>
        <input type="password" required="required" placeholder="密码" name="password"></input>
        <input type="password" required="required" placeholder="姓名" name="user_name"></input>
        <input type="password" required="required" placeholder="电话号码" name="telephone"></input>
        <input type="password" required="required" placeholder="地址" name="address"></input>
        <button class="but" type="submit">注册</button>
    </form>
</body>
</html>