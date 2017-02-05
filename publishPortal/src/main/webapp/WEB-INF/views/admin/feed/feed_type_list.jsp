<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>反馈类型列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="category_form"  action="<%=path %>/admin/feed/type/getBackFeedTypeLs" method="post">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="<%=path %>/admin/feed/type/toAddBackFeedType">创建反馈类型</a></span>
						<span class="action-span1">出版头条管理中心</span>
						<span class="action-span1 action-span2">-反馈类型管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
					            反馈类型名称
						<input name="feed_type_name" type="text" value="${backFeedType.feed_type_name}"/>
						<button type="submit" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>序号</th>
								<th>反馈类型名称</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<c:forEach var="type" items="${page.list }" varStatus="typeStatus">
									<tr>
									    <td>${typeStatus.index+1 }</td>
										<td>${type.feed_type_name }</td>
										<td><fmt:formatDate value="${type.create_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>
											<a href="<%=path %>/admin/feed/type/toUpdateBackFeedType?id=${type.id}" title="反馈类型修改"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
											<a href="javascript:void(0);" title="删除" onclick="deleteBackFeedType(${type.id})"><img src="<%=path %>/back/images/icon_trash.gif" /></a>
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
			
		   function deleteBackFeedType(id){
	        	//询问框
				var index = layer.confirm('确定删除该反馈类型吗？', {
					title: '删除反馈类型',
				    btn: ['确定','取消'] //按钮
				}, function(){
					layer.close(index);
					del(id);
				}, function(){
				});
			}
			
			function del(id){
	       		$("#category_form").attr("action","<%=path %>/admin/feed/type/delBackFeedType?id="+id);
				$("#category_form").submit();
			}
	   </script>
	   <c:if test="${not empty msg }">
		   <script>
			   layer.alert('${msg}', function(index){
				    //do something
				    window.location.href="<%=path %>/admin/feed/type/getBackFeedTypeLs";
				    layer.close(index);
				});             
		   </script>
	    </c:if> 
	</body>
</html>