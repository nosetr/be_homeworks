package com.nosetr._202308_30;

import java.text.DecimalFormat;

import com.nosetr._202308_30.enums.Currency;
import com.nosetr._202308_30.enums.ProductCategory;

public class Main {

	public static void main(String[] args) {
		ShopManager shopManager = new ShopManager();
		DecimalFormat df = new DecimalFormat("0.00");
		
		shopManager.addProduct(new Product( 1, "product1", ProductCategory.SHOES, 25.50, Currency.EUR));
		shopManager.addProduct(new Product( 2, "product2", ProductCategory.ACCESSORIES, 5.50, Currency.EUR));
		shopManager.addProduct(new Product( 3, "product3", ProductCategory.CLOTHING, 225.50, Currency.EUR));
		shopManager.addProduct(new Product( 4, "product4", ProductCategory.SHOES, 305.00, Currency.EUR));
		shopManager.addProduct(new Product( 5, "product5", ProductCategory.SHOES, 28.75, Currency.EUR));
		shopManager.addProduct(new Product( 6, "product6", ProductCategory.SHOES, 15.95, Currency.EUR));
		shopManager.addProduct(new Product( 7, "product7", ProductCategory.SHOES, 17.95, Currency.EUR));
		
		Product[] catProducts = shopManager.getProductsByCategory(ProductCategory.SHOES);
		for (Product product : catProducts) {
			System.out.println(product.getName() + " " + df.format(product.getPrice()) + product.getCurrency().getSymbolString()+ " " + product.getCategory());
		}
		System.out.println("");
		
		catProducts = shopManager.getProductsByPriceRange(10, 30, "USD");
		for (Product product : catProducts) {
			System.out.println(product.getName() + " " + df.format(product.getPrice()) + product.getCurrency().getSymbolString()+ " " + product.getCategory());
		}
	}

}
