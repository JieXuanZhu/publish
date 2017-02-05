/**Util通用包***/

/**
 * 左右或上下布局时，点击按钮，展开左关闭右，或展开上，关闭下
 * sliberLayer 布局伸缩方法方法
 * @requires jQuery 
 */
function sliberLayer(options){
	var setting = {
		status:true,//展开关闭切换状态
		layers:{
			selector:{
				btn:"",//控制元素选择器
				exp:"",//展开元素层选择器
				nar:"",//关闭元素层选择器
				con:""//控制元素层选择器
			}
		},
		expand:{//展开
			style:{
				exp:"",//展开元素样式
				nar:"",//关闭元素样式
				con:""//控制元素样式
			},
			callback:{
				exp:function(options){},//展开元素效果执行回调函数
				nar:function(options){},//关闭元素效果执行回调函数
				con:function(options){}//控制元素效果执行回调函数
			}
		}, 
		narrow:{//关闭
			style:{
				exp:"",
				nar:"",
				con:""
			},
			callback:{
				exp:function(options){},//展开元素效果执行回调函数
				nar:function(options){},//关闭元素效果执行回调函数
				con:function(options){}//控制元素效果执行回调函数
			}
		}
	};

	$.extend(setting, options);
	
	$(setting.layers.selector.btn).click(function(){
		if(setting.status){
			$(setting.layers.selector.exp).attr("style", setting.expand.style.exp);
			$(setting.layers.selector.nar).attr("style", setting.expand.style.nar);
			$(setting.layers.selector.con).attr("style", setting.expand.style.con);
			setting.expand.callback.exp(setting);
			setting.expand.callback.nar(setting);
			setting.expand.callback.con(setting);
			
			setting.status = false;
		}else{
			$(setting.layers.selector.exp).attr("style", setting.narrow.style.exp);
			$(setting.layers.selector.nar).attr("style", setting.narrow.style.nar);
			$(setting.layers.selector.con).attr("style", setting.narrow.style.con);
			setting.narrow.callback.exp(setting);
			setting.narrow.callback.nar(setting);
			setting.narrow.callback.con(setting);
			
			setting.status = true;
		}
	});
}

//初始化菜单json转对象
function initMenu(node_root){
	for (var i = 0; i < node_root.length; i++) {
		initRootMenu(node_root[i]);
	}
}

//初始化菜单根节点
function initRootMenu(node_root){
	if(isHaveChildren(node_root)){
		menu_html = loopSubMenu(node_root);
	}else{
		menu_html = appendMenuHtml(node_root);
	}
	$("#slider_menu").append(menu_html);
}

//循环当前节点的子菜单(递归)
function loopSubMenu(node_parent){
	var curContext = "";
	var cur_node_children = node_parent.children;
	var cur_node_children_length = cur_node_children.length;
	for(var i = 0; i < cur_node_children_length; i++){
		var curTempContext = "";
		var curTempNode = cur_node_children[i];
		if(isHaveChildren(curTempNode)){
			curTempContext += loopSubMenu(curTempNode);
		}else{
			curTempContext += appendMenuHtml(curTempNode);
		}
		curContext += curTempContext;
	}
	return appendSubMenuHtml(node_parent, curContext);
}

//判断是否有子菜单
function isHaveChildren(node){
	var cur_node_children = node.children;
	if(cur_node_children !=undefined && cur_node_children != null && cur_node_children.length > 0){
		return true;
	}
	return false;
}

//追加没有子菜单项
function appendMenuHtml(node){
	var menuNoSub_html = '<li onclick="closeSubs(this)"><a href="'+node.attributes.href+'?menu_pid='+node.pid+'" title="'+node.attributes.title+'"><i class="'+node.iconCls+'"></i><span>'+node.text+'</span></a></li>';
	return menuNoSub_html;
}

//追加有子菜单项
function appendSubMenuHtml(node, context){
	var menuHaveSub_html = '<li onclick="closeSubs(this)"><a href="'+node.attributes.href+'" title="'+node.attributes.title+'"><i class="'+node.iconCls+'"></i><span>'+node.text+'</span></a>';
	if(node.state == 'off'){
		menuHaveSub_html += '<span class="sliser_icon"></span><ul class="subs closed">'+context+'</ul></li>';
	}else{
		menuHaveSub_html += '<span class="sliser_icon off"></span><ul class="subs">'+context+'</ul></li>';
	}
	return menuHaveSub_html;
}
/**
 * 展开关闭菜单
 * */
function closeSubs(dom){
	var subs = $(dom).find(".subs");
	subs.toggleClass("closed");
	$(dom).find(".sliser_icon").toggleClass("off");
}