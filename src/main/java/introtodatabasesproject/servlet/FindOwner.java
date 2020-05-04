package introtodatabasesproject.servlet;

import introtodatabasesproject.core.TableCmds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindOwner implements IQuery
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, Connection conn, PreparedStatement pstmt) throws IOException, SQLException
    {
        // Get owner id and dropdown option
        String ssNumber = request.getParameter("Owner1_ssNumber");
        String option = request.getParameter("selectOwnerOption");
        String sql = "";

        // Figure out option
        switch (option)
        {
            case "mostExpensive":
                sql = "select * from home where ssNumber = " + ssNumber + " and price = (select max(price) from (select price from hometransaction where ssNumber = " + ssNumber + " union select price from home where ssNumber = " + ssNumber + "))";
                break;
            case "previousHomes":
                sql = "select * from hometransaction where ssNumber = " + ssNumber;
                break;
            default:
                break;
        }

        pstmt = conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();

        // Now print the results
        PrintWriter writer = response.getWriter();

        writer.println("<h1>Results for Find Owner</h1>");
        writer.println("<h3>" + sql + "</h3>");
        TableCmds.generateTable(resultSet, writer);
        resultSet.close();
        writer.close();
    }
}
