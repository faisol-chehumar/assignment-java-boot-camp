package com.sol.demoecom.product.controller.response;

import java.util.List;

public class ProductDetail {
	private int salePriceMin;
	private List<String> images;
	private Object percentDiscountMax;
	private Rating rating;
	private String description;
	private Object percentDiscountMin;
	private List<VariantsItem> variants;
	private String productNumber;
	private int regularPriceMin;
	private int salePriceMax;
	private int warrantyDays;
	private String name;
	private List<AttributesItem> attributes;
	private String id;
	private int regularPriceMax;

	public int getSalePriceMin(){
		return salePriceMin;
	}

	public List<String> getImages(){
		return images;
	}

	public Object getPercentDiscountMax(){
		return percentDiscountMax;
	}

	public Rating getRating(){
		return rating;
	}

	public String getDescription(){
		return description;
	}

	public Object getPercentDiscountMin(){
		return percentDiscountMin;
	}

	public List<VariantsItem> getVariants(){
		return variants;
	}

	public String getProductNumber(){
		return productNumber;
	}

	public int getRegularPriceMin(){
		return regularPriceMin;
	}

	public int getSalePriceMax(){
		return salePriceMax;
	}

	public int getWarrantyDays(){
		return warrantyDays;
	}

	public String getName(){
		return name;
	}

	public List<AttributesItem> getAttributes(){
		return attributes;
	}

	public String getId(){
		return id;
	}

	public int getRegularPriceMax(){
		return regularPriceMax;
	}
}