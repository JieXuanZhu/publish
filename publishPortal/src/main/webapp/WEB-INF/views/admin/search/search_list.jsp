<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>关键热词列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="search_form"  action="<%=path %>/admin/search/getSearchWordsLs" method="post">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="<%=path %>/admin/search/toAddSearchWords">创建关键热词</a></span>
						<span class="action-span1">出版头条管理中心</span>
						<span class="action-span1 action-span2">-关键热词管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
					            关键热词名称
						<input name="name" type="text" value="${searchWords.name}"/>
						&nbsp; &nbsp;
						<%-- 特殊字符（替换关键热词汇）
						 <input name="special_character" type="text" value="${searchWords.special_character}"/> --%>
						<button type="submit" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>序号</th>
								<th>关键热词名称</th>
								<th>搜素次数</th>
								<th>优先级</th>
								<th>拼音首字母</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<c:forEach var="search" items="${page.list }" varStatus="searchStatus">
									<tr>
									    <td>${searchStatus.index+1 }</td>
										<td>${search.name }</td>
										<td>${search.hit_count}</td>
									    <td>${search.priority}</td>
									    <td>${search.name_initial}</td>
										<td><fmt:formatDate value="${search.create_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>
											<a href="<%=path %>/admin/search/toUpdateSearchWords?id=${search.id}" title="关键热词修改"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
											<a href="javascript:void(0);" title="删除" onclick="deleteSearchWords(${search.id})"><img src="<%=path %>/back/images/icon_trash.gif" /></a>
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
			
		   function deleteSearchWords(id){
	        	//询问框
				var index = layer.confirm('确定删除该关键热词吗？', {
					title: '删除关键热词',
				    btn: ['确定','取消'] //按钮
				}, function(){
					layer.close(index);
					del(id);
				}, function(){
				});
			}
			
			function del(id){
	       		$("#search_form").attr("action","<%=path %>/admin/search/delSearchWords?id="+id);
				$("#search_form").submit();
			}
	   </script>
	    <c:if test="${not empty msg }">
			   <script>
				   layer.alert('${msg}', function(index){
					    //do something
					    window.location.href="<%=path %>/admin/search/getSearchWordsLs";
					    layer.close(index);
					});             
			   </script>
		    </c:if> 
	</body>
</html>