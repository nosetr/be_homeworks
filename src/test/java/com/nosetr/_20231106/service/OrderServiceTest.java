package com.nosetr._20231106.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nosetr._20231106.model.Order;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
	
	@InjectMocks
	OrderService orderService;
	
	@Mock
	PaymentService paymentService;

	@BeforeEach
	void setUp() throws Exception {}

	@Test
	void testPlaceOrder() {
		Order order = new Order("1", 10.05, false);
		when(paymentService.processPayment(order))
			.thenReturn(true);
		
		Assertions.assertTrue(
				orderService.placeOrder(order));
		Assertions.assertTrue(order.isPaid());
	}

}
