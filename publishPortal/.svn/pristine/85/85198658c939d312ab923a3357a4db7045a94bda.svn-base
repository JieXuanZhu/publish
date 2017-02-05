package cn.com.shukaiken.util.tree.ztree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	protected String ID;

	protected String parentID;

	protected String name;

	protected String title;

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if ( !(other instanceof TreeNode) ) 
			return false;
		final TreeNode node = (TreeNode)other;
		if(node.getID() == null || !node.getID().equals(getID())) {
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		int result = 0;
		result += getID().hashCode()*27;
		return result;
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode();
		node1.setID("中国1");
		TreeNode node2 = new TreeNode();
		node2.setID("中国");
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes.add(node1);
//		System.out.println(nodes.contains(node2));
	}
}
