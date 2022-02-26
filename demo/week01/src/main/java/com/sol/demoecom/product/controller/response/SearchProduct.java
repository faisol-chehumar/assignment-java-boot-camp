package com.sol.demoecom.product.controller.response;

import java.util.List;

public class SearchProduct {
	private int totalCount;
	private int count;
	private List<ProductsItem> products;

	public SearchProduct(int totalCount, int count, List<ProductsItem> products) {
		this.totalCount = totalCount;
		this.count = count;
		this.products = products;
	}

	@Override
	public String toString() {
		return "SearchProduct{" +
				"totalCount=" + totalCount +
				", count=" + count +
				", products=" + products +
				'}';
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<ProductsItem> getProducts() {
		return products;
	}

	public void setProducts(List<ProductsItem> products) {
		this.products = products;
	}
}