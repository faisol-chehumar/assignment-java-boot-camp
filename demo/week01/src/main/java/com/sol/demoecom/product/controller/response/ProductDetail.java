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

	@Override
	public String toString() {
		return "ProductDetail{" +
				"salePriceMin=" + salePriceMin +
				", images=" + images +
				", percentDiscountMax=" + percentDiscountMax +
				", rating=" + rating +
				", description='" + description + '\'' +
				", percentDiscountMin=" + percentDiscountMin +
				", variants=" + variants +
				", productNumber='" + productNumber + '\'' +
				", regularPriceMin=" + regularPriceMin +
				", salePriceMax=" + salePriceMax +
				", warrantyDays=" + warrantyDays +
				", name='" + name + '\'' +
				", attributes=" + attributes +
				", id='" + id + '\'' +
				", regularPriceMax=" + regularPriceMax +
				'}';
	}

	public int getSalePriceMin() {
		return salePriceMin;
	}

	public void setSalePriceMin(int salePriceMin) {
		this.salePriceMin = salePriceMin;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Object getPercentDiscountMax() {
		return percentDiscountMax;
	}

	public void setPercentDiscountMax(Object percentDiscountMax) {
		this.percentDiscountMax = percentDiscountMax;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getPercentDiscountMin() {
		return percentDiscountMin;
	}

	public void setPercentDiscountMin(Object percentDiscountMin) {
		this.percentDiscountMin = percentDiscountMin;
	}

	public List<VariantsItem> getVariants() {
		return variants;
	}

	public void setVariants(List<VariantsItem> variants) {
		this.variants = variants;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public int getRegularPriceMin() {
		return regularPriceMin;
	}

	public void setRegularPriceMin(int regularPriceMin) {
		this.regularPriceMin = regularPriceMin;
	}

	public int getSalePriceMax() {
		return salePriceMax;
	}

	public void setSalePriceMax(int salePriceMax) {
		this.salePriceMax = salePriceMax;
	}

	public int getWarrantyDays() {
		return warrantyDays;
	}

	public void setWarrantyDays(int warrantyDays) {
		this.warrantyDays = warrantyDays;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AttributesItem> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AttributesItem> attributes) {
		this.attributes = attributes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRegularPriceMax() {
		return regularPriceMax;
	}

	public void setRegularPriceMax(int regularPriceMax) {
		this.regularPriceMax = regularPriceMax;
	}
}