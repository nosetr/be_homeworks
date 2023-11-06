package com.nosetr._20231106.model;

/**
 * Задание 1: Сервис заказов с внешним API для проверки статуса платежа
 * Бизнес логика:
 * Order - класс заказа, содержащий данные о заказе.
 * PaymentService - сервис для обработки платежей, который взаимодействует с
 * внешним платежным API.
 * OrderService - сервис для управления заказами, который использует
 * PaymentService.
 */

public class Order {
	private String id;
	private double amount;
	private boolean isPaid;

	public Order(String id, double amount, boolean isPaid) {
		this.id = id;
		this.amount = amount;
		this.isPaid = isPaid;
	}

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public double getAmount() { return amount; }

	public void setAmount(double amount) { this.amount = amount; }

	public boolean isPaid() { return isPaid; }

	public void setPaid(boolean paid) { isPaid = paid; }
}
