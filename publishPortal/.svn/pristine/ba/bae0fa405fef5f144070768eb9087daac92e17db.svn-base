<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>修改会员</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<div class="content_div">
				<h1>
					<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
					<span class="action-span1">出版头条管理中心</span>
					<span class="action-span1 action-span2">-会员管理</span>
				</h1>
				<form action="<%=path %>/admin/cust/updateCust" method="post">
				    <input type="hidden" name="springMVC.token" value="${TOKEN}">
                    <input type="hidden" name="id" value="${cust.id }"/>
					<div class="main-div">
						<table>
						   <tr>
								<td class="label">会员用户名</td>
								<td>${cust.user_name}</td>
						   </tr>
						   <tr>
								<td class="label">昵称</td>
								<td>${cust.nick_name}</td>
						   </tr>
						   <tr>
								<td class="label">等级</td>
								<td>${cust.level_name }</td>
						   </tr>
						   <tr>
								<td class="label">状态</td>
								<td>
								<select name="is_valid"  class="input">
								    <c:if test="${cust.is_valid==0 }">
										<option value="0">正常</option>
										<option value="1">失效</option>
				   					</c:if>
				   					<c:if test="${cust.is_valid==1 }">
				   						<option value="1">失效</option>
										<option value="0">正常</option>
				   					</c:if>
				   					<c:if test="${cust.is_valid==2 }">
										<option value="0">正常</option>
										<option value="1">失效</option>
				   					</c:if>
								</select>
					   			</td>
						   </tr>
						   <tr>
								<td class="label">会员等级</td>
								<td>
									<select name="level_id" class="input">
										<c:forEach items="${levelLs }" var="level" varStatus="levelStatus">
											<option value="${level.id }" <c:if test="${level.id==cust.level_id}">selected="selected"</c:if>>${level.level_name }</option>
										</c:forEach>
									</select>
								</td>
						   </tr>
						   <tr>
								<td class="label">最近的登录时间</td>
								<td><fmt:formatDate value="${cust.last_login_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						   </tr>
						   <tr>
								<td class="label">注册时间</td>
								<td><fmt:formatDate value="${cust.create_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						   </tr>
						   <tr>
							    <td class="label">
							   	 &nbsp;
							    </td>
								<td>
									<button class="btn" type="submit">确定</button>
									<button class="btn" type="button" onclick="history.go(-1);">取消</button>
								</td>
						   </tr>
						</table>
					</div>
				</form>
			</div>
		</div>
		<%@include file="/WEB-INF/views/admin/include_js.jsp" %>
		<c:if test="${not empty msg }">
		   <script>
			   layer.alert('${msg}',{icon: 6, closeBtn:2,title:'会员管理'},function(index){
					layer.close(index);
				});
		   </script>
	    </c:if>
	</body>
</html>