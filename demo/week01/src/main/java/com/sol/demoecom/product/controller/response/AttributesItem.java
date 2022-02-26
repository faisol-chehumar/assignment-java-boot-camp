package com.sol.demoecom.product.controller.response;

import java.util.List;

public class AttributesItem{
	private String name;
	private List<String> value;

	@Override
	public String toString() {
		return "AttributesItem{" +
				"name='" + name + '\'' +
				", value=" + value +
				'}';
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