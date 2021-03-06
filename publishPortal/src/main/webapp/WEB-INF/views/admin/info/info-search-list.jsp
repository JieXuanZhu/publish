﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>资讯列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
		
	</head>
	<body>
			<div id="slider_content" class="content">
			<form action="<%=path %>/admin/info/searchInfos" id="id_info_form" method="post">
				<div class="content_div">
					<h1>
						<!-- <span class="action-span"><a href="javascript:void(0);" onclick="addInfo();">发布资讯</a></span> -->
						<span class="action-span1">管理中心</span>
						<span class="action-span1 action-span2">-资讯管理</span>
					</h1>
					<div class="form_div">
						<img src="<%=path %>/back/images/icon_search.gif" />
						关键字:
						<input type="text" name="keyWord" value="${queryCond.keyWord }" id="id_keyWord_id"/> &nbsp; &nbsp;
						标签（分类）:
						<select name="labelId">
							<option value="">--全部分类--</option>
							<c:forEach items="${labels }" var="label" varStatus="labelStatus">
								<option value="${label.id }" <c:if test="${label.id==queryCond.labelId }">selected="selected"</c:if>>${label.label_name }</option>
							</c:forEach>
						</select>
						&nbsp; &nbsp;
						二级标签:
							<select name="tagId">
								<option value="">--全部--</option>
								<c:forEach items="${tags }" var="tag" varStatus="tagStatus">
									<option value="${tag.tagId }" <c:if test="${tag.tagId==queryCond.tagId }">selected="selected"</c:if>>${tag.tagName }</option>
								</c:forEach>
							</select>
						&nbsp; &nbsp;
						资讯状态:
							<select name="status">
								<option value="">全部</option>
								<c:forEach items="${statusMap }" var="item" varStatus="staSt">
									<option value="${item.value }" <c:if test="${queryCond.status==item.value }">selected="selected"</c:if>>${item.key }</option>
								</c:forEach>
							</select>
						&nbsp; &nbsp;
						<button type="button" onclick="queryInfo();" class="search_btn">搜索</button>
						&nbsp; &nbsp;
						<!-- <button type="button" onclick="advancedSearch();" class="search_btn">高级搜索</button> -->
						<br/>
						搜索热词:<c:forEach items="${searchWords }" var="searchWord" varStatus="searchStatus">
							<a href="javascript:void(0);" onclick="searchInfo('${searchWord.name}')" > ${searchWord.name } </a>&nbsp; &nbsp;
						</c:forEach>
						&nbsp; &nbsp;
						<br>
						二次搜索关键字:
						<input type="text" name="secondkeyWord" value="${queryCond.secondkeyWord }" /> 
						
						&nbsp; &nbsp;
						三次搜索关键字:
						<input type="text" name="thirdkeyWord" value="${queryCond.thirdkeyWord }" /> 
						
						<%-- 资讯内容:
						<input type="text" name="infoContent.content" value="${queryInfo.infoContent.content }"/>&nbsp; &nbsp; --%>
						
						
						&nbsp; &nbsp;
						排序方式：
						<select name="orderBy" id="id_orderBy">
							<option value="1" <c:if test="${queryCond.orderBy=='1' }">selected="selected"</c:if>>按时间倒序排列</option>
							<option value="2" <c:if test="${queryCond.orderBy=='2' }">selected="selected"</c:if>>按时间正序排列</option>
							<!-- <option value="3"></option> -->
						</select>
						&nbsp; &nbsp;
						每页显示数量:
						<select name="showNum" id="id_showNum">
							<option value="10" <c:if test="${queryCond.showNum=='10' }">selected="selected"</c:if>>10</option>
							<option value="20" <c:if test="${queryCond.showNum=='20' }">selected="selected"</c:if>>20</option>
							<option value="30" <c:if test="${queryCond.showNum=='30' }">selected="selected"</c:if>>30</option>
						</select>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3" class="table-layout-view">
							<thead>
							<tr>
								<th width="5%">序号</th>
								<th width="40%">新闻标题</th>
								<th width="10%">分类</th>
								<!-- <th width="40%">新闻摘要</th> -->
								<!-- <th width="10%">新闻类型</th> -->
								<th width="10%">标签</th>
								<th width="30%">上传时间</th>
								<th width="5%">状态</th>
								<!-- <th width="10%">操作</th> -->
							</tr>
							</thead>
							<tbody>
							<c:forEach var="info" items="${page.list }" varStatus="infoStatus">
								<tr>
									<td>${infoStatus.index+1 }</td>
									<td class="text-elps">${info.infoContent.title }</td>
									<td>${info.labelName }</td>
									<td>
										${info.infoTagNames }
									</td>
									<td><fmt:formatDate value="${info.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td>
										${info.statusStr }
									</td>
									<%-- <td>
										<a href="<%=path %>/admin/info/viewInfo?infoId=${info.infoId}" title="查看"><img src="<%=path %>/back/images/icon_view.gif" /></a>
									</td> --%>
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
			
			function searchInfo(word){
				$("#id_keyWord_id").val(word);
				$("#id_info_form").submit();
			}
		</script> 
	</body>
</html>