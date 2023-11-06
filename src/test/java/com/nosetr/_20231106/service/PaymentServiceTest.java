package com.nosetr._20231106.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nosetr._20231106.implementation.ExternalPaymentApi;
import com.nosetr._20231106.model.Order;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
	@InjectMocks
	PaymentService paymentService;
	
	@Mock
	ExternalPaymentApi paymentApi;

	@BeforeEach
	void setUp() throws Exception {}

	@Test
	void testProcessPayment() {
		Order order = new Order("1", 10.05, false);
		when(paymentApi.requestPayment(order))
			.thenReturn(true);
		
		doReturn(true).when(paymentApi)
			.verifyPayment(order.getId());
		
		Assertions.assertTrue(
				paymentService.processPayment(order));
	}

}
