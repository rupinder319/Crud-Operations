<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body style="background-color:#87cefa">
<h1 style="text-align:center; color:#324ab2;margin-top:10px;">Insert Account Information</h1><br>
<div class=container >
<form action="insert" style="margin-left:400px;">
  <div class="col-sm-8">
   <h5><label for=" account_id" class="form-label" style="color:#4b0082">Account ID</label></h5>
    <input type="text" class="form-control" id="account_id" name="id" >
   
  </div><br>
  <div class="col-sm-8">
    <h5><label for="type" class="form-label" style="color:#4b0082">Account Type</label></h5>
    <input type="text" class="form-control" id="type" name="type" >
   
  </div>
  <br>
  <div class="col-sm-8">
   <h5> <label for="name" class="form-label" style="color:#4b0082">Account Holder Name</label></h5>
    <input type="text" class="form-control" id="name" name="name" >
   
  </div>
  <br>
  <div class="col-sm-8">
  <h5>  <label for="con" class="form-label" style="color:#4b0082">Account Holder Contact</label></h5>
    <input type="text" class="form-control" id="con" name="con" >
   
  </div>
  <br>
  <div class="col-sm-8">
   <h5> <label for="balance" class="form-label" style="color:#4b0082">Account Balance</label></h5>
    <input type="text" class="form-control" id="balance" name="balance" >
   
  </div>
  <br>
  <div class="col-sm-8">
   <h5> <label for="date" class="form-label" style="color:#4b0082">Account SetupDate</label></h5>
    <input type="date" class="form-control" id="date" name="date" >
   
  </div><br>
  
  <button type="submit" class="btn btn-success">Insert Account Information</button>
</form>
</div>

</body>
</html>