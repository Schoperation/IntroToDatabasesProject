-- new user

--CREATE USER yes IDENTIFIED BY mohammed;
--GRANT CREATE SESSION TO yes;
--GRANT CREATE TABLE TO yes;
--GRANT CREATE SEQUENCE TO yes;
--ALTER USER yes QUOTA UNLIMITED ON USERS;

--connect yes/mohammed;

-- Creating tables
create table myTestTable
(
    name varchar(50) not null,
    id integer not null,
    primary key (id)
);