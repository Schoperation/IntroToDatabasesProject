package main.java.introtodatabasesproject.cmd;

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

    private int numberofArguments;

    // Normally, doing an arraylist with no type specification is suicide, but we can
    private ArrayList data;

    public RowEntry(int numArgs, Types argTypes[])
    {
        data = new ArrayList();
        numberofArguments = numArgs;


    }

    
}
