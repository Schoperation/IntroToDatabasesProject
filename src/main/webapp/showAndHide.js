function changeForm()
{
    changeTable();

    var list = document.getElementById("queryType");
    var elementValue = list.options[list.selectedIndex].value;

    <!-- block = shown, none = hidden ... i know its weird -->
    switch (elementValue)
    {
        case "selectAll":
            document.getElementById("selectAll").style.display = "block";
            document.getElementById("selectPremade").style.display = "none";
            document.getElementById("customQuery").style.display = "none";
            document.getElementById("addEntry").style.display = "none";
            document.getElementById("changeOwner").style.display = "none";
            break;
        case "selectPremade":
            document.getElementById("selectAll").style.display = "none";
            document.getElementById("selectPremade").style.display = "block";
            document.getElementById("customQuery").style.display = "none";
            document.getElementById("addEntry").style.display = "none";
            document.getElementById("changeOwner").style.display = "none";
            break;
        case "customQuery":
            document.getElementById("selectAll").style.display = "none";
            document.getElementById("selectPremade").style.display = "none";
            document.getElementById("customQuery").style.display = "block";
            document.getElementById("addEntry").style.display = "none";
            document.getElementById("changeOwner").style.display = "none";
            break;
        case "addEntry":
            document.getElementById("selectAll").style.display = "none";
            document.getElementById("selectPremade").style.display = "none";
            document.getElementById("customQuery").style.display = "none";
            document.getElementById("addEntry").style.display = "block";
            document.getElementById("changeOwner").style.display = "none";
            break;
        case "changeOwner":
            document.getElementById("selectAll").style.display = "none";
            document.getElementById("selectPremade").style.display = "none";
            document.getElementById("customQuery").style.display = "none";
            document.getElementById("addEntry").style.display = "none";
            document.getElementById("changeOwner").style.display = "block";
            break;
        default:
            document.getElementById("selectAll").style.display = "none";
            document.getElementById("selectPremade").style.display = "none";
            document.getElementById("customQuery").style.display = "none";
            document.getElementById("addEntry").style.display = "none";
            document.getElementById("changeOwner").style.display = "none";
            break;
    }
}

function changeTable()
{
    var list = document.getElementById("table1");
    var elementValue = list.options[list.selectedIndex].value;

    <!-- block = shown, none = hidden ... i know its weird -->
    switch (elementValue)
    {
        case "myTestTable":
            document.getElementById('myTestTable_divadd').style.display = 'block';
            document.getElementById('Agent_divadd').style.display = 'none';
            document.getElementById('Appliance_divadd').style.display = 'none';
            document.getElementById('Home_divadd').style.display = 'none';
            document.getElementById('HomeTransaction_divadd').style.display = 'none';
            document.getElementById('Location_divadd').style.display = 'none';
            document.getElementById('Owner_divadd').style.display = 'none';
            break;
        case "Agent":
            document.getElementById('myTestTable_divadd').style.display = 'none';
            document.getElementById('Agent_divadd').style.display = 'block';
            document.getElementById('Appliance_divadd').style.display = 'none';
            document.getElementById('Home_divadd').style.display = 'none';
            document.getElementById('HomeTransaction_divadd').style.display = 'none';
            document.getElementById('Location_divadd').style.display = 'none';
            document.getElementById('Owner_divadd').style.display = 'none';
            break;
        case "Appliance":
            document.getElementById('myTestTable_divadd').style.display = 'none';
            document.getElementById('Agent_divadd').style.display = 'none';
            document.getElementById('Appliance_divadd').style.display = 'block';
            document.getElementById('Home_divadd').style.display = 'none';
            document.getElementById('HomeTransaction_divadd').style.display = 'none';
            document.getElementById('Location_divadd').style.display = 'none';
            document.getElementById('Owner_divadd').style.display = 'none';
            break;
        case "Home":
            document.getElementById('myTestTable_divadd').style.display = 'none';
            document.getElementById('Agent_divadd').style.display = 'none';
            document.getElementById('Appliance_divadd').style.display = 'none';
            document.getElementById('Home_divadd').style.display = 'block';
            document.getElementById('HomeTransaction_divadd').style.display = 'none';
            document.getElementById('Location_divadd').style.display = 'none';
            document.getElementById('Owner_divadd').style.display = 'none';
            break;
        case "HomeTransaction":
            document.getElementById('myTestTable_divadd').style.display = 'none';
            document.getElementById('Agent_divadd').style.display = 'none';
            document.getElementById('Appliance_divadd').style.display = 'none';
            document.getElementById('Home_divadd').style.display = 'none';
            document.getElementById('HomeTransaction_divadd').style.display = 'block';
            document.getElementById('Location_divadd').style.display = 'none';
            document.getElementById('Owner_divadd').style.display = 'none';
            break;
        case "Location":
            document.getElementById('myTestTable_divadd').style.display = 'none';
            document.getElementById('Agent_divadd').style.display = 'none';
            document.getElementById('Appliance_divadd').style.display = 'none';
            document.getElementById('Home_divadd').style.display = 'none';
            document.getElementById('HomeTransaction_divadd').style.display = 'none';
            document.getElementById('Location_divadd').style.display = 'block';
            document.getElementById('Owner_divadd').style.display = 'none';
            break;
        case "Owner":
            document.getElementById('myTestTable_divadd').style.display = 'none';
            document.getElementById('Agent_divadd').style.display = 'none';
            document.getElementById('Appliance_divadd').style.display = 'none';
            document.getElementById('Home_divadd').style.display = 'none';
            document.getElementById('HomeTransaction_divadd').style.display = 'none';
            document.getElementById('Location_divadd').style.display = 'none';
            document.getElementById('Owner_divadd').style.display = 'block';
            break;
        default:
            document.getElementById('myTestTable_divadd').style.display = 'none';
            document.getElementById('Agent_divadd').style.display = 'none';
            document.getElementById('Appliance_divadd').style.display = 'none';
            document.getElementById('Home_divadd').style.display = 'none';
            document.getElementById('HomeTransaction_divadd').style.display = 'none';
            document.getElementById('Location_divadd').style.display = 'none';
            document.getElementById('Owner_divadd').style.display = 'none';
    }
}

function changePremade()
{
    <!-- todo -->
}