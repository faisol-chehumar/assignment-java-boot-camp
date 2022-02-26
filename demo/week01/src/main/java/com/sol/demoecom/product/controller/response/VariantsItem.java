package com.sol.demoecom.product.controller.response;

import java.util.List;

public class VariantsItem{
	private int regularPrice;
	private String image;
	private int unitInStock;
	private int percentDiscount;
	private String sku;
	private List<Integer> attributeIndex;
	private int salePrice;

	public int getRegularPrice(){
		return regularPrice;
	}

	public String getImage(){
		return image;
	}

	public int getUnitInStock(){
		return unitInStock;
	}

	public int getPercentDiscount(){
		return percentDiscount;
	}

	public String getSku(){
		return sku;
	}

	public List<Integer> getAttributeIndex(){
		return attributeIndex;
	}

	public int getSalePrice(){
		return salePrice;
	}
}