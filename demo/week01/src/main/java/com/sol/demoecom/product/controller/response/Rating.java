package com.sol.demoecom.product.controller.response;

public class Rating{
	private double ratingStar;
	private int ratingCount;

	@Override
	public String toString() {
		return "Rating{" +
				"ratingStar=" + ratingStar +
				", ratingCount=" + ratingCount +
				'}';
	}

	public double getRatingStar(){
		return ratingStar;
	}

	public int getRatingCount(){
		return ratingCount;
	}

	public void setRatingStar(double ratingStar) {
		this.ratingStar = ratingStar;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}
}
