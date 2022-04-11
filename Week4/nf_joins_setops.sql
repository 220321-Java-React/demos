--This SQL script will demonstrate Normal Forms

--Then we'll get into joins, and set operations

--I might also fit a transaction in here (TCL)



--A table in 1st Normal Form
--Tables must have a primary key (can be a composite key)
--Columns must be atomic (you should only have one piece of data within each cell)

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




