-- New script in locale_verbindung.
-- Date: 17.10.2023
-- Time: 13:01:38
USE TelRanHr;

-- найти среднюю зарплату для каждого job_id 
-- вывести поля 
-- job_id 
-- avg_salary
SELECT
	job_id,
	AVG(salary) AS avg_salary
FROM employees
GROUP BY job_id;

-- вывести сотрудников, у которых зарплата
-- равна минимальной
SELECT *
FROM employees
WHERE salary = (
	SELECT MIN(salary)  -- ONLY one field
	FROM employees
);

-- вывести имя и фамилию сотрудников с минимальной
-- зп в каждом job_id
SELECT e.first_name , e.last_name 
FROM employees AS e
INNER JOIN (
	SELECT 
		job_id,
		MIN(salary) AS min_salary 
	FROM employees
	GROUP BY job_id
) AS e2
ON e.job_id = e2.job_id
AND e.salary = e2.min_salary;

-- вывести manager_id и имя и фамилию подчиненного
-- с максимальной зп.
SELECT e.manager_id,
e.first_name,
e.last_name,
e.salary 
FROM employees AS e 
INNER JOIN (
	SELECT manager_id , MAX(salary) AS max_salary 
	FROM employees
	GROUP BY manager_id 
) AS e2
ON e.manager_id = e2.e2.manager_id
AND e.salary = e2.max_salary
ORDER BY e.manager_id;

-- доработать запрос и вывести имя и фамилию
-- менеджера 
-- и имя и фамилию подчиненного с максимальной зп
SELECT 
	e3.first_name AS manager_first_name,
	e3.last_name AS manager_last_name,
	e.first_name,
	e.last_name,
	e.salary 
FROM employees AS e 
INNER JOIN (
	SELECT manager_id , MAX(salary) AS max_salary 
	FROM employees
	GROUP BY manager_id 
) AS e2
ON e.manager_id = e2.manager_id
AND e.salary = e2.max_salary
LEFT JOIN employees AS e3
ON e.manager_id = e3.employee_id
ORDER BY e.manager_id;

-- вывести manager_id и кол-во сотрудников у
-- данного менеджера
SELECT e.manager_id, COUNT(*) AS cnt 
FROM employees AS e
WHERE e.manager_id IS NOT NULL
GROUP BY e.manager_id;


























