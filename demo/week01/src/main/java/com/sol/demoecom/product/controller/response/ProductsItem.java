package com.sol.demoecom.product.controller.response;

public class ProductsItem {
	private String id;
	private String name;
	private String image;
	private int regularPriceMin;
	private int regularPriceMax;
	private int percentDiscountMin;
	private int percentDiscountMax;
	private int salePriceMin;
	private int salePriceMax;
	private String shopLocation;
	private double ratingStar;

	@Override
	public String toString() {
		return "ProductsItem{" +
				"image='" + image + '\'' +
				", salePriceMin=" + salePriceMin +
				", rating=" + ratingStar +
				", regularPriceMin=" + regularPriceMin +
				", regularSalePrice=" + regularPriceMax +
				", salePriceMax=" + salePriceMax +
				", name='" + name + '\'' +
				", shopLocation='" + shopLocation + '\'' +
				", percentDiscountMin=" + percentDiscountMin +
				", percentDiscountMax=" + percentDiscountMax +
				", id='" + id + '\'' +
				'}';
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSalePriceMin() {
		return salePriceMin;
	}

	public void setSalePriceMin(int salePriceMin) {
		this.salePriceMin = salePriceMin;
	}

	public double getRatingStar() {
		return ratingStar;
	}

	public void setRatingStar(double ratingStar) {
		this.ratingStar = ratingStar;
	}

	public int getRegularPriceMin() {
		return regularPriceMin;
	}

	public int getPercentDiscountMax() {
		return percentDiscountMax;
	}

	public void setPercentDiscountMax(int percentDiscountMax) {
		this.percentDiscountMax = percentDiscountMax;
	}

	public void setRegularPriceMin(int regularPriceMin) {
		this.regularPriceMin = regularPriceMin;
	}

	public int getRegularPriceMax() {
		return regularPriceMax;
	}

	public void setRegularPriceMax(int regularPriceMax) {
		this.regularPriceMax = regularPriceMax;
	}

	public int getSalePriceMax() {
		return salePriceMax;
	}

	public void setSalePriceMax(int salePriceMax) {
		this.salePriceMax = salePriceMax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShopLocation() {
		return shopLocation;
	}

	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}

	public int getPercentDiscountMin() {
		return percentDiscountMin;
	}

	public void setPercentDiscountMin(int percentDiscountMin) {
		this.percentDiscountMin = percentDiscountMin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
