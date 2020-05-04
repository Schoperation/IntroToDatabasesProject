<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>

    <!-- Javascript for showing/hiding elements -->
    <script language="javascript" type="text/javascript" src="showAndHide.js"></script>
</head>
<body onload=changeForm() bgcolor="#00ccff">
    <h1>Database Project - Spring 2020</h1>
    <h4>Find the perfect home; or owner; or whatever!</h4><p />
    <h4>Version <%= introtodatabasesproject.core.DatabaseMain.VERSION %></h4>

    <!-- This is the form that will be submitted and processed by MainServlet -->
    <form action="mainServlet" method="post">

    <h3>What would you like to do?</h3><br />
    <select id="queryType" name="queryType" onchange=changeForm()>
        <option value="selectHome" selected="selected">Find a home...</option>
        <option value="selectOwner">Find an owner/transaction...</option>
        <option value="selectAgent">Find an agent&#39;s total commissions</option>
        <option value="changeOwner">Change Owner/Mark a House Sold</option>
        <option value="selectAll">View an entire datatable</option>
        <option value="addEntry">Add an entry to a table</option>
        <option value="customQuery">Enter in a custom query</option>
    </select><p />

    <!-- Drop down with all tables -->
    <div id="tableDropdown">
        <label for="table1"><b>Table: </b></label>
        <select id="table1" name="table1" onchange=changeTable()>
            <option value="myTestTable">myTestTable</option>
            <option value="Agent">Agent</option>
            <option value="Owner">Owner</option>
            <option value="Home" selected="selected">Home</option>
            <option value="Location">Location</option>
            <option value="Appliance">Appliance</option>
            <option value="HomeTransaction">HomeTransaction</option>
        </select>
    <p />
    </div>

    <div id="selectHome">
        <h5>Fill in the information to your heart&#39;s desire. Not all need to be filled in, but at least one field does.</h5>
        <label for="Home1_home.homeID">Home ID: </label>
        <input type="text" id="Home1_home.homeID" name="Home1_home.homeID" size=12 /><br />
        <label for="Home1_floors">Floors (exact): </label>
        <input type="text" id="Home1_floors" name="Home1_floors" size=12 /><br />
        <label for="Home1_bedrooms">Bedrooms (exact): </label>
        <input type="text" id="Home1_bedrooms" name="Home1_bedrooms" size=12 /><br />
        <label for="Home1_bathrooms"> Bathrooms (exact): </label>
        <input type="text" id="Home1_bathrooms" name="Home1_bathrooms" size=12 /><br />

        <label for="Home1_landAcres_min">Land Acres: (MIN, MAX)</label>
        <input type="text" id="Home1_landAcres_min" name="Home1_landAcres_min" value=0 size=6 />
        <input type="text" id="Home1_landAcres_max" name="Home1_landAcres_max" size=6 /><br />

        <label for="Home1_floorSpace_min">Floor Space (sqft) (MIN, MAX): </label>
        <input type="text" id="Home1_floorSpace_min" name="Home1_floorSpace_min" value=0 size=6 />
        <input type="text" id="Home1_floorSpace_max" name="Home1_floorSpace_max" size=6 /><br />

        <label for="Home1_type">Type (Apartment, Mansion, Townhome, Condo): </label>
        <input type="text" id="Home1_type" name="Home1_type" size=12 /><br />
        <label for="Home1_yearConstructed">Year Constructed: </label>
        <input type="text" id="Home1_yearConstructed" name="Home1_yearConstructed" size=12 /><br />

        <label for="Home1_price_min">Price: (MIN, MAX)</label>
        <input type="text" id="Home1_price_min" name="Home1_price_min" value=0 size=6 />
        <input type="text" id="Home1_price_max" name="Home1_price_max" size=6 /><br />

        <br>At least one or the other is required. Put a -1 in blank ones.</br>
        <label for="Home1_ssNumber">SS Number: </label>
        <input type="text" id="Home1_ssNumber" name="Home1_ssNumber" size=12 /><br />
        <label for="Home1_agentID">Agent ID: </label>
        <input type="text" id="Home1_agentID" name="Home1_agentID" size=12 /><br /><br />

        <label for="Home1_city">City: </label>
        <input type="text" id="Home1_city" name="Home1_city" size=12 /><br />
    </div>

    <div id="selectOwner">
        <p>Find the most expensive home an owner bought...</p>
        <p>OR</p>
        <p>Find all previous homes an owner has bought...</p>
    </div>

    <div id="selectAgent">
        <label for="Agent1_agentID">Agent ID: </label>
        <input type="text" id="Agent1_agentID" name="Agent1_agentID" size=12 /><br />
    </div>

    <div id="changeOwner">
        <p>Search through the tables the find ids, if needed.</p>
        <label for="newssNumber">Enter the New Owners SS Number: </label>
        <input type="text" id="newssNumber" name="newssNumber" size=12 /><br />
        <label for="newHomeID">Enter the ID of the Home: </label>
        <input type="text" id="newHomeID" name="newHomeID" size=12 /><br />
        <label for="newPrice">Enter the Price: </label>
        <input type="text" id="newPrice" name="newPrice" size=12 /><br />
    </div>

    <div id="selectAll">
        <label for="table1">See all entries in the above table...</label>
    </div>

    <div id="addEntry">

        <!-- Different things for different tables -->
        <div id="myTestTable_divadd">
            <label for="myTestTable_name">Name: </label>
            <input type="text" id="myTestTable_name" name="myTestTable_name" size=12 /><br />
            <label for="myTestTable_id">ID: </label>
            <input type="text" id="myTestTable_id" name="myTestTable_id" size=4 /><br />
        </div>
        <div id="Agent_divadd">
            <label for="Agent_percentCommission">% Commission: </label>
            <input type="text" id="Agent_percentCommission" name="Agent_percentCommission" size=4 /><br />
            <label for="Agent_company">Company: </label>
            <input type="text" id="Agent_company" name="Agent_company" size=12 /><br />
            <label for="Agent_agentID">Agent ID: </label>
            <input type="text" id="Agent_agentID" name="Agent_agentID" size=6 /><br />
        </div>
        <div id="Appliance_divadd">
            <label for="Appliance_name">Appliance Name: </label>
            <input type="text" id="Appliance_name" name="Appliance_name" size=10 /><br />
            <label for="Appliance_price">Price: </label>
            <input type="text" id="Appliance_price" name="Appliance_price" size=6 /><br />
            <label for="Appliance_maker">Maker: </label>
            <input type="text" id="Appliance_maker" name="Appliance_maker" size=12 /><br />
            <label for="Appliance_year">Year: </label>
            <input type="text" id="Appliance_year" name="Appliance_year" size=12 /><br />
            <label for="Appliance_modelName">Model Name: </label>
            <input type="text" id="Appliance_modelName" name="Appliance_modelName" size=12 /><br />
            <label for="Appliance_homeID">Home ID: </label>
            <input type="text" id="Appliance_homeID" name="Appliance_homeID" size=12 /><br />
        </div>
        <div id="Home_divadd">
            <label for="Home_homeID">Home ID: </label>
            <input type="text" id="Home_homeID" name="Home_homeID" size=12 /><br />
            <label for="Home_floors">Floors: </label>
            <input type="text" id="Home_floors" name="Home_floors" size=12 /><br />
            <label for="Home_bedrooms">Bedrooms: </label>
            <input type="text" id="Home_bedrooms" name="Home_bedrooms" size=12 /><br />
            <label for="Home_bathrooms"> Bathrooms: </label>
            <input type="text" id="Home_bathrooms" name="Home_bathrooms" size=12 /><br />
            <label for="Home_landAcres">Land Acres: </label>
            <input type="text" id="Home_landAcres" name="Home_landAcres" size=12 /><br />
            <label for="Home_floorSpace">Floor Space (sqft): </label>
            <input type="text" id="Home_floorSpace" name="Home_floorSpace" size=12 /><br />
            <label for="Home_type">Type (Apartment, Mansion, Townhome, Condo): </label>
            <input type="text" id="Home_type" name="Home_type" size=12 /><br />
            <label for="Home_yearConstructed">Year Constructed: </label>
            <input type="text" id="Home_yearConstructed" name="Home_yearConstructed" size=12 /><br />
            <label for="Home_price">Price: </label>
            <input type="text" id="Home_price" name="Home_price" size=12 /><br />
            <br>At least one or the other is required. Put a -1 in blank ones.</br>
            <label for="Home_ssNumber">SS Number: </label>
            <input type="text" id="Home_ssNumber" name="Home_ssNumber" size=12 /><br />
            <label for="Home_agentID">Agent ID: </label>
            <input type="text" id="Home_agentID" name="Home_agentID" size=12 /><br />
        </div>
        <div id="HomeTransaction_divadd">
            <label for="HomeTransaction_transID">Trans ID: </label>
            <input type="text" id="HomeTransaction_transID" name="HomeTransaction_transID" size=12 /><br />
            <label for="HomeTransaction_homeID">Home ID: </label>
            <input type="text" id="HomeTransaction_homeID" name="HomeTransaction_homeID" size=12 /><br />
            <label for="HomeTransaction_ssNumber">SS Number: </label>
            <input type="text" id="HomeTransaction_ssNumber" name="HomeTransaction_ssNumber" size=12 /><br />
            <label for="HomeTransaction_agentID">Agent ID: </label>
            <input type="text" id="HomeTransaction_agentID" name="HomeTransaction_agentID" size=12 /><br />
            <label for="HomeTransaction_price">Price: </label>
            <input type="text" id="HomeTransaction_price" name="HomeTransaction_price" size=12 /><br />
        </div>
        <div id="Location_divadd">
            <label for="Location_streetNumber">Street Number: </label>
            <input type="text" id="Location_streetNumber" name="Location_streetNumber" size=12 /><br />
            <label for="Location_streetName">Street Name: </label>
            <input type="text" id="Location_streetName" name="Location_streetName" size=12 /><br />
            <label for="Location_unitNumber">Unit Number (1 if none): </label>
            <input type="text" id="Location_unitNumber" name="Location_unitNumber" size=12 /><br />
            <label for="Location_city">City: </label>
            <input type="text" id="Location_city" name="Location_city" size=12 /><br />
            <label for="Location_zipCode">Zip Code: </label>
            <input type="text" id="Location_zipCode" name="Location_zipCode" size=12 /><br />
            <label for="Location_county">County: </label>
            <input type="text" id="Location_county" name="Location_county" size=12 /><br />
            <label for="Location_homeID">Home ID: </label>
            <input type="text" id="Location_homeID" name="Location_homeID" size=12 /><br />
        </div>
        <div id="Owner_divadd">
            <label for="Owner_name">Full Name: </label>
            <input type="text" id="Owner_name" name="Owner_name" size=12 /><br />
            <label for="Owner_ssNumber">SS Number: </label>
            <input type="text" id="Owner_ssNumber" name="Owner_ssNumber" size=12 /><br />
            <label for="Owner_age">Age: </label>
            <input type="text" id="Owner_age" name="Owner_age" size=12 /><br />
            <label for="Owner_dependents"># of Dependents: </label>
            <input type="text" id="Owner_dependents" name="Owner_dependents" size=12 /><br />
            <label for="Owner_yearlyIncome">Yearly Income: </label>
            <input type="text" id="Owner_yearlyIncome" name="Owner_yearlyIncome" size=12 /><br />
            <label for="Owner_profession">Profession: </label>
            <input type="text" id="Owner_profession" name="Owner_profession" size=12 /><br />
        </div>
    </div>

    <div id="customQuery">
        <br>Include the SELECT</br>
        <label for="customQueryText">Enter Oracle SQL SELECT Query: </label><br />
        <input type="text" name="customQueryText" id="customQueryText" size=60 />
    </div>

    <input type="submit" value="Submit Query" />
    </form>
</body>
</html>