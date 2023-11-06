-- New script in locale_verbindung.
-- Date: 10.10.2023
-- Time: 13:15:39
USE TelRanHr;

-- написать запрос, который выводит имя и 
-- фамилию сотрудника и название его
-- должности (job_title)
SELECT e.first_name , e.last_name, j.job_title  
FROM employees AS e
INNER JOIN jobs AS j 
ON e.job_id = j.job_id ;

-- вывести значения разницы min_salary
-- с зарплатой 
-- и max_salary с зарплатой
SELECT e.salary - j.min_salary AS min_delta,
j.max_salary - e.salary AS max_delta
FROM employees AS e
INNER JOIN jobs AS j 
ON e.job_id = j.job_id ;

-- сформировать поле happy_flg 
-- если min_delta меньше, чем max_delta, 
-- то happy_flg принимает 1
-- в ином случае 0
SELECT e.first_name , e.last_name,
CASE 
	WHEN salary < 10000 THEN 1
	WHEN salary < 15000 THEN 2
	ELSE 3
END AS salary_group
FROM employees AS e ;

-- написать запрос, который выводит название
-- департамента, название города и страны,
-- в которых департамент находится
SELECT d.department_name , l.city , c.country_name 
FROM departments AS d 
LEFT JOIN locations AS l 
ON d.location_id = l.location_id 
LEFT JOIN countries AS c 
ON c.country_id = l.country_id ;


-- доработать запрос таким образом, чтобы вывелись регионы
SELECT d.department_name , l.city , c.country_name,
r.region_name 
FROM departments AS d 
LEFT JOIN locations AS l 
ON d.location_id = l.location_id 
LEFT JOIN countries AS c 
ON c.country_id = l.country_id
LEFT JOIN regions AS r
ON r.region_id = c.region_id;


SELECT d.department_name 
FROM departments AS d 
LEFT JOIN employees AS e 
ON d.department_id = e.department_id 
WHERE e.employee_id IS NULL ;
















