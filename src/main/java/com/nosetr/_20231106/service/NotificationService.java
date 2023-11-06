package com.nosetr._20231106.service;

import com.nosetr._20231106.implementation.EmailService;
import com.nosetr._20231106.model.User;

public class NotificationService implements EmailService{
    private EmailService emailService;

    @Override
    public boolean sendEmail(String toAddress, String subject, String body) {
        return false;
    }

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public boolean notifyUser(User user, String subject, String message) {
        return emailService.sendEmail(user.getEmail(), subject, message);
    }
}