<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<table border="1">
  <c:forEach items="${list}" var="s">
    <tr>
      <td><c:out value="${s.userName}"></c:out></td>
      <td><c:out value="${s.password}"></c:out></td>
      <td><c:out value="${s.email}"></c:out></td>
      <td><a href="user_detail?id=${s.id}">记录详情</a></td>
      <td><a href="user_update?id=${s.id}">修改信息</a></td>
      <td><a href="user_del?id=${s.id}">删除记录</a></td>
    </tr><br>
  </c:forEach>
</table>
<a href="index.jsp">返回主页</a>
</body>
</html>