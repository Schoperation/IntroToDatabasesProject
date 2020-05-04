package introtodatabasesproject.core;

import introtodatabasesproject.entry.*;

import java.io.PrintWriter;
import java.sql.*;

// Basic table commands, can be adjusted to suit a particular table's needs
public class TableCmds
{
    /*
        SQL INSERT command
     */
    public static void insert(String table, RowEntry entry, Connection conn, PreparedStatement pstmt) throws SQLException
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

        // Actual command execution
        pstmt = fillInBlanks(conn.prepareStatement(sql), entry);
        pstmt.executeUpdate();

        // Commit changes
        PreparedStatement pstmt1 = conn.prepareStatement("COMMIT");
        pstmt1.executeUpdate();
        pstmt1.close();
    }

    /*
        SQL SELECT * command
     */
    public static ResultSet selectAll(String table, Connection conn, PreparedStatement pstmt) throws SQLException
    {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(table);

        String sql = sb.toString();

        // Now do the actual command stuff
        ResultSet resultSet = null;
        pstmt = conn.prepareStatement(sql);
        resultSet = pstmt.executeQuery(sql);

        // resultSet, pstmt, and conn are closed in MainServlet and SelectAll, so no need to do it here
        return resultSet;
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
                    if ((Integer) entry.getData().get(i-1) < 0)
                        pstmt.setNull(i, Types.INTEGER);
                    else
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

    /*
        After a post request is made, we gotta actually fill in the table, so here it is, since the same code will be used multiple times
     */
    public static void populateHTMLTable(ResultSet resultSet, PrintWriter writer, RowEntry dummyEntry) throws SQLException {
        // Iterate through the result set

        while (resultSet.next())
        {
            // Each iteration of the resultset is ONE ROW.
            writer.println("<tr>");

            int i = 1;
            for (DataType type : dummyEntry.getDataTypes())
            {
                // Each iteration through here is ONE CELL.
                writer.println("<td>");

                switch (type)
                {
                    case INTEGER:
                        writer.println(resultSet.getInt(i));
                        break;
                    case FLOAT:
                        writer.println(resultSet.getFloat(i));
                        break;
                    case DOUBLE:
                        writer.println(resultSet.getDouble(i));
                        break;
                    case STRING:
                        writer.println(resultSet.getString(i));
                        break;
                    case CHARACTER:
                        writer.println(resultSet.getObject(i));
                        break;
                    case BOOLEAN:
                        writer.println(resultSet.getBoolean(i));
                        break;
                    case DATE:
                        writer.print(resultSet.getDate(i));
                        break;
                    case TIME:
                        writer.println(resultSet.getTime(i));
                        break;
                    default:
                        break;
                }

                writer.println("</td>");
                i++;
            }

            writer.println("</tr>");
        }
    }

    public static RowEntry getDummyEntry(String table)
    {
        switch (table)
        {
            case Tables.AGENT_TABLE:
                return AgentEntry.DUMMY_ENTRY;
            case Tables.OWNER_TABLE:
                return OwnerEntry.DUMMY_ENTRY;
            case Tables.HOME_TABLE:
                return HomeEntry.DUMMY_ENTRY;
            case Tables.LOCATION_TABLE:
                return LocationEntry.DUMMY_ENTRY;
            case Tables.APPLIANCE_TABLE:
                return ApplianceEntry.DUMMY_ENTRY;
            case Tables.HOME_TRANSACTION_TABLE:
                return HomeTransactionEntry.DUMMY_ENTRY;
            case Tables.TEST_TABLE:
            default:
                return TestEntry.DUMMY_ENTRY;
        }
    }

    public static void generateTable(ResultSet resultSet, PrintWriter writer) throws SQLException
    {
        writer.println("<table>");
        writer.println("<tr>");

        // Headers
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int j;
        for (j = 0; j < resultSetMetaData.getColumnCount(); j++)
        {
            writer.println("<td>");
            writer.println(resultSetMetaData.getColumnLabel(j+1));
            writer.println("</td>");
        }

        writer.println("</tr>");

        // Actual table
        while (resultSet.next())
        {
            writer.println("<tr>");
            int k;
            for (k = 0; k < resultSetMetaData.getColumnCount(); k++)
            {
                writer.println("<td>");
                writer.println(resultSet.getObject(k+1));
                writer.println("</td>");
            }

            writer.println("</tr>");
        }

        writer.println("</table>");
    }
}
