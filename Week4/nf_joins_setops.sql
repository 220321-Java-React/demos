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

	  