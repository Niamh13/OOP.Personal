drop database if exists fishDB;
create database fishDB;

use fishDB;

CREATE TABLE log_table(
	date varchar (255),
    species varchar (255),
    caught int,
    sold int
    
);

CREATE TABLE data_table(
	Species varchar (255),
    Pwaste double,
    totals int
);

CREATE TABLE output_table AS 
SELECT species AS species, SUM(sold) AS sold, SUM(caught) AS caught
FROM fishdb.log_table
GROUP BY species;

