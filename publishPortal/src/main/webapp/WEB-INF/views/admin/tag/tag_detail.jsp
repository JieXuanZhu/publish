<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>查看标签</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<div class="content_div">
				<h1>
					<%-- <span class="action-span">
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
					</span> --%>
					<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
					<span class="action-span1">管理中心</span>
					<span class="action-span1 action-span2">-查看标签</span>
				</h1>
				<form action="" method="post" onsubmit="return checkForm();">
                    <input id="label_id" type="hidden" name="tagId" value="${tag.tagId}"/>
				<div class="main-div">
					<table>
						<tr>
							<td class="label">标签名称：</td>
							<td>${tag.tagName }</td>
						</tr>
						<tr>
							<td class="label">创建时间：</td>
							<td><fmt:formatDate value="${tag.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
					</table>
				</div>
				</form>
			</div>
		</div>
		<%@include file="/WEB-INF/views/admin/include_js.jsp" %>
	</body>
</html>