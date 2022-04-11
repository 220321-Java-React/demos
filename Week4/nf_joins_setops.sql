--This SQL script will demonstrate Normal Forms

--Then we'll get into joins, and set operations

--I might also fit a transaction in here (TCL)



--A table in 1st Normal Form
--Tables must have a primary key (can be a composite key)
--Columns must be atomic (you should only have one piece of data within each cell)

--ben should have split up real_name into first_name and last_name for atomicity, but he forgot :O

CREATE TABLE avengers (
	hero_name TEXT,
	hero_power TEXT,
	real_name TEXT,
	home_base TEXT,
	street_address TEXT, --usually, if you aren't doing math operations on a column, you should make it text, not int
	PRIMARY KEY (hero_name, real_name) --composite key!!! Don't do this lol just showing it for the sake of 1NF.
);

INSERT INTO avengers (hero_name, hero_power, real_name, home_base, street_address)
VALUES ('Spiderman', 'Webby boi', 'Peter Parker', 'His Aunt''s house', '35 street street'),
	   ('Spiderman', 'Webby boi', 'Miles Morales', 'His Aunt''s house', '35 street street'),
		--To put an apostrophe in a text type, you need two single quotes.
		--Note how everything in the spidermen records are identical except for real_name. This is legal in 1NF
	   ('Kawaiiman', 'Weeby boi', 'Jake Mockler', 'His House', '123 Jake street');

SELECT * FROM avengers;

DROP TABLE avengers;

--2NF
--Remove Partial Dependencies, which can be done with a unique primary key (to uniquely identify each row)

CREATE TABLE avengers (
	hero_id serial PRIMARY KEY, --no more composite key, each record will be identified by a number 
	hero_name TEXT,
	hero_power TEXT,
	first_name TEXT,
	last_name TEXT,
	home_base TEXT,
	street_address TEXT --usually, if you aren't doing math operations on a column, you should make it text, not int
);

INSERT INTO avengers (hero_name, hero_power, first_name, last_name, home_base, street_address)
VALUES ('Spiderman', 'Webby boi', 'Peter', 'Parker', 'His Aunt''s house', '35 street street'),
	   ('Spiderman', 'Webby boi', 'Miles', 'Morales', 'His Aunt''s house', '35 street street'),
	   ('Kawaiiman', 'Weeby boi', 'Jake', 'Mockler', 'His House', '123 Jake street');
	  
SELECT * FROM avengers;

DROP TABLE avengers;

--3NF 
--Remove Transitive Dependencies (by separating them out into new tables)
--home data doesn't really belong in the avengers table... it would be better practice to have two different tables

--create homes first, since avengers depend on the homes table to exist (every avenger has a home)

CREATE TABLE homes (
	home_id serial PRIMARY KEY,
	home_base TEXT,
	street_address TEXT
);

INSERT INTO homes (home_base, street_address)
VALUES ('Stark Tower', '1 Stark way'),
	   ('Sanctum Sanctorum', '77 Sanctum st'),
	   ('Avengers Tower', '690 10th ave');

SELECT * FROM homes;
	  

CREATE TABLE avengers (
	hero_id serial PRIMARY KEY, --no more composite key, each record will be identified by a number 
	hero_name TEXT,
	hero_power TEXT,
	first_name TEXT,
	last_name TEXT,
	home_base_id_fk int REFERENCES homes(home_id)
);

INSERT INTO avengers (hero_name, hero_power, first_name, last_name, home_base_id_fk)
VALUES ('Spiderman', 'Webby boi', 'Peter', 'Parker', 1),
	   ('Spiderman', 'Webby boi', 'Miles', 'Morales', 1),
	   ('Kawaiiman', 'Weeby boi', 'Jake', 'Mockler', 3),
	   ('Doctor Strange', 'got those light zoopy zoop things that do stuff and spells', 'Benedict', 'Cumberbatch', 2);

SELECT * FROM avengers;
	  
--cool, this database schema is now fully 3NF (which is what we want, and what your P0 databases will be).

--(Joins)-----------------------------------------------------------------------------------------

--Remember, joins are necessary if we want to SELECT data from multiple tables. Multi-table queries!

--one more INSERT statement for each table to better understand left/right joins 
INSERT INTO avengers (hero_name, hero_power, first_name, last_name)
VALUES ('Hancock', 'he tries his best', 'Will', 'Smith');

INSERT INTO homes (home_base, street_address)
VALUES ('Some Pizza Joint', '456 MammaMia way');

--note the keywords:
--we specify the type of join, and what table and column we're joining ON.

--INNER JOIN
--returns all records with matching data (from the PK/FK) in both tables
SELECT * FROM avengers INNER JOIN homes ON home_id = home_base_id_fk;
--"Select every piece of data from avengers and homes where the home_id match"
--Notice we don't get Hancock, because his record has no home_base_id_fk

--FULL OUTER JOIN
--returns all record from both tables no matter what
SELECT * FROM avengers FULL OUTER JOIN homes ON home_id = home_base_id_fk;

--LEFT OUTER JOIN
--return everything in the left table, and matching records in the right table
SELECT * FROM avengers LEFT OUTER JOIN homes ON home_id = home_base_id_fk;

--RIGHT OUTER JOIN
--return everything in the right table, and matching records in the left table
SELECT * FROM avengers RIGHT OUTER JOIN homes ON home_id = home_base_id_fk;

--Joins are how we make our select statement include more data (spanning multiple tables)
--we can select * from avengers, but that only gives us the id of their home base
--what if we want each avenger and all the data of the home base they live at? better use a join!

--(Set Operations)-----------------------------------------------------------------------------





	  