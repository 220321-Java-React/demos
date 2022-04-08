--This schema will model Krusty Krab employees and their roles

--This will be a one to many relationship, one role can be assigned to many employees, employees can only have one role.

CREATE TABLE roles (
	role_id serial PRIMARY KEY,
	role_title TEXT,
	role_salary int
);


CREATE TABLE employees (
	employee_id serial PRIMARY KEY,
	first_name TEXT,
	last_name TEXT,
	role_id_fk int REFERENCES roles (role_id) --foreign key: establishes a relationship between the tables
);

--I've created my tables, now I just want to put some data in

INSERT INTO roles (role_title, role_salary)
VALUES ('Manager', 100000),
	   ('Fry Cook', 25000),
	   ('Cashier', 20000),
	   ('Marketing Director', 100000);
	  
SELECT * FROM roles;

INSERT INTO employees (first_name, last_name, role_id_fk)
VALUES ('Eugene', 'Krabs', 1),
	   ('Spongebob', 'Squarepants', 2),
	   ('Pete', 'Fishman', 2),
	   ('Squidward', 'Tentacles', 3),
	   ('Sheldon', 'Plankton', 4);
	   
SELECT * FROM employees;




