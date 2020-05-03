package introtodatabasesproject.servlet;

import introtodatabasesproject.core.TableCmds;
import introtodatabasesproject.core.Tables;
import introtodatabasesproject.entry.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEntry implements IQuery
{

    /*
        For adding entries to a table
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, Connection conn, PreparedStatement pstmt) throws IOException, SQLException
    {
        // Get parameters
        String table = request.getParameter("table1");
        PrintWriter writer = response.getWriter();
        writer.println("Added new entry for " + table + ".");

        // Switch statement for getting the correct parameters
        // First grab the parameters for the respective table, put them in a new, specialized RowEntry, then call insert method
        switch (table)
        {
            case Tables.AGENT_TABLE:
                int percentCommission = Integer.parseInt(request.getParameter("Agent_percentCommission"));
                String company = request.getParameter("Agent_company");
                int agentID = Integer.parseInt(request.getParameter("Agent_agentID"));

                AgentEntry ae = new AgentEntry(percentCommission, company, agentID);
                TableCmds.insert(table, ae, conn, pstmt);
                writer.println("% Commission: " + percentCommission + ", Company: " + company + ", Agent ID: " + agentID);
                break;
            case Tables.OWNER_TABLE:
                String name = request.getParameter("Owner_name");
                int ssNumber = Integer.parseInt(request.getParameter("Owner_ssNumber"));
                int age = Integer.parseInt(request.getParameter("Owner_age"));
                int dependents = Integer.parseInt(request.getParameter("Owner_dependents"));
                int yearlyIncome = Integer.parseInt(request.getParameter("Owner_yearlyIncome"));
                String profession = request.getParameter("Owner_profession");

                OwnerEntry oe = new OwnerEntry(name, ssNumber, age, dependents, yearlyIncome, profession);
                TableCmds.insert(table, oe, conn, pstmt);
                writer.println("Owner " + oe.getData());
                break;
            case Tables.HOME_TABLE:
                int homeID = Integer.parseInt(request.getParameter("Home_homeID"));
                int floors = Integer.parseInt(request.getParameter("Home_floors"));
                int bedrooms = Integer.parseInt(request.getParameter("Home_bedrooms"));
                int bathrooms = Integer.parseInt(request.getParameter("Home_bathrooms"));
                float landAcres = Float.parseFloat(request.getParameter("Home_landAcres"));
                int floorSpace = Integer.parseInt(request.getParameter("Home_floorSpace"));
                String type = request.getParameter("Home_type");
                int yearConstructed = Integer.parseInt(request.getParameter("Home_yearConstructed"));
                int price = Integer.parseInt(request.getParameter("Home_price"));
                int ssNumber1 = Integer.parseInt(request.getParameter("Home_ssNumber"));
                int agentID1 = Integer.parseInt(request.getParameter("Home_agentID"));

                HomeEntry he = new HomeEntry(homeID, floors, bedrooms, bathrooms, landAcres, floorSpace, type, yearConstructed, price, ssNumber1, agentID1);
                TableCmds.insert(table, he, conn, pstmt);
                writer.println("Home: " + he.getData());
                break;
            case Tables.LOCATION_TABLE:
                int streetNumber = Integer.parseInt(request.getParameter("Location_streetNumber"));
                String streetName = request.getParameter("Location_streetName");
                int unitNumber = Integer.parseInt(request.getParameter("Location_unitNumber"));
                String city = request.getParameter("Location_city");
                int zipCode = Integer.parseInt(request.getParameter("Location_zipCode"));
                String county = request.getParameter("Location_county");
                int homeID1 = Integer.parseInt(request.getParameter("Location_homeID"));

                LocationEntry le = new LocationEntry(streetNumber, streetName, unitNumber, city, zipCode, county, homeID1);
                TableCmds.insert(table, le, conn, pstmt);
                writer.println("Location: " + le.getData());
                break;
            case Tables.APPLIANCE_TABLE:
                String name1 = request.getParameter("Appliance_name");
                int price1 = Integer.parseInt(request.getParameter("Appliance_price"));
                String maker = request.getParameter("Appliance_maker");
                int year = Integer.parseInt(request.getParameter("Appliance_year"));
                String modelName = request.getParameter("Appliance_modelName");
                int homeID2 = Integer.parseInt(request.getParameter("Appliance_homeID"));

                ApplianceEntry appe = new ApplianceEntry(name1, price1, maker, year, modelName, homeID2);
                TableCmds.insert(table, appe, conn, pstmt);
                writer.println("Appliance: " + appe.getData());
                break;
            case Tables.HOME_TRANSACTION_TABLE:
                int transID = Integer.parseInt(request.getParameter("HomeTransaction_transID"));
                int homeID3 = Integer.parseInt(request.getParameter("HomeTransaction_homeID"));
                int ssNumber2 = Integer.parseInt(request.getParameter("HomeTransaction_ssNumber"));
                int agentID2 = Integer.parseInt(request.getParameter("HomeTransaction_agentID"));
                int price2 = Integer.parseInt(request.getParameter("HomeTransaction_price"));

                HomeTransactionEntry hte = new HomeTransactionEntry(transID, homeID3, ssNumber2, agentID2, price2);
                TableCmds.insert(table, hte, conn, pstmt);
                writer.println("HomeTransaction: " + hte.getData());
                break;
            case Tables.TEST_TABLE:
            default:
                TestEntry te = new TestEntry(request.getParameter("myTestTable_name"), Integer.parseInt(request.getParameter("myTestTable_id")));
                TableCmds.insert(table, te, conn, pstmt);
                writer.println("Name: " + request.getParameter("myTestTable_name") + ", ID: " + request.getParameter("myTestTable_id"));
                break;
        }
    }
}
