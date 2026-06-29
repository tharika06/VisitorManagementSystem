<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wipro.visitor.bean.VisitorBean" %>
<% VisitorBean bean=(VisitorBean)request.getAttribute("visitor"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<h1>Details</h1>
<body>
<% if (bean!=null)
	{
	%>
<table border="1">
<tr>
<th>VisitorId</th>
<th>VisitorName</th>
<th>Purpose</th>
<th>VisitDate</th>
<th>ContactNo</th>
<th>Remarks</th>
</tr>

<tr>
<td><%=bean.getVisitorId() %></td>
<td><%=bean.getVisitorName() %></td>
<td><%=bean.getPurpose() %></td>
<td><%=bean.getVisitDate() %></td>
<td><%=bean.getContactNo() %></td>
<td><%=bean.getRemarks() %></td>
</tr>

</table>
<%
}
else
{
%>
<h1>No matching records exists!Please try again</h1>
<%} %>
</body>
</html>