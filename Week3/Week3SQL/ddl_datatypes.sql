--To create a new schema, we right clicked the schemas folder, create new schema, and named it ddl_datatypes
--Then, to create this file, we right clicked our schema -> SQL Editor -> Open SQL Script 

--Data Definition Language (DDL): create, alter, truncate, drop
--DDL is any command that relates to building the structure of your data (typically tables)
--It doesn't deal directly with data!!! Just the strucutre of data

--the create command will CREATE your tables in your database
CREATE TABLE users(
	username TEXT --text is my text datatype of choice 
);

--we created a (bad) table of users that simply tracks a username

--we can view this new table (and any other new tables by right clicking the schema -> view diagram -> 
--right click your schema -> refresh)

--OH NO! I meant to add an age column to my table. I can use the ALTER command to change or add columns
ALTER TABLE users ADD user_age int;

--We can also rename columns using alter
ALTER TABLE users RENAME COLUMN user_age TO users_age;

--we can DROP a table with the drop command
DROP TABLE users;

--not shown: TRUNCATE, which drops all records in a table
--common after backups, if you want to save the 

--TRUNCATE TABLE users;

--so DROP deletes a table/column (and all the data), TRUNCATE only deletes the data.

--This is an extremely rudimentary table, just to show DDL commands and their syntax

---------------------------------------------------------------------------------------

--SQL Datatypes

--I'm gonna make a horribly designed table just to demonstrate SQL datatypes
--This table will not have a primary key, it will not be normalized, these are things that will make sense to you later

--Note that each column is delimited by commas
CREATE TABLE datatypes (
	small_number int2, --2 bytes, for smaller numbers (kinda like a short in Java)
	normal_number int, --4 bytes, most common int type (can also be int4)
	big_number int8, --8 bytes, for swole numbers (kinda like a long in Java)
	standard_decimal decimal(10, 2), --2 parameters: (total digits, decimal places)
	--so this decimal has 10 total digits, with 2 decimal places.
	
	"boolean" boolean, --double quotes let you use keywords as column names, etc.
	
	fixed_length_text char(2), --text field, in this case we give it 2, which means it can only be 2 characters long
	variable_length_text varchar(15), --text field, we gave it 15 so it can be between 0-15 characters long
	unlimited_length_text TEXT, --unlimited length, best practice if you don't need to limit your characters.
	
	--ben will show date and timestamp
	
);

--This is NOT all the datatypes we have... There are so many
--But most of the time, data will just be numbers, text, and maybe times or booleans










