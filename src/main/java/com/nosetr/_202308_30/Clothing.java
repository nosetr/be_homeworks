package com.nosetr._202308_30;

import com.nosetr._202308_30.enums.Currency;
import com.nosetr._202308_30.enums.ProductCategory;
import com.nosetr._202308_30.enums.Size;

public class Clothing extends Product {

	public Size size;

	public Clothing(long id, String name, ProductCategory category, double price, Currency currency, Size size) {
		super(id, name, category, price, currency);
		this.size = size;
	}

	
}
