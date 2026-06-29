<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
</head>
<body>
<form method="post" action="MainServlet">
<h1>Add Visitor</h1><br><br>
Visitor Name:<input type="text" name="visitorName"><br><br>
Purpose:<input type="text" name="purpose"><br><br>
Visit Date:<input type="date" name="visitDate"><br><br>
Contact No:<input type="text" name="contactNo"><br><br>
Remarks:<input type="text" name="remarks"><br><br>
<input type="hidden" name="operation" value="newRecord">
<button type="submit" value="add">Add</button>
</form>
</body>
</html>