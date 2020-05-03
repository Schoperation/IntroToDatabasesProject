package introtodatabasesproject.entry;

public class HomeEntry extends RowEntry
{

    /*
        Homes

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
     */
    public static final HomeEntry DUMMY_ENTRY = new HomeEntry(1,2,3,4,5.6f, 7, "Mansion",2007,20000,222,333);

    public HomeEntry(int homeID, int floors, int bedrooms, int bathrooms, float landAcres, int floorSpace, String type, int yearConstructed, int price, int ssNumber, int agentNum)
    {
        super();

        data.add(homeID);
        data.add(floors);
        data.add(bedrooms);
        data.add(bathrooms);
        data.add(landAcres);
        data.add(floorSpace);
        data.add(type);
        data.add(yearConstructed);
        data.add(price);

        // if any of these are 0, then they are null
        data.add(ssNumber);
        data.add(agentNum);

        determineDataTypes(data);

        dataLabels.add("Home ID");
        dataLabels.add("Floors");
        dataLabels.add("Bedrooms");
        dataLabels.add("Bathrooms");
        dataLabels.add("Acres");
        dataLabels.add("Floor Space (sqft)");
        dataLabels.add("Type");
        dataLabels.add("Year Constructed");
        dataLabels.add("Price");
        dataLabels.add("Owner SS #");
        dataLabels.add("Agent ID");

        length = 11;
        primaryKeyIndex = 0;
    }
}
