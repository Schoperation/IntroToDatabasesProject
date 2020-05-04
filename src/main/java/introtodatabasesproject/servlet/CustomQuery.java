package introtodatabasesproject.servlet;

import introtodatabasesproject.core.TableCmds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class CustomQuery implements IQuery
{
    /*
        For a bit more... control
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, Connection conn, PreparedStatement pstmt) throws IOException, SQLException
    {
        // Our statement... could be select, insert, update...
        String sql = request.getParameter("customQueryText");

        // Get rid of any semi colons
        sql.replace(";", "");

        // Now lets run the command
        pstmt = conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();

        // Create table and rows
        PrintWriter writer = response.getWriter();

        writer.println("<h1>Results for custom query</h1>");
        writer.println("<h3>" + sql + "</h3>");
        TableCmds.generateTable(resultSet, writer);
        resultSet.close();
        writer.close();
    }
}
