<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<div class="contact">
	 <div class="container">		 
		 <div class="contact-head">		
				<h2>CONTACT US</h2>			 
				<p style="font-family: 方正姚体;font-size:18px;">请如实描述您所要寄售的商品，共同打造真诚的校园购物平台！（认真脸）</p>
		 </div>
		 <div class="col-md-8 contact-left">
			 <form class="contact-details" action="fabu" method="post">
					 <input type="text" name="wpmc" class="text" value="物品名称" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '物品名称';}">
					 <input type="text" name="xjcd" class="text" value="新旧程度" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '新旧程度';}">
					 <input type="text" name="jg" class="text" value="价格" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '价格';}">
					 <input type="text" name="lxfs" class="text" value="联系方式（手机或者QQ）" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '联系方式（手机或者QQ）';}">
					<div class="form-group" style="width: 120px;">
						<select class="form-control" name="wpzl">
							<option>生活用品</option>
							<option>学习文具</option>
							<option>衣物</option>
							<option>学习资料</option>
							<option>闲置数码</option>
							<option>鞋包</option>
							<option>贵重物品</option>
							<option>其它分类</option>
						</select>
						请选择要上传的文件<input type="file" name="upfile" size="50">
					</div>
					<textarea name="discription"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '物品介绍';}" >物品介绍</textarea>	
					 <div class="clearfix"></div>
					 <input type="submit" value="确认发布">
			 </form>
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