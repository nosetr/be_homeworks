-- New script in locale_verbindung.
-- Date: 21.09.2023
-- Time: 09:42:56
USE TelRan2;

DROP TABLE students;

CREATE TABLE students (
	id int NOT NULL,
	first_name varchar(64),
	last_name varchar(64) NOT NULL UNIQUE,
	avg_score numeric(4,2) DEFAULT 50.00,
	gender char(1),
	PRIMARY KEY (id, last_name)
);

CREATE TABLE students (
	id int PRIMARY KEY,
	first_name varchar(64),
	last_name varchar(64),
	avg_score numeric(4,2) DEFAULT 50.00,
	gender char(1) CHECK (gender IN('M', 'F')),
	age int CHECK (age >= 18)
);

CREATE TABLE students (
	id int auto_increment,
	first_name varchar(64),
	last_name varchar(64),
	avg_score numeric(4,2) DEFAULT 50.00,
	gender char(1) CHECK (gender IN('M', 'F')),
	age int CHECK (age >= 18),
	PRIMARY KEY (id)
);

INSERT INTO students (id, last_name, gender, age)
VALUES (3, 'Ivanova', 'f', 55);

INSERT INTO students (id, first_name, last_name,
avg_score, gender)
VALUES (2, 'Ivan', 'Petrov', 54.72, 'M'),
(3, 'Boris', 'Sidorov', 54.72, 'M'),
(4, 'Irina', 'Ushanova', 54.72, 'M'),
(5, 'Anna', 'Gribov', 54.72, 'M');

-- Einige Daten nach ID aus der Tabele löschen
DELETE FROM students 
WHERE id IN (2,4);

-- Alle Daten löschen
DELETE FROM students;
SET sql_safe_updates = 0;

-- Tabele leeren + AutoInc == 0
TRUNCATE students;

DROP TABLE goods;

-- ПРАКТИКА
-- 1. Создать таблицу goods (товары) с полями:

-- id (первичный ключ, авто инкеремент)
-- title (cтрока максимум 30 символов)
-- quantity (целое число больше 0)
-- price (число макс 7 символов, 2 из которых после точки)
-- in_stock (символ (Y/N))
CREATE TABLE goods(
	id int PRIMARY KEY AUTO_INCREMENT,
	title varchar(30),
	quantity int CHECK(quantity > 0),
	price numeric(7,2),
	in_stock char(1) CHECK(in_stock IN('Y','N')) DEFAULT 'Y'
);

-- 2. Заполните созданную таблицу данными, минимум 5 строк
INSERT INTO goods (title,quantity,price)
	VALUES ('Proba1', 5, 12345.67),
	('Proba2', 5, 12345.67),
	('Proba3', 5, 12345.67),
	('Proba4', 5, 12345.67),
	('Proba5', 5, 12345.67);








