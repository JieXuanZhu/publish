<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title><c:if test="${type==1 }">创建</c:if><c:if test="${type==2 }">修改</c:if>标签</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<div class="content_div">
				<h1>
					<span class="action-span">
					    <a href="javascript:void(0);" onclick="changeStatus(${label.is_valid});">
				            <c:choose>
								<c:when test="${label.is_valid==0 }">
									<img src="<%=path %>/back/images/yes.gif" />通过并展示
								</c:when>
								<c:when test="${label.is_valid==1 }">
									<img src="<%=path %>/back/images/no.gif" />结束展示
								</c:when>
							</c:choose>
						</a>
					</span>
					<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
					<span class="action-span1">出版头条管理中心</span>
					<span class="action-span1 action-span2">-创建标签</span>
				</h1>
				<form action="<%=path %>/admin/label/addOrUpdateLabel" method="post" onsubmit="return checkForm();">
                    <input id="label_id" type="hidden" name="label_id" value="${label.id }"/>
				<div class="main-div">
					<table>
						<tr>
							<td class="label">标签名称：</td>
							<td>${label.label_name }</td>
						</tr>
				    	<tr>
							<td class="label">父标签名称：</td>
							<td>${label.pName }</td>
						</tr>
						<tr>
							<td class="label">级别：</td>
							<td>${label.level}</td>
						</tr>
						<tr>
							<td class="label">创建时间：</td>
							<td><fmt:formatDate value="${label.create_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<tr>
							<td class="label">状态：</td>
							<td >
								<c:if test="${label.is_valid==0 }">
									待审核
			   					</c:if>
			   					<c:if test="${label.is_valid==1 }">
									审核通过
			   					</c:if>
			   					<c:if test="${label.is_valid==2 }">
									删除
			   					</c:if>
		   					</td>
	   					</tr>
					</table>
				</div>
				</form>
			</div>
		</div>
		<%@include file="/WEB-INF/views/admin/include_js.jsp" %>
		<script type="text/javascript">
			function changeStatus(status){
				var labelId=$("#label_id").val();
				$.ajax({
					type:'POST',
					url:'<%=path%>/admin/label/changeStatus',
					data:{
						"id":labelId,
						"status":Math.abs(parseInt(status)-1)
					},
					dataType:'json',
					success:function(data){
						if(data.success=='true'){
							layer.alert(data.message,{icon: 6, closeBtn:2,title:'标签管理',offset:'100px'},function(index){
								//window.location.reload();
								window.location.href="<%=path %>/admin/label/getLabelLs";
								layer.close(index);
							});
						}else if(data.success=='false'){
							layer.alert(data.message,{icon: 5, closeBtn:2,title:'标签管理',offset:'100px'});
						}
					},
					error: function(data) {
						var message = "";
						if( typeof(data) == "undefined" || data == null || data.message==null||data.message==''){
							message = "标签确认失败";
						}else {
							message = data.message;
						}
						layer.alert(message,{icon: 5, closeBtn:2,title:'标签管理',offset:'100px'});
	                }
				});
			}
		</script>
	</body>
</html>