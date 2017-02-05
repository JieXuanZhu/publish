package cn.com.shukaiken.util.tree.ztree;


import java.util.ArrayList;
import java.util.List;

/**
 * 通用的树形结构
 * 
 * @author zhhd
 * 
 * @param <T>
 * 
 */
public class TreeNodeO<T> {
	private T value;
	private TreeNodeO<T> parent;
	private List<TreeNodeO<T>> children;

	public TreeNodeO(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public TreeNodeO<T> getParent() {
		return parent;
	}

	public void setParent(TreeNodeO<T> parent) {
		this.parent = parent;
	}

	/**
	 * 增加子节点
	 * 
	 * @param node
	 */
	public void addChild(TreeNodeO<T> node) {
		if (children == null)
			children = new ArrayList<TreeNodeO<T>>();

		children.add(node);
	}

	/**
	 * 得到直接下级的节点列表
	 * 
	 * @return
	 */
	public List<TreeNodeO<T>> getChildren() {
		return children;
	}

	/**
	 * 得到所有的子节点列表（递归向上）
	 * 
	 * @return
	 */
	public List<TreeNodeO<T>> getAllChildren() {
		if (isLeaf())
			return null;

		List<TreeNodeO<T>> list = new ArrayList<TreeNodeO<T>>();
		list.addAll(children);
		for (TreeNodeO<T> node : children) {
			if (!node.isLeaf())
				list.addAll(node.getAllChildren());
		}
		return list;
	}

	/**
	 * 得到所有的父节点列表（递归向上）
	 * 
	 * @return
	 */
	public List<TreeNodeO<T>> getAllParent() {
		List<TreeNodeO<T>> list = new ArrayList<TreeNodeO<T>>();
		if (parent != null && parent != this) {
			list.add(parent);
			list.addAll(parent.getAllParent());
		}
		return list;
	}
	/**
	 * 返回树的宽度，每个节点占一个宽度单位
	 * 
	 * @return
	 */
	public int getTreeWidth() {
		if (isLeaf()) {
			return 1;
		}
		int width = 0;
		for (TreeNodeO<T> node : children) {
			width += node.getTreeWidth();
		}
		return width;
	}

	/**
	 * 返回树的深度
	 * 
	 * @return
	 */
	public int getTreeDepth() {
		if (isLeaf())
			return 1;
		int maxDepth = 0;
		for (TreeNodeO<T> node : children) {
			int depth = node.getTreeDepth();
			if (depth > maxDepth)
				maxDepth = depth;
		}
		maxDepth = maxDepth + 1;
		return maxDepth;
	}

	/**
	 * 是否是树叶，没有子节点的为树叶
	 * 
	 * @return
	 */
	public boolean isLeaf() {
		return children == null || children.size() == 0;
	}
}
