package introtodatabasesproject.servlet;

import introtodatabasesproject.core.DatabaseMain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet
{
    public static final long serialVersionUUID = 1L;

    public MainServlet()
    {
        super();
    }

    // This is fired whenever the form is submitted with the post method
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Load database
        DatabaseMain.main(new String[2]);

        // Create connection
        Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
            System.out.println("Creating connection to database...");
            conn = DriverManager.getConnection(DatabaseMain.dbAddress, DatabaseMain.username, DatabaseMain.password);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        // Write out html and css code common for all pages
        PrintWriter writer = response.getWriter();

        // CSS for styling the table
        writer.println("<head>");
        writer.println("<style>");
        writer.println("table, th, td {");
        writer.println("border: 1px solid black; background-color: #ff6247; padding: 5px; text-align: right; ");
        writer.println("}");
        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body bgcolor=#00ccff>");

        writer.println("<a href=../IntroToDatabases>Go back</a><br>");

        // Figure out what queryType was, then fire corresponding method
        switch (request.getParameter("queryType"))
        {
            case "selectAll":
                SelectAll sa = new SelectAll();
                System.out.println("Running Select all command for " + request.getParameter("table1") + "...");
                try {
                    sa.execute(request, response, conn, pstmt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    writer.println(throwables.getSQLState());
                    writer.println(throwables.getMessage());
                }
                break;
            case "selectHome":
                FindHome fh = new FindHome();
                System.out.println("Finding homes...");
                try {
                    fh.execute(request, response, conn, pstmt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    writer.println(throwables.getSQLState());
                    writer.println(throwables.getMessage());
                }
                break;
            case "selectAgent":
                FindAgent fa = new FindAgent();
                System.out.println("Finding agent commission...");
                try {
                    fa.execute(request, response, conn, pstmt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    writer.println(throwables.getSQLState());
                    writer.println(throwables.getMessage());
                }
                break;
            case "selectOwner":
                FindOwner fo = new FindOwner();
                System.out.println("Finding owner...");
                try {
                    fo.execute(request, response, conn, pstmt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    writer.println(throwables.getSQLState());
                    writer.println(throwables.getMessage());
                }
                break;
            case "selectPremade":
                PremadeQuery pq = new PremadeQuery();
                System.out.println("Doing premade query...");
                try {
                    pq.execute(request, response, conn, pstmt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    writer.println(throwables.getSQLState());
                    writer.println(throwables.getMessage());
                }
                break;
            case "customQuery":
                CustomQuery cq = new CustomQuery();
                System.out.println("Running custom select query...");
                try {
                    cq.execute(request, response, conn, pstmt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    writer.println(throwables.getSQLState());
                    writer.println(throwables.getMessage());
                }
                break;
            case "addEntry":
                AddEntry ae = new AddEntry();
                System.out.println("Running Insert command for " + request.getParameter("table1") + "...");
                try {
                    ae.execute(request, response, conn, pstmt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    writer.println(throwables.getSQLState());
                    writer.println(throwables.getMessage());
                }
                break;
            case "changeOwner":
                ChangeOwnership co = new ChangeOwnership();
                System.out.println("Changing ownership...");
                try {
                    co.execute(request, response, conn, pstmt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    writer.println(throwables.getSQLState());
                    writer.println(throwables.getMessage());
                }
            default:
                break;
        }

        writer.println("</body>");
        writer.close();

        // Close prepared statement and connection
        try
        {
            conn.close();
            pstmt.close();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
