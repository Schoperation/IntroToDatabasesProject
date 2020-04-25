package introtodatabasesproject.core;

import introtodatabasesproject.entry.DataType;
import introtodatabasesproject.entry.RowEntry;

import java.sql.*;

import static introtodatabasesproject.core.DatabaseMain.*;

// Basic table commands, can be adjusted to suit a particular table's needs
public class TableCmds
{
    /*
        SQL INSERT command
     */
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
            Connection conn = DriverManager.getConnection(dbAddress, username, password);

            // Turn the sql command into a prepared statement, and fill in the question marks.
            PreparedStatement pstmt = fillInBlanks(conn.prepareStatement(sql), entry);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    /*
        SQL SELECT * command
     */
    public static void selectAll(String table, RowEntry dummyEntry)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(table);

        String sql = sb.toString();

        // Now do the actual command stuff
        try
        {
            Connection conn = DriverManager.getConnection(dbAddress, username, password);

            // Turn the sql command into a prepared statement
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery(sql);

            System.out.println(table);
            System.out.println("---------------------------------------------");

            // Iterate through resultset and print out results TODO convert this to tomcat page
            while (resultSet.next())
            {
                // Alright, go through the columns and print them out
                int i = 1;
                for (DataType dt : dummyEntry.getDataTypes())
                {
                    switch (dt)
                    {
                        case INTEGER:
                            System.out.print(" " + resultSet.getInt(i) + " ");
                            break;
                        case FLOAT:
                            System.out.print(" " + resultSet.getFloat(i) + " ");
                            break;
                        case DOUBLE:
                            System.out.print(" " + resultSet.getDouble(i) + " ");
                            break;
                        case STRING:
                            System.out.print(" " + resultSet.getString(i) + " ");
                            break;
                        case CHARACTER:
                            System.out.print(" " + resultSet.getObject(i) + " ");
                            break;
                        case BOOLEAN:
                            System.out.print(" " + resultSet.getBoolean(i) + " ");
                            break;
                        case DATE:
                            System.out.print(" " + resultSet.getDate(i) + " ");
                            break;
                        case TIME:
                            System.out.print(" " + resultSet.getTime(i) + " ");
                            break;
                        default:
                            break;
                    }

                    i++;
                }

                System.out.print("\n");
            }

            // Close everything
            resultSet.close();
            pstmt.close();
            conn.close();
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
        for (DataType dt : entry.getDataTypes())
        {
            switch (dt)
            {
                case INTEGER:
                    pstmt.setInt(i, (Integer) entry.getData().get(i-1));
                    break;
                case FLOAT:
                    pstmt.setFloat(i, (Float) entry.getData().get(i-1));
                    break;
                case DOUBLE:
                    pstmt.setDouble(i, (Double) entry.getData().get(i-1));
                    break;
                case STRING:
                    pstmt.setString(i, (String) entry.getData().get(i-1));
                    break;
                case CHARACTER:
                    pstmt.setObject(i, (Character) entry.getData().get(i-1));
                    break;
                case BOOLEAN:
                    pstmt.setBoolean(i, (Boolean) entry.getData().get(i-1));
                    break;
                case DATE:
                    pstmt.setDate(i, (Date) entry.getData().get(i-1));
                    break;
                case TIME:
                    pstmt.setTime(i, (Time) entry.getData().get(i-1));
                    break;
                default:
                    break;
            }

            i++;
        }

        return pstmt;
    }
}
