package introtodatabasesproject.core;

import introtodatabasesproject.entry.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.security.acl.Owner;

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

        // Load config file
        System.out.println("Loading config file...");
        loadConfig();
    }

    private static void loadConfig()
    {
        // Do ../ twice to get out of core, then introtodatabasesproject
        // TODO make this not hell
        File config = new File("../conf/project_config.xml");

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
            System.out.println(config.getAbsolutePath());
        }
    }
}
