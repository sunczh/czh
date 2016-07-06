<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<!---->
<script src="js/responsiveslides.min.js"></script>
  <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        manualControls: '#slider3-pager',
      });
    });
  </script>
</head>
<body>
 <div class="slider">
	  <div class="callbacks_container">
	     <ul class="rslides" id="slider">
	         <li>
				  <img src="images/bnr.jpg" alt="">
				  <div class="banner-info">
				  <h3 style="font-family:幼圆;font-size: 34px">心满意足的交换<br>得偿所愿</h3>
	<!--  			  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. consectetur adipiscing elit. consectetur adipiscing elit.</p>-->
				  </div>
	         </li>
	         <li>
				 <img src="images/bnr2.jpg" alt="">
	        	 <div class="banner-info">
	        	 <h3>Shopper在等你</h3>
<!--          	 <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. consectetur adipiscing elit. consectetur adipiscing elit.</p>-->
				 </div>
			 </li>
	         <li>
	             <img src="images/bnr3.jpg" alt="">
	        	 <div class="banner-info">
	        	 <h3>NOW TO BUY</h3>
<!--	          	 <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. consectetur adipiscing elit. consectetur adipiscing elit.</p>-->
				 </div>
	         </li>
	      </ul>
	  </div>
  </div>
<!---->
<div class="tab-section">
	 <div class="wrap">
		 <div id="horizontalTab">
			   <ul class="resp-tabs-list">
					<li><a href="#">FEATURED</a></li>
					<li class="active"><a href="#">JUST ARRIVED</a></li>
					<li><a href="#">SALE</a></li>
					<div class="clearfix"></div>				
			   </ul>
			   <div class="resp-tabs-container">
				 <!---tab1----->
				 <div>
					 <div class="course_demo1">
							 <ul id="flexiselDemo1">	
								 <li class="g1">						
									 <img src="images/c1.jpg" alt="" />		
										<a href="sellitems.jsp"><div class="caption">
										<span></span>
										<h3>笔</h3>
										<h5>10.00 RMB</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c2.jpg" alt="" />
									 <a href="sellitems.jsp"><div class="caption">
										<span></span>
										<h3>自行车</h3>
										<h5>180.00 RMB</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c3.jpg" alt="" />					
									 <a href="sellitems.jsp"><div class="caption">
										<span></span>
										<h3>电脑</h3>
										<h5>180.00 RMB</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c4.jpg" alt="" />					
									 <a href="sellitems.jsp"><div class="caption">
										<span></span>
										<h3>化妆品</h3>
										<h5>180.00 RMB</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c1.jpg" alt="" />					
									 <a href="sellitems.jsp"><div class="caption">
										<span></span>
										<h3>笔</h3>
										<h5>10.00 RMB</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c3.jpg" alt="" />					
									 <a href="sellitems.jsp"><div class="caption">
										<span></span>
										<h3>电脑</h3>
										<h5>180.00 RMB</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
							 </ul>
						 </div>
						  <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
							<script type="text/javascript">
						 $(window).load(function() {
							$("#flexiselDemo1").flexisel({
								visibleItems: 4,
								animationSpeed: 1000,
								autoPlay: true,
								autoPlaySpeed: 3000,    		
								pauseOnHover: true,
								enableResponsiveBreakpoints: true,
								responsiveBreakpoints: { 
									portrait: { 
										changePoint:480,
										visibleItems: 1
									}, 
									landscape: { 
										changePoint:640,
										visibleItems: 2
									},
									tablet: { 
										changePoint:768,
										visibleItems: 3
									}
								}
							});
							
						 });
						  </script>
						<script type="text/javascript" src="js/jquery.flexisel.js"></script>
				 </div>
				 <!---//tab1----->
				 <!---tab2----->
				 <div>
					 <div class="course_demo1">
							 <ul id="flexiselDemo2">	
								 <li class="g1">						
									 <img src="images/c4.jpg" alt="" />		
										<a href="single.html"><div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c3.jpg" alt="" />
									 <a href="single.html"><div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c2.jpg" alt="" />					
									 <a href="single.html"><div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c1.jpg" alt="" />					
									 <a href="single.html"><div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c4.jpg" alt="" />					
									 <a href="single.html"><div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c1.jpg" alt="" />					
									<a href="single.html"><div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
							 </ul>
						 </div>
						  <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
							<script type="text/javascript">
						 $(window).load(function() {
							$("#flexiselDemo2").flexisel({
								visibleItems: 4,
								animationSpeed: 1000,
								autoPlay: true,
								autoPlaySpeed: 3000,    		
								pauseOnHover: true,
								enableResponsiveBreakpoints: true,
								responsiveBreakpoints: { 
									portrait: { 
										changePoint:480,
										visibleItems: 1
									}, 
									landscape: { 
										changePoint:640,
										visibleItems: 2
									},
									tablet: { 
										changePoint:768,
										visibleItems: 3
									}
								}
							});
							
						 });
						  </script>
						<script type="text/javascript" src="js/jquery.flexisel.js"></script>
				 </div>
				 <!---//tab2----->
				 <!---tab3----->
				 <div>
					 <div class="course_demo1">
							 <ul id="flexiselDemo3">	
								 <li class="g1">						
									 <img src="images/c1.jpg" alt="" />		
										<a href="single.html"><div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c2.jpg" alt="" />
									 <a href="single.html"><div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c3.jpg" alt="" />					
									 <a href="single.html"><div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c4.jpg" alt="" />					
									 <a href="single.html"><div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c1.jpg" alt="" />					
									 <a href="single.html"><div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
								 <li class="g1">						
									 <img src="images/c3.jpg" alt="" />					
									<a href="single.html"> <div class="caption">
										<span></span>
										<h3>PRODUCT NAME</h3>
										<h5>180.00 &euro;</h5>
										</div></a>
										<div class="clearfix"></div>
								 </li>
							 </ul>
						 </div>
						  <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
							<script type="text/javascript">
						 $(window).load(function() {
							$("#flexiselDemo3").flexisel({
								visibleItems: 4,
								animationSpeed: 1000,
								autoPlay: true,
								autoPlaySpeed: 3000,    		
								pauseOnHover: true,
								enableResponsiveBreakpoints: true,
								responsiveBreakpoints: { 
									portrait: { 
										changePoint:480,
										visibleItems: 1
									}, 
									landscape: { 
										changePoint:640,
										visibleItems: 2
									},
									tablet: { 
										changePoint:768,
										visibleItems: 3
									}
								}
							});
							
						 });
						  </script>
						<script type="text/javascript" src="js/jquery.flexisel.js"></script>
				 </div>
				 <!---//tab3----->
			 </div>
		 </div>
	 </div>
	 <div class="container">
		 <div class="navigation">
			 <ul>			 
				 <li><a href="sellitems.jsp">二手商店</a></li>
				 <li><a href="terms.jsp">条款须知</a></li>
				 <li><a href="release.jsp">发布平台</a></li>
				 <li><a href="about.jsp">关于</a></li>
				 <li><a href="jubao.jsp">违规举报</a></li>
			 </ul>
		 </div>
	 </div>
</div>
<!---->
</body>
</html>