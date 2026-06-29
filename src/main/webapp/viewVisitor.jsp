<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>
<form method="post" action="MainServlet">
<h1>View Visitor</h1><br><br>
Visitor Name:<input type="text" name="visitorName"><br><br>
Visit Date:<input type="date" name="visitDate"><br><br>
<input type="hidden" name="operation" value="viewRecord">
<button type="submit" value="search">Search</button>
</form>
</body>
</html>