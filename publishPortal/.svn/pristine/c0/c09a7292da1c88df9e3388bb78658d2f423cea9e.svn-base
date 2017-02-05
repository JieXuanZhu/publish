package cn.com.shukaiken.util.tree.etree;

import cn.com.shukaiken.util.tree.core.ITree;
import cn.com.shukaiken.util.tree.core.ITreeFactory;

public class EuiTreeFactory extends ITreeFactory {
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ITree<?>> T newTree(Class<T> c) {
		T treeNode = null;
		try {
			treeNode = (T) Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treeNode;
	}
}
