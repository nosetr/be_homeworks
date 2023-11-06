package com.nosetr._20231106.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nosetr._20231106.model.Product;

@ExtendWith(MockitoExtension.class)
class OrderFulfillmentServiceTest {

	@InjectMocks
	OrderFulfillmentService orderFulfillmentService;

	@Mock
	InventoryService inventoryService;

	@Test
	void fulfill_order_quantity_lower_as_stock_whith_error() {
		Product product = Mockito.mock(Product.class);
		int quantity = product.getStockQuantity();
		// stock == quantity
		Assertions.assertEquals(inventoryService.checkProductStock(product.getSku()), quantity);
		// stock < quantity
		Assertions.assertFalse(orderFulfillmentService.fulfillOrder(product, ++quantity));
	}

	@Test
	void fulfill_order_quantity_equal_stock_whith_error() {
		Product product = new Product("ABC123", 100);
		int quantity = product.getStockQuantity();

		when(inventoryService.checkProductStock(product.getSku())).thenReturn(quantity);

		// stock == quantity
		Assertions.assertEquals(inventoryService.checkProductStock(product.getSku()), quantity);

		doReturn(false).when(inventoryService).updateStock(product.getSku(), -quantity);

		Assertions.assertFalse(orderFulfillmentService.fulfillOrder(product, quantity));

	}

	@Test
	void test_fulfill_order_whith_success() {
		Product product = new Product("ABC123", 10);
		int quantity = product.getStockQuantity();
		// check if product.getStockQuantity() == 10
		Assertions.assertEquals(10, product.getStockQuantity());

		when(inventoryService.checkProductStock(product.getSku())).thenReturn(quantity);

		// stock == quantity
		Assertions.assertEquals(inventoryService.checkProductStock(product.getSku()), quantity);

		doReturn(true).when(inventoryService).updateStock(product.getSku(), -quantity);

		Assertions.assertTrue(orderFulfillmentService.fulfillOrder(product, quantity));
		// check if product.getStockQuantity() == (stock - quantity)
		int exp = 0;
		Assertions.assertEquals(exp, product.getStockQuantity());
	}

	@Test
	void testReturnItemsToInventory() {
		Product product = new Product("ABC123", 10);
		// check if stock == 10
		Assertions.assertEquals(10, product.getStockQuantity());

		int quantity = product.getStockQuantity();

		doReturn(true).when(inventoryService).updateStock(product.getSku(), quantity);
		Assertions.assertTrue(orderFulfillmentService.returnItemsToInventory(product, quantity));
		// check if stock == 10 * 2
		int exp = 20;
		Assertions.assertEquals(exp, product.getStockQuantity());
	}

}
