package introtodatabasesproject.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindAgent implements IQuery
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, Connection conn, PreparedStatement pstmt) throws IOException, SQLException
    {
        // Get agent ID
        int agentID = Integer.parseInt(request.getParameter("Agent1_agentID"));

        // Add up all the prices of the homes this agent has sold, from HomeTransaction.
        // We can do this thanks to the associative property of algebra
        String sql = "select sum(price) from HomeTransaction where agentID = " + agentID;
        pstmt = conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();

        resultSet.next();
        int totalPrice = resultSet.getInt(1);

        // Get the agent's commission
        PreparedStatement pstmt1 = conn.prepareStatement("select percentCommission from Agent where agentID = " + agentID);
        ResultSet resultSet1 = pstmt1.executeQuery();

        resultSet1.next();
        int percentCommission = resultSet1.getInt(1);
        resultSet1.close();
        pstmt1.close();

        // Divide commission by 100
        float actualPercent = percentCommission / 100f;
        float finalCommission = totalPrice * actualPercent;

        System.out.println("totalPrice: " + totalPrice);
        System.out.println("percentCommission: " + percentCommission);
        System.out.println("actualPercent: " + actualPercent);

        PrintWriter writer = response.getWriter();
        writer.println("<h2>Agent #" + agentID + " has made $" + finalCommission + " from commissions.</h2>");
    }
}
