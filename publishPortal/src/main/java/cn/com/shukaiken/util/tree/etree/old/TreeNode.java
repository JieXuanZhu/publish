package cn.com.shukaiken.util.tree.etree.old;

import java.util.List;

public class TreeNode {
	private String id;
	private String text;
	private List<TreeNode> childList;
	private TreeNode parent;
	private int level;
	private boolean isLeaf;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<TreeNode> getChildList() {
		return childList;
	}
	public void setChildList(List<TreeNode> childList) {
		this.childList = childList;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public TreeNode() {}
	public TreeNode(String id, String text, String pid,
			List<TreeNode> childList, TreeNode parent, int level, boolean isLeaf) {
		this.id = id;
		this.text = text;
		this.childList = childList;
		this.parent = parent;
		this.level = level;
		this.isLeaf = isLeaf;
	}
	
	
}
