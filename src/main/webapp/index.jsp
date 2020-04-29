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
            if (elementValue == "selectAll")
            {
                document.getElementById("selectAll").style.display = "block";
                document.getElementById("selectSome").style.display = "none";
            }
            else if (elementValue == "selectSome")
            {
                document.getElementById("selectAll").style.display = "none";
                document.getElementById("selectSome").style.display = "block";
            }

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
        <option value="addEntry">Add an entry to a table</option>
        <option value="customQuery">Enter in a custom query</option>
    </select><p />

    <div id="selectAll">
        <label for="table1">Select all elements from </label>
        <select id="table1" name="table1">
            <option value="myTestTable">myTestTable</option>

        </select>
    </div>

    <div id="selectSome">
        <label for="table2">Select...</label>
        <input type="checkbox" value="gay" />
    </div>

    <div id="selectPremade">
    </div>

    <div id="addEntry">
    </div>

    <div id="customQuery">
    </div>

    <input type="submit" value="Submit Query" />
    </form>
</body>
</html>