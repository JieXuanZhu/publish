<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>反馈信息分组</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<div class="content_div">
				<h1>
					<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
					<span class="action-span1">出版头条管理中心</span>
					<span class="action-span1 action-span2">-反馈信息分组</span>
				</h1>
				<form action="<%=path %>/admin/feed/updateBackFeedWithType" method="post">
				   <%--  <input type="hidden" name="springMVC.token" value="${TOKEN}"> --%>
                    <input type="hidden" name="id" value="${backFeed.id }"/>
                    <input type="hidden" name="type" value="${type }"/>
					<div class="main-div">
						<table>
						 <tr>
								<td class="label">分组名称：</td>
								<td>
									<select name="feed_type_id"  class="input">
									   <c:forEach items="${backFeedTypeLs }" var="type" varStatus="typeStatus">
											<option value="${type.id }" <c:if test="${type.id==backFeed.feed_type_id}">selected="selected"</c:if>>${type.feed_type_name }</option>
										</c:forEach>
									</select>
									<span class="require-field">*</span>如果没有合适的分组，请先去创建一个
					   			</td>
						   </tr>
						   <tr>
								<td class="label">反馈人：</td>
								<td>${backFeed.user_name}</td>
						   </tr>
						   <tr>
								<td class="label">联系方式：</td>
								<td>${backFeed.contact}</td>
						   </tr>
						   <tr>
								<td class="label">系统：</td>
								<td>${backFeed.system}</td>
						   </tr>
						   <tr>
								<td class="label">机型：</td>
								<td>${backFeed.model}</td>
						   </tr>
						   <tr>
								<td class="label">版本：</td>
								<td>${backFeed.version}</td>
						   </tr>
						   <tr>
								<td class="label">反馈时间：</td>
								<td><fmt:formatDate value="${backFeed.create_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						   </tr>
						   <tr>
								<td class="label">状态：</td>
								<td>
								    <c:if test="${backFeed.is_valid==0 }">
										未分组
				   					</c:if>
				   					<c:if test="${backFeed.is_valid==1 }">
				   						已分组
				   					</c:if>
				   					<c:if test="${backFeed.is_valid==2 }">
										已提取
				   					</c:if>
				   					<c:if test="${backFeed.is_valid==3 }">
										已处理
				   					</c:if>
					   			</td>
						   </tr>
						   <tr>
								<td class="label">内容：</td>
								<td>
									<textarea class="input-textarea">${backFeed.content }</textarea>
								</td>
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