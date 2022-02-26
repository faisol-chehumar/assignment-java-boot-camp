package com.sol.demoecom.product.controller.response;

import java.util.List;

public class Rating {
	private double ratingStar;
	private List<Integer> ratingCount;

	public double getRatingStar(){
		return ratingStar;
	}

	public List<Integer> getRatingCount(){
		return ratingCount;
	}

	public void setRatingStar(double ratingStar) {
		this.ratingStar = ratingStar;
	}

	public void setRatingCount(List<Integer> ratingCount) {
		this.ratingCount = ratingCount;
	}
}