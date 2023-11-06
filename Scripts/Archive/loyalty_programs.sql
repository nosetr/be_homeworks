CREATE TABLE IF NOT EXISTS loyalty_programs (
  id INT AUTO_INCREMENT PRIMARY KEY,
  program_name VARCHAR(255) NOT NULL,
  discount DECIMAL(5,2) NOT NULL
);

INSERT INTO loyalty_programs (program_name, discount)
VALUES
  ('Bronze', 5),
  ('Silver', 10),
  ('Gold', 15),
  ('Platinum', 20),
  ('Diamond', 25);