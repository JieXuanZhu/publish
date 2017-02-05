<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>标签列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="label_form"  action="<%=path %>/admin/label/getLabelLs" method="post">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="<%=path %>/admin/label/toAddLabel">创建标签</a></span>
						<span class="action-span1">出版头条管理中心</span>
						<span class="action-span1 action-span2">-标签管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
					            标签名称
						<input name="label_name" type="text" value="${label.label_name}"/>
						&nbsp; &nbsp;
						父菜单名称
						<input name="pName" type="text" value="${label.pName}"/>
						&nbsp; &nbsp;
						  级别
						<select name="level">
							<option value="0">全部等级</option>
							<c:forEach items="${levelList }" var="level" varStatus="levelStatus">
								<option value="${level.level }" <c:if test="${level.level==label.level}">selected="selected"</c:if>>${level.level }</option>
							</c:forEach>
						</select> 
						&nbsp; &nbsp;
						状态
						<select name="is_valid">
							<option value="2">全部状态</option>
							<option value="0" <c:if test="${label.is_valid==0}">selected="selected"</c:if>>待审核</option>
							<option value="1" <c:if test="${label.is_valid==1}">selected="selected"</c:if>>审核通过</option>
						</select>
						<button type="submit" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>序号</th>
								<th>标签名</th>
							    <th>父级标签名</th> 
								<th>级别</th>
								<th>创建时间</th>
								<th>状态</th> 
								<th>操作</th>
							</tr>
							<tr>
								<c:forEach var="label" items="${page.list }" varStatus="labelStatus">
									<tr>
									    <td>${labelStatus.index+1 }</td>
										<td>${label.label_name }</td>
									    <td>${label.pName }</td>
										<td>${label.level}</td>
										<td><fmt:formatDate value="${label.create_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
										<td>
										    <a href="<%=path %>/admin/label/viewLabel?id=${label.id}" title="预览审核"><img src="<%=path %>/back/images/icon_view.gif" /></a>
											<a href="<%=path %>/admin/label/toUpdateLabel?id=${label.id}" title="标签修改"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
											<a href="javascript:void(0);" title="删除" onclick="deleteLabel(${label.id})"><img src="<%=path %>/back/images/icon_trash.gif" /></a>
											<a href="<%=path %>/admin/label/toAddSubLabel?id=${label.id}" title="创建子标签"><img src="<%=path %>/back/images/icon_add.gif" /></a>
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
			
		   function deleteLabel(id){
	        	//询问框
				var index = layer.confirm('确定删除该标签吗？', {
					title: '删除标签',
				    btn: ['确定','取消'] //按钮
				}, function(){
					layer.close(index);
					del(id);
				}, function(){
				});
			}
			
			function del(id){
					$.ajax({
				        type: "POST",
				        url:'<%=path %>/admin/label/canDelLabel?id='+id,
				        async: false,// 设置同步方式
				        error: function(request) {
				        	layer.msg('程序异常！', {icon: 2});
				        },
				        success: function(data) {
				        	if(data.result==0){
				        		$("#label_form").attr("action","<%=path %>/admin/label/delLabel?id="+id);
								$("#label_form").submit();
				        	}else if(data.result==1){
				        		layer.msg('该标签还有子标签在使用，不能删除！', {icon: 2});
				        	}else{
				        		layer.msg('id不能为空！', {icon: 2});
				        	}
				        }
			 		});
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