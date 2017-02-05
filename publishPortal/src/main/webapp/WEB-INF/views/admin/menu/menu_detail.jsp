<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>菜单详情</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div  id="slider_content" class="content">
			<div class="content_div">
				<h1>
				<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
					<span class="action-span1">出版头条管理中心</span>
					<span class="action-span1 action-span2">-菜单详情</span>
				</h1>
				<div class="main-div">
					<table>
					   <tr>
							<td class="label">父级菜单名称</td>
							<td>${menu.pName }</td>
						</tr>
						<tr>
							<td class="label">菜单名称</td>
							<td>${menu.menu_name }</td>
						</tr>
						<tr>
							<td class="label">菜单url</td>
							<td>${menu.url }</td>
						</tr>
					    <tr>
							<td class="label">创建时间</td>
							<td><fmt:formatDate value="${menu.create_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>