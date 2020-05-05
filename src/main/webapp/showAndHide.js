function changeForm()
{
    var list = document.getElementById("queryType");
    var elementValue = list.options[list.selectedIndex].value;

    var possibleValues = ["selectHome", "selectOwner", "selectAgent", "selectPremade", "changeOwner", "selectAll", "addEntry", "customQuery"];

    // loop through possibleValues and change display depending on elementValue
    // block = shown, none = hidden ... i know its weird
    var i;
    for (i = 0; i < possibleValues.length; i++)
    {
        if (elementValue == possibleValues[i])
        {
            document.getElementById(possibleValues[i]).style.display = 'block';
        }
        else
        {
            document.getElementById(possibleValues[i]).style.display = 'none';
        }
    }

    changeTable();

    // Check if we even need to show the table dropdown
    if (elementValue == "selectAll" || elementValue == "addEntry")
    {
        document.getElementById("tableDropdown").style.display = 'block';
    }
    else
    {
        document.getElementById("tableDropdown").style.display = 'none';
    }
}

function changeTable()
{
    var list = document.getElementById("table1");
    var elementValue = list.options[list.selectedIndex].value;

    var possibleValues = ["Agent", "Appliance", "Home", "HomeTransaction", "Location", "Owner", "myTestTable"];
    var divIds = ["Agent_divadd", "Appliance_divadd", "Home_divadd", "HomeTransaction_divadd", "Location_divadd", "Owner_divadd", "myTestTable_divadd"];

    // loop through possibleValues and change display depending on elementValue
    // block = shown, none = hidden ... i know its weird
    var i;
    for (i = 0; i < possibleValues.length; i++)
    {
        if (elementValue == possibleValues[i])
        {
            document.getElementById(divIds[i]).style.display = 'block';
        }
        else
        {
            document.getElementById(divIds[i]).style.display = 'none';
        }
    }
}
