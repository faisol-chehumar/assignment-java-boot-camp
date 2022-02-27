package com.sol.demoecom.user.response;

import java.util.ArrayList;
import java.util.List;

public class MyBasket {
	private int subTotal = 0;
	private List<BasketItems> items = new ArrayList<>();

	public MyBasket() {
	}

	public MyBasket(int subTotal, List<BasketItems> items) {
		this.subTotal = subTotal;
		this.items = items;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public List<BasketItems> getItems() {
		return items;
	}

	public void setItems(List<BasketItems> items) {
		this.items = items;
	}
}