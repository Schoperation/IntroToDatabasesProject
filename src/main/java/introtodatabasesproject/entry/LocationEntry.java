package introtodatabasesproject.entry;

import javax.xml.stream.Location;

public class LocationEntry extends RowEntry
{

    /*
        Locations of the homes

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
     */
    public static final LocationEntry DUMMY_ENTRY = new LocationEntry(4, "hhh", 2, "charleston", 444, "broward", 22);

    public LocationEntry(int streetNumber, String streetName, int unitNumber, String city, int zipCode, String county, int homeID)
    {
        super();

        data.add(streetNumber);
        data.add(streetName);
        data.add(unitNumber);
        data.add(city);
        data.add(zipCode);
        data.add(county);
        data.add(homeID);

        determineDataTypes(data);

        dataLabels.add("Street Number");
        dataLabels.add("Street Name");
        dataLabels.add("Unit Number");
        dataLabels.add("City");
        dataLabels.add("Zip Code");
        dataLabels.add("County");
        dataLabels.add("Home ID");

        length = data.size();
        primaryKeyIndex = 0;
    }
}
