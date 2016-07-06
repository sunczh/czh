<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
记录修改<br>
<a href="javascript:history.go(-1)">返回列表</a>
<a href="index.jsp">返回主页</a>
<form action="update" method="post">
<input type="hidden" id="xx" name="id" value="${user.id}"><br>
姓名<input type="text" id="xx" name="userName" value="${user.userName}"><br>
密码<input type="text" id="xx" name="password" value="${user.password}"><br>
邮箱<input type="text" id="xx" name="email" value="${user.email}"><br>
<input type="submit" value="添加"><input type="reset" value="重置">
</form>
</body>
</html>