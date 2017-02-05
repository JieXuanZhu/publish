<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>资讯发布列表</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
		
	</head>
	<body>
			<div id="slider_content" class="content">
			<form action="<%=path %>/admin/info/getToPublishInfos" id="id_info_form" method="post">
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
						&nbsp; &nbsp;&nbsp; &nbsp;
						<select id="id_labelType_id">
							<option value="">--选择展示模块--</option>
							<c:forEach items="${labelList }" var="label" varStatus="labelSta">
								<option value="${label.id }">${label.label_name } </option>
							</c:forEach>
						</select>
						<button type="button" onclick="disSelected();" class="search_btn">分配</button>
					</div>
					<div class="list_table">
						<table cellspacing="1" cellpadding="3" class="table-layout-view">
							<thead>
							<tr>
								<th width="5%"><input type="checkbox" id="id_selectAll_check_id"></th>
								<th width="5%">序号</th>
								<th width="35%">新闻标题</th>
								<th width="10%">分类</th>
								<!-- <th width="40%">新闻摘要</th> -->
								<!-- <th width="10%">新闻类型</th> -->
								<th width="10%">标签</th>
								<th width="20%">上传时间</th>
								<th width="5%">状态</th>
								<th width="10%">操作</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach var="info" items="${page.list }" varStatus="infoStatus">
								<tr>
									<td><input type="checkbox" id="id_info_check_${info.infoId }" class="checkbox_infoId" name="infoId" value="${info.infoId }" ></td>
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
										<%-- <a href="javascript:void(0);" title="编辑" onclick="modifyInfoDetail(${info.infoId});"><img src="<%=path %>/back/images/icon_edit.gif" /></a>--%>
										<%-- <a href="javascript:void(0);" title="删除" onclick="deleteInfo(${info.infoId});"><img src="<%=path %>/back/images/icon_trash.gif" /></a>  --%>
										<%-- <a href="javascript:void(0);" title="分配" onclick="distributeInfo(${info.infoId});"><img alt="分配" src="<%=path %>/back/images/icon_rec.jpg"></a> --%>
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
		
		$(function(){
			//全选或全不选 
		    $("#id_selectAll_check_id").click(function(){    
		    	var isChecked = $(this).prop("checked");
		        $(".checkbox_infoId").prop("checked", isChecked);
		     });  
		     
		    //设置全选复选框 
		    $(".checkbox_infoId").click(function(){ 
		        allchk(); 
		    }); 
		  
		});
			
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
				layer.confirm("确定要删除该资讯?",{title:'资讯管理',closeBtn:2,offset:'100px'},function(index){
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
							layer.alert("分配失败",{icon: 6, closeBtn:2,title:'资讯管理',offset:'100px'});
						}
					});
			}
			
			//
			function distributeInfo(infoIds,labelId){
				$.ajax({
					type:'POST',
					url:'<%=path%>/admin/info/distributeInfo',
					data:{
						"infoIds":infoIds,
						"labelId":labelId
					},
					success:function(data){
						
						if(data.success=='true'){
							layer.alert(data.message,{icon: 6, closeBtn:2,title:'资讯管理',offset:'100px'},function(index){
								$(".checkbox_infoId").each(function(i){ 
									if($(this).is(":checked")==true){ 
										$(this).attr("checked",false);
							        }
						           
						        }); 
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
			
			//分配当前列表页选择的所有的
			function disSelected(){
				if(getCheckIds()==''){
					layer.alert("请选择要分配的资讯");
					return ;
				}
				var selectLable = $("#id_labelType_id").val();
				if(typeof(selectLable)=='undefined'||selectLable==null ||selectLable==''){
					layer.alert("请选择要分配的分类");
					return ;
				}
				var ids = getCheckIds();
				distributeInfo(ids,$("#id_labelType_id").val());
			}
			
			
		function allchk(){ 
		    var chknum = $(".checkbox_infoId").size();//选项总个数 
		    var chk = 0; 
		    $(".checkbox_infoId").each(function () {   
		        if($(this).attr("checked")==true){ 
		            chk++; 
		        } 
		    }); 
		    if(chknum==chk){//全选 
		        $("#id_selectAll_check_id").attr("checked",true); 
		    }else{//不全选 
		        $("#id_selectAll_check_id").attr("checked",false); 
		    } 
		}
		
		function getCheckIds(){
			console.info("------1");
			var checkInfoIds = '';
			$(".checkbox_infoId").each(function(i){ 
				 /* console.info(i);
				console.info($(this));
				console.info($(this).is(":checked"));
				console.info($(this).val());  */
				if($(this).is(":checked")==true){ 
					checkInfoIds=checkInfoIds+$(this).val()+","; 
		        }
	           
	        }); 
			/* console.info(checkInfoIds); */
			if(checkInfoIds!=''){
				return checkInfoIds.substring(0,checkInfoIds.length-1);
			}else {
				return checkInfoIds;
			}
		}
		
		/*  //获取选中选项的值 
	    $("#getValue").click(function(){ 
	    	
	        var valArr = new Array; 
	        $(".checkbox_infoId").each(function(i){ 
	            valArr[i] = $(this).val(); 
	        }); 
	        var vals = valArr.join(','); 
	          alert(vals); 
	    });  */
			
		</script> 
	</body>
</html>