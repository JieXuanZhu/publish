<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title><c:if test="${type==1 }">创建</c:if><c:if test="${type==2 }">修改</c:if>新闻类型</title>
	    <link rel="stylesheet" type="text/css" href="<%=path %>/back/css/reset.css">
		<link rel="stylesheet" type="text/css" href="<%=path %>/back/css/main.css">
		<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/front/images/favicon.ico" />
	</head>
	<body>
		<div class="wrap">
			<%@ include file="/WEB-INF/views/admin/header.jsp"%>
			<%@ include file="/WEB-INF/views/admin/left.jsp"%>
			
			<div id="slider_content" class="content">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
						<span class="action-span1">东翌管理中心</span>
						<span class="action-span1 action-span2">-新闻类型管理</span>
					</h1>
					<form action="<%=path %>/admin/news/type/addOrUpdateType" method="post" onsubmit="return checkForm();">
						<input id="type" type="hidden" name="type" value="${type}">
	                    <input type="hidden" name="id" value="${newsType.id }"/>
						<div class="main-div">
							<table>
								<tr>
									<td class="label">新闻类型名称</td>
									<td><input id="name" name="name" type="text" class="input" value="${newsType.name }" /><span class="require-field">*</span></td>
								</tr>
								<tr>
									<td class="label">新闻类型编号</td>
									<td><input id="code" name="code" type="text" class="input" value="${newsType.code }" /><span class="require-field">*</span></td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<button class="btn" type="submit">确定</button>
										<button class="btn" type="button" onclick="history.go(-1);">取消</button>
									</td>
								</tr>
							</table>
						</div>
					</form>
				</div>
				<%@ include file="/WEB-INF/views/admin/footer.jsp"%>
			</div>
		</div>
		<script type="text/javascript">
			//检查form
			function checkForm() {
				var name = $("#name").val();
				var code = $("#code").val();
				if (isEmpty(name)) {
					layer.tips('新闻类型名称不能为空！', '#name', {
					    tips: 2,
					    time:4000
					});
					return false;
				}
				if (isEmpty(code)) {
					layer.tips('新闻类型编号不能为空！', '#code', {
					    tips: 2,
					    time:4000
					});
					return false;
				}
			}
			
		</script>
	</body>
</html>