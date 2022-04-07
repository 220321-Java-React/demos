--the first thing I want to do is create two tables with a relationship
--(using primary keys and foreign keys)

--This schema will be used to track exotic pets and their owners

--owners table
CREATE TABLE owners(
	owner_id serial PRIMARY KEY, --The primary key uniquely identifies each record in a table. it's typically an ID.
	--serial is an auto-incrementing int data type. We don't need to give it a value when we insert data. It's automatic
	--whenever we insert a new owner, the owner_id will be generated for us.
	owner_name TEXT NOT NULL --since this has a not null constraint, we have to provide values for name
);

--pets table
CREATE TABLE pets(
	pet_id serial PRIMARY KEY,	
	species TEXT,
	age int CHECK (age > 1), --no baby animals are allowed in this exotic animal trade. 
	--this check makes it so that we can't insert a new pet with an age field less than 1.
	
	owner_id_fk int REFERENCES owners (owner_id) --this is a FOREIGN KEY. (note the use of "references")
	--this is saying, this foreign key is bound to the primary key (owner_id) of the owners table
	--THIS IS HOW WE ESTABLISH RELATIONSHIPS BETWEEN OUR TABLES OF DATA 
);



--Ben will try to violate some of these constraints when we insert data