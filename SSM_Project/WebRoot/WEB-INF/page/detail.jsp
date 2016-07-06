<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
姓名：<span>${user.userName}</span><br>
密码：<span>${user.password}</span><br>
邮箱：<span>${user.email}</span><br>
<a href="javascript:history.go(-1)">返回列表</a>
<a href="index.jsp">返回主页</a>
</body>
</html>