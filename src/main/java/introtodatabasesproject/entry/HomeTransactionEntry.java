package introtodatabasesproject.entry;

public class HomeTransactionEntry extends RowEntry
{

    /*
        HomeTransactions

        CREATE TABLE HomeTransaction (
        transID INT PRIMARY KEY,
        homeID INT NOT NULL,
        ssNumber INT NOT NULL,
        agentID INT NOT NULL,
        price INT NOT NULL,
        FOREIGN KEY (homeID) REFERENCES Home(homeID),
        FOREIGN KEY (ssNumber) REFERENCES Owner(ssNumber),
        FOREIGN KEY (agentID) REFERENCES Agent(agentID)
        );
     */
    public static final HomeTransactionEntry DUMMY_ENTRY = new HomeTransactionEntry(2,2,2,2,222);

    public HomeTransactionEntry(int transID, int homeID, int ssNumber, int agentID, int price)
    {
        super();

        data.add(transID);
        data.add(homeID);
        data.add(ssNumber);
        data.add(agentID);
        data.add(price);

        determineDataTypes(data);

        dataLabels.add("Transaction ID");
        dataLabels.add("Home ID");
        dataLabels.add("SS Number");
        dataLabels.add("Agent ID");
        dataLabels.add("Price");

        length = data.size();
        primaryKeyIndex = 0;
    }
}
