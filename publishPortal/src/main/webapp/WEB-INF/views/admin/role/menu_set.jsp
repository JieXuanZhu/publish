<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>设置权限</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
		<link rel="stylesheet" href="<%=path %>/back/zTree/css/demo.css" type="text/css">
		<link rel="stylesheet" href="<%=path %>/back/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	</head>
	<body>
		<div id="slider_content" class="content">
			<div class="content_div">
				<h1>
					<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
					<span class="action-span1">出版头条管理中心</span>
					<span class="action-span1 action-span2">-角色管理</span>
				</h1>
				<form action="<%=path %>/admin/role/editRoleMenu" method="post">
                    <input id="roleId" type="hidden" name="id" value="${role.id }"/>
					<div class="main-div">
						<table>
							<tr>
								<td class="label">角色名称</td>
								<td>${role.name }</td>
							</tr>
							<tr>
								<td class="label">菜单</td>
								<td rowspan="3" colspan="3">
									 <div class="zTreeDemoBackground">
										<ul id="treeDemo" class="ztree"></ul>
									 </div> 
								</td>
							</tr>
						</table>
						<div class="submit_btn">
							<button class="btn" type="button" onclick="editRole();">确定</button>
							<button class="btn" type="button" onclick="history.go(-1);" >取消</button>
						</div>
					</div>
				</form>
			</div>
		</div> 
		<%@include file="/WEB-INF/views/admin/include_js.jsp" %>
	    <script type="text/javascript" src="<%=path %>/back/zTree/js/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript" src="<%=path %>/back/zTree/js/jquery.ztree.excheck-3.5.js"></script>
		<script type="text/javascript">
			var setting = {
					check: {
						enable: true
					},
					data: {
						simpleData: {
							enable: true
						}
					}
				};
	
			  var zNodes =[
					{ id:1, pId:0, name:"随意勾选 1", open:true},
					{ id:11, pId:1, name:"随意勾选 1-1", open:true},
					{ id:111, pId:11, name:"随意勾选 1-1-1"},
					/* { id:112, pId:11, name:"随意勾选 1-1-2"},
					{ id:12, pId:1, name:"随意勾选 1-2", open:true},
					{ id:121, pId:12, name:"随意勾选 1-2-1"},
					{ id:122, pId:12, name:"随意勾选 1-2-2"},
					{ id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
					{ id:21, pId:2, name:"随意勾选 2-1"},
					{ id:22, pId:2, name:"随意勾选 2-2", open:true},
					{ id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
					{ id:222, pId:22, name:"随意勾选 2-2-2"},
					{ id:23, pId:2, name:"随意勾选 2-3"} */
				];
				var treeObj = null;
				
				//$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				$(function(){
					var roleId = $("#roleId").val().trim();
					$.ajax({
						type: "post",
				        url: "<%=path %>/admin/role/ajaxRolePowerList",
				        data:{
							"id":roleId
							},
				        dataType: "json",
						success:function(data){
							treeObj = $.fn.zTree.init($("#treeDemo"), setting, data);
					   }
				      });
				
				});
				
				
				
				function getNodesId(nodes){
					var nodesId = "";
					for(var node = 0; node < nodes.length; node++){
						nodesId += nodes[node].id+",";
					}
					return nodesId;
				}
				
				function editRole(){
					var nodes = treeObj.getCheckedNodes(true);
					var nodesId = getNodesId(nodes);
					var roleId = $("#roleId").val().trim();
					//console.info(nodesId);
					$.ajax({
						type:'POST',
						url:'<%=path%>/admin/role/editRoleMenu',
						data:{
							"id":roleId,
							"menusId":nodesId
							},
						success:function(data){
							
							if(data.success=='true'){
								layer.alert(data.message,{icon: 6, closeBtn:2,title:'角色管理'},function(index){
									window.location.reload();
									layer.close(index);
								});
							}
							if(data.success=='false'){
								layer.alert(data.message,{icon: 6, closeBtn:2,title:'角色管理'},function(index){
									window.location.reload();
									layer.close(index);
								});
							}
						},
						error:function(data){
							layer.alert(data.message,{icon: 6, closeBtn:2,title:'角色管理'});
						}
					});
					
				}
				
		</script>
		
	</body>
</html>