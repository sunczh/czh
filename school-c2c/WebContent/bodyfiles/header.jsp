<%@page import="myclass.dal.cartDal"%>
<%@page import="myclass.bol.userInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<!---->
<div class="header">
	 <div class="container">
		 <div class="header-left">
			 <div class="top-menu">
				 <ul>
				 <li><a href="index.jsp">主页</a></li>
				 <li><a href="sellitems.jsp">校园二手街</a></li>
				 <li><a href="release.jsp">发布平台</a></li>			 
				 </ul>
			 </div>
		 </div>
		 <div class="logo">
			 <a href="index.jsp"><img src="images/logo.png" alt=""/></a>
		 </div>
		 <div class="header-right">
			
			 <div class="signin">
				  <ul>
				  <%
				  cartDal cd=new cartDal();
				  if (session.getAttribute("user") != null){						
							userInfo user = (userInfo) session.getAttribute("user");
					  %>		  
				  <div class="cart-sec">
				  <a href="shoppingcart.jsp"><img href="shoppingcart.jsp" src="images/cart.png" alt=""/>(<%=cd.getnumberbybuyerID(user.getUserName()) %>)</a>
				  </div>
					  <li><a href="userinformation.jsp"><%=user.getUserName() %></a> <span>/<span> &nbsp;</li>
					 <li><a href=" <%=request.getContextPath()%>/zhuxiao">注销</a></li>
					<%} else{%>
				  
				  
					 <li><a href="zhuce.jsp">注册</a> <span>/<span> &nbsp;</li>
					 <li><a href="login.jsp">登录</a></li>
					 <%} %>
				 </ul>			 
			 </div>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!---->
</body>
</html>