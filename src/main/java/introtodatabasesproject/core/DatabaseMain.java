package main.java.introtodatabasesproject.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseMain
{
    // Some constants.. username, password, address of database...
    public static final String USER = "system";
    public static final String PASSWORD = "data21";
    public static final String DB_ADDRESS = "jdbc:oracle:thin:@localhost:1521:orcl";

    public static void main(String args[])
    {
        System.out.println("Welcome to the crappy databases project!");

        // Load driver
        try
        {
            System.out.println("Loading driver...");
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        // Ask for info, temporary stuff
        Scanner scan = new Scanner(System.in);

        /*
        System.out.println("StreetNumber? ");
        int streetNumber = scan.nextInt();
        scan.nextLine();

        System.out.println("StreetName? ");
        String streetName = scan.nextLine();

        System.out.println("UnitNumber? ");
        int unitNumber = scan.nextInt();

        System.out.println("ZipCode? ");
        int zipCode = scan.nextInt();

        System.out.println("City? ");
        String city = scan.nextLine();
        scan.nextLine();

        System.out.println("County? ");
        String county = scan.nextLine();
        scan.nextLine();
        */

        int streetNumber = 777;
        String streetName = "vyra way";
        int unitNumber = 69;
        int zipCode = 90930;
        String city = "ussl";
        String county = "rotterdam";

        //addAddress(streetNumber, streetName, unitNumber, zipCode, city, county);

        scan.close();
    }

    // Add an entry to the Addresses table. Will be copied for Locations, Houses, Agents, Appliances, and Owners
    public static void addAddress(int streetNumber, String streetName, int unitNumber, int zipCode, String city, String county)
    {
        // Actual sql command... in the try {} is what we'll attempt to insert
        String sql = "INSERT INTO Addresses VALUES (?,?,?,?,?,?)";
        try
        {
            Connection conn = DriverManager.getConnection(DB_ADDRESS, USER, PASSWORD);

            // Turn the sql command into a prepared statement, and fill in the question marks.
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, streetNumber);
            pstmt.setString(2, streetName);
            pstmt.setInt(3, unitNumber);
            pstmt.setInt(4, zipCode);
            pstmt.setString(5, city);
            pstmt.setString(6, county);
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
