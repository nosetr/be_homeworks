-- New script in locale_verbindung.
-- Date: 19.10.2023
-- Time: 10:01:43

/*
**Создание таблиц**

1) создать таблицу Students

с полями:
- id целое число первичный ключ автоинкремент
- name строка 128 не null
- age целое число

2) создать таблицу Teachers

с полями:
- id целое число первичный ключ автоинкремент
- name строка 128 не null
- age целое число

3) создать таблицу Competencies

с полями:
- id целое число первичный ключ автоинкремент
- title строка 128 не null

4) создать таблицу Teachers2Competencies

с полями:
- id целое число первичный ключ автоинкремент
- teacher_id целое число
- competencies_id целое число

5) создать таблицу Courses

- id целое число первичный ключ автоинкремент
- teacher_id целое число
- title строка 128 не null
- headman_id целое число

6) создать таблицу Students2Courses

- id целое число первичный ключ автоинкремент
- student_id целое число
- course_id целое число
*/
CREATE DATABASE TelRanUniversity;

USE TelRanUniversity;

create table Students(
 id integer primary key auto_increment,
    name varchar(128) not null,
    age integer
);

create table Teachers(
 id integer primary key auto_increment,
    name varchar(128) not null,
    age integer
);

create table Competencies(
 id integer primary key auto_increment,
    title varchar(128) not null
);

create table Teachers2Competencies(
 id integer primary key auto_increment,
    teacher_id integer,
    competencies_id integer
);

create table Courses(
 id integer primary key auto_increment,
    teacher_id integer,
    title varchar(128) not null,
    headman_id integer
);

create table Students2Courses(
 id integer primary key auto_increment,
    student_id integer,
    course_id integer
);

insert into Students (name, age) values ('Анатолий', 29);
insert into Students (name, age) values ('Олег', 25);
insert into Students (name, age) values ('Семен', 27);
insert into Students (name, age) values ('Олеся', 28);
insert into Students (name, age) values ('Ольга', 31);
insert into Students (name, age) values ('Иван', 22);

insert into Teachers (name, age) values ('Петр', 39);
insert into Teachers (name, age) values ('Максим', 35);
insert into Teachers (name, age) values ('Антон', 37);
insert into Teachers (name, age) values ('Всеволод', 38);
insert into Teachers (name, age) values ('Егор', 41);
insert into Teachers (name, age) values ('Светлана', 32);

insert into Competencies (title) values ('Математика');
insert into Competencies (title) values ('Информатика');
insert into Competencies (title) values ('Программирование');
insert into Competencies (title) values ('Графика');

insert into Teachers2Competencies (teacher_id, competencies_id) values (1, 1);
insert into Teachers2Competencies (teacher_id, competencies_id) values (2, 1);
insert into Teachers2Competencies (teacher_id, competencies_id) values (2, 3);
insert into Teachers2Competencies (teacher_id, competencies_id) values (3, 2);
insert into Teachers2Competencies (teacher_id, competencies_id) values (4, 1);
insert into Teachers2Competencies (teacher_id, competencies_id) values (5, 3);

insert into Courses (teacher_id, title, headman_id) values (1, 'Алгебра логики', 2);
insert into Courses (teacher_id, title, headman_id) values (2, 'Математическая статистика', 3);
insert into Courses (teacher_id, title, headman_id) values (4, 'Высшая математика', 5);
insert into Courses (teacher_id, title, headman_id) values (5, 'Javascript', 1);
insert into Courses (teacher_id, title, headman_id) values (5, 'Базовый Python', 1);

insert into Students2Courses (student_id, course_id) values (1, 1);
insert into Students2Courses (student_id, course_id) values (2, 1);
insert into Students2Courses (student_id, course_id) values (3, 2);
insert into Students2Courses (student_id, course_id) values (3, 3);
insert into Students2Courses (student_id, course_id) values (4, 5);

-- 1. Ввыести имена студентов и название курсов,
--    которые они посещают
SELECT s.name , c.title 
FROM Students AS s 
LEFT JOIN Students2Courses AS sc 
ON s.id = sc.student_id 
LEFT JOIN Courses AS c 
ON sc.course_id = c.id;

-- 2. Вывести имена студентов, которые посещают курс
-- Алгебра логики и Базовый Python
SELECT s.name
FROM Students AS s 
INNER JOIN Students2Courses AS sc 
ON s.id = sc.student_id 
INNER JOIN Courses AS c 
ON sc.course_id = c.id
WHERE c.title IN ("Алгебра логики", "Базовый Python");

-- 3. Выведите имена всех преподавателей с их компетенциями.
-- Если у преподавтеля нет компетенций, то вывести для него
-- null
SELECT t.name, c.title 
FROM Teachers AS t 
LEFT JOIN Teachers2Competencies AS tc 
ON t.id = tc.teacher_id 
LEFT JOIN Competencies AS c 
ON tc.competencies_id = c.id;

-- 4. Найти имена студентов, которые не посещают ни
-- одного курса (использовать один join)
SELECT s.name 
FROM Students AS s 
LEFT JOIN Students2Courses AS sc 
ON s.id = sc.student_id
WHERE sc.course_id IS NULL;

-- 5. Найти имена  преподавателей, у которых нет компетенций
SELECT t.name 
FROM Teachers AS t 
LEFT JOIN Teachers2Competencies AS tc 
ON t.id = tc.teacher_id 
WHERE tc.competencies_id IS NULL ;
-- The same whith inner-select:
SELECT name 
FROM Teachers
WHERE id NOT IN (
	SELECT teacher_id 
	FROM Teachers2Competencies
);

-- ДЗ
-- 1. выведите название курса и имя старосты
SELECT c.title, s.name 
FROM Courses AS c 
LEFT JOIN Students AS s 
ON c.headman_id = s.id;

-- 2. выведите имя студента и имена старост, которые
-- есть на курсах, которые он проходит
SELECT s.name, s2.name AS headman
FROM Students AS s
INNER JOIN Students2Courses AS sc
ON sc.student_id = s.id
INNER JOIN Courses AS c 
ON c.id = sc.course_id
INNER JOIN Students AS s2
ON c.headman_id = s2.id;














