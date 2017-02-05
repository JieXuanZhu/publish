<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>角色列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="role_form"  action="<%=path %>/admin/role/getRoleLs" method="post">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="<%=path %>/admin/role/toAddRole">创建角色</a></span>
						<span class="action-span1">出版头条管理中心</span>
						<span class="action-span1 action-span2">-角色列表</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
					   	 角色名称
						<input name="name" type="text" value="${role.name }"/>
						<button type="submit" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>角色</th>
								<th>角色描述</th>
								<th>操作</th>
							</tr>
							<c:forEach var="role" items="${page.list }" varStatus="roleStatus">
								<tr>
									<td>${role.name }</td>
									<td>${role.description }</td>
									<td>
										<a href="<%=path %>/admin/role/toUpdateRole?id=${role.id}" title="编辑"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
										<a href="javascript:void(0);" title="删除" onclick="deleteRole(${role.id})"><img src="<%=path %>/back/images/icon_trash.gif" /></a>
										<a href="<%=path %>/admin/role/goSetMenu?id=${role.id}" title="设置权限"><img src="<%=path %>/back/images/icon_priv.gif" /></a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="right paging"><page:pageinfo pageinfo="${page}" /></div>
				</div>
			</form>
		</div>
		<%@include file="/WEB-INF/views/admin/include_js.jsp" %>
		<script type="text/javascript">
			function deleteRole(id){
				//询问框
				var index = layer.confirm('确定删除该角色？', {
					title: '删除角色',
				    btn: ['确定','取消'] //按钮
				}, function(){
					layer.close(index);
					del(id);
				    //layer.msg('的确很重要', {icon: 1});
				}, function(){
				   // layer.msg('奇葩么么哒', {shift: 6});
				});
			}
			
			function del(id){
					$.ajax({
				        type: "POST",
				        url:'<%=request.getContextPath() %>/admin/role/canDelRole?id='+id,
				        async: false,// 设置同步方式
				        error: function(request) {
				        	layer.msg('程序异常！', {icon: 2});
				        },
				        success: function(data) {
				        	if(data.result==0){
				        		$("#role_form").attr("action","<%=request.getContextPath() %>/admin/role/delRole?id="+id);
								$("#role_form").submit();
				        	}else if(data.result==1){
				        		layer.msg('有用户还在该角色下，不能删除！', {icon: 2});
				        	}else{
				        		layer.msg('id不能为空！', {icon: 2});
				        	}
				        }
			 		});
			}
		</script>
		<c:if test="${not empty msg }">
		   <script>
			   layer.alert('${msg}', function(index){
				    //do something
				    window.location.href="<%=path %>/admin/role/getRoleLs";
				    layer.close(index);
				});             
		   </script>
		</c:if> 
	</body>
</html>