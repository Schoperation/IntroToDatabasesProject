package introtodatabasesproject.servlet;

import introtodatabasesproject.core.TableCmds;
import introtodatabasesproject.core.Tables;
import introtodatabasesproject.entry.TestEntry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEntry implements IQuery
{

    /*
        For adding entries to a table
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, Connection conn, PreparedStatement pstmt) throws IOException, SQLException
    {
        // Get parameters
        String table = request.getParameter("table1");
        PrintWriter writer = response.getWriter();
        writer.println("Added new entry for " + table + ".");

        // Switch statement for getting the correct parameters
        switch (table)
        {
            case Tables.TEST_TABLE:
            default:
                TestEntry te = new TestEntry(request.getParameter("myTestTable_name"), Integer.parseInt(request.getParameter("myTestTable_id")));
                TableCmds.insert(table, te, conn, pstmt);
                writer.println("Name: " + request.getParameter("myTestTable_name") + ", ID: " + request.getParameter("myTestTable_id"));
                break;
        }
    }
}
