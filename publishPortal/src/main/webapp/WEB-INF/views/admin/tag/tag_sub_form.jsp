<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>创建子标签</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<div class="content_div">
				<h1>
					<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
					<span class="action-span1">出版头条管理中心</span>
					<span class="action-span1 action-span2">-创建子标签</span>
				</h1>
				<form action="<%=path %>/admin/label/addSubLabel" method="post" onsubmit="return checkForm();">
				   <input type="hidden" name="springMVC.token" value="${TOKEN}">
                   <input type="hidden" name="pId" value="${label.id}"/>
				<div class="main-div">
					<table>
					    <tr>
							<td class="label">父级标签名称：</td>
							<td>${label.label_name }</td>
						</tr>
						<tr>
							<td class="label">子标签名称：</td>
							<td><input id="label_name" name="label_name"  type="text"  class="input" /><span class="require-field">*</span></td>
						</tr>
						<tr>
						    <td class="label">
							   	 &nbsp;
							</td>
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
				
				var label_name = $("#label_name").val();
				if(isEmpty(label_name)){
					layer.tips('子标签名称不能为空！', '#label_name', {
					    tips: 2,
					    time:4000
					});
					return false;
				}
				return true;
			}
		</script>
		<c:if test="${not empty msg }">
			   <script>
				   layer.alert('${msg}', function(index){
					    //do something
					    window.location.href="<%=path %>/admin/label/getLabelLs";
					    layer.close(index);
					});             
			   </script>
		    </c:if> 
	</body>
</html>