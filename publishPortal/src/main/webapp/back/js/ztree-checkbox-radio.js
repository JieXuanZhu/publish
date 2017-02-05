//http://blog.csdn.net/xulei_19850322/article/details/8624867

/*var setting = {
					check: {
						chkStyle : "checkbox",
						enable: true
					},
					data: {
						simpleData: {
							enable: true
						}
					},
					callback:{
						onCheck:function(){
							var nodes = treeObj.getCheckedNodes(true);
							var nodesId = getNodesId(nodes);
							$("#id_hidden_tag_id").val(nodesId);
						}
					}
				};

			  var zNodes =[
					{ id:1, pId:0, name:"随意勾选 1", open:true},
					{ id:11, pId:1, name:"随意勾选 1-1", open:true},
					{ id:111, pId:11, name:"随意勾选 1-1-1"},
					 { id:112, pId:11, name:"随意勾选 1-1-2"},
					{ id:12, pId:1, name:"随意勾选 1-2", open:true},
					{ id:121, pId:12, name:"随意勾选 1-2-1"},
					{ id:122, pId:12, name:"随意勾选 1-2-2"},
					{ id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
					{ id:21, pId:2, name:"随意勾选 2-1"},
					{ id:22, pId:2, name:"随意勾选 2-2", open:true},
					{ id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
					{ id:222, pId:22, name:"随意勾选 2-2-2"},
					{ id:23, pId:2, name:"随意勾选 2-3"} 
				];*/
		var zTree;
        var IDMark_A = "_a";
        var setting = {
            view: {
                addDiyDom: addDiyDom
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback:{
				onCheck:function(){
					var nodes = zTree.getCheckedNodes(true);
					var parNode = nodes[0].getParentNode();
					console.info(nodes[0]);
					console.info(parNode);
					$("#id_hidden_labelId").val(parNode.id);
					var nodesId = getNodesId(nodes);
					$("#id_hidden_tag_id").val(nodesId);
				}
			}
        };

        var zNodes =[
            { id:1, pId:0, name:"父节点 1", open:true},
            { id:11, pId:1, name:"叶子节点 1-1"},
            { id:12, pId:1, name:"叶子节点 1-2"},
            { id:13, pId:1, name:"叶子节点 1-3"},
            { id:2, pId:0, name:"父节点 2", open:true},
            { id:21, pId:2, name:"叶子节点 2-1"},
            { id:22, pId:2, name:"叶子节点 2-2"},
            { id:23, pId:2, name:"叶子节点 2-3"},
            { id:3, pId:0, name:"父节点 3", open:true},
            { id:31, pId:3, name:"叶子节点 3-1"},
            { id:32, pId:3, name:"叶子节点 3-2"},
            { id:33, pId:3, name:"叶子节点 3-3"}
        ];
//判断节点是否在已选择的节点中，判断重复选择
    function isNodeInChecked(curId){
            if(zTree==null){
                return false;
            }
            var selectedNodes=zTree.getNodesByParam("checked", true, null);
            var selectedNode;
            
            if(selectedNodes == null || selectedNodes.length==0){
                return false;
            }
            for(var i=0; i<selectedNodes.length;i++){
                selectedNode = selectedNodes[i];
                if(selectedNode.id==curId){
                    return true;
                }
            }
            return false;
        }
        //自定义的树形规则
        function addDiyDom(treeId, treeNode) {
            var aObj = $("#" + treeNode.tId + IDMark_A);
            if (treeNode.level == 0) {
                var editStr = "<input type='radio' class='radioBtn' id='radio_" +treeNode.id+"_"+treeNode.pId+"' onfocus='this.blur();'></input>";
                aObj.before(editStr);
                var btn = $("#radio_"+treeNode.id+"_"+treeNode.pId);
                if (btn) {
                    btn.bind("click", function() {checkAccessories(treeNode, btn);});
                }
                
            } else {
                var editStr = "<input type='checkbox' class='checkboxBtn' id='checkbox_" +treeNode.id+"_"+treeNode.pId+ "' name='checkbox_"+treeNode.getParentNode().id+"_"+treeNode.pId+ "' onfocus='this.blur();'></input>";
                aObj.before(editStr);
                var btn = $("#checkbox_"+treeNode.id+"_"+treeNode.pId);
                if (btn){
                
                     btn.bind("change", function() {checkBrand(treeNode, btn);});
                    var isNodeInChecked = false;
                    var selectedNodes=null;
                    if(zTree!=null){
                        selectedNodes = zTree.getNodesByParam("checked", true, null);
                    }
                    
                    var selectedNode;
                    //初始化时判断是否需要选择，这里可以去掉或者通过在zNodes中定义中添加checked:true来代替
                    if(selectedNodes != null && selectedNodes.length > 0){
                        for(var i=0; i<selectedNodes.length;i++){
                            selectedNode = selectedNodes[i];
                            if(selectedNode.id==treeNode.pId){
                                isNodeInChecked = true;
                                break;
                            }
                        }
                    }
                    if(isNodeInChecked){
                        treeNode.checked=true;
                        btn.attr("checked", true);
                    }
                }

            }
        }
        function checkAccessories(treeNode, btn) {
            if (btn.attr("checked")) {
                //点击的节点是否在已选的根节点中
                var isRootInChecked = isNodeInChecked(treeNode.id);
                if(!isRootInChecked){
                    //去除其余根节点以及下级节点的选择
                    beforeCheckAccessories();
                }
                treeNode.checked=true;
                //节点下所有节点都勾选
                setChildSelected(treeNode, btn,true);
            } else {
                treeNode.checked=false;
                setChildSelected(treeNode, btn,false);
            }
        }
        function setChildSelected(treeNode, btn,status){
            var children;
            if(treeNode.children==null){
                return true;
            }
            var lenth=treeNode.children.length;
            if(lenth==0){
                return true;
            }
            for(var i=0;i<lenth;i++){
                children = treeNode.children[i];
                $("#checkbox_" + children.id+"_"+children.pId).attr("checked", status);
                children.checked=status;
                btn = $("#checkbox_"+children.id+"_"+children.pId);
                rls = setChildSelected(children, btn,status);
                if(rls){
                    continue;
                }
            }
                
        }
        function beforeCheckAccessories() {
            var selectedNodes=null;
            if(zTree!=null){
                selectedNodes = zTree.getNodesByParam("checked", true, null);
            }
            
            var selectedNode;
            if(selectedNodes == null || selectedNodes.length == 0){
                return;
            }
            for(var i=0; i<selectedNodes.length;i++){
                selectedNode = selectedNodes[i];
                selectedNode.checked=false;
                $("#radio_" + selectedNode.id+"_"+selectedNode.pId).attr("checked", false);
                $("#checkbox_" + selectedNode.id+"_"+selectedNode.pId).attr("checked", false);
            }
        }
        
        
        function getCheckedBox(checkedName) {
            var r = document.getElementsByName(checkedName);
            for(var i=0; i<r.length; i++)    {
                if(r[i].checked)    {
                    return $(r[i]);
                }
            }
            return null;
        }

        function checkBrand(treeNode, btn) {
            if (btn.attr("checked")) {
                var isRootInChecked = isNodeInChecked(treeNode.rootId);
                if(!isRootInChecked){
                    beforeCheckAccessories();
                    treeNode.checked=true;
                }
                setParentNodeChecked(treeNode);
                setChildSelected(treeNode,btn,true);
            }else{
                treeNode.checked=false;
                setChildSelected(treeNode,btn,false);
            }
        }
        //复选框勾选时，将上级节点到根节点都勾选
        function setParentNodeChecked(treeNode) {
            var parentNode;
            if(treeNode==null){
                return true;
            }
            if(treeNode.getParentNode()!=null){
                    parentNode = treeNode.getParentNode();
                    $("#checkbox_" + parentNode.id+"_"+parentNode.pId).attr("checked", true);
                    parentNode.checked=true;
                    return setParentNodeChecked(parentNode);
            }else{
                var pObj = $("#radio_" + treeNode.id+"_"+treeNode.pId);
                if (!pObj.attr("checked")) {
                    treeNode.checked=true;
                    pObj.attr("checked", true);
                }
                return true;
            }
        }
        
    	function getNodesId(nodes){
			var nodesId = "";
			for(var node = 0; node < nodes.length; node++){
				nodesId += nodes[node].id+",";
			}
			return nodesId.substring(0,nodesId.length-1);
		}