package com.nosetr._20231108;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class MainTest {
	@InjectMocks
	Main main;

	@BeforeEach
	void setUp() throws Exception {}

	@Test
	void testCheckPosition() {
		fail("Not yet implemented");
	}

	@Test
	void testFirstPosition() {
		Assertions.assertFalse(main.firstPosition("RLUDLU"));
		Assertions.assertTrue(main.firstPosition("RLUD"));
	}

	@Test
	void testCountChars() {
		fail("Not yet implemented");
	}

}
