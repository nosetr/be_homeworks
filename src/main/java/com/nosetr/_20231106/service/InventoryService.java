package com.nosetr._20231106.service;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
  private Map<String, Integer> productStockDatabase = new HashMap<>();

  public InventoryService() {
      // Инициализация некоторыми тестовыми данными
      productStockDatabase.put("ABC123", 100);
      productStockDatabase.put("XYZ987", 200);
      productStockDatabase.put("IJK654", 150);
  }

  public int checkProductStock(String sku) {
      return productStockDatabase.getOrDefault(sku, 0);
  }

  public boolean updateStock(String sku, int quantityChange) {
      // Проверяем, существует ли продукт
      if (!productStockDatabase.containsKey(sku)) {
          return false;
      }
      int currentStock = productStockDatabase.get(sku);
      int newStock = currentStock + quantityChange;
      // Проверяем, не становится ли новое количество отрицательным
      if (newStock < 0) {
          return false;
      }
      productStockDatabase.put(sku, newStock);
      return true;
  }
}
