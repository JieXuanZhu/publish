package cn.com.shukaiken.util.tree.etree;

import java.util.ArrayList;
import java.util.List;

import cn.com.shukaiken.util.tree.core.ITree;
import cn.com.shukaiken.util.tree.core.ITreeNode;

import com.alibaba.fastjson.JSONObject;

public class EuiTreeNodeS extends EuiTreeAttribute implements ITree<EuiTreeNodeS>, ITreeNode<String> {
	private String id;
	private String pid;
	private JSONObject attributes;
	private List<EuiTreeNodeS> children;

	public EuiTreeNodeS() {
		super();
	}

	public EuiTreeNodeS(String id, String pid) {
		super();
		this.id = id;
		this.pid = pid;
	}

	public EuiTreeNodeS(String id, String pid, List<EuiTreeNodeS> children) {
		super();
		this.id = id;
		this.pid = pid;
		this.children = children;
	}

	public EuiTreeNodeS(String id, String pid, JSONObject attributes) {
		super();
		this.id = id;
		this.pid = pid;
		this.attributes = attributes;
	}

	public EuiTreeNodeS(String id, String pid, JSONObject attributes,
			List<EuiTreeNodeS> children) {
		super();
		this.id = id;
		this.pid = pid;
		this.attributes = attributes;
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public String getPid() {
		return pid;
	}

	public JSONObject getAttributes() {
		return attributes;
	}

	public List<EuiTreeNodeS> getChildren() {
		return children;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setAttributes(JSONObject attributes) {
		this.attributes = attributes;
	}

	public void setChildren(List<EuiTreeNodeS> children) {
		this.children = children;
	}

	public List<EuiTreeNodeS> convert(EuiTreeNodeS root,
			List<EuiTreeNodeS> nodes) {
		if (root == null) {
			root = this;
		}
		EuiTreeNodeS node = new EuiTreeNodeS();
		List<EuiTreeNodeS> treelist = new ArrayList<EuiTreeNodeS>();
		List<EuiTreeNodeS> parentnodes = new ArrayList<EuiTreeNodeS>();

		if (nodes != null && nodes.size() > 0) {
			root = nodes.get(0);
			for (int i = 1; i < nodes.size(); i++) {
				node = (EuiTreeNodeS) nodes.get(i);
				if (node.getPid().equals(root.getId())) {
					parentnodes.add(node);
					root.getChildren().add(node);
				} else {
					getChildrenNodes(parentnodes, node);
					parentnodes.add(node);
				}
			}
		}
		treelist.add(root);
		return treelist;
	}

	private static void getChildrenNodes(List<EuiTreeNodeS> parentnodes,
			EuiTreeNodeS node) {
		for (int i = parentnodes.size() - 1; i >= 0; i--) {
			EuiTreeNodeS pnode = parentnodes.get(i);
			if (pnode.getId().equals(node.getPid())) {
				pnode.setState("closed");
				pnode.getChildren().add(node);
				return;
			} else {
				parentnodes.remove(i);
			}
		}
	}

	public static List<EuiTreeNodeS> buildtree(List<EuiTreeNodeS> nodes,
			String id) {
		List<EuiTreeNodeS> treeNodes = new ArrayList<EuiTreeNodeS>();
		for (EuiTreeNodeS treeNode : nodes) {
			EuiTreeNodeS node = new EuiTreeNodeS();
			node.setId(treeNode.getId());
			node.setPid(treeNode.getPid());
			node.setText(treeNode.getText());
			node.setChecked(treeNode.isChecked());
			node.setState(treeNode.getState());
			node.setIconCls(treeNode.getIconCls());
			node.setTarget(treeNode.getTarget());
			node.setAttributes(treeNode.getAttributes());
			
			if ((id).equals(treeNode.getPid())) {
				node.setChildren(buildtree(nodes, node.getId()));
				treeNodes.add(node);
			}
		}
		return treeNodes;
	}
}
