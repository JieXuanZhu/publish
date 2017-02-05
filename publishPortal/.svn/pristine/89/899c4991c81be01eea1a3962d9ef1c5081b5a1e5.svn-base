<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0">
<title>资讯新增</title>
<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
<link rel="stylesheet" href="<%=path%>/back/kindeditor-4.1.10/themes/default/default.css" />
<style type="text/css">
	.file-name{ line-height: 30px;}
	#file-list .file-li{
	float:left;
	}
</style>
<script type="text/javascript"
	src="<%=path%>/back/js/libs/jquery-1.11.1.min.js"></script>

</head>
<body>
		<div id="slider_content" class="content">
			<form action='<%=path%>/admin/info/addInfo' id="id_form_add_news" method="post" enctype="multipart/form-data">
				<div class="content_div">
					<h1>
						<span class="action-span"><a href="javascript:void(0);"
							onclick="cancel();">返回</a></span> <span class="action-span1">管理中心</span>
						<span class="action-span1 action-span2">-资讯管理</span>
					</h1>
					<div class="main-div">
						<input type="hidden" name="springMVC.token" value="${TOKEN}">
						<input type="hidden" name="baner_url" value="" id="id_file_id" />
						<input type="hidden" name="imageSize" value="0" id="id_files_length"/>
						<input type="hidden" name="status" value="1101-1" id="id_info_status_id">
						<!--初始为空，在保存草稿后置为1，如果有过修改，置为2 -->
						<input type="hidden" name="ischangeImage" value="" id="id_isChangeImage_id">
						<table>
							<tr>
								<td class="label"><span class="require-field">*</span>标题</td>
								<td><input type="text" class="input" id="id_news_title"
									name="infoContent.title" value="" style="width: 80%" /><span
									id="err_mark_title"></span></td>
							</tr>
							<tr>
								<td class="label"><span class="require-field">*</span>摘要</td>
								<td><input type="text" class="input" id="id_news_brief"
									name="infoContent.brief" value="" style="width: 80%" /><span
									id="err_mark_brief"></span></td>
							</tr>
							<%-- <tr>
								<td class="label" id="type_mark"><span
									class="require-field">*</span>类型</td>
								<td><c:forEach items="${typeList }" var="newsType"
										varStatus="typeStatus">
										<input type="radio" name="news_type_id"
											value="${newsType.id }"
											<c:if test="${newsType.id==news.news_type_id }">checked="checked"</c:if> />${newsType.name }&nbsp;&nbsp;&nbsp;&nbsp;
									</c:forEach> <span id="err_mark_type"></span></td>
							</tr> --%>
							<tr>
								<td class="label"><span class="require-field">*</span>内容</td>
								<td id="id_hidden_content"><span>已输入<span id="input_count_id" style="font-color: red">0</span>字
								</span> <textarea class="form-control" name="infoContent.content"
										id="id_news_content"> </textarea><span
									id="err_mark_content"></span></td>
							</tr>
							<%-- <tr>
								<td class="label">banner图</td>
								<td>
									<div style="width:80%; height:300px;border:1px #8ec5fc solid;margin-right:20px;" >
						      			<img id="ImgPr" src='<c:if test="${not empty news.baner_url}">${news.baner_url }</c:if><c:if test="${empty news.baner_url}"><%=path %>/back/images/news_01.jpg</c:if>' width="645" height="300" />
						      		</div>
								</td>
							</tr>
							<tr>
						        <td></td>
								<td class="formTa">
									<input type="text" id="id_file_name" class="input" value="${news.baner_url }" readonly="readonly">
									<input type="hidden" name="isChangeImage" id="id_ischangeImage" value="">
									<span class="input-file">
										<input id="id_news_upload_file" type="file" name="bannerFile" onchange="changeImage();"/>选择图片
									</span>
								</td>
						    </tr> --%>

							<tr>
								<td class="label">banner</td>
								<td>
									<div id="browse_div_id">
										<p id="browse"
											style="border: 1px solid #ccc; height: 150px; line-height: 150px; text-align: center; color: #aaa; width: 600px;">
											选择文件...支持HTML5的浏览器可以拖拽上传，将文件拖到此区域</p>
										<!-- <input type="button" value="选择文件..."  /> -->

									</div>
									<ul id="file-list">

									</ul>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<!-- <span>剩余<span id="remain_id"></span> 秒</span> -->
									<button type="submit" class="btn">保&nbsp;&nbsp;存</button>&nbsp;&nbsp;
									<button type="button" class="btn" onclick="cancel();">取&nbsp;&nbsp;消</button>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</form>

	</div>
	<%@include file="/WEB-INF/views/admin/include_js.jsp" %>
	<script src="<%=path%>/back/js/jquery.md5.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/back/js/jquery.form.js"></script>
<script type="text/javascript"
	src="<%=path%>/back/kindeditor-4.1.10/kindeditor.js"></script>
<script type="text/javascript"
	src="<%=path%>/back/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/back/js/uploadPreview.js"></script>
<script type="text/javascript"
	src="<%=path%>/back/js/plupload.full.min.js"></script>
<script type="text/javascript">
			var selector_form = "#id_form_add_news";
			var editor;
			var uploader;
			var fileUploadSucFlag = false;
			var uploadedFileName;
			var options = {};
			var total_time = 10*60 ;//10分钟
			var remain_time = total_time;
			var resJson ={};
			jQuery(function($){
				
				$(document).keydown(function(event){
					remain_time = total_time;
				});
				$(document).mousedown(function(event){
					remain_time = total_time;
				});
				
				var t = setInterval(function(){
					remain_time--;
					//$("#remain_id").html(remain_time);
					//console.info(remain_time);
					if(remain_time<=0){
						clearInterval(t);
						//layer.msg("保存草稿成功");
						uploader.start();
					}
					//clearInterval(t);
				},1000);
				
				uploader = new plupload.Uploader({ //实例化一个plupload上传对象
					browse_button : 'browse',
					//url : '<%=path%>/uploadImg',
					url : '<%=path%>/admin/info/addInfo',
					//file_data_name:'bannerFile',
					drop_element : 'browse',
					multipart:true,
					multipart_params:{},
					filters: {
					  mime_types : [ //只允许上传图片文件
					    { title : "图片文件", extensions : "jpg,gif,png" }
					  ]
					}
				});
				uploader.init(); //初始化

				//绑定文件添加进队列事件
				uploader.bind('FilesAdded',function(uploader,files){
					for(var i = 0, len = files.length; i<len; i++){
						var file_name = files[i].name; //文件名
						//构造html来更新UI
						var html = '<li id="file-' + files[i].id +'" class="file-li"><p class="file-name">' + file_name + '</p><input type="hidden" value="'+files[i].id+'" id="file_id"><input type="button" value="删除" id="remove-btn"/><p class="progress"></p></li>';
						$(html).appendTo('#file-list');
						/*  if(files.length==1){
							uploader.disableBrowse(true);
							document.getElementById("browse_div_id").style.display="none";
						}  */
						!function(i){
							previewImage(files[i],function(imgsrc){
								$('#file-'+files[i].id).append('<img src="'+ imgsrc +'" />');
							});
					    }(i);
					}
				});
				
				uploader.bind('QueueChanged',function(uploader){
					console.info($("#id_files_length").val());
					console.info(uploader.files.length);
					$("#id_files_length").val(uploader.files.length);
					console.info("-----begin"+$("#id_isChangeImage_id").val());
					$("#id_isChangeImage_id").val("2");
					console.info("-----end"+$("#id_isChangeImage_id").val());
				});
				
				uploader.bind("FileUploaded",function(uploader,file,responseObject){
					resJson = jQuery.parseJSON(responseObject.response);
					
				});
				uploader.bind("UploadComplete",function(uploader,files){
					var status = $("#id_info_status_id").val();
					fileUploadSucFlag = true;
					console.info("uploadSuccess");
					console.info(resJson);
					if(resJson.success=='true'){
						if(status=='1101-1'){
							$("#id_isChangeImage_id").val("1");
							layer.msg("草稿保存成功");
						}else if(status =='1101-2'){
							layer.alert(resJson.message,{icon: 6, closeBtn:2,title:'资讯管理'},function(index){
								window.location.href="<%=path%>/admin/info/viewInfo?id="+resJson.infoId+"&from=1";
								layer.close(index);
							});
						}
						
					}else if(resJson.fail=='true'){
						layer.alert(resJson.message,{icon: 5, closeBtn:2,title:'资讯管理'});
					}
					
				});
				uploader.bind("Error",function(uploader,errObject){
					fileUploadSucFlag = false;
					layer.msg("图片上传失败,稍后重试或联系管理员");
				});
				
				
				//绑定文件上传进度事件
				uploader.bind('UploadProgress',function(uploader,file){
					$('#file-'+file.id+' .progress').css('width',file.percent + '%');//控制进度条
				});
				
				$(document).on("click","#remove-btn",function(){
					var fileId = $(this).parent().find("#file_id").val();
					uploader.removeFile(uploader.getFile(fileId));
					$(this).parent().remove();
					uploader.disableBrowse(false);
					document.getElementById("browse_div_id").style.display="block";
				}); 
				/* uploader.bind('QueueChanged',function(uploader){
					$("#file-list").html("");
					for(var i = 0, len = uploader.files.length; i<len; i++){
						var file_name = uploader.files[i].name; //文件名
						//构造html来更新UI
						var html = '<li id="file-' + uploader.files[i].id +'"><p class="file-name">' + file_name + '<input type="button" value="删除" id="remove-btn" onclick="removeFile(\''+file_name+'\');"/></p><p class="progress"></p></li>';
						$(html).appendTo('#file-list');
					}
				}); */

				//上传按钮
				/* $('#upload-btn').click(function(){
					uploader.start(); //开始上传
				}); */
				
				//plupload中为我们提供了mOxie对象
				//有关mOxie的介绍和说明请看：https://github.com/moxiecode/moxie/wiki/API
				//如果你不想了解那么多的话，那就照抄本示例的代码来得到预览的图片吧
				function previewImage(file,callback){//file为plupload事件监听函数参数中的file对象,callback为预览图片准备完成的回调函数
					if(!file || !/image\//.test(file.type)) return; //确保文件是图片
					if(file.type=='image/gif'){//gif使用FileReader进行预览,因为mOxie.Image只支持jpg和png
						var fr = new mOxie.FileReader();
						fr.onload = function(){
							callback(fr.result);
							fr.destroy();
							fr = null;
						}
						fr.readAsDataURL(file.getSource());
					}else{
						var preloader = new mOxie.Image();
						preloader.onload = function() {
							preloader.downsize( 300, 300 );//先压缩一下要预览的图片,宽300，高300
							var imgsrc = preloader.type=='image/jpeg' ? preloader.getAsDataURL('image/jpeg',80) : preloader.getAsDataURL(); //得到图片src,实质为一个base64编码的数据
							callback && callback(imgsrc); //callback传入的参数为预览图片的url
							preloader.destroy();
							preloader = null;
						};
						preloader.load( file.getSource() );
					}	
				}
				
				$(selector_form).submit(function(){//提交表单
					var newsId = $("#id_news_id").val();
		            options = {
		                //target:'#Tip', //后台将把传递过来的值赋给该元素
		               // url:'<%=path%>/admin/info/addInfo', 
		                type:'POST',
		                dataType:'json',
		                success: function(msg){
							var status = $("#id_info_status_id").val();
							if(msg.success=='true'){
								if(status=='1101-1'){
									$("#id_isChangeImage_id").val("1");
									layer.msg("草稿保存成功");
								}else if(status =='1101-2'){
									layer.alert(msg.message,{icon: 6, closeBtn:2,title:'资讯管理'},function(index){
										if(!isEmpty(newsId)){
											window.location.href="<%=path%>/admin/news/viewNews?id="+newsId+"&from=1";
										}else {
											window.location.href="<%=path%>/admin/news/viewNews?id="+msg.id+"&from=1";
										}
										layer.close(index);
									});
								}
								
							}else{
								layer.alert(msg.message,{icon: 5, closeBtn:2,title:'资讯管理'});
							}
		                } //显示操作提示
		            };
		            editor.sync();
					if(checkForm()){
						console.info($("#id_info_status_id").val());
						$("#id_info_status_id").val("1101-2");
						console.info($("#id_info_status_id").val());
						console.info($(selector_form).serializeArray());
						console.info(formToJson($(selector_form)));
						
						uploader.settings.multipart_params = formToJson($(selector_form));
						uploader.start();
						
						//uploader.start(); //开始上传
					}
		            return false; //为了不刷新页面,返回false，反正都已经在后台执行完了，没事！

			    });
				
				$("#id_news_upload_file").bind("click",function(){
					$("#id_news_upload_file").uploadPreview({ Img: "ImgPr", Width: 800, Height: 300,Callback: function () { 
						
					}});
				});
				
				
				
			});
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="infoContent.content"]', {
					
					uploadJson : '<%=path%>/back/kindeditor-4.1.10/jsp/upload_json.jsp',
					fileManagerJson : '<%=path%>/back/kindeditor-4.1.10/jsp/file_manager_json.jsp',
					allowFileManager : true,
					width:'80%',
					height:'100%',
					resizeType:1,
					allowImageRemote:false,
					afterChange : function() {
						K('#input_count_id').html(this.count());
						//K('.word_count2').html(this.count('text'));
						remain_time = total_time;
					},
					afterFocus:function(){
						remain_time = total_time;
					}
					
				});
	
			});
			
			function checkForm(){
				
				$("#err_mark_title").html("");
				$("#err_mark_brief").html("");
				//$("#err_mark_type").html("");
				$("#err_mark_content").html("");
				//$("#err_mark_file").html("");
				var title = $("#id_news_title").val();
				var brief = $("#id_news_brief").val();
				//var type = $('input:radio[name="news_type_id"]:checked').val(); 
				var content = $("#id_news_content").val();
				//var uploadFile = $("#id_news_upload_file").val();
				if(title==null||title.trim()==''){
					/* $("#err_mark_title").html("新闻标题不能为空");
					return false; */
					layer.tips('资讯标题不能为空', '#id_news_title', {
					    tips: 4,
					    time:4000
					});
					return false;
				}
				 
				/* if(type==null||type.trim()==''){
					layer.tips('新闻类型不能为空', '#err_mark_type', {
					    tips: 4,
					    time:4000
					});
					return false;
				} */
				if(content==null||content.trim()==''){
					//$("#err_mark_content").html("新闻内容不能为空");
					layer.tips('资讯内容不能为空', '#id_hidden_content', {
					    tips: 4,
					    time:4000
					});
					return false;
				}
				/* if(uploadFile==null||uploadFile.trim()==''){
					console.info("777");
					$("#err_mark_file").html("请上传BANNER图");
					return false;
				} */
				if(brief==null||brief.trim()==''){
					$("#id_news_brief").val(title);
					
					/* layer.tips('资讯不能为空', '#id_news_brief', {
					    tips: 4,
					    time:4000
					});
					return false; */
				}
				return true;
			}
			
			function cancel(){
				window.location.href="<%=path%>/admin/news/getNewsLs?from=1";
	}

	function formToJson(formObj){
		   var o={};
		   var a=formObj.serializeArray();
		   $.each(a, function() {

		       if(this.value){
		           if (o[this.name]) {
		               if (!o[this.name].push) {
		                   o[this.name]=[ o[this.name] ];
		               }
		                   o[this.name].push(this.value || null);
		           }else {
		               if($("[name='"+this.name+"']:checkbox",formObj).length){
		                   o[this.name]=[this.value];
		               }else{
		                   o[this.name]=this.value || null;
		               }
		           }
		       }
		   });
		   //alert(JSON.stringify(o));
		   console.info(o);
		   return o;
		};
</script>
</body>
</html>