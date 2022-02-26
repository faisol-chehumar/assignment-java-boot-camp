package com.sol.demoecom.product.controller.response;

import java.util.List;

public class VariantsItem{
	private String productSkuId;
	private int regularPrice;
	private String image;
	private int unitInStock;
	private int percentDiscount;
	private String sku;
	private List<Integer> attributeIndex;
	private int salePrice;

	@Override
	public String toString() {
		return "VariantsItem{" +
				"productSkuId='" + productSkuId + '\'' +
				", regularPrice=" + regularPrice +
				", image='" + image + '\'' +
				", unitInStock=" + unitInStock +
				", percentDiscount=" + percentDiscount +
				", sku='" + sku + '\'' +
				", attributeIndex=" + attributeIndex +
				", salePrice=" + salePrice +
				'}';
	}

	public String getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(String productSkuId) {
		this.productSkuId = productSkuId;
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

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public int getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
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