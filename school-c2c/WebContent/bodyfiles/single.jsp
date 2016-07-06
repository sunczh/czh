<%@page import="myclass.bol.userInfo"%>
<%@page import="myclass.bol.goodsInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
if (session.getAttribute("goodsdiscription") != null){						
	goodsInfo goodsdiscription = (goodsInfo) session.getAttribute("goodsdiscription"); 
	%>
<!---->
 <script>
    // You can also use "$(window).load(function() {"
    $(function () {
      // Slideshow 1
      $("#slider2").responsiveSlides({
         auto: true,
		 nav: true,
		 speed: 500,
		 namespace: "callbacks",
      });
    });
  </script>
    <script src="js/responsiveslides.min.js"></script>
<div class="single-section">
	 <div class="col-md-8 fashions2">			 
			<div class="slider2">
				<ul class="rslides rslider" id="slider2">				  
				  <li><img src="<%=goodsdiscription.getPictureAddress() %>" alt=""></li>
				</ul>
		   </div>
	  </div> 
	<div class="col-md-4 side-bar2">
		  <div class="product-price">
			   <div class="product-name">
				 <h2><%=goodsdiscription.getGoodsName()%></h2>
					<p><%=goodsdiscription.getDescription()%></p>
					<span><%=goodsdiscription.getPrice() %>RMB</span>
					<div class="clearfix"></div>
					<h4><%=goodsdiscription.getGoodstype()%></h4>
			  </div>	
			 <div class="product-id">
				 <h4><%=goodsdiscription.getOldornew()%></h4>
				  
				 <p>联系方式 : <a href="#"><%=goodsdiscription.getContact()%></a></p>
				 <a class="add" href="<%=request.getContextPath()%>/cart">加入购物车</a>
			 </div>
		 </div>
      </div>
<%} %>	      	 
	 <div class="clearfix"></div>
</div>
<!---->
</body>
</html>