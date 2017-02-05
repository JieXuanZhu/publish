<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!DOCTYPE>
<html>
	<head>
		<meta charset="utf-8">
		<title>天梯头条后台管理系统</title>
		<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/back/images/favicon.ico" />
	</head>
	<frameset name="index" rows="83,*" cols="*" frameborder="no" border="0" scrolling="yes">
		<frame id="header"  name="header" src="<%=path%>/admin/header"  scrolling="no" noresize="noresize" />
		<frameset id="body"  name="body" rows="*" cols="165,*" frameborder="no" border="0" scrolling="yes">
			<frame id="left"  name="left" src="<%=path %>/admin/left"  scrolling="yes" noresize="noresize" style="border-right: 1px solid #ccc;"/>
			<frameset rows="*,50" cols="*" frameborder="no" border="0">
				<frame id="main"  name="main" src="<%=path %>/admin/welcome" scrolling="yes" noresize="noresize"    />
				<frame id="footer"  name="footer" src="<%=path%>/admin/footer"  scrolling="no" noresize="noresize" />
			</frameset>
		</frameset>
	</frameset>
</html>