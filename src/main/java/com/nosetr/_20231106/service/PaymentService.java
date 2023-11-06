package com.nosetr._20231106.service;

import com.nosetr._20231106.implementation.ExternalPaymentApi;
import com.nosetr._20231106.model.Order;

public class PaymentService {
	private ExternalPaymentApi paymentApi;

	public PaymentService(ExternalPaymentApi paymentApi) {
		this.paymentApi = paymentApi;
	}

	public boolean processPayment(Order order) {
		return paymentApi.requestPayment(order) && paymentApi.verifyPayment(order.getId());
	}
}