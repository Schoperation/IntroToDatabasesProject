package introtodatabasesproject.entry;

public class OwnerEntry extends RowEntry
{

    /*
        Owners

        CREATE TABLE Owner (
        name VARCHAR(50) NOT NULL,
        ssNumber INT PRIMARY KEY,
        age INT NOT NULL,
        dependents INT NOT NULL,
        yearlyIncome INT NOT NULL,
        profession VARCHAR(40) NOT NULL
        );
     */
    public static final OwnerEntry DUMMY_ENTRY = new OwnerEntry("John Doe", 1,2,3,4, "lame");

    public OwnerEntry(String name, int ssNumber, int age, int dependents, int yearlyIncome, String profession)
    {
        super();

        data.add(name);
        data.add(ssNumber);
        data.add(age);
        data.add(dependents);
        data.add(yearlyIncome);
        data.add(profession);

        determineDataTypes(data);

        dataLabels.add("Name");
        dataLabels.add("SS Num");
        dataLabels.add("Age");
        dataLabels.add("Dependents");
        dataLabels.add("Income");
        dataLabels.add("Profession");

        length = data.size();
        primaryKeyIndex = 1;
    }
}
