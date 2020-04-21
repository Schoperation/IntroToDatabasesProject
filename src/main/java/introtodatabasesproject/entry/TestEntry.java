package introtodatabasesproject.entry;

public class TestEntry extends RowEntry
{

    /*
        For the test table, for... testing of course

        varchar(50) name, int id
     */

    public TestEntry(String name, int id)
    {
        super();

        data.add(name);
        data.add(id);


        //determineDataTypes(data);
        dataTypes.add(DataType.STRING);
        dataTypes.add(DataType.INTEGER);

        length = 2;
        primaryKeyIndex = 1;
    }
}
