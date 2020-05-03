package introtodatabasesproject.servlet;

import introtodatabasesproject.core.TableCmds;
import introtodatabasesproject.entry.HomeTransactionEntry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeOwnership implements IQuery
{

    /*
        Used to change the ownership of a Home. Creates a transaction too
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, Connection conn, PreparedStatement pstmt) throws IOException, SQLException
    {
        // We'll get the owner and home.
        // First, grab the agentid from the home
        pstmt = conn.prepareStatement("select agentID from Home where homeID = " + request.getParameter("newHomeID"));
        ResultSet resultSet = pstmt.executeQuery();

        resultSet.next();
        int agentID = resultSet.getInt(1);
        resultSet.close();

        // Update the Home with the new owner, get rid of agent selling it
        PreparedStatement pstmt2 = conn.prepareStatement("update Home set ssNumber = " + request.getParameter("newssNumber") + ", agentID = NULL where homeID = " + request.getParameter("newHomeID"));
        pstmt2.executeUpdate();
        pstmt2.close();

        // Now create a new HomeTransaction
        // First find the highest transID
        PreparedStatement pstmt3 = conn.prepareStatement("select max(transID) from HomeTransaction");
        ResultSet resultSet1 = pstmt3.executeQuery();
        resultSet1.next();
        int highestID = resultSet1.getInt(1);
        resultSet1.close();
        pstmt3.close();

        // Our new transID is the highest one, plus one
        HomeTransactionEntry hte = new HomeTransactionEntry(highestID + 1, Integer.parseInt(request.getParameter("newHomeID")), Integer.parseInt(request.getParameter("newssNumber")), agentID, Integer.parseInt(request.getParameter("newPrice")));
        PreparedStatement pstmt4 = null;
        TableCmds.insert("HomeTransaction", hte, conn, pstmt4);
        pstmt4.close();

        // Print out results
        PrintWriter writer = response.getWriter();
        writer.println("Changed ownership of home with ID " + request.getParameter("newHomeID"));
        writer.println("New owner " + request.getParameter("newssNumber") + ", price $" + request.getParameter("newPrice"));
        writer.close();

    }
}
