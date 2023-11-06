package com.nosetr._20231106.implementation;

import com.nosetr._20231106.model.Order;

public interface ExternalPaymentApi {
    boolean requestPayment(Order order);
    boolean verifyPayment(String orderId);
}