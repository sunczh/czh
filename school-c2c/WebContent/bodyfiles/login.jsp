<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="login">
	 <div class="container">
		 <h2>用户登录</h2>
		 <div class="col-md-6 log">			 
				 <p>欢迎您，请输入你的密码 </p>
				 <form action="denglu" method="post">
					 <h5>User Name:</h5>	
					 <input type="text" value="" name="username">
					 <h5>Password:</h5>
					 <input type="password" value="" name="password">					
					 <input type="submit" value="Login">
					  <a href="#">Forgot Password ?</a>
				 </form>				 
		 </div>
		  <div class="col-md-6 login-right">
			  	<h3>NEW REGISTRATION</h3>
				<p>创建一个账号，您就可以享受到贵宾级的待遇，包括寄售您的小商品，以及对别的商品进行评论</p>
				<a class="acount-btn" href="zhuce.jsp">Create an Account</a>
		 </div>
		 <div class="clearfix"></div>
		 
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
</body>
</html>