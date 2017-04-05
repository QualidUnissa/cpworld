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
<nav class="navbar navbar-inverse">

<div class="navbar-header">
      <a class="navbar-brand"  class="active" href="#">CP WORLD</a>
    </div>
<div class="container">
<ul class="nav navbar-nav">
<li class="active"><a href="home"><span class="glyphicon glyphicon-home"></span>HOME</a></li>
<li><a href="#">ABOUT US</a></li>
<li><a href="#">CONTACT US</a></li>
</ul>
<ul class="nav navbar-nav navbar-right">
<li class="active"><a href="reqSignUp"><span class="glyphicon glyphicon-user"></span>SIGN UP</a></li>
<li><a href="reqLoginPage"><span class="glyphicon glyphicon-Login"></span>LOGIN</a></li>
</ul>
</div>
</nav>

<div class="col-sm-4"></div>
<kds:form class="form-horizontal" action="reqSendEditDatatoDB" commandName="userData" method="POST">
<div class="col-sm-6" style="background:rgba(0,0,50,0.6)">
 <div class="card">
    <div class="card-block">
    
    	    <!--Header-->
        <div class="form-header" >
            <h3 ><b><i class="c1">Edit Profile:</i></b></h3>
        </div>
<kds:hidden path="userid"/>
<div>
<label for="firstname" class="c1">Enter First Name</label>
<kds:input class="c1" style="background-color:transparent" path="firstname" placeholder="First Name"/>
</div>
<!--<kds:errors path="firstname"></kds:errors> -->
<div>
<label  class="c1" for="lastname">Enter Last Name</label>
<kds:input class="c1"  style="background-color:transparent" path="lastname" placeholder="Last Name"/>
</div>
<div class="c1">
<label  class="c1" for="email">Enter Email ID</label>
<kds:input   style="background-color:transparent" path="email" placeholder="abcd@xyz.com"/>
</div>
<div class="c1">
<label  class="c1" for="dateofBirth">Enter Date Of birth</label>
<kds:input  style="background-color:transparent" path="dateofBirth" placeholder="YYYY-MM-DD"/>
</div>
<div class="c1">
<label  class="c1" for="password">Enter Password</label>
<kds:hidden  style="background-color:transparent" path="password" placeholder="CreatePassword"/>
</div>
<div class="c1">
<label  class="c1" for="contact">Enter Mobile Number</label>
<kds:input  style="background-color:transparent" path="contact" pattern="[789]\d{9}" placeholder="Enter 10 digit mobile number"/>
</div>
<div class="c1">
<label  class="c1" for="address">Enter Your Address</label>
<kds:input  style="background-color:transparent" path="address" placeholder="Enter your address" />
</div>
<div class="c1">
<label  class="c1" for="city">Enter Your city</label>
<kds:input  style="background-color:transparent" path="city" placeholder="Enter your City"/>
</div>
<div class="c1">
<label  class="c1" for="zipcode">Enter Zipcode</label>
<kds:input  style="background-color:transparent" path="zipcode" placeholder="Enter Zipcode"/>
</div>
<div class="c1">
<label  class="c1" for="country">Enter Your Country</label>
<kds:input  style="background-color:transparent" path="country" placeholder="Enter Country"/>
</div>
<%-- <div class="c1">
<label  class="c1" for="imagefile">Select Image</label>
<kds:input  style="background-color:transparent" type="file" path="imagefile" align="center" readonly="true"/>
</div> --%>
<div class="c1">
<br> <kds:button class="btn btn-primary" align="center" >Update</kds:button>
<div class="c1" class="modal-footer">
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