<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

 <div class="container" style="margin: 20px;">
<%
if (request.getAttribute("warning").equals("")||request.getAttribute("warning").equals(null)) {
	%>
	<p  style="font-family: 方正姚体;">没毛病！</p>
	<a href="index.jsp" style="font-family: 方正姚体;">点击返回</a>
	<% 
}
else{
%>
	<p  style="font-family: 方正姚体;">出错了！<%=request.getAttribute("warning") %></p>
	<br>
	<a href="<%=request.getAttribute("returnurl") %>" style="font-family: 方正姚体;">点击返回</a>
<%
}
%>
</div>
</body>
</html>