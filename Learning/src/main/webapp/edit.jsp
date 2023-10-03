<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.cestar.model.BankAccount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body style="background-color:#abcdef ">

<%    

  BankAccount account=(BankAccount)session.getAttribute("account_to_edit");

session.setAttribute("old_id", account.getAccount_id());

%>
<h1 style="text-align:center; color:#6f2da8;margin-top:10px;">Edit Account Information</h1><br>
<form action="update" style="margin-left:400px;">


  <div class="col-sm-8">
   <h5> <label for="id" class="form-label"> Account Id</label></h5>
    <input type="text" class="form-control" id="id" name="new_id" value="<%=account.getAccount_id() %>">
   
  </div><br>
  <div class="col-sm-8">
  <h5>  <label for="id" class="form-label">Account Type</label></h5>
    <input type="text" class="form-control" id="id" name="type" value="<%=account.getAccont_type() %>">
   
  </div><br>
  <div class="col-sm-8">
   <h5> <label for="name" class="form-label">Account Holder Name</label></h5>
    <input type="text" class="form-control" id="name" name="name" value="<%=account.getAccountHolderName() %>">
   
  </div>
  <br>
  <div class="col-sm-8">
   <h5> <label for="con" class="form-label">Account Holder Contact</label></h5>
    <input type="text" class="form-control" id="con" name="con" value="<%=account.getAccountHolderContact() %>" >
   
  </div>
  <br>
  <div class="col-sm-8">
   <h5> <label for="book_issued" class="form-label">Account Balance</label></h5>
    <input type="text" class="form-control" id="book_issued" name="balance" value="<%=account.getAccountBalance() %>">
   
  </div>
  <br>
  <div class="col-sm-8">
   <h5> <label for="date" class="form-label">Account Setup Date</label></h5>
    <input type="date" class="form-control" id="date_issued" name="date" value="<%=account.getAccountSetupDate() %>" >
   
  </div>
  <br>
  
  
  <button type="submit" class="btn btn-success">Update Account Information</button>
</form>


   
</body>
</html>