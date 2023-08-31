package com.nosetr._202308_30;

import com.nosetr._202308_30.enums.Currency;
import com.nosetr._202308_30.enums.ProductCategory;

public class Product {
	private long id;
	private String name;
	private ProductCategory category;
	private double price;
	private Currency currency;

	public Product(long id, String name, ProductCategory category, double price, Currency currency) {
		this.setId(id);
		this.setName(name);
		this.setCategory(category);
		this.setPrice(price);
		this.setCurrency(currency);
	}

	public long getId() { return id; }

	public void setId(long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public ProductCategory getCategory() { return category; }

	public void setCategory(ProductCategory category) { this.category = category; }

	public double getPrice() { return price; }

	public void setPrice(double price) { this.price = price; }

	public Currency getCurrency() { return currency; }

	public void setCurrency(Currency currency) { this.currency = currency; }

}
