package introtodatabasesproject.entry;

public class LocationEntry extends RowEntry
{

    /*
        Locations of the homes

        int streetNum, varchar streetName, int unitNumber, int zipcode, varchar city, varchar county
     */

    public LocationEntry(int streetNum, String streetName, int unitNumber, int zipCode, String city, String county)
    {
        super();

        data.add(streetNum);
        data.add(streetName);
        data.add(unitNumber);
        data.add(zipCode);
        data.add(city);
        data.add(county);

        determineDataTypes(data);

        length = 6;
        primaryKeyIndex = 0;
    }
}
