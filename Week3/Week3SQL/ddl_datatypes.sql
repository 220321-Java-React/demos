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






