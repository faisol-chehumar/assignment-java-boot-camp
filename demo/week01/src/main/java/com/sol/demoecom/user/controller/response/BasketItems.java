package com.sol.demoecom.user.controller.response;

import java.util.List;
import java.util.UUID;

public class BasketItems {
	private UUID productSkuId;
	private String sku;
	private int quantity;
	private int regularPrice;
	private int salePrice;
	private String image;
	private int percentDiscount;
	private List<AttributesItem> attributes;
	private List<Integer> attributeIndex;

	public BasketItems() {
	}

	public BasketItems(int regularPrice, String image, int quantity, UUID productSkuId, int percentDiscount, List<AttributesItem> attributes, String sku, List<Integer> attributeIndex, int salePrice) {
		this.regularPrice = regularPrice;
		this.image = image;
		this.quantity = quantity;
		this.productSkuId = productSkuId;
		this.percentDiscount = percentDiscount;
		this.attributes = attributes;
		this.sku = sku;
		this.attributeIndex = attributeIndex;
		this.salePrice = salePrice;
	}

	public int getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(int regularPrice) {
		this.regularPrice = regularPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public UUID getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(UUID productSkuId) {
		this.productSkuId = productSkuId;
	}

	public int getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

	public List<AttributesItem> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AttributesItem> attributes) {
		this.attributes = attributes;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public List<Integer> getAttributeIndex() {
		return attributeIndex;
	}

	public void setAttributeIndex(List<Integer> attributeIndex) {
		this.attributeIndex = attributeIndex;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
}