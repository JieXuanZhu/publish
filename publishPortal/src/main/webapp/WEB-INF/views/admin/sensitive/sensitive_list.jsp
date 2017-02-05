<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>敏感词列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="sensitive_form"  action="<%=path %>/admin/sensitive/getSensitiveLs" method="post">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="<%=path %>/admin/sensitive/toAddSensitiveWords">创建敏感词</a></span>
						<span class="action-span1">出版头条管理中心</span>
						<span class="action-span1 action-span2">-敏感词管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
					            敏感词名称
						<input name="words" type="text" value="${sensitiveWords.words}"/>
						&nbsp; &nbsp;
						<%--  特殊字符（替换敏感词汇）
						<input name="special_character" type="text" value="${sensitiveWords.special_character}"/> --%>
						<button type="submit" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>序号</th>
								<th>敏感词名称</th>
								<!-- <th>特殊字符（替换敏感词汇）</th> -->
								<th>创建时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<c:forEach var="sensitive" items="${page.list }" varStatus="sensitiveStatus">
									<tr>
									    <td>${sensitiveStatus.index+1 }</td>
										<td>${sensitive.words }</td>
										<%-- <td>${sensitive.special_character}</td> --%>
										<td><fmt:formatDate value="${sensitive.create_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>
											<a href="<%=path %>/admin/sensitive/toUpdateSensitiveWords?id=${sensitive.id}" title="敏感词修改"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
											<a href="javascript:void(0);" title="删除" onclick="deleteSensitive(${sensitive.id})"><img src="<%=path %>/back/images/icon_trash.gif" /></a>
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
			
		   function deleteSensitive(id){
	        	//询问框
				var index = layer.confirm('确定删除该敏感词吗？', {
					title: '删除敏感词',
				    btn: ['确定','取消'] //按钮
				}, function(){
					layer.close(index);
					del(id);
				}, function(){
				});
			}
			
			function del(id){
	       		$("#sensitive_form").attr("action","<%=path %>/admin/sensitive/delSensitiveWords?id="+id);
				$("#sensitive_form").submit();
			}
	   </script>
	    <c:if test="${not empty msg }">
			   <script>
				   layer.alert('${msg}', function(index){
					    //do something
					    window.location.href="<%=path %>/admin/sensitive/getSensitiveLs";
					    layer.close(index);
					});             
			   </script>
		    </c:if> 
	</body>
</html>