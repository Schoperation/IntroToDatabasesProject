package introtodatabasesproject.entry;

import java.sql.Date;
import java.sql.Time;
import java.sql.Types;
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
    protected ArrayList<DataType> dataTypes;

    public RowEntry()
    {
        data = new ArrayList();
        dataTypes = new ArrayList<DataType>();
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

    public ArrayList<DataType> getDataTypes()
    {
        return dataTypes;
    }

    public DataType getDataType(Object o)
    {
        if (!data.contains(o))
            return DataType.STRING;
        else
            return dataTypes.get(data.indexOf(o));
    }

    // Automating the process of determining datatypes... use a parallel arraylist with enum datatype
    protected void determineDataTypes(ArrayList list)
    {
        // Go through the list and add the correct datatype as a DataType
        for (Object o : list)
        {
            if (o instanceof Integer)
                dataTypes.add(DataType.INTEGER);
            else if (o instanceof Float)
                dataTypes.add(DataType.FLOAT);
            else if (o instanceof Double)
                dataTypes.add(DataType.DOUBLE);
            else if (o instanceof String)
                dataTypes.add(DataType.STRING);
            else if (o instanceof Character)
                dataTypes.add(DataType.CHARACTER);
            else if (o instanceof Boolean)
                dataTypes.add(DataType.BOOLEAN);
            else if (o instanceof Date)
                dataTypes.add(DataType.DATE);
            else if (o instanceof Time)
                dataTypes.add(DataType.TIME);
            else
                dataTypes.add(DataType.STRING);
        }
    }
}
