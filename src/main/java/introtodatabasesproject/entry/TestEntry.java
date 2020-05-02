package introtodatabasesproject.entry;

public class TestEntry extends RowEntry
{

    /*
        For the test table, for... testing of course

        varchar(50) name, int id
     */
    public static final TestEntry DUMMY_ENTRY = new TestEntry("hello", 1);

    public TestEntry(String name, int id)
    {
        super();

        data.add(name);
        data.add(id);


        //determineDataTypes(data);
        dataTypes.add(DataType.STRING);
        dataTypes.add(DataType.INTEGER);

        dataLabels.add("Name");
        dataLabels.add("ID");

        length = data.size();
        primaryKeyIndex = 1;
    }
}
