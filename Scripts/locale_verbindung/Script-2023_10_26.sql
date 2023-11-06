-- New script in locale_verbindung.
-- Date: 26.10.2023
-- Time: 09:44:48
CREATE DATABASE TelRanShop;

USE TelRanShop;

CREATE TABLE SELLERS(
       SELL_ID    INTEGER, 
       SNAME   VARCHAR(20), 
       CITY    VARCHAR(20), 
       COMM    NUMERIC(2, 2),
             BOSS_ID  INTEGER
);
                                            
CREATE TABLE CUSTOMERS(
       CUST_ID    INTEGER, 
       CNAME   VARCHAR(20), 
       CITY    VARCHAR(20), 
       RATING  INTEGER
);

CREATE TABLE ORDERS(
       ORDER_ID  INTEGER, 
       AMT     NUMERIC(7,2), 
       ODATE   DATE, 
       CUST_ID    INTEGER,
       SELL_ID    INTEGER 
);

INSERT INTO SELLERS VALUES(201,'Олег','Москва',0.12,202);
INSERT INTO SELLERS VALUES(202,'Лев','Сочи',0.13,204);
INSERT INTO SELLERS VALUES(203,'Арсений','Владимир',0.10,204);
INSERT INTO SELLERS VALUES(204,'Екатерина','Москва',0.11,205);
INSERT INTO SELLERS VALUES(205,'Леонид ','Казань',0.15,NULL);


INSERT INTO CUSTOMERS VALUES(301,'Андрей','Москва',100);
INSERT INTO CUSTOMERS VALUES(302,'Михаил','Тула',200);
INSERT INTO CUSTOMERS VALUES(303,'Иван','Сочи',200);
INSERT INTO CUSTOMERS VALUES(304,'Дмитрий','Ярославль',300);
INSERT INTO CUSTOMERS VALUES(305,'Руслан','Москва',100);
INSERT INTO CUSTOMERS VALUES(306,'Артём','Тула',100);
INSERT INTO CUSTOMERS VALUES(307,'Юлия','Сочи',300);


INSERT INTO ORDERS VALUES(101,18.69,'2022-03-10',308,207);
INSERT INTO ORDERS VALUES(102,5900.1,'2022-03-10',307,204);
INSERT INTO ORDERS VALUES(103,767.19,'2022-03-10',301,201);
INSERT INTO ORDERS VALUES(104,5160.45,'2022-03-10',303,202);
INSERT INTO ORDERS VALUES(105,1098.16,'2022-03-10',308,207);
INSERT INTO ORDERS VALUES(106,75.75,'2022-04-10',304,202); 
INSERT INTO ORDERS VALUES(107,4723,'2022-05-10',306,201);
INSERT INTO ORDERS VALUES(108,1713.23,'2022-04-10',302,203);
INSERT INTO ORDERS VALUES(109,1309.95,'2022-06-10',304,203);
INSERT INTO ORDERS VALUES(110,9891.88,'2022-06-10',306,201);


-- 1. Выведите список имен покупателей, которые совершили
-- покупку. 
-- Предусмотрите в выборке номер заказа.
-- В выборке должно присутствовать два атрибута — cname,
-- order_id.
SELECT c.CNAME
FROM CUSTOMERS AS c
LEFT JOIN ORDERS AS o
ON o.CUST_ID = c.CUST_ID
WHERE  o.ORDER_ID IS null;


-- 2. Выведите список имен всех покупателей (вне зависимости
-- от того совершили они покупку или нет). 
-- Предусмотрите в выборке номер заказа.
-- В выборке должно присутствовать два атрибута — cname,
-- order_id.
SELECT c.CNAME, o.ORDER_ID 
FROM CUSTOMERS AS c
LEFT JOIN ORDERS AS o
ON o.CUST_ID = c.CUST_ID;

-- 3. Выведите список имен покупателей, продавцов и итоговую
-- сумму заказа.
-- В выборке должны присутствовать три атрибута — cname, sname,
-- amt.
SELECT c.CNAME AS customer,
	s.SNAME AS saller,
	o.AMT AS price
FROM CUSTOMERS AS c
LEFT JOIN ORDERS AS o
ON o.CUST_ID = c.CUST_ID
LEFT JOIN SELLERS AS s
ON o.SELL_ID = s.SELL_ID;

-- 4. Выведите имена покупателей, которые сделали заказ. 
-- Предусмотрите в выборке также имена продавцов.
-- Примечание: покупатели и продавцы должны быть из разных
-- городов.
-- В выборке должно присутствовать два атрибута — cname, sname.
SELECT  c.CNAME AS customer,
	s.SNAME AS saller,
	o.ORDER_ID
FROM CUSTOMERS AS c
LEFT JOIN ORDERS AS o
ON o.CUST_ID = c.CUST_ID
LEFT JOIN SELLERS AS s
ON o.SELL_ID = s.SELL_ID
WHERE c.CITY NOT LIKE s.CITY;

-- ----::::PESOCHNIZA::::----
-- 5. Найти кол-во покупателей
select
 count(*) as customers_cnt
from customers;
/*
update customers
set age = null
where customer_id = 5;
*/
-- 6. Найти всех покупателей, чей возраст равен минимальному
select
 first_name,
    last_name,
    age
from customers
where age = (select min(age) from customers);

-- 7. Найти покупателей из USA и UK, чей возраст выше среднего
select
 first_name,
    last_name,
    age
from customers
where country in ('USA', 'UK')
and age > (select avg(age) from customers);

-- ПРАКТИКА (БД hr)
USE TelRanHr;

-- 1. Найти сотрудников (имя, фамилия, зп), которые
-- зарабатывают меньше всех / чья зп равна минимальной
SELECT first_name,
	last_name,
	salary
FROM employees
WHERE salary = (
	SELECT min(salary)
	FROM employees
);

-- 2. Найти сотрудников (имя, фамилия, зп), которые
-- работают в департаментах 90, 100, 110 и 60 и зарабатывают
-- меньше среднего по компании
SELECT first_name,
	last_name,
	salary
FROM employees
WHERE salary < (
	SELECT avg(salary)
	FROM employees
)
AND department_id IN (90, 100, 110, 60);

-- 3. Найти сотрудников (имя, фамилия, зп), которые работают
-- в департаментах 'Executive', 'Finance', 'Accounting' и 'IT' 
-- и зарабатывают меньше среднего по компании
SELECT first_name,
	last_name,
	salary
FROM employees
WHERE salary < (
	SELECT avg(salary)
	FROM employees
)
AND department_id IN (
	SELECT department_id
	FROM departments
	WHERE department_name
	IN ("Executive","Finance","Accounting","IT")
);
-- mit join:
SELECT e.first_name,
	e.last_name,
	e.salary
FROM employees AS e
INNER JOIN departments AS d
ON e.department_id = d.department_id
WHERE e.salary < (
	SELECT avg(salary)
	FROM employees
)
AND d.department_name
	IN ("Executive","Finance","Accounting","IT");































