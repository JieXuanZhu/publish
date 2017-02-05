package cn.com.shukaiken.util.tree.etree.old;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 */
public class ETreeNode implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer pid;
	private String text;
	private String iconCls;
	private String state;
	private String checked;
	private String target;
	private JSONObject attributes = new JSONObject();
	private List<ETreeNode> children = new ArrayList<ETreeNode>();

	public ETreeNode(Integer id, Integer pid, String text) {
		super();
		this.id = id;
		this.pid = pid;
		this.text = text;
	}

	public ETreeNode(Integer id, Integer pid, String text, String iconCls,
			String state, String checked, JSONObject attributes,
			List<ETreeNode> children) {
		super();
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.iconCls = iconCls;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
		this.children = children;
	}

	public ETreeNode(Integer id, Integer pid, String text, String iconCls,
			String state, String checked, String target, JSONObject attributes,
			List<ETreeNode> children) {
		super();
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.iconCls = iconCls;
		this.state = state;
		this.checked = checked;
		this.target = target;
		this.attributes = attributes;
		this.children = children;
	}

	public ETreeNode() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public JSONObject getAttributes() {
		return attributes;
	}

	public void setAttributes(JSONObject attributes) {
		this.attributes = attributes;
	}

	public List<ETreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<ETreeNode> children) {
		this.children = children;
	}
}
