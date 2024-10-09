package com.delight.inventory_management.dto;

public class RestockPlanDTO {

	private int productId;
	private double recommendedQuantity;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getRecommendedQuantity() {
		return recommendedQuantity;
	}

	public void setRecommendedQuantity(double recommendedQuantity) {
		this.recommendedQuantity = recommendedQuantity;
	}

	public RestockPlanDTO(int productId, double recommendedQuantity) {
		this.productId = productId;
		this.recommendedQuantity = recommendedQuantity;
	}

	public RestockPlanDTO() {
	}

	@Override
	public String toString() {
		return "RestockPlanDTO [productId=" + productId + ", recommendedQuantity=" + recommendedQuantity + "]";
	}

}
