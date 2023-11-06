package com.nosetr._20231106.service;

import com.nosetr._20231106.model.Product;

public class OrderFulfillmentService {
  private InventoryService inventoryService;

  public OrderFulfillmentService(InventoryService inventoryService) {
      this.inventoryService = inventoryService;
  }

  public boolean fulfillOrder(Product product, int quantity) {
      String sku = product.getSku();
      int stock = inventoryService.checkProductStock(sku);
      if (stock >= quantity) {
          boolean stockUpdated = inventoryService.updateStock(sku, -quantity);
          if (stockUpdated) {
              product.setStockQuantity(stock - quantity);
          }
          return stockUpdated;
      }
      return false;
  }

  public boolean returnItemsToInventory(Product product, int quantity) {
      String sku = product.getSku();
      boolean stockUpdated = inventoryService.updateStock(sku, quantity);
      if (stockUpdated) {
          product.setStockQuantity(product.getStockQuantity() + quantity);
      }
      return stockUpdated;
  }
}
