package com.nosetr._20231106.implementation;

public interface EmailService {
    boolean sendEmail(String toAddress, String subject, String body);
}