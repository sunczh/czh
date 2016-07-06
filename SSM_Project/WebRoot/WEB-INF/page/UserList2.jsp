<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
 <s:set var="pageModel" value="#request.pageModel"/>    
<s:iterator var="user" value="#pageModel.dataList"> 
<tr>    
  <td width="200" height="35" align="center"><s:property value="#user.id"/></td>    
  <td height="35" align="center"><s:property value="#user.userName"/></td>    
  <td height="35" align="center"><s:property value="#user.password"/></td>    
  <td height="35" align="center"><s:property value="#user.email"/></td>    
</tr>    
</s:iterator>    
<tr>    
  <td width="200" height="35" align="center"><a href="book_showMainPage">首页</a></td>    
  <td height="35" colspan="5" align="center"><a><s:property value="#request.currentPage"/></a>/<a><s:property value="#request.totalPage"/></a>       
    <a href="borrow_showBorrowPage?page=<s:property value='#pageModel.first'/>">首页</a>    
    <a href="borrow_showBorrowPage?page=<s:property value='#pageModel.previous'/>">上一页</a>    
    <a href="borrow_showBorrowPage?page=<s:property value='#pageModel.next'/>">下一页</a>    
    <a href="borrow_showBorrowPage?page=<s:property value='#pageModel.last'/>">尾页</a>    
  <td height="35" align="center" ><a onclick="saveAsExcel(table1)">导出Excel</a></td>    
  <td height="35" align="center" ><a onclick="javascript:window.print();">打印</a></td>    
</tr> 
	</table>
</body>
</html>