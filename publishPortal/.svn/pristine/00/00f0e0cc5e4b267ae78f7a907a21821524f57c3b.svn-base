<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath%>">
     <title>上传文件</title>
	 <meta http-equiv="pragma" content="no-cache">
	 <meta http-equiv="cache-control" content="no-cache">
	 <meta http-equiv="expires" content="0">   
	 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	 <meta http-equiv="description" content="This is my page">
  </head>

  <body>
    <form name="upload" action="<%=path %>/file/uploads" method="post" enctype="multipart/form-data">
    <%--  <img src="<%=path %>/upload/20151216111757_head_197344.jpg"/> --%>
     <table align="center">
      <tr><td align="center">上传文件</td></tr>
      <tr><td><input type="text" name="title"></td></tr>
      <tr><td><textarea name="content"></textarea></td></tr>
      <tr><td><input type="file" name="file"></td></tr>
      <tr><td><input type="file" name="file"></td></tr>
      <tr><td><input type="file" name="file"></td></tr>
      <tr><td><input type="submit" name="go" value="提交"></td></tr>
     </table>
    </form>
  </body>
</html>