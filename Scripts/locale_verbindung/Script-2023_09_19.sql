-- New script in locale_verbindung.
-- Date: 19.09.2023
-- Time: 13:36:46
CREATE database TelRanHr;

USE TelRanHr;

CREATE TABLE users(
	first_name varchar(128),
	last_name varchar(128),
	age int,
	salary int
);

INSERT INTO users (first_name, last_name, age, salary)
 values('Анатолий', 'Ушанов', 32, 16000);
INSERT INTO users (first_name, last_name, age, salary)
 values('Максим', 'Грибов', 31, 15000);
INSERT INTO users (first_name, last_name, age, salary)
 values('Антон', 'Куликов', 34, 13000);
INSERT INTO users (first_name, last_name, age, salary)
 values('Юрий', 'Митрофанов', 45, 22000);
INSERT INTO users (first_name, last_name, age, salary)
 values('Ольга', 'Иванова', 37, 15000);

/*
 * вывести пользователей, у которых возраст больше 34 
 * и зп меньше 17000
 */
SELECT * FROM users AS u 
WHERE age > 34 AND salary < 17000;

/*
 * вывести пользователей у которых фамилия кончается на "ов"
 * и зп от 15000 до 16000
 */
SELECT * FROM users AS u
WHERE last_name LIKE  '%ов'
AND salary BETWEEN 15000 AND 16000;

DROP TABLE students ;

CREATE TABLE students(
	first_name varchar(128),
	last_name varchar(128),
	age int,
	avg_mark double(3,2),
	group_num int DEFAULT 1,
	active_flg char(1) DEFAULT 'Y'
);

INSERT INTO students(first_name, last_name,
age,avg_mark)
values ('John', 'Tysen', 25, 2.5);
INSERT INTO students(last_name, first_name, 
age,avg_mark)
values ('Twen', 'Mark', 250, 4.7);
INSERT INTO students(last_name, first_name, 
age,avg_mark, group_num)
values ('Maus', 'Micke', 150, 1.7, 2);
INSERT INTO students(last_name, first_name, 
age,avg_mark, group_num, active_flg)
values ('Mason', 'Merlin', 47, 0.3, 3, 'N');


















