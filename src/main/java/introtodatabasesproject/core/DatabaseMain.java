package introtodatabasesproject.core;

import introtodatabasesproject.cmd.TableCmds;
import introtodatabasesproject.entry.LocationEntry;
import introtodatabasesproject.entry.TestEntry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class DatabaseMain
{
    // Some constants.. username, password, address of database... initialized in loadConfig();
    public static String username;
    public static String password;
    public static String dbAddress;

    public static void main(String args[])
    {
        System.out.println("Loading java init code...");

        // Load driver
        try
        {
            System.out.println("Loading driver...");
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Couldn't load the driver! Make sure ojdbc6.jar is in the libs folder!");
        }

        // See if Tomcat is installed in the project directory (starts off in IntroToDatabasesProject folder, emcompassing entire project)
        if (new File("apache-tomcat-9.0.34/").exists())
        {
            System.out.println("Tomcat directory detected. Hallelujah!");
        }
        else
            System.out.println("WARNING: Can't find apache-tomcat-9.0.34 directory! Put it in the main directory (outside src)!");

        // Load config file
        System.out.println("Loading config file...");
        loadConfig();

        // testing stuff
        int streetNumber = 777;
        String streetName = "vyra way";
        int unitNumber = 69;
        int zipCode = 90930;
        String city = "ussl";
        String county = "rotterdam";

        LocationEntry le = new LocationEntry(streetNumber, streetName, unitNumber, zipCode, city, county);
        TestEntry te = new TestEntry("k", 89);

        //TableCmds.insert("myTestTable", te);
        TableCmds.selectAll("myTestTable", te);
    }

    private static void loadConfig()
    {
        File config = new File("config.xml");

        try
        {
            // Create document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Turn our loaded file into a document instance
            Document document = builder.parse(config);
            document.getDocumentElement().normalize();

            // Grab a list of all database nodes (aka 1), turn it into a single one
            NodeList nodeList = document.getElementsByTagName("database");
            Node node = nodeList.item(0);

            // Now grab each child's content and set it as our username, oassword, and dbaddress
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                username = element.getElementsByTagName("username").item(0).getTextContent();
                password = element.getElementsByTagName("password").item(0).getTextContent();
                dbAddress = element.getElementsByTagName("database-url").item(0).getTextContent();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
