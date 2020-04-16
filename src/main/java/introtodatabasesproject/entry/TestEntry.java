package main.java.introtodatabasesproject.entry;

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

        // TODO for known entries (like TestEntry), just manually specify type (with enum)
        determineDataTypes(data);

        length = 2;
        primaryKeyIndex = 1;
    }
}
