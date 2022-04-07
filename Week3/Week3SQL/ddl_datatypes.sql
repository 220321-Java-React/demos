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