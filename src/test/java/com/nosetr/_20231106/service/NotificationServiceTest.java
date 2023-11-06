package com.nosetr._20231106.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nosetr._20231106.implementation.EmailService;
import com.nosetr._20231106.model.User;
import com.nosetr._20231106.service.NotificationService;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

	String subject;

	String message;
	
	@InjectMocks
	NotificationService notificationService;

	@Mock
	User user;
	
	@Mock
	EmailService emailService;
	
	@BeforeEach
	void setUp() throws Exception {
		subject = "subject";
		message = "message";
	}

	@Test
	void notifyUserTrueTest() {
		User user = Mockito.mock(User.class);
		Assertions.assertFalse(notificationService.notifyUser(user, subject, message));
		verify(emailService).sendEmail(user.getEmail(), subject, message);
	}
}

