package introtodatabasesproject.servlet;

import introtodatabasesproject.core.TableCmds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class FindHome implements IQuery
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, Connection conn, PreparedStatement pstmt) throws IOException, SQLException
    {
        // Get all the possible parameters of HomeEntry we can get
        // Put them all in a list
        ArrayList values = new ArrayList();
        String[] array = {"home.homeID", "floors", "bedrooms", "bathrooms", "landAcres_min", "landAcres_max", "floorSpace_min", "floorSpace_max", "type", "yearConstructed", "price_min", "price_max", "ssNumber", "agentID"};
        ArrayList<String> names = new ArrayList(Arrays.asList(array));

        for (String name : names)
        {
            if (request.getParameter("Home1_" + name).isEmpty())
                values.add(null);
            else
                values.add(request.getParameter("Home1_" + name));
        }

        // The above parameters are for the where condition; we'll just slap them all on with the and keyword
        StringBuilder sb = new StringBuilder();
        sb.append("select * from home where ");

        // Special parameters maker (appliance), name (owner), and city (location)
        if (!request.getParameter("Home1_city").isEmpty())
            sb.append("homeID in (select homeID from location where city = '" + request.getParameter("Home1_city") + "') and ");
        if (!request.getParameter("Home1_maker").isEmpty())
            sb.append("homeID in (select homeID from appliance where maker = '" + request.getParameter("Home1_maker") + "') and ");
        if (!request.getParameter("Home1_name").isEmpty())
            sb.append("ssNumber in (select ssNumber from owner where name = '" + request.getParameter("Home1_name") + "') and ");

        // Add the normals first
        int i;
        for (i = 0; i < values.size(); i++)
        {
            // Range item, minimum
            if (values.get(i) != null && names.get(i).contains("min"))
            {
                sb.append(names.get(i).replace("_min", ""));
                sb.append(" >= ");
                sb.append(values.get(i));
            }
            // Range item, maximum
            else if (values.get(i) != null && names.get(i).contains("max"))
            {
                sb.append(names.get(i).replace("_max", ""));
                sb.append(" <= ");
                sb.append(values.get(i));
            }
            // String
            else if (values.get(i) != null && values.get(i) instanceof String)
            {
                sb.append(names.get(i));
                sb.append(" = ");
                sb.append("'" + values.get(i) + "'");
            }
            // Normal item
            else if (values.get(i) != null)
            {
                sb.append(names.get(i));
                sb.append(" = ");
                sb.append(values.get(i));
            }

            // Is this the last item? If so, no AND
            if (values.get(i) != null)
                sb.append(" AND ");
        }

        // dummy condition
        sb.append("home.homeID > 0");

        String sql = sb.toString();

        System.out.println(sql);

        pstmt = conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();

        // Now print the results
        PrintWriter writer = response.getWriter();

        writer.println("<h1>Results for finding Home</h1>");
        writer.println("<h3>" + sql + "</h3>");
        TableCmds.generateTable(resultSet, writer);
        resultSet.close();
        writer.close();
    }
}
