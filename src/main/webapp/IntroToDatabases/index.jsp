<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h1>Database Project</h1>
    <p>If you can read this, congrats you are not dumb...</p>

    <form action="mainServlet" method="post">
    <label for="table">Select all elements from </label>
    <select id="table" name="table">
        <option value="myTestTable">myTestTable</option>
    </select>
    <input type="submit" value="Submit Query" />
    </form>
</body>
</html>