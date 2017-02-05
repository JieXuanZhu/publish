<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title><c:if test="${type==1 }">创建</c:if><c:if test="${type==2 }">修改</c:if>数据来源</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<div class="content_div">
				<h1>
					<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
					<span class="action-span1">出版头条管理中心</span>
					<span class="action-span1 action-span2">-创建数据来源</span>
				</h1>
				<form action="<%=path %>/admin/category/addOrUpdateDataCategory" method="post" onsubmit="return checkForm();">
					<input type="hidden" name="springMVC.token" value="${TOKEN}">
					<input type="hidden" name="type" value="${type}">
                    <input type="hidden" name="id" value="${dataCategory.id }"/>
				<div class="main-div">
					<table>
				    	
						<tr>
							<td class="label">数据来源名称：</td>
							<td><input id="category_name" name="category_name"  type="text" value="${dataCategory.category_name }" class="input" /><span class="require-field">*</span></td>
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
				
				var category_name = $("#category_name").val();
				if(isEmpty(category_name)){
					layer.tips('数据来源名称不能为空！', '#category_name', {
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
				    window.location.href="<%=path %>/admin/category/getDataCategoryLs";
				    layer.close(index);
				});             
		   </script>
	    </c:if> 
	</body>
</html>