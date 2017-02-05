<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>菜单列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="menu_form"  action="<%=path %>/admin/menu/getMenuLs" method="post">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="<%=path %>/admin/menu/toAddMenu">创建菜单</a></span>
						<span class="action-span1">出版头条管理中心</span>
						<span class="action-span1 action-span2">-菜单列表</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
						菜单名称
						<input name="menu_name" type="text" value="${menu.menu_name}"/>
						&nbsp; &nbsp;
						父菜单名称
						<input name="pName" type="text" value="${menu.pName}"/>
						<button type="submit" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>序号</th>
								<th>名称</th>
								<th>父菜单名称</th>
								<th>url</th>
								<th>操作</th>
							</tr>
							<c:forEach var="menu" items="${page.list }" varStatus="menuStatus">
								<tr>
									<td>${menuStatus.index+1}</td>
									<td>${menu.menu_name}</td>
									<td>${menu.pName}</td>
									<td>${menu.url}</td>
									<td>
										<a href="<%=path %>/admin/menu/viewMenu?id=${menu.id}" title="查看"><img src="<%=path %>/back/images/icon_view.gif" /></a>
										<a href="<%=path %>/admin/menu/toUpdateMenu?id=${menu.id}" title="编辑"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
										<a href="javascript:void(0);" title="删除" onclick="deleteMenu(${menu.id})"><img src="<%=path %>/back/images/icon_trash.gif" /></a>
										<a href="<%=path %>/admin/menu/toAddSubMenu?id=${menu.id}" title="创建子菜单"><img src="<%=path %>/back/images/icon_add.gif" /></a>
									</td>
								</tr>
							</c:forEach>
						</table>
						</div>
						<div class="right paging"><page:pageinfo pageinfo="${page}" /></div>
					</div>
					</form>
			</div>
		</div>
		<%@include file="/WEB-INF/views/admin/include_js.jsp" %>
		<script>
			
			function deleteMenu(id){
	        	//询问框
				var index = layer.confirm('确定删除该菜单吗？', {
					title: '删除菜单',
				    btn: ['确定','取消'] //按钮
				}, function(){
					layer.close(index);
					del(id);
				}, function(){
				});
			}
			
			function del(id){
					$.ajax({
				        type: "POST",
				        url:'<%=path %>/admin/menu/canDelMenu?id='+id,
				        async: false,// 设置同步方式
				        error: function(request) {
				        	layer.msg('程序异常！', {icon: 2});
				        },
				        success: function(data) {
				        	if(data.result==0){
				        		$("#menu_form").attr("action","<%=path %>/admin/menu/delMenu?id="+id);
								$("#menu_form").submit();
				        	}else if(data.result==1){
				        		layer.msg('还有角色在使用该菜单，不能删除！', {icon: 2});
				        	}else if(data.result==2){
				        		layer.msg('还有子菜单在使用，不能删除！', {icon: 2});
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
				    window.location.href="<%=path %>/admin/menu/getMenuLs";
				    layer.close(index);
				});             
		   </script>
		</c:if> 
	</body>
</html>