package com.nosetr._20231106.model;

/**
 * InventoryService управляет простой "базой данных" продуктов
 * ключ — это SKU продукта
 * значение — количество товара на складе.
 * updateStock учитывает возможность, что обновление запасов не должно привести к отрицательному количеству товара.
 *
 * OrderFulfillmentService использует InventoryService для проверки и
 * обновления запасов при выполнении заказа.
 * Если запасы достаточны, заказ выполняется и запасы обновляются.
 * returnItemsToInventory может использоваться для возврата товаров на склад,
 * что увеличивает количество запасов для данного SKU.
 */
public class Product {
    private String sku; // Stock Keeping Unit - уникальный идентификатор продукта
    private int stockQuantity;

    public Product(String sku, int stockQuantity) {
        this.sku = sku;
        this.stockQuantity = stockQuantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
