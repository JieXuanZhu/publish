<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>创建子标签</title>
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
					<span class="action-span1 action-span2">-创建子标签</span>
				</h1>
				<form action="<%=path %>/admin/label/addSubLabel" method="post" >
				   <input type="hidden" name="springMVC.token" value="${TOKEN}">
                   <input type="hidden" name="labelId" id="id_label_id" value="${label.id}"/>
				<div class="main-div">
					<table>
					    <tr>
							<td class="label">分类名称：</td>
							<td>${label.label_name }</td>
						</tr>
						<tr>
							<td class="label"><span class="require-field">*</span>标签名称：</td>
							<td><!-- <input id="label_name" name="label_name"  type="text"  class="input" /> -->
								<div class="zTreeDemoBackground">
									<ul id="treeDemo" class="ztree"></ul>
								 </div>
							</td>
						</tr>
						<tr>
						    <td class="label">
							   	 &nbsp;
							</td>
							<td>
								<button class="btn" type="button" onclick="addSubTag();">确定</button>
								<button class="btn" type="button" onclick="history.go(-1);" >取消</button>
							</td>
						</tr>
					</table>
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
				var labelId = $("#id_label_id").val().trim();
				$.ajax({
					type: "post",
			        url: "<%=path %>/admin/tag/ajaxLabelTagList",
			        data:{
						"labelId":labelId
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
				return nodesId.substring(0,nodesId.length-1);;
			}
		
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
			
			function addSubTag(){
				var nodes = treeObj.getCheckedNodes(true);
				var nodesId = getNodesId(nodes);
				console.info(nodesId);
				var labelId = $("#id_label_id").val().trim();
				//console.info(nodesId);
				$.ajax({
					type:'POST',
					url:'<%=path%>/admin/label/addSubLabel',
					data:{
						"labelId":labelId,
						"nodesId":nodesId
						},
					success:function(data){
						
						if(data.success=='true'){
							layer.alert(data.message,{icon: 6, closeBtn:2,title:'标签管理'},function(index){
								window.location.reload();
								layer.close(index);
							});
						}
						if(data.success=='false'){
							layer.alert(data.message,{icon: 6, closeBtn:2,title:'标签管理'},function(index){
								window.location.reload();
								layer.close(index);
							});
						}
					},
					error:function(data){
						layer.alert(data.message,{icon: 6, closeBtn:2,title:'标签管理'});
					}
				});
				
			}
			
		</script>
		<script type="text/javascript">
Function.prototype.method = function(name, func) {
  this.prototype[name] = func;
  return this;
};
if(!String.prototype.trim){ //判断下浏览器是否自带有trim()方法
String.method('trim', function() {
return this.replace(/^s+|s+$/g, '');
});
String.method('ltrim', function() {
return this.replace(/^s+/g, '');
});
String.method('rtrim', function() {
return this.replace(/s+$/g, '');
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