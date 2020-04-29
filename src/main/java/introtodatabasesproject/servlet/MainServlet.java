package introtodatabasesproject.servlet;

import introtodatabasesproject.core.DatabaseMain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

        // Figure out what queryType was, then fire corresponding method
        switch (request.getParameter("queryType"))
        {
            case "selectAll":
                SelectAll sa = new SelectAll();
                try {
                    sa.execute(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "selectSome":
            case "selectPremade":
            case "addEntry":
            case "customQuery":
            default:
                break;
        }
        // TODO flesh this out
        // Grab form elements
        String table = request.getParameter("table");

        // Output/write html code
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Results for table " + table + ":</h1>");
        writer.close();
    }
}
