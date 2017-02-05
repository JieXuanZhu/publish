if (window.top !== window.self) {
	window.top.location.href = window.location;
}

$(function() {
	var m = document.getElementById("msgInfo").value;
	if(m == ""){
		
	}else{
		document.getElementById("tips").style.display="block";
		$("#login_info").html(m);
	}

});

function check(){
   var accountName= $("#username").val();		   
   var accountPassword=$("#password").val();
   var captcha = $("#captcha").val();
    if(accountName==''){	
    	document.getElementById("tips").style.display="block";
		$("#login_info").html("请输入用户名");
 	    $("#username").focus();
 	    return ;
    }				 	
 	if(accountPassword==''){	
 		document.getElementById("tips").style.display="block";
		$("#login_info").html("请输入密码");
 		$("#password").focus();
 		return ;
 	}	
 	
 	/*if(captcha==''){	
 		document.getElementById("tips").style.display="block";
		$("#login_info").html("请输入验证码");
 		$("#captcha").focus();
 		return ;
 	}		*/
 	
   $("#password").val($.md5(accountPassword));
   
   
   $("#loginForm").submit();		  
}  			  	 
	  	 