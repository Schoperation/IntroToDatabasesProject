package introtodatabasesproject.entry;

public class ApplianceEntry extends RowEntry
{

    /*
        Appliances

        CREATE TABLE Appliance (
        name VARCHAR(50) NOT NULL,
        price INT NOT NULL,
        maker VARCHAR(50) NOT NULL,
        year INT NOT NULL,
        modelName VARCHAR(40) PRIMARY KEY,
        homeID INT NOT NULL,
        FOREIGN KEY (homeID) REFERENCES Home(homeID)
        );
     */
    public static final ApplianceEntry DUMMY_ENTRY = new ApplianceEntry("yes",2,"s",2007,"hds092",222);

    public ApplianceEntry(String name, int price, String maker, int year, String modelName, int homeID)
    {
        super();

        data.add(name);
        data.add(price);
        data.add(maker);
        data.add(year);
        data.add(modelName);
        data.add(homeID);

        determineDataTypes(data);

        dataLabels.add("Name");
        dataLabels.add("Price");
        dataLabels.add("Maker");
        dataLabels.add("Year");
        dataLabels.add("Model Name");
        dataLabels.add("Home ID");

        length = data.size();
        primaryKeyIndex = 4;
    }
}
