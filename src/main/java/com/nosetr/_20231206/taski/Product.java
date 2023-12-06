package com.nosetr._20231206.taski;

public class Product {
    private String name;
    private double price;
    
    public void saveToDatabase() {
        // Сохранение товара в базу данных
    }
    
    public void generateInvoice() {
        // Генерация счета для товара
    }
    
    // Избыточный метод, который не связан с товаром
    public void sendEmailConfirmation() {
        // Отправка электронного письма с подтверждением
    }
}

/**
 * My solution:
 */
class ProductMy {
    private String name;
    private double price;
    
    public void saveToDatabase() {
        // Сохранение товара в базу данных
    }
    
    public void generateInvoice() {
        // Генерация счета для товара
    }
}

class Email {
	
	// Избыточный метод, который не связан с товаром
	public void sendEmailConfirmation() {
		// Отправка электронного письма с подтверждением
	}
	
}