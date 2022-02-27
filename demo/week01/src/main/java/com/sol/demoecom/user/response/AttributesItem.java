package com.sol.demoecom.user.response;

import java.util.List;

public class AttributesItem{
	private String name;
	private List<String> value;

	public AttributesItem() {
	}

	public AttributesItem(String name, List<String> value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}
}