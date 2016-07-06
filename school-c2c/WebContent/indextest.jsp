<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="myclass.dal.*,java.sql.*,myclass.bol.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试界面</title>
</head>
<body>
  <div id="showpicture"></div>
  <div>
    <form action="finishupload" method="post" enctype="multipart/form-data" name="form1">
           choose a image file
      <input type="file" name="file">
      <input type="submit" name="Submit" value="upload">
    </form>
  </div>
</body>
</html>