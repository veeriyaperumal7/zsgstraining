package com.veeriyaperumal.onlineshopping.model;

public class Product {

	private long productId;
	private String productName;
	private float price;
	private String unit;
	private int quantity;

	public Product() {

	}

	public Product(long productId, String productName, float price, String unit, int quantityAvailable) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.unit = unit;
		this.quantity = quantityAvailable;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
