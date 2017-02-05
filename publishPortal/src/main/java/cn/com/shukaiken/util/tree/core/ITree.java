package cn.com.shukaiken.util.tree.core;

import java.util.List;


public interface ITree<T> {
	public List<T> getChildren();
	public void setChildren(List<T> children);
	public List<T> convert(T root, List<T> nodes);
}
