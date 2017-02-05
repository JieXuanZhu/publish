<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>资讯预览</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
			<div id="slider_content" class="content">
			<form action="" id="id_form_view_news" method="post">
				<div style="display:none">
					<input type="hidden" name="id" id="id_news_id" value="${info.id }">
				</div>
				<div class="content_div">
					<h1>
						<%-- <c:if test="${info.status=='1101-2' }">
							<span class="action-span"><a href="javascript:void(0);" onclick="confirm('1102-1');">确认提交审核</a></span>
						</c:if>
						<c:if test="${info.status=='1102-7' }">
							<span class="action-span"><a href="javascript:void(0);" onclick="confirm('1102-8');">首页修改成功，提交</a></span>
						</c:if>
						<c:if test="${info.status=='1102-2' }">
							<span class="action-span"><a href="javascript:void(0);" onclick="confirm('1102-1');">修改完成，提交审核</a></span>
						</c:if>
						<c:if test="${info.status=='1102-4' }">
							<span class="action-span"><a href="javascript:void(0);" onclick="confirm('1102-1');">修改完成，提交审核</a></span>
						</c:if>
						
						<span class="action-span"><a href="javascript:void(0);" onclick="gotoModify(${info.infoId});">修改</a></span> --%>
						<span class="action-span"><a href="javascript:void(0);" onclick="javascript:go(-1);">返回</a></span>
						<span class="action-span1">管理中心</span>
						<span class="action-span1 action-span2">-资讯管理</span>
					</h1>
				</div>
					<div class="case">
						<div class="model">
							<h1>资讯预览<span>-Info Preview-</span></h1>
							<div class="clearfix">
								
								<div class="news_txt">
									<h3>标题:${info.title }</h3>
									<p>副标题:${info.subtitle }</p>
									<span>作者:${info.author }&nbsp;新闻来源:${info.newsoriginal }&nbsp;发布时间:${info.releasetime }&nbsp;新闻类型:${info.newstype }&nbsp;
									浏览次数:${info.viewcount }&nbsp;抓取时间:${info.crawlertime }</span>
								</div>
								<c:if test="${not empty info.indexnum  || not empty info.themetype || not empty info.publishorgan || not empty info.publishdate || not empty info.name || not empty info.themeword || not empty info.docnum}">
								<div class="list_table">
									<table cellspacing="1" cellpadding="3">
										<tr>
											<td>索引号</td>
											<td>${info.indexnum }</td>
											<td>主题分类</td>
											<td>${info.themetype }</td>
										</tr>
										<tr>
											<td>发布机关</td>
											<td>${info.publishorgan }</td>
											<td>发布日期</td>
											<td>${info.publishdate }</td>
										</tr>
										<tr>
											<td>名称</td>
											<td>${info.name }</td>
											<td>主题词</td>
											<td>${info.themeword }</td>
										</tr>
										<tr>
											<td>文号</td>
											<td colspan="3">${info.docnum}</td>
										</tr>
									</table>
								</div>
								</c:if>
								<c:if test="${not empty info.fromunit  || not empty info.approvalfilename || not empty info.approvaldocnum || not empty info.approvaltime}">
								<div class="list_table">
									<table cellspacing="1" cellpadding="3">
										<tr>
											<td>来文单位</td>
											<td colspan="3" >${info.fromunit }</td>
											
										</tr>
										<tr>
											<td>审批文件名称 </td>
											<td colspan="3">${info.approvalfilename }</td>
										</tr>
										<tr>
											<td>审批文号</td>
											<td colspan="3">${info.approvaldocnum}</td>
										</tr>
										<tr>
											<td>时间</td>
											<td colspan="3">${info.approvaltime}</td>
										</tr>
									</table>
								</div>
								</c:if>
							</div>
							<br>
							<br>
							<div class="new_page">
								<p>${info.content }</p>
								<p>抓取页面：${info.crawlerurl }</p>
							</div>
						</div>
					</div>
					
				</form>
			
		</div>
		<%@include file="/WEB-INF/views/admin/include_js.jsp" %>
		<script src="<%=path %>/back/js/jquery.md5.js" type="text/javascript"></script>
		<script type="text/javascript">
		
			function confirm(status){
				var infoId=$("#id_news_id").val();
				$.ajax({
					type:'POST',
					url:'<%=path%>/admin/info/changeStatus',
					data:{
						"infoId":infoId,
						"status":status
					},
					dataType:'json',
					success:function(data){
						if(data.success=='true'){
							layer.alert(data.message,{icon: 6, closeBtn:2,title:'资讯管理',offset:'100px'},function(index){
								//window.location.reload();
								window.location.href="<%=path %>/admin/info/getInfos";
								layer.close(index);
							});
						}else if(data.success=='false'){
							layer.alert(data.message,{icon: 5, closeBtn:2,title:'资讯管理',offset:'100px'});
						}
					},
					error: function(data) {
						var message = "";
						if( typeof(data) == "undefined" || data == null || data.message==null||data.message==''){
							message = "资讯确认失败";
						}else {
							message = data.message;
						}
						layer.alert(message,{icon: 5, closeBtn:2,title:'资讯管理',offset:'100px'});
	                }
				});
			}
		
			function cancel(){
				window.location.href="<%=path %>/admin/info/getDatas";
			}
			
			function gotoModify(infoId){
				window.location.href="<%=path %>/admin/info/initModifyInfo?infoId="+infoId;
			}
			
		</script>
	</body>
</html>