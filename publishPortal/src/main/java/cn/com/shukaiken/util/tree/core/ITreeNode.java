package cn.com.shukaiken.util.tree.core;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public interface ITreeNode<T extends Serializable> {
	public T getId();

	public T getPid();

	public JSONObject getAttributes();

	public void setId(T id);

	public void setPid(T pid);

	public void setAttributes(JSONObject attributes);
}
