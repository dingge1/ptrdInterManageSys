package com.huihuan.gmp.vo;

import java.util.ArrayList;
import java.util.List;

public class ComboboxTreeVo {
	private String id;
	private String text;
	private boolean checked;
	private String state;
	private List<ComboboxTreeVo> children=new ArrayList<ComboboxTreeVo>();
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<ComboboxTreeVo> getChildren() {
		return children;
	}
	public void setChildren(List<ComboboxTreeVo> children) {
		this.children = children;
	}
	
}
