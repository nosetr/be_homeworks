-- New script in locale_verbindung.
-- Date: 12.10.2023
-- Time: 10:01:48
USE TelRanHr;

-- Durchschnitliches Verdienst
SELECT AVG(salary)
FROM employees;

SELECT min(min_salary) AS min_salary 
FROM jobs;

-- найти кол-во не null значений в поле commission_pct
SELECT COUNT(commission_pct)
FROM employees;

-- найти job_title с минимальным min_salary
SELECT job_title 
FROM jobs
WHERE min_salary = (
	SELECT MIN(min_salary)  -- ONLY one field
	FROM jobs
);

-- Alle Abteilungen mit Personal ausgeben
SELECT department_name
FROM departments
WHERE department_id IN (
	SELECT DISTINCT department_id 
	FROM employees
);

-- Alle Abteilungen ohne Personal ausgeben
SELECT department_name
FROM departments
WHERE department_id NOT IN (
	SELECT DISTINCT department_id 
	FROM employees
	-- NULL muss auch ausgenohmen werden,
	-- ansonst kommt leere Ausgabe
	WHERE department_id IS NOT NULL  
);

-- вывести имя и фамилию сотрудника 
-- с максимальной зп
SELECT e.first_name , e.last_name 
FROM employees AS e 
WHERE e.salary = (
	SELECT MAX(e2.salary)
	FROM employees AS e2 
); 

-- вывести имя и фамилию сотрудников у которых зп
-- больше средней
SELECT e.first_name , e.last_name 
FROM employees AS e 
WHERE e.salary > (
	SELECT AVG(e2.salary)
	FROM employees AS e2 
); 












