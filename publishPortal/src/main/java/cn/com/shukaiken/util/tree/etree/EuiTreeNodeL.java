package cn.com.shukaiken.util.tree.etree;

import java.util.ArrayList;
import java.util.List;

import cn.com.shukaiken.util.tree.core.ITree;
import cn.com.shukaiken.util.tree.core.ITreeNode;

import com.alibaba.fastjson.JSONObject;

public class EuiTreeNodeL extends EuiTreeAttribute implements ITree<EuiTreeNodeL>, ITreeNode<Long>{
	private Long id;
	private Long pid;
	private JSONObject attributes;
	private List<EuiTreeNodeL> children;
	public Long getId() {
		return id;
	}
	public Long getPid() {
		return pid;
	}
	public JSONObject getAttributes() {
		return attributes;
	}
	public List<EuiTreeNodeL> getChildren() {
		return children;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	
	public void setAttributes(JSONObject attributes) {
		this.attributes = attributes;
	}
	public void setChildren(List<EuiTreeNodeL> children) {
		this.children = children;
	}
	public List<EuiTreeNodeL> convert(EuiTreeNodeL root, List<EuiTreeNodeL> nodes) {
		if(root == null){
			root = this;
		}
		EuiTreeNodeL node = new EuiTreeNodeL();
        List<EuiTreeNodeL> treelist = new ArrayList<EuiTreeNodeL>();
        List<EuiTreeNodeL> parentnodes = new ArrayList<EuiTreeNodeL>();
        
        if (nodes != null && nodes.size() > 0) {
            root = nodes.get(0) ;
            for (int i = 1; i < nodes.size(); i++) {
                node = (EuiTreeNodeL) nodes.get(i);
                if(node.getPid().equals(root.getId())){
                    parentnodes.add(node) ;
                    root.getChildren().add(node) ;
                }else{
                    getChildrenNodes(parentnodes, node);
                    parentnodes.add(node) ;
                }
            }    
        }
        treelist.add(root) ;
        return treelist ;		
	}
	
	private static void getChildrenNodes(List<EuiTreeNodeL> parentnodes, EuiTreeNodeL node) {
        for (int i = parentnodes.size() - 1; i >= 0; i--) {
        	EuiTreeNodeL pnode = parentnodes.get(i);
            if (pnode.getId().equals(node.getPid())) {
                pnode.setState("closed") ;
                pnode.getChildren().add(node) ;
                return ;
            } else {
                parentnodes.remove(i) ;
            }
        }
    }
	
	public static List<EuiTreeNodeL> buildtree(List<EuiTreeNodeL> nodes,Long id){
		List<EuiTreeNodeL> treeNodes=new ArrayList<EuiTreeNodeL>();
		for (EuiTreeNodeL treeNode : nodes) {
			EuiTreeNodeL node=new EuiTreeNodeL();
			node.setId(treeNode.getId());
			node.setPid(treeNode.getPid());
			node.setText(treeNode.getText());
			node.setChecked(treeNode.isChecked());
			node.setState(treeNode.getState());
			node.setIconCls(treeNode.getIconCls());
			node.setTarget(treeNode.getTarget());
			node.setAttributes(treeNode.getAttributes());
			
			if(id == treeNode.getPid()){
				node.setChildren(buildtree(nodes, node.getId()));
				treeNodes.add(node);
			}
		}
		return treeNodes;
	}
}
