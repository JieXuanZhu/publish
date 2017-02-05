<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>新闻类型列表</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/back/css/reset.css">
		<link rel="stylesheet" type="text/css" href="<%=path %>/back/css/main.css">
		<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/front/images/favicon.ico" />
		<script>
			
			function deleteNewsType(id){
				//询问框
				var index = layer.confirm('删除该新闻类型,该类型对应的新闻资讯将同步删除,确定删除该新闻类型吗？', {
					title: '删除新闻类型',
				    btn: ['确定','取消'] //按钮
				}, function(){
					layer.close(index);
					del(id);
				}, function(){
				});
			}
			
			function del(id){
				$("#account_form").attr("action","<%=request.getContextPath() %>/admin/news/type/delNewsType?id="+id);
				$("#account_form").submit();
			}
	   </script>
	</head>
	<body>
		<div class="wrap">
			<%@ include file="/WEB-INF/views/admin/header.jsp"%>
			<%@ include file="/WEB-INF/views/admin/left.jsp"%>
			
			<div id="slider_content" class="content">
			<form id="account_form"  action="<%=path %>/admin/news/type/getNewsTypeLs" method="post">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="<%=path %>/admin/news/type/goAddType">创建新闻类型</a></span>
						<span class="action-span1">东翌管理中心</span>
						<span class="action-span1 action-span2">-新闻类型管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
					           新闻类型名称
						<input name="name" type="text"/>
						<button class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>序号</th>
								<th>新闻类型名称</th>
								<th>新闻类型编号</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<c:forEach var="type" items="${page.list }" varStatus="typeStatus">
									<tr>
									    <td>${typeStatus.index+1 }</td>
										<td>${type.name }</td>
										<td>${type.code }</td>
										<td><fmt:formatDate value="${type.create_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>
										<a href="<%=path %>/admin/news/type/toUpdateType?id=${type.id}" title="编辑"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
											<a href="javascript:void(0);" title="删除" onclick="deleteNewsType(${type.id})"><img src="<%=path %>/back/images/icon_trash.gif" /></a>
										</td>
									</tr>
								</c:forEach>
							</tr>
						</table>
					</div>
					<div class="right paging"><page:pageinfo pageinfo="${page}" /></div>
				</div>
			</form>
			<%@ include file="/WEB-INF/views/admin/footer.jsp"%>
			</div>
		</div>
	</body>
</html>