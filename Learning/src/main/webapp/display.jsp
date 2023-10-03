<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import ="java.util.List,com.cestar.model.BankAccount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body style="background-color:#e0ffff">
<%
List<BankAccount> accounts =(List)session.getAttribute("accounts_from_db");



%>
<h1 style="text-align:center; color:#6a5acd;margin-top:20px;">Accounts Information Page</h1><br><br>
<table class="table table-striped table-secondary" >

<tr>
<th>Account ID</th>
<th>Account Type</th>
<th>Account Holder Name</th>
<th>Holder Contact</th>
<th>Account Balance</th>
<th>Account SetupDate</th>
<th>Edit</th>
<th>Delete</th>

</tr>
<% 
     for(int i=0;i<accounts.size();i++){
    	 
    	 out.print("<tr>");
    	 
    	 out.print("<td>"+accounts.get(i).getAccount_id()+"</td>");
    	 
    	 out.print("<td>"+accounts.get(i).getAccont_type()+"</td>");
    	 
    	 out.print("<td>"+accounts.get(i).getAccountHolderName()+"</td>");
    	 
    	 out.print("<td>"+accounts.get(i).getAccountHolderContact()+"</td>");
    	 
    	 out.print("<td>"+accounts.get(i).getAccountBalance()+"</td>");
    	 
    	 out.print("<td>"+accounts.get(i).getAccountSetupDate()+"</td>");
    	 
    	 out.print("<td><a href='edit?id="+accounts.get(i).getAccount_id()+"' class='btn btn-primary'>Update</a></td>");
    	 
    	 out.print("<td><a href='delete?id="+accounts.get(i).getAccount_id()+"' class='btn btn-danger'>Delete</a></td>");
    	  
     }

%>
</table>
<div class="d-grid gap-2 col-6 mx-auto">
  <a class="btn btn-success" href="insert.jsp" role="button">Insert Account Record</a>
</div>

</body>
</html>