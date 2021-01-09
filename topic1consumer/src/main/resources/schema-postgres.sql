DROP TABLE IF EXISTS Countries;
CREATE TABLE Countries(id serial PRIMARY KEY, Country VARCHAR(255),country_code VARCHAR(255),
Slug VARCHAR(255),new_confirmed VARCHAR(255),total_confirmed VARCHAR(255),new_deaths VARCHAR(255),total_deaths VARCHAR(255),new_recovered VARCHAR(255),total_recovered VARCHAR(255),Date VARCHAR(255));

DROP TABLE IF EXISTS Globale;
CREATE TABLE Globale(id serial PRIMARY KEY, new_confirmed VARCHAR(255),total_confirmed VARCHAR(255),
new_deaths VARCHAR(255),total_deaths VARCHAR(255),new_recovered VARCHAR(255),total_recovered VARCHAR(255));