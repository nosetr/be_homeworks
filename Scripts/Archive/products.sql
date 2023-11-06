
CREATE TABLE IF NOT EXISTS products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price DECIMAL(8,2) NOT NULL,
  description TEXT,
  supplier_id integer,
  amount INTEGER,
  in_stoke CHAR(1)
);


-- Добавление 30 продуктов в таблицу products
INSERT INTO products (name, price, description, supplier_id, amount, in_stoke)
VALUES
  ('T-shirt', 19.99, 'A comfortable and stylish t-shirt for everyday wear.', 3, 100, 'Y'),
  ('Jeans', 49.99, 'High-quality jeans that provide both style and comfort.', 3, 50, 'Y'),
  ('Sneakers', 79.99, 'Trendy sneakers with excellent cushioning and support.', 2, 75, 'Y'),
  ('Watch', 129.99, 'A sleek and elegant watch that complements any outfit.', 1, 30, 'Y'),
  ('Backpack', 39.99, 'A durable and spacious backpack for all your travel needs.', 2, 0, 'N'),
  ('Headphones', 89.99, 'Wireless headphones with noise-cancellation technology.', 2, 50, 'Y'),
  ('Laptop', 999.99, 'A powerful and versatile laptop for work and entertainment.', 2, 10, 'Y'),
  ('Smartphone', 799.99, 'The latest smartphone with advanced features and a stunning display.', 3, 15, 'Y'),
  ('Camera', 499.99, 'A high-resolution camera for capturing your most memorable moments.', 2, 25, 'Y'),
  ('Speaker', 149.99, 'A portable speaker that delivers rich and immersive sound.', 4, 40, 'Y'),
  ('Dress', 69.99, 'An elegant dress for special occasions and formal events.', 2, 60, 'Y'),
  ('Suit', 199.99, 'A well-tailored suit that exudes sophistication and style.', 1, 30, 'Y'),
  ('Running Shoes', 89.99, 'Lightweight and supportive running shoes for optimal performance.', 4, 0, 'N'),
  ('Guitar', 299.99, 'A versatile guitar that produces rich and vibrant tones.', 5, 15, 'Y'),
  ('Hiking Boots', 119.99, 'Sturdy and comfortable hiking boots for outdoor adventures.', 1, 25, 'Y'),
  ('Perfume', 59.99, 'A captivating fragrance that leaves a lasting impression.', 3, 50, 'Y'),
  ('Cosmetic Set', 79.99, 'A collection of high-quality cosmetics for a complete makeup look.', 4, 40, 'Y'),
  ('Sports Bag', 29.99, 'A spacious sports bag to carry your gear in style.', 4, 0, 'N'),
  ('Wristwatch', 149.99, 'A classic wristwatch that adds a touch of elegance to any outfit.', 3, 20, 'Y'),
  ('Sunglasses', 39.99, 'Stylish sunglasses that provide UV protection and a fashionable look.', 3, 60, 'Y'),
  ('Wallet', 49.99, 'A sleek and functional wallet to keep your essentials organized.', 2, 35, 'Y'),
  ('Fitness Tracker', 79.99, 'A wearable device that monitors your fitness and tracks your progress.', 3, 45, 'Y'),
  ('Yoga Mat', 24.99, 'A comfortable and non-slip yoga mat for your workout sessions.', 5, 50, 'Y'),
  ('Cookware Set', 199.99, 'A comprehensive set of high-quality cookware for your kitchen.', 5, 10, 'Y'),
  ('Vacuum Cleaner', 149.99, 'A powerful vacuum cleaner that makes cleaning effortless.', 2, 20, 'Y'),
  ('Tennis Racket', 79.99, 'A lightweight and durable tennis racket for improved performance.', 1, 30, 'Y'),
  ('Dumbbell Set', 99.99, 'A set of adjustable dumbbells for strength training at home.', 3, 15, 'Y'),
  ('Smart TV', 799.99, 'A smart TV with a high-resolution display and built-in streaming services.', 2, 0, 'N'),
  ('Digital Camera', 599.99, 'An advanced digital camera with professional-level features.', 4, 10, 'Y'),
  ('Hair Dryer', 49.99, 'A high-performance hair dryer for fast and efficient drying.', 1, 30, 'Y');
