package com.nosetr._20231206.taski;

import java.util.List;

// Нарушение SOLID: Нарушение принципа единственной ответственности
public class Order {
	private List<Item> items;

	public void addItem(Item item) {
		// Добавление товара
	}

	public void calculateTotal() {
		// Вычисление общей стоимости заказа
	}

	public void printInvoice() {
		// Печать счета
	}
}

/**
 * My solution:
 */
class OrderMy {
	private List<Item> items;

	public void addItem(Item item) {
		// Добавление товара
	}
}

class OrderCalc {

	public void calculateTotal() {
		// Вычисление общей стоимости заказа
	}

}

class OrderPrintt {

	public void printInvoice() {
		// Печать счета
	}

}

record Item() {}
