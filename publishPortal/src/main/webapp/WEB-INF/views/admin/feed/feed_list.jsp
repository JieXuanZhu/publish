<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>反馈列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<form id="feed_form"  action="<%=path %>/admin/feed/getBackFeedLs" method="post">
				<div class="content_div">
					<h1>
					 <!--    <span class="action-span"><a href="javascript:void(0);" onclick="batchBackFeed();">批量处理反馈信息</a></span> -->
						<span class="action-span1">出版头条管理中心</span>
						<span class="action-span1 action-span2">-反馈管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
					            反馈人(用户名)
						<input name="user_name" type="text" value="${backFeed.user_name}"/>
						&nbsp; &nbsp;
						 状态
						<select name="is_valid">
						    <c:if test="${backFeed.is_valid==null }">
						        <option value="">全部状态</option>
						   		<option value="0">未分组</option>
								<option value="1">已分组</option>
								<option value="2">已提取</option>
								<option value="3">已处理</option>
						    </c:if>
						    <c:if test="${backFeed.is_valid==0 }">
						        <option value="0">未分组</option>
							    <option value="">全部状态</option>
								<option value="1">已分组</option>
								<option value="2">已提取</option>
								<option value="3">已处理</option>
						    </c:if>
						    <c:if test="${backFeed.is_valid==1 }">
						        <option value="1">已分组</option>
							    <option value="">全部状态</option>
								<option value="0">未分组</option>
								<option value="2">已提取</option>
								<option value="3">已处理</option>
						    </c:if>
						    <c:if test="${backFeed.is_valid==2 }">
						        <option value="2">已提取</option>
							    <option value="">全部状态</option>
								<option value="0">未分组</option>
								<option value="1">已分组</option>
								<option value="3">已处理</option>
						    </c:if>
						    <c:if test="${backFeed.is_valid==3 }">
						        <option value="3">已处理</option>
							    <option value="">全部状态</option>
								<option value="0">未分组</option>
								<option value="1">已分组</option>
								<option value="2">已提取</option>
						    </c:if>
						</select>
						&nbsp; &nbsp;
						分组
						<select name="feed_type_id">
							<option value="0">全部分组</option>
							<c:forEach items="${backFeedTypeLs }" var="type" varStatus="typeStatus">
								<option value="${type.id }" <c:if test="${type.id==backFeed.feed_type_id}">selected="selected"</c:if>>${type.feed_type_name }</option>
							</c:forEach>
						</select>
						&nbsp;&nbsp;
						提交文本
						<input name="content" type="text" value="${backFeed.content}"/>
						&nbsp;&nbsp;
						需求点
						<input name="demand_point" type="text" value="${backFeed.demand_point}"/>
						<button type="submit" class="search_btn">搜索</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3" class="table-layout-view">
							<tr>
								<th width="5%"><!-- <input type="checkbox" class="checkbox btn_selectAll"  /> -->序号</th>
								<th width="10%">反馈人</th>
								<th width="10%">分组名称</th>
								<th width="30%">提交的文本</th>
								<th width="10%">系统</th>
								<th width="10%">机型</th>
								<th width="10%">版本</th>
								<th width="30%">需求点</th>
								<th width="10%">反馈时间</th>
							    <th width="5%">状态</th>
								<th width="10%">操作</th>
							</tr>
							<tr>
								<c:forEach var="feed" items="${page.list }" varStatus="feedStatus">
									<tr>
									    <td><%-- <input name="feeds" type="checkbox" class="checkbox" value="${feed.id+27 }"/> --%>${feedStatus.index+1 }</td>
										<td>${feed.user_name }</td>
										<td>${feed.feed_type_name }</td>
										<td  class="text-elps">${feed.content }</td>
										<td>${feed.system }</td>
										<td>${feed.model }</td>
										<td>${feed.version }</td>
									    <td  class="text-elps">${feed.demand_point }</td>
										<td><fmt:formatDate value="${feed.create_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>
											<c:if test="${feed.is_valid==0 }">
												未分组
						   					</c:if>
						   					<c:if test="${feed.is_valid==1 }">
												已分组
						   					</c:if>
						   					<c:if test="${feed.is_valid==2 }">
												已提取
						   					</c:if>
						   					<c:if test="${feed.is_valid==3 }">
												已处理
						   					</c:if>
										</td>
										<td>
											<c:if test="${feed.is_valid == 0 }">
												<a href="<%=path %>/admin/feed/toGroupWithBackFeed?id=${feed.id}" title="反馈信息分组"><img src="<%=path %>/back/images/icon_add.gif" /></a>
											</c:if>
											<c:if test="${feed.is_valid == 1 }">
												  <a href="<%=path %>/admin/feed/toGroupWithBackFeed?id=${feed.id}" title="反馈信息分组"><img src="<%=path %>/back/images/icon_add.gif" /></a>
												  <a href="<%=path %>/admin/feed/toFetchDemandPoint?id=${feed.id}" title="提取需求点"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
											</c:if>
											<c:if test="${feed.is_valid == 2 }">
												  <a href="<%=path %>/admin/feed/toGroupWithBackFeed?id=${feed.id}" title="反馈信息分组"><img src="<%=path %>/back/images/icon_add.gif" /></a>
												  <a href="<%=path %>/admin/feed/toFetchDemandPoint?id=${feed.id}" title="提取需求点"><img src="<%=path %>/back/images/icon_edit.gif" /></a>
												  <a href="<%=path %>/admin/feed/toHandleBackFeed?id=${feed.id}" title="处理反馈信息"><img src="<%=path %>/back/images/icon_view.gif" /></a>
											</c:if>
											<c:if test="${feed.is_valid == 3 }">
												已处理
											</c:if>
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
		<script type="text/javascript">
		   var n =0;
		   function batchBackFeed(){
			    count();
			    if(parseInt(n)>0){
			    	//询问框
					var index = layer.confirm('确定批量处理反馈信息吗？', {
						title: '批量处理反馈信息',
					    btn: ['确定','取消'] //按钮
					}, function(){
						layer.close(index);
						$("#feed_form").attr("action","<%=path %>/admin/feed/batchBackFeed");
						$("#feed_form").submit();
					}, function(){
					});
			    }else{
			    	
			    	layer.msg('请至少选择一条信息！', {
			    	    icon: 2,
			    	    time: 2000 //2秒关闭（如果不配置，默认是3秒）
			    	}, function(){
			    	    //do something
			    	});    
			    	
			    }
			   
			}
		   
		   function count(){
				var checks = document.getElementsByName("feeds");
				for(var i=0;i<checks.length;i++){
					if(checks[i].checked)
						n++;
				}
				//alert(n);
			}
		   
		   $(function(){
				var btn_checked = $(".btn_selectAll");
				var checkeds = $("input[type=checkbox]");
				var checkeds_notbtn = $(checkeds).not(btn_checked);
				//全选、全不选
				$(btn_checked).on("click", function(e){
					if(this.checked){
						$.each(checkeds, function(i){	
							this.checked = true;
						});
					}else{
						$.each(checkeds, function(i){
							this.checked = false;
						});
					}
				});
				
				//item选中或取消，改变全选和全不选状态
				$(checkeds_notbtn).on("click", function(e){
					var status = true;
					if(this.checked){
						$.each($(checkeds_notbtn), function(){
							if(!this.checked){
								status = false;
							}
						});
					}else{
					    status = false;
					}
					//判断是否选中全选
					$.each($(btn_checked), function(i){
						if(status){
							this.checked = true;
						}else{
							this.checked = false;
						}
					});
				});
			});
			
	   </script>
	   <c:if test="${not empty msg }">
	       <script>
			   layer.alert('${msg}', function(index){
				    //do something
				    window.location.href="<%=path %>/admin/feed/getBackFeedLs";
				    layer.close(index);
				});             
		   </script>
	    </c:if> 
	</body>
</html>