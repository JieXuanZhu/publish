<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>会员列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="cust_form"  action="<%=path %>/admin/cust/getCustLs" method="post">
				<div class="content_div">
					<h1>
						<!-- <span class="action-span">&nbsp;</span> -->
						<span class="action-span1">出版头条管理中心</span>
						<span class="action-span1 action-span2">-会员管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
					            会员用户名
						<input name="user_name" type="text" value="${cust.user_name }"/>
						&nbsp;&nbsp;
						昵称
						<input name="nick_name" type="text" value="${cust.nick_name }"/>
						<button type="submit" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>序号</th>
								<th>会员用户名</th>
								<th>昵称</th>
								<th>等级</th>
								<th>状态</th>
								<th>最近的登录时间</th>
								<th>注册时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<c:forEach var="cust" items="${page.list }" varStatus="custStatus">
									<tr>
									    <td>${custStatus.index+1 }</td>
										<td>${cust.user_name }</td>
										<td>${cust.nick_name }</td>
										<td>${cust.level_name }</td>
										<td>
											<c:if test="${cust.is_valid==0 }">
												正常
						   					</c:if>
						   					<c:if test="${cust.is_valid==1 }">
												失效
						   					</c:if>
						   					<c:if test="${cust.is_valid==2 }">
												删除
						   					</c:if>
										</td>
										<td><fmt:formatDate value="${cust.last_login_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td><fmt:formatDate value="${cust.create_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>
											<a href="<%=path %>/admin/cust/toUpdateCust?id=${cust.id}" title="会员修改"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
											<c:if test="${cust.is_valid!=2 }"><a href="javascript:void(0);" title="删除会员" onclick="deleteCust(${cust.id})"><img src="<%=path %>/back/images/icon_trash.gif" /></a></c:if>
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
			
			function deleteCust(id){
				//询问框
				var index = layer.confirm('确定删除该会员吗？', {
					title: '删除会员',
				    btn: ['确定','取消'] //按钮
				}, function(){
					layer.close(index);
					del(id);
				}, function(){
				});
			}
			
			function del(id){
				$("#cust_form").attr("action","<%=request.getContextPath() %>/admin/cust/delCust?id="+id);
				$("#cust_form").submit();
			}
	   </script>
       <c:if test="${not empty msg }">
		   <script>
			   layer.alert('${msg}', function(index){
				    //do something
				    window.location.href="<%=path %>/admin/cust/getCustLs";
				    layer.close(index);
				});             
		   </script>
	    </c:if> 
	</body>
</html>