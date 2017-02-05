<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>资讯审核列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
		
	</head>
	<body>
			<div id="slider_content" class="content">
			<form action="<%=path %>/admin/info/<c:if test="${type=='check'}">getFirstCheckInfos</c:if><c:if test="${type=='recheck'}">getSecondCheckInfos</c:if>" id="id_info_form" method="post">
				<div class="content_div">
					<h1>
						<!-- <span class="action-span"><a href="javascript:void(0);" onclick="addInfo();">发布资讯</a></span> -->
						<span class="action-span1">管理中心</span>
						<span class="action-span1 action-span2">-资讯管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
						资讯标题:
						<input type="text" name="infoContent.title" value="${queryInfo.infoContent.title }" /> &nbsp; &nbsp;
						资讯内容:
						<input type="text" name="infoContent.content" value="${queryInfo.infoContent.content }"/>&nbsp; &nbsp;
						资讯状态:
						<select name="status">
							<option value="">全部</option>
							<c:forEach items="${statusMap }" var="item" varStatus="staSt">
								<option value="${item.value }" <c:if test="${queryInfo.status==item.value }">selected="selected"</c:if>>${item.key }</option>
							</c:forEach>
						</select>
						
						&nbsp; &nbsp;
						<button type="button" onclick="queryInfo();" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3" class="table-layout-view">
							<thead>
							<tr>
								<th width="5%">序号</th>
								<th width="35%">新闻标题</th>
								<th width="10%">分类</th>
								<!-- <th width="40%">新闻摘要</th> -->
								<!-- <th width="10%">新闻类型</th> -->
								<th width="10%">标签</th>
								<th width="25%">上传时间</th>
								<th width="5%">状态</th>
								<th width="10%">操作</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach var="info" items="${page.list }" varStatus="infoStatus">
								<tr>
									<td>${infoStatus.index+1 }</td>
									<td class="text-elps">${info.infoContent.title }</td>
									<td>${info.labelName }</td>
									<%-- <td class="text-elps">${info.brief }</td> --%>
									<%-- <td>${news.newsType.name}</td> --%>
									<td>
										${info.infoTagNames }
									</td>
									<td><fmt:formatDate value="${info.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td>
										${info.statusStr }
									</td>
									<td>
										<a href="<%=path %>/admin/info/checkInfo?infoId=${info.infoId}" title="查看"><img src="<%=path %>/back/images/icon_view.gif" /></a>
										<a href="javascript:void(0);" title="编辑" onclick="modifyInfoDetail(${info.infoId});"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
										<%-- <a href="javascript:void(0);" title="删除" onclick="deleteInfo(${info.infoId});"><img src="<%=path %>/back/images/icon_trash.gif" /></a>  --%>
									</td>
								</tr>	
							</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="right paging"><page:pageinfo pageinfo="${page}" /></div>
				</div>
				</form>
			</div>
			<%@include file="/WEB-INF/views/admin/include_js.jsp" %>
		<script src="<%=path %>/back/js/jquery.md5.js" type="text/javascript"></script>
		<script type="text/javascript">
			
			function queryInfo(){
				$("#id_info_form").submit();
			}
		
			//新增新闻		
			function addInfo(){
				var url = "<%=path %>/admin/info/initAddInfo";
				window.location.href=url;
			}
			
			//查看新闻
			function viewInfo(id){
				var url ="<%=path %>/admin/info/viewInfo?infoId="+id;
				window.location.href=url;
			}
			
			//修改新闻
			function modifyInfoDetail(id){
				var url ="<%=path %>/admin/info/initModifyInfo?infoId="+id;
				window.location.href=url;
			}
			
			//删除新闻
			
			function deleteInfo(infoId){
				layer.confirm("确定要删除该资讯?",{title:'资讯管理',closeBtn:2},function(index){
					del(infoId);
				});
			}
			
			function del(infoId){
					console.info("删除资讯");
					$.ajax({
						type:'POST',
						url:'<%=path%>/admin/info/deleteInfo',
						data:{"infoId":infoId},
						success:function(data){
							
							if(data.success=='true'){
								layer.alert(data.message,{icon: 6, closeBtn:2,title:'资讯管理',offset:'100px'},function(index){
									window.location.reload();
									layer.close(index);
								});
								
							}else if(data.fail=='true'){
								layer.alert(data.message,{icon: 6, closeBtn:2,title:'资讯管理',offset:'100px'});
							}
								
						},
						error:function(data){
							layer.alert(data.message,{icon: 6, closeBtn:2,title:'资讯管理',offset:'100px'});
						}
					});
			}
		</script> 
	</body>
</html>