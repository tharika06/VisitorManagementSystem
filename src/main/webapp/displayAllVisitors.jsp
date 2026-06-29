<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wipro.visitor.bean.VisitorBean" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<body>
<% 
List<VisitorBean> list=(List<VisitorBean>)request.getAttribute("visitor");
if(list!=null||!list.isEmpty()){
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
<%
for(VisitorBean bean:list)
{
%>
<tr>
<td><%=bean.getVisitorId() %></td>
<td><%=bean.getVisitorName() %></td>
<td><%=bean.getPurpose() %></td>
<td><%=bean.getVisitDate() %></td>
<td><%=bean.getContactNo() %></td>
<td><%=bean.getRemarks() %></td>
</tr>
<%
}
}
else
{
%>
<h1>No records available!</h1>
<%} %>
</table>
</body>
</html>