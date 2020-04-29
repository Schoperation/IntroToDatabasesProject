package introtodatabasesproject.servlet;

import introtodatabasesproject.core.TableCmds;
import introtodatabasesproject.entry.TestEntry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class SelectAll implements IQuery
{
    /*
        Shows an entire table in an HTML table
     */

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
    {
        // Only variable we need to deal with is table1, aka the name of the table
        String table = request.getParameter("table1");

        // TODO make this a switch statement

        // Grab results of select all command
        ResultSet resultSet = TableCmds.selectAll(table, TestEntry.DUMMY_ENTRY);

        // Start creating html code with PrintWriter
        PrintWriter writer = response.getWriter();

        // CSS for styling the table
        writer.println("<head>");
        writer.println("<style>");
        writer.println("table, th, td {");
        writer.println("border: 1px solid black; background-color: #b3b3b3; padding: 5px;");
        writer.println("}");
        writer.println("</style>");
        writer.println("</head>");


        writer.println("<h1>Results for table " + table + ":</h1>");
        writer.println("<table>");

        // First row headers
        writer.println("<tr>");

        // TODO make this dependent on table too
        Iterator<String> iterator = TestEntry.DUMMY_ENTRY.getDataLabels().iterator();

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

    }
}
