<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>管理员列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="user_form"  action="<%=path %>/admin/user/getUserLs" method="post">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="<%=path %>/admin/user/toAddUser">创建用户</a></span>
						<span class="action-span1">出版头条管理中心</span>
						<span class="action-span1 action-span2">-用户管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
					            管理员账户名
						<input name="name" type="text" value="${user.name }"/>
						<button type="submit" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>序号</th>
								<th>管理员账户名</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<c:forEach var="user" items="${page.list }" varStatus="userStatus">
									<tr>
									    <td>${userStatus.index+1 }</td>
										<td>${user.name }</td>
										<td><fmt:formatDate value="${user.create_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>
											<a href="<%=path %>/admin/user/toEditUser?id=${user.id}" title="角色修改"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
											<a href="javascript:void(0);" title="删除" onclick="deleteUser(${user.id})"><img src="<%=path %>/back/images/icon_trash.gif" /></a>
											<a href="<%=path %>/admin/user/goSetPassword?id=${user.id}" title="重置密码"><img src="<%=path %>/back/images/icon_priv.gif" /></a>
										</td>
									</tr>
								</c:forEach>
							</tr>
						</table>
					</div>
					<div class="right paging"><page:pageinfo pageinfo="${page}" /></div>
				</div>
			</form>
		</div>
		<%@include file="/WEB-INF/views/admin/include_js.jsp" %>
		<script>
			
			function deleteUser(id){
				//询问框
				var index = layer.confirm('确定删除该管理员吗？', {
					title: '删除管理员',
				    btn: ['确定','取消'] //按钮
				}, function(){
					layer.close(index);
					del(id);
				}, function(){
				});
			}
			
			function del(id){
				$("#user_form").attr("action","<%=request.getContextPath() %>/admin/user/delUser?id="+id);
				$("#user_form").submit();
			}
	   </script>
	     <c:if test="${not empty msg }">
			   <script>
				   layer.alert('${msg}', function(index){
					    //do something
					    window.location.href="<%=path %>/admin/user/getUserLs";
					    layer.close(index);
					});             
			   </script>
		    </c:if> 
	</body>
</html>