package main.java.introtodatabasesproject.core;

import main.java.introtodatabasesproject.cmd.TableCmds;
import main.java.introtodatabasesproject.entry.LocationEntry;
import main.java.introtodatabasesproject.entry.TestEntry;

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

        // testing stuff
        int streetNumber = 777;
        String streetName = "vyra way";
        int unitNumber = 69;
        int zipCode = 90930;
        String city = "ussl";
        String county = "rotterdam";

        LocationEntry le = new LocationEntry(streetNumber, streetName, unitNumber, zipCode, city, county);
        TestEntry te = new TestEntry("gay", 99);

        TableCmds.insert("myTestTable", te);

        //addAddress(streetNumber, streetName, unitNumber, zipCode, city, county);

        scan.close();
    }
}
