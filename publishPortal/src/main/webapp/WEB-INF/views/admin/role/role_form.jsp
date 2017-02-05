<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title><c:if test="${type==1 }">创建</c:if><c:if test="${type==2 }">修改</c:if>角色</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<div class="content_div">
				<h1>
					<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
					<span class="action-span1">出版头条管理中心</span>
					<span class="action-span1 action-span2">-角色管理</span>
				</h1>
				<form action="<%=path %>/admin/role/addOrUpdateRole" method="post" onsubmit="return checkForm();">
					<input type="hidden" name="springMVC.token" value="${TOKEN}">
					<input type="hidden" name="type" value="${type}">
                    <input type="hidden" name="id" value="${role.id }"/>
					<div class="main-div">
						<table>
							<tr>
								<td class="label">角色名称</td>
								<td><input id="name" name="name" type="text" class="input" value="${role.name }" /><span class="require-field">*</span></td>
							</tr>
							<tr>
								<td class="label">角色描述</td>
								<td><input id="description" name="description" type="text" class="input" value="${role.description }" /><span class="require-field">*</span></td>
							</tr>
							<tr>
							     <td class="label">&nbsp;</td>
								<td>
									<button class="btn" type="submit">确定</button>
									<button class="btn" type="button" onclick="history.go(-1);" >取消</button>
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
			function checkForm(){
				
				var name = $("#name").val();
				var description = $("#description").val();
				if(isEmpty(name)){
					layer.tips('角色名称不能为空！', '#name', {
					    tips: 2,
					    time:4000
					});
					return false;
				}
				if(isEmpty(description)){
					layer.tips('角色描述不能为空！', '#description', {
					    tips: 2,
					    time:4000
					});
					return false;
				}
			}
		</script>
		<c:if test="${not empty msg }">
		   <script>
			   layer.alert('${msg}', function(index){
				    //do something
				    window.location.href="<%=path %>/admin/user/getUserLs";
				    layer.close(index);
				});             
		   </script>
		</c:if> 
	</body>
</html>