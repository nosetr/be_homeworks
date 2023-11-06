package com.nosetr._20231106.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryServiceTest {

	InventoryService inventoryService;
	
	@BeforeEach
	void setUp() {
		inventoryService = new InventoryService();
	}

	@Test
	void testCheckProductStock() {
		// if key exists
		int exp = inventoryService.checkProductStock("ABC123");
		assertEquals(exp, 100);
		// if key not exists
		exp = inventoryService.checkProductStock("_");
		assertEquals(exp, 0);
	}

	@Test
	void testUpdateStock() {
		// Проверяем, существует ли продукт
		Assertions.assertFalse(inventoryService.updateStock("_", 1));

		// Проверяем, не становится ли новое количество отрицательным
		Assertions.assertFalse(inventoryService.updateStock("IJK654", -1000));
		
		// update whith success
		Assertions.assertTrue(inventoryService.updateStock("XYZ987", 100));
	}

}
