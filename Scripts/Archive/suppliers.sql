CREATE TABLE IF NOT EXISTS suppliers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone VARCHAR(20) NOT NULL
);

-- Добавление 5 записей в таблицу suppliers
INSERT INTO suppliers (name, email, phone)
VALUES
  ('ABC Distributors', 'abc.distributors@example.com', '456-7890'),
  ('Global Imports', 'global.imports@example.com', '654-3210'),
  ('Quality Goods Co.', 'quality.goods@example.com', '789-0123'),
  ('Preferred Supplies', 'preferred.supplies@example.com', '345-6789'),
  ('Elite Trading', 'elite.trading@example.com', '555-8901');
