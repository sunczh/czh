<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<!---->
<div class="registration-form">
	 <div class="container">
		 <h2>萌新注册</h2>
		 <div class="col-md-6 reg-form">
			 <div class="reg">
				 <p>欢迎注册，嘿嘿嘿！</p>
				 <p>请查看注册条款 <a href="terms.jsp">click here</a></p>
				 <form action="zhuce" method="post">
					 <ul>
						 <li class="text-info">用户名: </li>
						 <li><input type="text" value="" name="userid"></li>
					 </ul>
					 <ul>
						 <li class="text-info">真实姓名（保密）: </li>
						 <li><input type="text" value="" name="realname"></li>
					 </ul>				 
					<ul>
						 <li class="text-info">用户邮箱: </li>
						 <li><input type="text" value="" name="email"></li>
					 </ul>
					 <ul>
						 <li class="text-info">密码: </li>
						 <li><input type="password" value="" name="userpassword1"></li>
					 </ul>
					 <ul>
						 <li class="text-info">密码确认:</li>
						 <li><input type="password" value="" name="userpassword2"></li>
					 </ul>
					 <ul>
						 <li class="text-info">手机号码:</li>
						 <li><input type="text" value="" name="userphone"></li>
					 </ul>
					  <ul>
						 <li class="text-info">二级密码:</li>
						 <li><input type="password" value="" name="secondpassword"></li>
					 </ul>						
					 <input type="submit" value="现在注册！">
					 <p class="click">By clicking this button, you agree to my modern style <a href="terms.jsp">Pollicy Terms and Conditions</a> to Use</p> 
				 </form>
			 </div>
		 </div>
		 <div class="col-md-6 reg-right">
			 <h3>免责条款</h3>
			 <p>我们就是这么直接的告诉你这是一个不太正经的网站只是为了分享信息勾引一下年轻的小黑客所以密码被盗了请拨打妖妖灵</p>
			 <h3 class="lorem">注册须知</h3>
			 <p>把你的用户名和密码设置的BT一点，用户名不能少于4个字符或者超过20个字符<br>密码不能超过少于6个字符或者超过20个字<br>二级密码为8个数字不可出现其他字符</p>
		 </div>
		 <div class="clearfix"></div>
		 <div class="navigation">
			 <ul>
				<li><a href="about.jsp">关于</a></li>
				 <li><a href="#">库存</a></li>
				 <li><a href="#">地址确认</a></li>
				 <li><a href="#">二手商店</a></li>
				 <li><a href="terms.jsp">条款须知</a></li>
				 <li><a href="#">发布平台</a></li>
			 </ul>
		 </div>
	 </div>
</div>
</body>
</html>