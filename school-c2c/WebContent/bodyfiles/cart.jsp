<%@page import="myclass.bol.userInfo"%>
<%@page import="mybean.model.cartBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="myclass.bll.cartBll"%>
<%@page import="myclass.dal.cartDal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="cart">
		<div class="container">
			<div class="cart-info">
				<h3>
					查看购物车
					</h2>
					<p>请将您的购物车塞满 </p>
					<a href="sellitems.jsp">继续购物</a>
			</div>
			<div class="table-responsive">
				<table class="table">
<%
ArrayList<cartBean>list=new ArrayList<cartBean>();
cartDal cart=new cartDal();
if(session.getAttribute("user")!= null){
	userInfo usera = (userInfo) session.getAttribute("user");
list=cart.getcartBybuyerID(usera.getUserName());

%>
					<caption>购物车情况查询</caption>
					<thead>
						<tr>
							<th>商品名称</th>
							<th>出售者用户名</th>
							<th>出售者联系方式</th>
							<th>简述</th>
							<th>价格</th>
							<th>购买状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<%for(int i =0 ;i<list.size();i++){
						cartBean cb=list.get(i);%>
						<tr>
							<td><%=cb.getGoodsName()%></td>
							<td><%=cb.getSellerName()%></td>
							<td><%=cb.getSellerContact()%></td>
							<td><%=cb.getGoodsDiscription()%></td>
							<td><%=cb.getGoodsPrice()%></td>
							<td><%=cb.getBuyType()%></td>
							<td><a href="<%=request.getContextPath()%>/deletecart?deleteid=<%=cb.getCartId()%>">删除</a></td>
						</tr>
					<%} }%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>