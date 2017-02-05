<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>东翌帮助页</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/back/css/reset.css">
		<link rel="stylesheet" type="text/css" href="<%=path %>/back/css/main.css">
		<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/front/images/favicon.ico" />
		<script type="text/javascript" src="<%=path %>/back/js/libs/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="<%=path %>/back/js/jquery.media.js"></script>
	<script type="text/javascript">
	
		$(window).resize(function(){
			$("iframe").width(($(window).width()-2*10)+'px');
			$("iframe").height(($(window).height()-152)+'px');
		});
		
	    $(function() {  
	        $('a.media').media({width:($(window).width()-2*10)+'px', height:($(window).height()-152)+"px"});  
	    });  
	</script>
	</head>
	<body>
		<div class="wrap">
			<div id="slider_content">
				<div class="content_div">
					<h1>
						<span class="action-span1">东翌管理中心</span>
						<span class="action-span1 action-span2">-帮助文档</span>
					</h1>
					<a class="media" href="<%=path %>/file/YYZ_OPERATION.pdf"></a>
				</div>
				<%@ include file="/WEB-INF/views/admin/footer.jsp"%>
			</div>
		</div>
	</body>
</html>