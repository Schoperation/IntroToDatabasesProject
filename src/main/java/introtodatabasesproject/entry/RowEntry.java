package introtodatabasesproject.entry;

import java.sql.Date;
import java.util.ArrayList;

public class RowEntry
{
    /*
        This serves as an all-purpose class to represent the different types of data entries you can put into a table.
        i.e. a row in a table

        So for example, there'll be a different one for addresses, homes, agents, etc.
        We have this in order to ensure we insert the correct types of data into the correct tables.
     */

    protected int length;
    protected int primaryKeyIndex;
    protected ArrayList data;
    protected ArrayList<String> dataTypes;

    public RowEntry()
    {
        data = new ArrayList();
        dataTypes = new ArrayList<String>();
    }

    public int getLength()
    {
        return length;
    }

    public int getPrimaryKeyIndex()
    {
        return primaryKeyIndex;
    }

    public Object getPrimaryKey()
    {
        return data.get(primaryKeyIndex);
    }

    public ArrayList<Object> getData()
    {
        return data;
    }

    public ArrayList<String> getDataTypes()
    {
        return dataTypes;
    }

    public String getDataType(Object o)
    {
        if (!data.contains(o))
            return "DNE";
        else
            return dataTypes.get(data.indexOf(o));
    }

    // Automating the process of determining datatypes... use a parallel arraylist with strings... it's...ok...
    // TODO use enums instead of strings
    protected void determineDataTypes(ArrayList list)
    {
        // Go through the list and add the correct datatype as a string.
        for (Object o : list)
        {
            if (o instanceof Integer)
                dataTypes.add("integer");
            else if (o instanceof Float)
                dataTypes.add("float");
            else if (o instanceof Double)
                dataTypes.add("double");
            else if (o instanceof String)
                dataTypes.add("string");
            else if (o instanceof Character)
                dataTypes.add("character");
            else if (o instanceof Boolean)
                dataTypes.add("boolean");
            else if (o instanceof Date)
                dataTypes.add("date");
            else
                dataTypes.add("string");

        }
    }
}
