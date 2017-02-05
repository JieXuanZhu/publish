<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>新闻数据数据源列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="category_form"  action="<%=path %>/admin/data/getNewsInfoSources" method="post">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="<%=path %>/admin/data/initAddCrawlNISource">创建新闻数据数据源</a></span>
						<span class="action-span1">出版头条管理中心</span>
						<span class="action-span1 action-span2">-新闻抓取管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
					            数据源名称:
						<input name="siteName" type="text" value="${queryCond.siteName}"/>&nbsp;&nbsp;&nbsp;
						数据来地址:
						<input name="siteUrl" type="text" value="${queryCond.siteUrl}"/>&nbsp;&nbsp;&nbsp;
						<button type="submit" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3">
							<tr>
								<th>序号</th>
								<th>数据源名称</th>
								<th>数据源地址</th>
								<th>所属分类</th>
								<th>配置文件名</th>
								<th>上次抓取时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<c:forEach var="source" items="${page.list }" varStatus="sourceStatus">
									<tr>
									    <td>${sourceStatus.index+1 }</td>
										<td>${source.siteName }</td>
										<td>${source.siteUrl }</td>
										<td>${source.siteType }</td>
										<td>${source.xmlUrl }</td>
										<td><fmt:formatDate value="${source.lastCrawlTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>
											<a href="<%=path %>/admin/data/viewNewsSource?sourceId=${source.id}" title="查看"><img src="<%=path %>/back/images/icon_view.gif" /></a>
											<a href="<%=path %>/admin/data/initModifyCrawlSource?sourceId=${source.id}" title="数据源修改"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
											<a href="javascript:void(0);" title="删除" onclick="deleteCrawlSource(${source.id})"><img src="<%=path %>/back/images/icon_trash.gif" /></a>
										<%-- 	<a href="javascript:void(0);" title="创建数据源" onclick="createSource();"><img src="<%=path %>/back/images/icon_add.gif" /></a> --%>
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
			
		   function deleteDataCategory(id){
	        	//询问框
				var index = layer.confirm('确定删除该数据来源吗？', {
					title: '删除数据源',
				    btn: ['确定','取消'] //按钮
				}, function(){
					layer.close(index);
					del(id);
				}, function(){
				});
			}
			
			<%-- function del(id){
	       		$("#category_form").attr("action","<%=path %>/admin/category/delDataCategory?id="+id);
				$("#category_form").submit();
			} --%>
			
			function del(id){
				$.ajax({
					type: "POST",
			        url:'<%=path %>/admin/data/delCrawlSource?sourceId='+id,
			        async: false,// 设置同步方式
			        error: function(request) {
			        	layer.msg('程序异常！', {icon: 2});
			        },
			        success: function(data) {
			        	if(data.success=='true'){
			        		layer.alert(data.message,function(index){
			        			window.location.reload();
			        			layer.close(index);
			        		});
			        	}else if(data.success=='false'){
			        		layer.msg(data.success);
			        	}
			        }
				});
			}
			
	   </script>
	</body>
</html>