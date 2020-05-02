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
import java.util.Iterator;

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
        writer.println("border: 1px solid black; background-color: #b3b3b3; padding: 5px;");
        writer.println("}");
        writer.println("</style>");
        writer.println("</head>");

        writer.println("<a href=../IntroToDatabases>Go back</a><br>");

        // TODO temp
        Iterator<String[]> iterator = request.getParameterMap().values().iterator();

        while (iterator.hasNext())
        {

            System.out.println("new thing");
            for (String s : iterator.next())
            {
                System.out.println(s);
            }
        }

        // Figure out what queryType was, then fire corresponding method
        switch (request.getParameter("queryType"))
        {
            case "selectAll":
                SelectAll sa = new SelectAll();
                try {
                    sa.execute(request, response, conn, pstmt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "selectPremade":
            case "customQuery":
                break;
            case "addEntry":
                AddEntry ae = new AddEntry();
                try {
                    ae.execute(request, response, conn, pstmt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                break;
        }

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
