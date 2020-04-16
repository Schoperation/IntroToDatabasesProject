----------------------------------------------------------
---- Student Names:          ----
----                                      ----
----                                      ----
----------------------------------------------------------
system
mohammed


CREATE USER MCS3543 IDENTIFIED BY mohammed; 
GRANT CREATE SESSION TO MCS3543;
GRANT CREATE TABLE TO MCS3543;
GRANT CREATE SEQUENCE TO MCS3543;
ALTER USER MCS3543 QUOTA UNLIMITED ON USERS;

connect MCS3543/mohammed;

create table Course 
(
  		courseId char(5),
  		subjectId char(4) not null,
  		courseNumber integer, 
  		title varchar(50) not null,
  		numOfCredits integer,
  		primary key (courseId)
);

desc Course;

select * from Course;

create table Enrollment (
	  courseId char( 5),
	  dateRegistered date,
	  grade char( 1),
	  primary key (courseId),
	  foreign key (courseId) references Course
	);


drop table Course;
drop table Enrollment;
drop table Course;
desc Course;

CREATE TABLE shr 
(
	 shrcode CHAR(3),
	 shrfirm VARCHAR(20)NOT NULL,
	 shrprice DECIMAL(6,2),
	 shrqty DECIMAL(8),
	 shrdiv	 DECIMAL(5,2),
	 shrpe DECIMAL(2),
		PRIMARY KEY(shrcode)
);

INSERT INTO shr (shrcode, shrfirm, shrprice, shrqty, shrdiv, shrpe)
VALUES ('FC', 'Freedonia Copper', '27.50', '10529', '1.84', '16');

INSERT INTO shr (shrcode, shrfirm, shrprice, shrqty, shrdiv, shrpe)
VALUES ('PT', 'Patagonian Tea', '55.25', '12635', '2.50', '10');

INSERT INTO shr (shrcode, shrfirm, shrprice, shrqty, shrdiv, shrpe)
VALUES ('AR', 'Abyssinian Ruby', '31.82', '22010', '1.32', '13');

INSERT INTO shr (shrcode, shrfirm, shrprice, shrqty, shrdiv, shrpe)
VALUES ('SLG', 'Sri Lankan Gold', '50.37', '32868', '2.68', '16');

INSERT INTO shr (shrcode, shrfirm, shrprice, shrqty, shrdiv, shrpe)
VALUES ('ILZ', 'Indian Lead & Zinc', '37.75', '6390', '3.00', '12');

INSERT INTO shr (shrcode, shrfirm, shrprice, shrqty, shrdiv, shrpe)
VALUES ('BE', 'Burmese Elephant', '0.07', '154713', '0.01', '3');

INSERT INTO shr (shrcode, shrfirm, shrprice, shrqty, shrdiv, shrpe)
VALUES ('BS', 'Bolivian Sheep', '12.75', '231678', '1.78', '11');

INSERT INTO shr (shrcode, shrfirm, shrprice, shrqty, shrdiv, shrpe)
VALUES ('NG', 'Nigerian Geese', '35.00', '12323', '1.68', '10');

INSERT INTO shr (shrcode, shrfirm, shrprice, shrqty, shrdiv, shrpe)
VALUES ('CS', 'Canadian Sugar', '52.78', '4716', '2.50', '15');

INSERT INTO shr (shrcode, shrfirm, shrprice, shrqty, shrdiv, shrpe)
VALUES ('ROF', 'Royal Ostrich Farms', '33.75', '1234923', '3.00', '6');


select * from shr;

SELECT * FROM shr WHERE shrcode = 'AR';

SELECT * FROM shr WHERE shrcode IN ('FC','AR','SLG');

SELECT * FROM shr WHERE shrcode = 'FC' 
                     OR shrcode = 'AR' 
					 OR shrcode = 'SLG';
					 
SELECT * 
FROM shr 
WHERE shrcode not in ('CS', 'PT');

SELECT *
FROM shr
WHERE shrcode not in ( 'ROF', 'CS', 'NG');


SELECT * FROM shr WHERE shrcode <> 'CS' AND shrcode <> 'PT';


SELECT shrfirm FROM shr
			WHERE shrfirm LIKE 'F%';

			
SELECT shrfirm FROM shr
		WHERE shrfirm LIKE '%Ruby%';

		
SELECT AVG(shrdiv) AS avgdiv FROM shr;

SELECT AVG(shrdiv/shrprice*100) AS avgyield FROM shr;

SELECT shrfirm, shrpe FROM shr 
	WHERE shrpe > (SELECT AVG(shrpe)FROM shr);

	
	



delete from shr;

select * from shr;

desc shr;

drop table shr;

select * from shr;

desc shr;

connect system/mohammed;

drop USER MCS3543 CASCADE;


