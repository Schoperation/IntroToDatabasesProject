package main.java.introtodatabasesproject.cmd;

import main.java.introtodatabasesproject.entry.RowEntry;

import java.io.Reader;
import java.sql.*;

import static main.java.introtodatabasesproject.core.DatabaseMain.*;

// Basic table commands, can be adjusted to suit a particular table's needs
public class TableCmds
{
    public static void insert(String table, RowEntry entry)
    {
        // Actual sql command... in the try {} is what we'll attempt to insert
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(table);
        sb.append(" VALUES (");

        // Inserting question marks depending on length
        int i;
        for (i = 0; i < entry.getLength(); i++)
        {
            // Dont put a comma if its the last one
            if (i < (entry.getLength() - 1))
                sb.append("?,");
            else
                sb.append("?");
        }

        sb.append(")"); // no semi-colon needed for applications

        // INSERT INTO [table] VALUES (?,?,?,...,?);
        String sql = sb.toString();

        // Now do the actual command stuff
        try
        {
            Connection conn = DriverManager.getConnection(DB_ADDRESS, USER, PASSWORD);

            // Turn the sql command into a prepared statement, and fill in the question marks.
            PreparedStatement pstmt = fillInBlanks(conn.prepareStatement(sql), entry);

            pstmt.executeUpdate();
            pstmt.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    // Fills in a preparedstatement's question marks
    private static PreparedStatement fillInBlanks(PreparedStatement pstmt, RowEntry entry) throws SQLException
    {
        int i = 1;
        for (String s : entry.getDataTypes())
        {
            if (s.equalsIgnoreCase("integer"))
                pstmt.setInt(i, (Integer) entry.getData().get(i-1));
            else if (s.equalsIgnoreCase("float"))
                pstmt.setFloat(i, (Float) entry.getData().get(i-1));
            else if (s.equalsIgnoreCase("double"))
                pstmt.setDouble(i, (Double) entry.getData().get(i-1));
            else if (s.equalsIgnoreCase("string"))
                pstmt.setString(i, (String) entry.getData().get(i-1));
            else if (s.equalsIgnoreCase("character"))
                pstmt.setObject(i, (Character) entry.getData().get(i-1));
            else if (s.equalsIgnoreCase("date"))
                pstmt.setDate(i, (Date) entry.getData().get(i-1));
            else if (s.equalsIgnoreCase("boolean"))
                pstmt.setBoolean(i, (Boolean) entry.getData().get(i-1));

            i++;
        }

        return pstmt;
    }
}
