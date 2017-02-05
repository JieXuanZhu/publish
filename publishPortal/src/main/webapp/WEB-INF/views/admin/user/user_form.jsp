<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title><c:if test="${type==1 }">创建</c:if><c:if test="${type==2 }">修改</c:if>管理员</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<div class="content_div">
				<h1>
					<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
					<span class="action-span1">东翌管理中心</span>
					<span class="action-span1 action-span2">-用户管理</span>
				</h1>
				<form action="<%=path %>/admin/user/editUser" method="post" onsubmit="return checkForm();">
					<input id="type" type="hidden" name="type" value="${type}">
                    <input type="hidden" name="id" value="${account.id }"/>
					<div class="main-div">
						<table>
							<c:if test="${type==1}">
								<tr>
									<td class="label">管理员账户名</td>
									<td><input id="name" name="name" type="text" class="input" /><span class="require-field">*</span></td>
								</tr>
								<tr>
									<td class="label">密码</td>
									<td><input name="password" id="password" type="password" class="input" /><span class="require-field">*</span></td>
								</tr>
								<tr>
									<td class="label">确认密码</td>
									<td><input name="surepwd" id="surepwd" type="password" class="input" /><span class="require-field">*</span></td>
								</tr>
								<tr>
								<td class="label">角色</td>
								<td>
					      		<c:forEach items="${requestScope.roleLs}" var="role" >
						      		<span class="power">
						      			<input id="roles" name="roles" value="${role.id }" type="checkbox" class="checkbox" />
						      			${role.name} 
						      		</span>
					      		</c:forEach>
								</td>
							</tr>
							</c:if>
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
		<script type="text/javascript">
			//检查form
			function checkForm() {
				var type = $("#type").val();
				var name = $("#name").val();
				var password = $("#password").val();
				var surepwd = $("#surepwd").val();
				if(type==1){
					if (isEmpty(name)) {
						layer.tips('管理员账户名不能为空！', '#name', {
						    tips: 2,
						    time:4000
						});
						return false;
					}
					if (isEmpty(password)) {
						layer.tips('密码不能为空！', '#password', {
						    tips: 2,
						    time:4000
						});
						return false;
					}
					if (isEmpty(surepwd)) {
						layer.tips('确认密码不能为空！', '#surepwd', {
						    tips: 2,
						    time:4000
						});
						return false;
					}
					if (password != surepwd) {
						layer.tips('2次密码输入不一致！', '#surepwd', {
						    tips: 2,
						    time:4000
						});
						return false;
					}
				}
			}
			
		</script>
		<c:if test="${not empty msg }">
		   <script>
			   layer.alert('${msg}',{icon: 6, closeBtn:2,title:'管理员管理'},function(index){
					layer.close(index);
				});
		   </script>
	    </c:if>
	</body>
</html>