package introtodatabasesproject.servlet;

import introtodatabasesproject.core.TableCmds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class PremadeQuery implements IQuery
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, Connection conn, PreparedStatement pstmt) throws IOException, SQLException
    {
        // What premade query did they want?
        String query = request.getParameter("premadeQuery");
        String sql = "";

        switch (query)
        {
            case "aptsAndMansions":
                sql = "select * from owner where ssNumber in (select ssNumber from home where type = 'Mansion') and ssNumber in (select ssNumber from home where type = 'Apartment')";
                break;
            case "soldMoreThanOnce":
                sql = "select * from home where 1 < (select count(homeID) from hometransaction where homeID = home.homeID)";
                break;
            default:
                break;
        }

        pstmt = conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();

        // Now print the results
        PrintWriter writer = response.getWriter();

        writer.println("<h1>Results for Premade Query</h1>");
        writer.println("<h3>" + sql + "</h3>");
        TableCmds.generateTable(resultSet, writer);
        resultSet.close();
        writer.close();
    }
}
