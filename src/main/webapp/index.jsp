<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>

    <!-- Javascript for showing/hiding elements -->
    <script language="javascript" type="text/javascript">

        function changeForm()
        {
            var list = document.getElementById("queryType");
            var elementValue = list.options[list.selectedIndex].value;

            <!-- block = shown, none = hidden ... i know its weird -->
            if (elementValue == "selectAll")
            {
                document.getElementById("selectAll").style.display = "block";
                document.getElementById("selectSome").style.display = "none";
                document.getElementById("selectPremade").style.display = "none";
                document.getElementById("customQuery").style.display = "none";
                document.getElementById("addEntry").style.display = "none";
            }
            else if (elementValue == "selectSome")
            {
                document.getElementById("selectAll").style.display = "none";
                document.getElementById("selectSome").style.display = "block";
                document.getElementById("selectPremade").style.display = "none";
                document.getElementById("customQuery").style.display = "none";
                document.getElementById("addEntry").style.display = "none";
            }
            else if (elementValue == "selectPremade")
            {
                document.getElementById("selectAll").style.display = "none";
                document.getElementById("selectSome").style.display = "none";
                document.getElementById("selectPremade").style.display = "block";
                document.getElementById("customQuery").style.display = "none";
                document.getElementById("addEntry").style.display = "none";
            }
            else if (elementValue == "customQuery")
            {
                document.getElementById("selectAll").style.display = "none";
                document.getElementById("selectSome").style.display = "none";
                document.getElementById("selectPremade").style.display = "none";
                document.getElementById("customQuery").style.display = "block";
                document.getElementById("addEntry").style.display = "none";
            }
            else if (elementValue == "addEntry")
            {
                document.getElementById("selectAll").style.display = "none";
                document.getElementById("selectSome").style.display = "none";
                document.getElementById("selectPremade").style.display = "none";
                document.getElementById("customQuery").style.display = "none";
                document.getElementById("addEntry").style.display = "block";
            }
        }

        function changeTable()
        {
            var list = document.getElementById("table1");
            var elementValue = list.options[list.selectedIndex].value;

            <!-- block = shown, none = hidden ... i know its weird -->
            if (elementValue == "myTestTable")
            {
                document.getElementById("myTestTable_divadd").style.display = "block";
                document.getElementById("myTestTable_divselect").style.display = "block";
                document.getElementById("Address_divadd").style.display = "none";
            }
            else if (elementValue == "Address")
            {
                document.getElementById("myTestTable_divadd").style.display = "none";
                document.getElementById("myTestTable_divselect").style.display = "none";
                document.getElementById("Address_divadd").style.display = "block";
            }
        }

        function changePremade()
        {
            <!-- todo -->
        }

    </script>
</head>
<body onload=changeForm()>
    <h1>Database Project</h1>
    <p>If you can read this, congrats you are not dumb...</p>

    <!-- This is the form that will be submitted and processed by MainServlet -->
    <form action="mainServlet" method="post">

    <h3>What would you like to do?</h3><br />
    <select id="queryType" name="queryType" onchange=changeForm()>
        <option value="selectAll" selected="selected">View an entire table</option>
        <option value="selectSome">View entries that follow a condition</option>
        <option value="selectPremade">Use a premade query</option>
        <option value="customQuery">Enter in a custom query</option>
        <option value="addEntry">Add an entry to a table</option>
    </select><p />

    <div id="selectAll">
        <label for="table1">Select all elements from </label>
    </div>

    <div id="selectSome">
        <label for="table1">Select...</label>
        <div id="myTestTable_divselect">
            <label for="myTestTable_name1">Name: </label>
            <input type="checkbox" id="myTestTable_name1" name="myTestTable_name1" /><br />
            <label for="myTestTable_id1">ID: </label>
            <input type="checkbox" id="myTestTable_id1" name="myTestTable_id1" /><br />
        </div>

        where <input type="text" name="condition" value="condition" size=20 />
    </div>

    <div id="selectPremade">
        <label for="premadeList">Select query: </label>
        <select id="premadeList" name="premadeList" onchange=changePremade()>
            <option value="premade1">List all the homes owned by a given owner in a given city</option>
            <option value="premade2">List all the homes that were sold more than once</option>
            <option value="premade3">Find the most expensive home an owner ever bought</option>
            <option value="premade4">Find all the homes that include all e appliances by the same maker</option>
            <option value="premade5">Find owners who do not own the homes they used to own</option>
            <option value="premade6">Find the total commissions earned by an agent. Assume that commission earned is on the purchased price of a home he/she sells</option>
            <option value="premade7">Find people who own apartments as well as mansions</option>
            <option value="premade8">List all the homes below a price in a given city</option>
            <option value="premade9">List owners who own all the most expensive homes in a given city</option>
            <option value="premade10">Find homes that up for sale in a given city that meet certain buyer choices such as number of bedrooms, baths, etc</option>
        </select>

        <div id="premade1">
            <p>
                List all homes owned by
                <input type="text" name="premade1_owner" value="owner" size=10 />
                in the city of
                <input type="text" name="premade1_city" value="city" size=10 />
            </p>
        </div>
        <div id="premade2"></div>
        <div id="premade3"></div>
        <div id="premade4"></div>
        <div id="premade5"></div>
        <div id="premade6"></div>
        <div id="premade7"></div>
        <div id="premade8"></div>
        <div id="premade9"></div>
        <div id="premade10"></div>

    </div>

    <div id="customQuery">
    </div>

    <div id="addEntry">

        <!-- Different things for different tables -->
        <div id="myTestTable_divadd">
            <label for="myTestTable_name">Name: </label>
            <input type="text" id="myTestTable_name" name="myTestTable_name" width=12 /><br />
            <label for="myTestTable_id">ID: </label>
            <input type="text" id="myTestTable_id" name="myTestTable_id" width=6 /><br />
        </div>
        <div id="Address_divadd">
        </div>
    </div>

    <!-- Drop down with all tables -->
    <select id="table1" name="table1" onchange=changeTable()>
        <option value="myTestTable">myTestTable</option>
        <option value="Address">Address</option>
    </select>

    <input type="submit" value="Submit Query" />
    </form>
</body>
</html>