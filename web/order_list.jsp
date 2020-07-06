<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="come.demo.orderDAO" %>
<%@ page import="come.demo.Order" %>
<%@ page import="come.demo.User" %>
<html>
<head>
<meta charset="utf-8"/>
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>

	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
</script>
</head>
<body>
<!--header-->
<header>
 <h1><img src="images/admin_logo.png"/></h1>
 <ul class="rt_nav">
  <li><a href="http://www.mycodes.net" target="_blank" class="website_icon">站点首页</a></li>
  <li><a href="#" class="clear_icon">清除缓存</a></li>
  <li><a href="#" class="admin_icon">DeathGhost</a></li>
  <li><a href="#" class="set_icon">账号设置</a></li>
  <li><a href="login.html" class="quit_icon">安全退出</a></li>
 </ul>
</header>
<!--aside nav-->
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="index.jsp">登录页</a></h2>
 <ul>
  <li>
   <dl>
    <dt>常用布局示例</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="product_list.jsp" class="active">商品列表示例</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>购物信息</dt>
    <dd><a href="order_list.jsp">购物车</a></dd>
   </dl>
  </li>

  <li>
   <dl>
    <dt>足迹信息</dt>
    <dd><a href="buy_records.jsp">购买记录</a></dd>
   </dl>
  </li>

  <li>
   <p class="btm_infor">© DeathGhost.cn 版权所有</p>
  </li>
 </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">购物车</h2>
       <a class="fr top_rt_btn add_icon">添加商品</a>
      </div>
      <section class="mtb">
       <select class="select">
        <option>订单状态</option>
        <option>待付款</option>
        <option>待发货</option>
        <option>待评价</option>
       </select>
       <input type="text" class="textbox textbox_225" placeholder="输入订单编号或收件人姓名/电话..."/>
       <input type="button" value="查询" class="group_btn"/>
      </section>
      <table class="table">
       <tr>
        <th>商品编号</th>
        <th>商品名</th>
        <th>商品价格</th>
        <th>品牌</th>
        <th>操作</th>
       </tr>
       <%!
        orderDAO oDao;
        Order od;
        User us;
        List<Order> orderList = new ArrayList();
       %>

       <%
        String apname = request.getParameter("apname");
        String abrand = request.getParameter("abrand");

        if(request.getParameter("apno") != null)
        {
         int apno = Integer.parseInt(request.getParameter("apno"));
         int aprice = Integer.parseInt(request.getParameter("aprice"));
         String auno = ((User)session.getAttribute("userLogin")).getUno();
         Order aod = new Order(apname,apno,aprice,abrand,auno);
         oDao.addOrder(aod);
        }

       %>

       <%
        oDao = new orderDAO();
        us = (User)session.getAttribute("userLogin");
        orderList = oDao.selOrder(us.getUno());
        for(int i = 0;i < orderList.size();i++)
        {
         od = orderList.get(i);
         %>
       <tr>
        <td class="center"><%= od.getPno() %></td>
        <td><%= od.getPname() %></td>
        <td><%= od.getPrice() %></td>
        <td>
         <address><%= od.getBrand() %></address>
        </td>
        <td class="center">
         <a href="delOrder.jsp?dpno=<%=od.getPno()%>&duno=<%=us.getUno()%>" title="删除" class="link_icon">&#100;</a>
        </td>
        <td class="center">
         <a href="delOrder.jsp?dpno=<%=od.getPno()%>&duno=<%=us.getUno()%>" title="购买" class="link_icon">&#101;</a>
        </td>
       </tr>
       <%
        }
       %>
      </table>
      <aside class="paging">
       <a>第一页</a>
       <a>1</a>
       <a>2</a>
       <a>3</a>
       <a>…</a>
       <a>1004</a>
       <a>最后一页</a>
      </aside>
 </div>
</section>
</body>
</html>
