package introtodatabasesproject.servlet;

import introtodatabasesproject.core.TableCmds;
import introtodatabasesproject.entry.RowEntry;
import introtodatabasesproject.entry.TestEntry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class SelectAll implements IQuery
{
    /*
        Shows an entire table in an HTML table
     */

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, Connection conn, PreparedStatement pstmt) throws IOException, SQLException
    {
        // Only variable we need to deal with is table1, aka the name of the table
        String table = request.getParameter("table1");
        RowEntry dummy = TableCmds.getDummyEntry(table);

        // Grab results of select all command
        ResultSet resultSet = TableCmds.selectAll(table, conn, pstmt);

        // Start creating html code with PrintWriter
        PrintWriter writer = response.getWriter();

        writer.println("<h1>Results for table " + table + ":</h1>");
        writer.println("<table>");

        // First row headers
        writer.println("<tr>");
        Iterator<String> iterator = dummy.getDataLabels().iterator();

        while (iterator.hasNext())
        {
            String label = iterator.next();
            writer.println("<th>");
            writer.println("<b>" + label + "</b>");
            writer.println("</th>");
        }

        writer.println("</tr>");

        // Now populate the table with the data
        TableCmds.populateHTMLTable(resultSet, writer, TestEntry.DUMMY_ENTRY);

        writer.println("</table>");
        writer.close();
        resultSet.close();
        // pstmt and conn are closed in MainServlet class
    }
}
