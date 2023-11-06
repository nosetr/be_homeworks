package com.nosetr._20231106.service;

import com.nosetr._20231106.model.Order;

public class OrderService {
	private PaymentService paymentService;

	public OrderService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public boolean placeOrder(Order order) {
		boolean paymentProcessed = paymentService.processPayment(order);
		if (paymentProcessed) {
			order.setPaid(true);
		}
		return paymentProcessed;
	}
}