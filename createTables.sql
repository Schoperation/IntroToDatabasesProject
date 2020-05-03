-- Creates the tables

CREATE TABLE Agent ( 
percentCommission INT NOT NULL,
company VARCHAR(50) NOT NULL,
agentID INT PRIMARY KEY
);

CREATE TABLE Owner ( 
name VARCHAR(50) NOT NULL,
ssNumber INT PRIMARY KEY,
age INT NOT NULL,
dependents INT NOT NULL,
yearlyIncome INT NOT NULL,
profession VARCHAR(40) NOT NULL
);

-- If it has an agent, then the house is available, otherwise it has an owner
CREATE TABLE Home ( 
homeID INT PRIMARY KEY, 
floors INT NOT NULL, 
bedrooms INT NOT NULL,
bathrooms INT NOT NULL, 
landAcres FLOAT NOT NULL,
floorSpace INT NOT NULL,
type VARCHAR(50) NOT NULL,
yearConstructed INT NOT NULL,
price INT NOT NULL,
ssNumber INT,
agentID INT UNIQUE,
FOREIGN KEY (ssNumber) REFERENCES Owner(ssNumber),
CONSTRAINT Chk_Type CHECK ((floorSpace >= 6000 AND landAcres >= 2 AND type = 'Mansion') OR (floors = 1 AND type = 'Apartment') OR (type = 'Townhome') OR (type = 'Condo')),
CONSTRAINT Chk_People CHECK (NOT (agentID IS NULL AND ssNumber IS NULL))
);

CREATE TABLE Location ( 
streetNumber INT NOT NULL,
streetName VARCHAR(50) NOT NULL,
unitNumber INT NOT NULL, 
city VARCHAR(50) NOT NULL,
zipCode INT NOT NULL, 
county VARCHAR(50) NOT NULL,
homeID INT PRIMARY KEY,
FOREIGN KEY (homeID) REFERENCES Home(homeID)
);

-- May be multiple appliances of the same type, just in different houses. So this table has all appliances ever
CREATE TABLE Appliance ( 
name VARCHAR(50) NOT NULL,
price INT NOT NULL,
maker VARCHAR(50) NOT NULL,
year INT NOT NULL,
modelName VARCHAR(40) PRIMARY KEY,
homeID INT NOT NULL,
FOREIGN KEY (homeID) REFERENCES Home(homeID)
);

CREATE TABLE HomeTransaction (
transID INT PRIMARY KEY,
homeID INT NOT NULL,
ssNumber INT NOT NULL,
agentID INT NOT NULL,
price INT NOT NULL,
FOREIGN KEY (homeID) REFERENCES Home(homeID),
FOREIGN KEY (ssNumber) REFERENCES Owner(ssNumber),
FOREIGN KEY (agentID) REFERENCES Agent(agentID)
);

-- Add some dummy entries
-- Agent
INSERT INTO Agent VALUES (20, 'Friderik Co', 1111);
INSERT INTO Agent VALUES (25, 'Homeblown', 1112);
INSERT INTO Agent VALUES (21, 'Nope and Yes Inc', 1113);
INSERT INTO Agent VALUES (15, 'Go Slow Co', 1114);
INSERT INTO Agent VALUES (10, 'Raid Lamedow Legends', 1115);
INSERT INTO Agent VALUES (20, 'Yes', 1116);
INSERT INTO Agent VALUES (30, 'Seven Tea Nine', 1117);

-- Owner
INSERT INTO Owner VALUES ('Joe Shmoe', 111223333, 21, 0, 40000, 'Senior Data Manager');
INSERT INTO Owner VALUES ('Anastasia Romanov', 222334444, 45, 3, 85000, 'Claimant to Russian Throne');
INSERT INTO Owner VALUES ('Doshie Hermando', 333445555, 16, 1, 21000, 'Teddy Bear');
INSERT INTO Owner VALUES ('Hannah Anthill', 444556666, 15, 1, 21000, 'Writer');
INSERT INTO Owner VALUES ('Chris Czech', 555667777, 32, 2, 67000, 'Progamer');
INSERT INTO Owner VALUES ('Chris Stop', 666778888, 101, 3, 120000, 'Software Developer');
INSERT INTO Owner VALUES ('Jacob Kansian', 777889999, 34, 2, 39000, 'Farmer');
INSERT INTO Owner VALUES ('Cyb Orron', 888990000, 2, 0, 21000, 'Starving Artist');
INSERT INTO Owner VALUES ('Pana Mint', 999001111, 22, 3, 72000, 'Photographer');
INSERT INTO Owner VALUES ('GotAny Grapes', 111332222, 21, 0, 60000, 'Cartographer');
INSERT INTO Owner VALUES ('Mari Sama', 222443333, 20, 0, 50500, 'Gossiper');
INSERT INTO Owner VALUES ('Yawn Handnuhme', 333552222, 70, 2, 87000, 'Complainer');
INSERT INTO Owner VALUES ('Roomburnt Rych', 444663333, 80, 2, 60000, 'Misleader');
INSERT INTO Owner VALUES ('Abby Judywoman', 555774444, 21, 3, 95000, 'Nurse');

-- Home
INSERT INTO Home (homeID, floors, bedrooms, bathrooms, landAcres, floorSpace, type, yearConstructed, price, ssNumber) VALUES (1111, 2, 4, 2, 1.3, 3000, 'Townhome', 1979, 300000, 555667777);
INSERT INTO Home (homeID, floors, bedrooms, bathrooms, landAcres, floorSpace, type, yearConstructed, price, ssNumber) VALUES (1112, 3, 5, 5, 2.1, 7000, 'Mansion', 1899, 1200000, 444556666);
INSERT INTO Home (homeID, floors, bedrooms, bathrooms, landAcres, floorSpace, type, yearConstructed, price, ssNumber) VALUES (1113, 1, 1, 1, 0.10, 800, 'Apartment', 1912, 100000, 222334444);
INSERT INTO Home (homeID, floors, bedrooms, bathrooms, landAcres, floorSpace, type, yearConstructed, price, ssNumber) VALUES (1114, 2, 2, 3, 0.98, 2200, 'Condo', 1997, 330000, 888990000);
INSERT INTO Home (homeID, floors, bedrooms, bathrooms, landAcres, floorSpace, type, yearConstructed, price, ssNumber, agentID) VALUES (1115, 3, 3, 3, 1.13, 4900, 'Condo', 1976, 500000, 999001111, 1111);
INSERT INTO Home (homeID, floors, bedrooms, bathrooms, landAcres, floorSpace, type, yearConstructed, price, ssNumber, agentID) VALUES (1116, 2, 2, 2, 0.67, 3200, 'Townhome', 1965, 420000, 555774444, 1115);
INSERT INTO Home (homeID, floors, bedrooms, bathrooms, landAcres, floorSpace, type, yearConstructed, price, agentID) VALUES (1117, 4, 6, 6, 4.5, 8500, 'Mansion', 1934, 2300000, 1116);
INSERT INTO Home (homeID, floors, bedrooms, bathrooms, landAcres, floorSpace, type, yearConstructed, price, agentID) VALUES (1118, 2, 3, 2, 1.2, 2900, 'Townhome', 1969, 340500, 1114);
INSERT INTO Home (homeID, floors, bedrooms, bathrooms, landAcres, floorSpace, type, yearConstructed, price, agentID) VALUES (1119, 1, 2, 1, 0.20, 1000, 'Apartment', 1999, 120000, 1112);
INSERT INTO Home (homeID, floors, bedrooms, bathrooms, landAcres, floorSpace, type, yearConstructed, price, agentID) VALUES (1120, 1, 1, 1, 0.05, 500, 'Apartment', 2005, 70000, 1117);

-- Location
INSERT INTO Location VALUES (456, 'Cumberland Lane', 1, 'Grand Rapids', 48111, 'Kent', 1111);
INSERT INTO Location VALUES (123, 'Maple Street', 1, 'Grand Rapids', 48111, 'Kent', 1112);
INSERT INTO Location VALUES (938, 'Sycamore Road', 30, 'Ferndale', 48222, 'Oakland', 1113);
INSERT INTO Location VALUES (374, 'Sycamore Road', 1, 'Ferndale', 48222, 'Oakland', 1114);
INSERT INTO Location VALUES (774, 'CatchMe Lane', 1, 'Pontiac', 48333, 'Oakland', 1115);
INSERT INTO Location VALUES (838, 'CatchMe Lane', 1, 'Pontiac', 48333, 'Oakland', 1116);
INSERT INTO Location VALUES (523, 'Idk Avenue', 1, 'Ferndale', 48222, 'Oakland', 1117);
INSERT INTO Location VALUES (827, 'Maple Street', 1, 'Grand Rapids', 48111, 'Kent', 1118);
INSERT INTO Location VALUES (938, 'Sycamore Road', 34, 'Ferndale', 48222, 'Oakland', 1119);
INSERT INTO Location VALUES (292, 'Cumberland Lane', 22, 'Grand Rapids', 48111, 'Kent', 1120);

-- Appliance
INSERT INTO Appliance VALUES ('Whirly Dishwasher', 200, 'Whirly Co', 2009, 'WW1111', 1111);
INSERT INTO Appliance VALUES ('Whirly Stove', 100, 'Whirly Co', 2010, 'WW1112', 1111);
INSERT INTO Appliance VALUES ('Whirly Dishwasher', 250, 'Whirly Co', 2012, 'WW1113', 1112);
INSERT INTO Appliance VALUES ('Whirly Fridge', 300, 'Whirly Co', 2013, 'WW1114', 1112);
INSERT INTO Appliance VALUES ('Goodwin Fridge', 200, 'Goodwin Co', 2005, 'GG1111', 1113);
INSERT INTO Appliance VALUES ('Whirly Dishwasher', 400, 'Whirly Co', 2019, 'WW1115', 1113);
INSERT INTO Appliance VALUES ('Whirly Stove', 200, 'Whirly Co', 2015, 'WW1116', 1114);
INSERT INTO Appliance VALUES ('Goodwin Dishwasher', 100, 'Goodwin Co', 2001, 'GG1112', 1114);
INSERT INTO Appliance VALUES ('Goodwin Stove', 250, 'Goodwin Co', 2009, 'GG1113', 1115);
INSERT INTO Appliance VALUES ('Goodwin Dishwasher', 275, 'Goodwin Co', 2010, 'GG1114', 1115);
INSERT INTO Appliance VALUES ('Whirly Fridge', 400, 'Whirly Co', 2009, 'WW1117', 1116);
INSERT INTO Appliance VALUES ('Whirly Stove', 100, 'Whirly Co', 2010, 'WW1118', 1116);
INSERT INTO Appliance VALUES ('Whirly Stove', 200, 'Whirly Co', 2003, 'WW1119', 1117);
INSERT INTO Appliance VALUES ('Goodwin Stove', 100, 'Goodwin Co', 1998, 'GG1115', 1118);
INSERT INTO Appliance VALUES ('Whirly Fridge', 240, 'Whirly Co', 2003, 'WW1120', 1119);
INSERT INTO Appliance VALUES ('Whirly Stove', 120, 'Whirly Co', 2011, 'WW1121', 1120);

-- HomeTransaction
INSERT INTO HomeTransaction VALUES (1111, 1112, 444556666, 1117, 1100000);
INSERT INTO HomeTransaction VALUES (1112, 1111, 444663333, 1111, 320000);
INSERT INTO HomeTransaction VALUES (1113, 1120, 333552222, 1114, 50000);
INSERT INTO HomeTransaction VALUES (1114, 1118, 222334444, 1112, 290000);
INSERT INTO HomeTransaction VALUES (1115, 1116, 111223333, 1116, 390000);
INSERT INTO HomeTransaction VALUES (1116, 1115, 777889999, 1117, 600000);

COMMIT;