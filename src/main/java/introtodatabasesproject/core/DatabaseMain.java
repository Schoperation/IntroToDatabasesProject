package main.java.introtodatabasesproject.core;

import main.java.introtodatabasesproject.cmd.TableCmds;
import main.java.introtodatabasesproject.entry.LocationEntry;
import main.java.introtodatabasesproject.entry.TestEntry;

import java.io.File;
import java.io.FileInputStream;
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
            System.out.println("Couldn't load the driver! Make sure ojdbc6.jar is added as a dependency!");
        }

        // See if Tomcat is installed in the project directory (starts off in IntroToDatabasesProject folder, emcompassing entire project)
        if (new File("apache-tomcat-9.0.34/").exists())
            System.out.println("Tomcat directory detected. Hallelujah!");
        else
            System.out.println("WARNING: Can't find apache-tomcat-9.0.34 directory! Put it in the main directory (outside src)!");

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

        //TableCmds.insert("myTestTable", te);   already inserted

        //addAddress(streetNumber, streetName, unitNumber, zipCode, city, county);

        scan.close();
    }
}
