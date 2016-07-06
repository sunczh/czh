
<%@page import="myclass.bol.goodsInfo"%>
<%@page import="myclass.dal.goodsDal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
	ArrayList<goodsInfo>goods=new ArrayList<goodsInfo>();
	if(request.getAttribute("goods")!=null){
		goods=(ArrayList<goodsInfo>)request.getAttribute("goods");
		int pages=(Integer)session.getAttribute("pages");
	}
	%>
	<div class="men-fashions">
		<div class="container">
			<div class="col-md-9 fashions">
				<div class="title">
					<h3 style="font-family: 方正姚体;">最新上架</h3>
				</div>
				<div class="fashion-section">
					<div class="fashion-grid1">
						<%if(request.getAttribute("goods")==null){
							goodsDal gd = new goodsDal();
							goods = gd.getgoodsNew();}
							for (int i = 0; i < goods.size(); i++) {
						%>
						<div class="col-md-4 fashion-grid">
							<a href="<%=request.getContextPath()%>/shangpin?shangpinid=<%=goods.get(i).getGoodsId()%>"><img
								src="<%=goods.get(i).getPictureAddress()%>" alt="" />
								<div class="product">
									<h3><%=goods.get(i).getGoodsName()%></h3>
									<p>
										<span></span>
										<%=goods.get(i).getPrice()%>
										RMB
									</p>
								</div> </a>
<!-- 							<div class="fashion-view">
								<span></span>
								<div class="clearfix"></div>
								<h4>
									<a href="single.jsp">Quick View</a>
								</h4>
							</div> -->
						</div>
						<%
							}
	
						%>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<div class="col-md-3 side-bar">
				<div class="categories">
					<h3>CATEGORIES</h3>
					<ul>
						<li><a href="<%=request.getContextPath()%>/menu?item=all">校园二手
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/menu?item=shenghuoyongpin">生活物品</a></li>
						<li><a
							href="<%=request.getContextPath()%>/menu?item=xuexiwenju">学习文具</a></li>
						<li><a href="<%=request.getContextPath()%>/menu?item=yiwu">衣物</a></li>
						<li><a
							href="<%=request.getContextPath()%>/menu?item=xuexiziliao">学习资料</a></li>
						<li><a
							href="<%=request.getContextPath()%>/menu?item=xianzhishuma">闲置数码</a></li>
						<li><a href="<%=request.getContextPath()%>/menu?item=xiebao">鞋包</a></li>
						<li><a
							href="<%=request.getContextPath()%>/menu?item=guizhongwupin">贵重物品</a></li>
						<li><a href="<%=request.getContextPath()%>/menu?item=others"><del>其它分类</a></li>
					</ul>
				</div>
				<div class="sales">
					<h3>SALE</h3>
					<div class="pricing">
						<h4>Price range</h4>
						<input type="text" placeholder="price from" required /> <input
							type="text" placeholder="price to" required />
						<div class="clearfix"></div>
					</div>
					
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!---->

</body>
</html>