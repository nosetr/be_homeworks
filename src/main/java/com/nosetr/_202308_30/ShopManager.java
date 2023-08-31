package com.nosetr._202308_30;

import com.nosetr._202308_30.enums.Currency;
import com.nosetr._202308_30.enums.ProductCategory;

/**
 * Service for shopping content
 */
public class ShopManager {
	private Product[] products = new Product[0];

	/**
	 * Helper to add one product with creating a new array
	 * 
	 * @param arr
	 * @param product
	 * @return
	 */
	private Product[] addToArrayHelper(Product[] arr, Product product) {
		int lng = arr.length;
		Product[] newProducts = new Product[lng + 1];

		for (int i = 0; i < lng; i++)
			newProducts[i] = arr[i];

		newProducts[lng] = product;

		return newProducts;
	}

	/**
	 * Add new product
	 * 
	 * @param product
	 */
	public void addProduct(Product product) {
		this.products = this.addToArrayHelper(this.products, product);
	}

	/**
	 * Return the whole list of the products
	 * 
	 * @return
	 */
	public Product[] getAllProducts() { return this.products; }

	/**
	 * Select only products with especial category
	 * 
	 * @param category
	 * @return
	 */
	public Product[] getProductsByCategory(ProductCategory category) {
		Product[] newProducts = new Product[0];

		for (Product product : this.products) {
			if (product.getCategory() == category) {
				newProducts = this.addToArrayHelper(newProducts, product);
			}
		}
		return newProducts;
	}
	
	/**
	 * Convert currency
	 * @param price
	 * @param currency
	 * @return
	 */
	private double convertHelper(double price, Currency currency) {
		double newPrice = price * currency.getConvert();
		return newPrice;
	}

	/**
	 * Get products by price and currency
	 * @param minPrice
	 * @param maxPrice
	 * @param currency
	 * @return
	 */
	public Product[] getProductsByPriceRange(double minPrice, double maxPrice, String curr) {
		Product[] newProducts = new Product[0];
		
		Currency currency = Currency.valueOf(curr);
		
		minPrice = convertHelper(minPrice, currency);
		maxPrice = convertHelper(maxPrice, currency);

		for (Product product : this.products) {
			double prodPrice = convertHelper(product.getPrice(), product.getCurrency());
			if (prodPrice >= minPrice && prodPrice <= maxPrice) {
				product.setCurrency(currency);
				product.setPrice(prodPrice);
				newProducts = this.addToArrayHelper(newProducts, product);
			}
		}
		return newProducts;
	}
}
