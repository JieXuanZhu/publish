<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>数据列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="data_form"  action="<%=path %>/admin/data/getDataLs" method="post">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="<%=path %>/admin/data/toAddData">创建数据</a></span>
						<span class="action-span1">出版头条管理中心</span>
						<span class="action-span1 action-span2">-数据管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
					            数据名称
						<input name="title" type="text" value="${data.title}"/>
						<button type="submit" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>序号</th>
								<th>数据来源</th>
								<th>数据名称</th>
								<th>抓取时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<c:forEach var="data" items="${page.list }" varStatus="dataStatus">
									<tr>
									    <td>${dataStatus.index+1 }</td>
										<td>${data.category_name }</td>
										<td>${data.title }</td>
										<td><fmt:formatDate value="${data.capture_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>
											<a href="<%=path %>/admin/data/toUpdateData?id=${data.id}" title="数据修改"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
											<a href="javascript:void(0);" title="删除" onclick="deleteData(${data.id})"><img src="<%=path %>/back/images/icon_trash.gif" /></a>
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
			
		   function deleteData(id){
	        	//询问框
				var index = layer.confirm('确定删除该数据吗？', {
					title: '删除数据',
				    btn: ['确定','取消'] //按钮
				}, function(){
					layer.close(index);
					del(id);
				}, function(){
				});
			}
			
			function del(id){
	       		$("#data_form").attr("action","<%=path %>/admin/data/delData?id="+id);
				$("#data_form").submit();
			}
	   </script>
	   <c:if test="${not empty msg }">
		   <script>
			   layer.alert('${msg}', function(index){
				    //do something
				    window.location.href="<%=path %>/admin/data/getDataLs";
				    layer.close(index);
				});             
		   </script>
	    </c:if> 
	</body>
</html>