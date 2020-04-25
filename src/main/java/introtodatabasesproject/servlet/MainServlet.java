package introtodatabasesproject.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        // TODO flesh this out
        // Grab form elements
        String table = request.getParameter("table");

        // Output/write html code
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Results for table " + table + ":</h1>");
        writer.close();
    }
}
