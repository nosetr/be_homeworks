CREATE TABLE IF NOT EXISTS customers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(128),
  last_name VARCHAR(128),
  email VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  date_of_birth DATETIME  NOT NULL,
  gender CHAR(1)  NOT NULL,
  loyalty_program_id integer,
  start_date DATETIME  NOT NULL
);



INSERT INTO customers (first_name, last_name, email, address, phone, date_of_birth, gender, loyalty_program_id, start_date)
VALUES
  ('John', 'Doe', 'johndoe@example.com', '123 Main St', '555-1234', '1980-01-01', 'M', 2, '2018-01-01'),
  ('Jane', 'Smith', 'janesmith@example.com', '456 Elm St', '555-5678', '1985-02-02', 'F', 4, '2019-03-15'),
  ('Michael', 'Johnson', 'michaeljohnson@example.com', '789 Oak St', '555-9012', '1990-03-03', 'M',NULL, '2020-05-10'),
  ('Emily', 'Williams', 'emilywilliams@example.com', '321 Pine St', '555-3456', '1995-04-04', 'F', 3, '2018-12-20'),
  ('David', 'Brown', 'davidbrown@example.com', '1111 Cedar St', '555-7890', '1982-05-05', 'M', 1, '2021-02-28'),
  ('Jennifer', 'Taylor', 'jennifertaylor@example.com', '2222 Maple St', '555-2345', '1987-06-06', 'F', 3, '2019-07-05'),
  ('Christopher', 'Davis', 'christopherdavis@example.com', '3333 Oak St', '555-6789', '1992-07-07', 'M', 2, '2020-09-12'),
  ('Jessica', 'Miller', 'jessicamiller@example.com', '4444 Pine St', '555-0123', '1997-08-08', 'F', NULL, '2021-11-19'),
  ('Matthew', 'Wilson', 'matthewwilson@example.com', '5555 Cedar St', '555-4567', '1984-09-09', 'M', 2, '2018-03-25'),
  ('Amanda', 'Anderson', 'amandaanderson@example.com', '6666 Maple St', '555-8901', '1989-10-10', 'F', NULL, '2019-06-30'),
  ('Andrew', 'Thomas', 'andrewthomas@example.com', '7777 Oak St', '555-2345', '1994-11-11', 'M', 1, '2020-08-07'),
  ('Olivia', 'Martinez', 'oliviamartinez@example.com', '8888 Elm St', '555-6789', '1999-12-12', 'F', NULL, '2021-10-14'),
  ('William', 'Jones', 'williamjones@example.com', '9999 Cedar St', '555-0123', '1983-01-15', 'M', 5, '2018-06-18'),
  ('Sophia', 'Garcia', 'sophiagarcia@example.com', '1010 Maple St', '555-4567', '1988-02-16', 'F', 3, '2019-09-25'),
  ('Alexander', 'Martinez', 'alexandermartinez@example.com', '1111 Oak St', '555-8901', '1993-03-17', 'M', 3, '2020-12-02'),
  ('Abigail', 'Brown', 'abigailbrown@example.com', '1212 Pine St', '555-2345', '1998-04-18', 'F', NULL, '2022-03-11'),
  ('James', 'Taylor', 'jamestaylor@example.com', '1313 Cedar St', '555-6789', '1985-05-19', 'M', 5, '2018-08-18'),
  ('Charlotte', 'Clark', 'charlotteclark@example.com', '1414 Elm St', '555-0123', '1990-06-20', 'F', 4, '2019-11-25'),
  ('Daniel', 'Lee', 'daniellee@example.com', '1515 Oak St', '555-4567', '1995-07-21', 'M', NULL, '2021-02-02'),
  ('Elizabeth', 'Walker', 'elizabethwalker@example.com', '1616 Pine St', '555-8901', '2000-08-22', 'F', 1, '2022-05-11'),
  ('Benjamin', 'Hall', 'benjaminhall@example.com', '1717 Cedar St', '555-2345', '1982-09-23', 'M', 4, '2018-10-20'),
  ('Mia', 'Young', 'miayoung@example.com', '1818 Maple St', '555-6789', '1987-10-24', 'F', NULL, '2019-01-27'),
  ('Liam', 'Walker', 'liamwalker@example.com', '1919 Elm St', '555-0123', '1992-11-25', 'M', 2, '2018-12-29'),
  ('Emma', 'Harris', 'emmaharris@example.com', '2020 Oak St', '555-4567', '1997-12-31', 'F', 1, '2019-04-05'),
  ('Noah', 'Clark', 'noahclark@example.com', '2121 Pine St', '555-8901', '1984-01-01', 'M', NULL, '2020-06-11'),
  ('Isabella', 'Hall', 'isabellahall@example.com', '2222 Cedar St', '555-2345', '1989-02-02', 'F', 2, '2021-08-19'),
  ('Oliver', 'Young', 'oliveryoung@example.com', '2323 Maple St', '555-6789', '1994-03-03', 'M', 2, '2018-10-27'),
  ('Sophia', 'Lopez', 'sophialopez@example.com', '2424 Elm St', '555-0123', '1999-04-04', 'F', NULL, '2019-01-02'),
  ('Lucas', 'Green', 'lucasgreen@example.com', '2525 Oak St', '555-4567', '1986-05-05', 'M', 3, '2020-03-10'),
  ('Ava', 'Lewis', 'avalewis@example.com', '2626 Pine St', '555-8901', '1991-06-06', 'F', NULL, '2021-05-18'),
  ('Mason', 'Jackson', 'masonjackson@example.com', '2727 Cedar St', '555-2345', '1996-07-07', 'M', 1, '2018-07-26'),
  ('Charlotte', 'Hill', 'charlottehill@example.com', '2828 Maple St', '555-6789', '2001-08-08', 'F', 3, '2019-10-02'),
  ('Elijah', 'Robinson', 'elijahrobinson@example.com', '2929 Elm St', '555-0123', '1983-09-09', 'M', 2, '2020-12-10'),
  ('Amelia', 'Carter', 'ameliacarter@example.com', '3030 Oak St', '555-4567', '1988-10-10', 'F', 3, '2022-02-18'),
  ('Harper', 'Phillips', 'harperphillips@example.com', '3131 Pine St', '555-8901', '1993-11-11', 'M', NULL, '2018-05-27'),
  ('Liam', 'Flores', 'liamflores@example.com', '3232 Cedar St', '555-2345', '1998-12-12', 'F', 4, '2019-08-03');

