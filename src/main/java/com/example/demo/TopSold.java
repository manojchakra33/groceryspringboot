package com.example.demo;

import lombok.Data;


public class TopSold {
	private int productId;
	private String productName;
	private int totalSold;
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the totalSold
	 */
	public int getTotalSold() {
		return totalSold;
	}
	/**
	 * @param totalSold the totalSold to set
	 */
	public void setTotalSold(int totalSold) {
		this.totalSold = totalSold;
	}

}
