<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
  <%@ include file="links.jsp" %>
  
  <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SIGN UP FORM</title>
<script>
$(function(){
$('input[name=dateofBirth]').datepicker({
	format:'YYYY-mm-dd'
});	
});
</script>
<style>
body{
background-size:contain;
background-repeat:no-repeat;
background-attachment:fixed;
background-size:100% 100%;

}
.c1{
  color:white;
}
</style>
</head>
<body   background="resources/images/bg1.1.jpg" >
<nav class=" container navbar navbar-inverse navbar-fixed-top" style="background-color:transparent;border-style: none;"> 
  <div class="container"  style="background-color:midnightblue;">
    <div class="navbar-header">

      <a class="navbar-brand " href="#"><!-- <img src="resources/images/kdslogo.JPG" class="img-circle" height="30" width="100"/> --><b  style="color:white;">  CP WORLD</b></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="home"><b  style="color:white;"><span class="glyphicon glyphicon-home " ></span></b></a></li>
      <li><a href="#"><b  style="color:white;">ABOUT US</b></a></li>
      <li class=""><a href="#"><b  style="color:white;">CONTACT US</b></a></li>
    
      <!--  <li class=""><a href="reqLoginPage">LOGIN</a></li> -->
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="reqSignUp"><b  style="color:white;"><span class="glyphicon glyphicon-user"></span>SignUp</b></a></li>
      <li><a href="reqspringloginpage"><b  style="color:white;"><span class="glyphicon glyphicon-log-in"></span>  Login</b></a></li>
    </ul>

  </div>
</nav>

<div class="col-sm-4"></div>
<kds:form class="form-horizontal c1" action="reqSendSignUpData" commandName="userObj" method="POST" enctype="multipart/form-data" align="center">
<div class="col-sm-6" style="background:rgba(0,0,50,0.6)">
 <div class="card">
    <div class="card-block">
    
    	    <!--Header-->
        <div class="form-header" >
            <h3 ><b><i class="c1">Create Account:</i></b></h3>
        </div>
<div>
<kds:hidden path="userid"/>
<label for="firstname">Enter First Name</label>
<kds:input style="background-color:transparent"  path="firstname" placeholder="First Name"/>
<kds:errors path="firstname"></kds:errors>
</div>

<div>
<label for="lastname">Enter Last Name</label>
<kds:input  style="background-color:transparent" path="lastname" placeholder="Last Name"/>
</div>
<div>
<label for="email">Enter Email ID</label>
<kds:input   style="background-color:transparent" path="email" placeholder="abcd@xyz.com"/>
</div>
<div>
<label  for="dateofBirth">Enter Date Of birth</label>
<kds:input  style="background-color:transparent" path="dateofBirth" placeholder="YYYY-MM-DD"/>
</div>
<div>
<label  for="password">Enter Password</label>
<kds:password  style="background-color:transparent" path="password" placeholder="CreatePassword"/>
</div>
<div >
<label for="contact">Enter Mobile Number</label>
<kds:input  style="background-color:transparent" path="contact" pattern="[789]\d{9}" placeholder="Enter 10 digit mobile number"/>
</div>
<div>
<label  for="address">Enter Your Address</label>
<kds:input  style="background-color:transparent" path="address" placeholder="Enter your address" />
</div>
<div>
<label for="city">Enter Your city</label>
<kds:input  style="background-color:transparent" path="city" placeholder="Enter your City"/>
</div>
<div>
<label  for="zipcode">Enter Zipcode</label>
<kds:input  style="background-color:transparent" path="zipcode" placeholder="Enter Zipcode"/>
</div>
<div>
<label for="country">Enter Your Country</label>
<kds:input  style="background-color:transparent" path="country" placeholder="Enter Country"/>
</div>
 <div>
<label   for="imagefile">Select Image</label>
<kds:input  style="background-color:transparent" type="file" path="imagefile" />
</div> 
<div>
<br> <kds:button class="btn btn-primary" align="center" >SignUp</kds:button>
<div class="modal-footer">
        <div class="options">
        </div>
        </div>
</div>
</div>
</div>
</div>

</kds:form>
</body>
</html>