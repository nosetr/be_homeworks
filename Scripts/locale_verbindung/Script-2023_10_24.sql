-- New script in locale_verbindung.
-- Date: 24.10.2023
-- Time: 13:04:41
CREATE DATABASE TelRanShop_2;

USE TelRanShop_2;

-- написать запрос, который выводит first_name, last_name
-- и order_id (идентификатор заказа)
SELECT c.first_name, c.last_name, o.id 
FROM orders AS o
LEFT JOIN customers AS c
ON o.customer_id = c.id;

-- написать запрос, который выводит first_name, last_name
-- и product_id (идентификатор продукта)
SELECT c.first_name, c.last_name, od.product_id 
FROM customers AS c 
LEFT JOIN orders AS o 
ON c.id = o.customer_id 
LEFT JOIN order_details AS od 
ON o.id = od.order_id;

-- написать запрос, который выводит first_name, last_name
-- и название продукта.
SELECT c.first_name, c.last_name, p.name 
FROM customers AS c 
LEFT JOIN orders AS o 
ON c.id = o.customer_id 
LEFT JOIN order_details AS od 
ON o.id = od.order_id
LEFT JOIN products AS p
ON od.product_id = p.id;

-- используя LEFT JOIN найти покупателей, которые не сделали
-- ни одного заказа
SELECT c.first_name, c.last_name
FROM customers AS c 
LEFT JOIN orders AS o 
ON c.id = o.customer_id
WHERE o.id IS NULL;

-- найти товары, которые ни разу не заказывали
SELECT p.name
FROM products AS p 
LEFT JOIN order_details AS od
ON od.product_id = p.id
WHERE od.id IS NULL;






















