<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>欢迎登录</title>
		<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/back/images/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/back/css/reset.css">
		<link rel="stylesheet" type="text/css" href="<%=path %>/back/css/main.css">
		<script type="text/javascript" src="<%=path %>/back/js/libs/jquery-1.11.1.min.js"></script>
		<script src="<%=request.getContextPath() %>/back/js/jquery.md5.js" type="text/javascript"></script> 
		<script src="<%=request.getContextPath() %>/back/js/login.js"  type="text/javascript"></script>	
	</head>
	<body class="lg_body">
		<form id="loginForm" action="<%=request.getContextPath() %>/dologin"  method="post" >
			<div class="lg_wrap">
				<div class="lg_cont">
					<div class="lg_logo"><img src="<%=path %>/back/images/logo.jpg" /></div>
					<div id="tips" style="display:none" class="onError alert-danger">
					    <span id="login_info"></span>
					</div>
					<input id="msgInfo" type="hidden" value="${msg}"/>
					<div class="lg_list clearfix">
						<label>用户名：</label>
						<div class="">
							<input id="username" type="text" name="username" value="${name }" class="lg_input" />
						</div>
					</div>
					<div class="lg_list clearfix">
						<label>密码：</label>
						<div class="">
							<input id="password" type="password" name="password"  class="lg_input" />
						</div>
					</div>
					<%-- <div class="lg_list clearfix">
						<label>验证码：</label>
						<div class="">
							<input id="captcha" name="captcha" type="text" maxlength="4" class="lg_input" style="width:100px;margin-right:5px" />
							<img id="image" src="<%=request.getContextPath() %>/getCode" alt="验证码" onclick="this.src='<%=request.getContextPath() %>/getCode?now='+new Date().getTime(); " style="margin-top:-2px;" title="点击刷新验证码"/>
						</div>
					</div> --%>
					
					<div class="lg_fot">
						<button type="button" onclick="check()">登录</button>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>