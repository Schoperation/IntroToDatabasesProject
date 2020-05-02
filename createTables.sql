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
agentID INT,
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
homeID INT NOT NULL,
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
-- Homes
