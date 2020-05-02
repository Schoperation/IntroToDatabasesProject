package introtodatabasesproject.entry;

public class AgentEntry extends RowEntry
{

    /*
        Agents

        CREATE TABLE Agent (
        percentCommission INT NOT NULL,
        company VARCHAR(50) NOT NULL,
        agentID INT PRIMARY KEY
        );
     */
    public static final AgentEntry DUMMY_ENTRY = new AgentEntry(20, "bb and co", 0);

    public AgentEntry(int percentCommission, String company, int agentID)
    {
        super();

        data.add(percentCommission);
        data.add(company);
        data.add(agentID);

        determineDataTypes(data);

        dataLabels.add("% Commission");
        dataLabels.add("Company");
        dataLabels.add("Agent ID");

        length = data.size();
        primaryKeyIndex = 2;
    }
}
