<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>标签列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="label_form"  action="<%=path %>/admin/tag/getTagLs" method="post">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="<%=path %>/admin/tag/toAddTag">创建标签</a></span>
						<span class="action-span1">管理中心</span>
						<span class="action-span1 action-span2">-标签管理</span>
					</h1>
					<div class="form_div">
						<%-- <img src="<%=path %>/back/images/icon_search.gif" />
					            标签名称
						<button type="submit" class="search_btn">搜索</button> --%>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>序号</th>
								<th>标签名</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<c:forEach var="tag" items="${page.list }" varStatus="tagStatus">
									<tr>
									    <td>${tagStatus.index+1 }</td>
										<td>${tag.tagName }</td>
										<td><fmt:formatDate value="${tag.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>
										    <a href="<%=path %>/admin/tag/viewTag?id=${tag.tagId}" title="预览审核"><img src="<%=path %>/back/images/icon_view.gif" /></a>
											<a href="<%=path %>/admin/tag/toUpdateTag?id=${tag.tagId}" title="标签修改"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
											<a href="javascript:void(0);" title="删除" onclick="deleteTag(${tag.tagId})"><img src="<%=path %>/back/images/icon_trash.gif" /></a>
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
			
		   function deleteTag(id){
	        	//询问框
				var index = layer.confirm('确定删除该标签吗？', {
					title: '删除标签',
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
				        url:'<%=path %>/admin/tag/delTag?id='+id,
				        async: false,// 设置同步方式
				        error: function(request) {
				        	layer.msg('程序异常！', {icon: 2});
				        },
				        success: function(data) {
				        	if(data.success=='true'){
				        		layer.alert(data.message,function(index){
				        			window.location.reload();
				        			layer.close(index);
				        		});
				        	}else if(data.success=='false'){
				        		layer.msg(data.success);
				        	}
				        }
			 		});
			}
	   </script>
	    <c:if test="${not empty msg }">
			   <script>
				   layer.alert('${msg}', function(index){
					    //do something
					    window.location.href="<%=path %>/admin/tag/getTagLs";
					    layer.close(index);
					});             
			   </script>
		    </c:if> 
	</body>
</html>