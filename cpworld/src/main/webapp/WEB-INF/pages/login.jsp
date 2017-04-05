<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="links.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-size:contain;
background-repeat:no-repeat;
background-attachment:fixed;
background-size:100% 100%;

}
</style>
</head>
<body background="resources/images/login.jpg">
<nav class="navbar navbar-inverse">
<div class="container">

<ul class="nav navbar-nav">
<li class="active"><a href="home"><span class="glyphicon glyphicon-home"></span>HOME</a></li>
<li><a href="#">ABOUT US</a></li>
<li><a href="#">CONTACT US</a></li>
</ul>
<ul class="nav navbar-nav navbar-right">
<li><a href="customerSignupForm"><span class="glyphicon glyphicon-user"></span>SIGN UP</a></li>
<li class="active"><a href="reqLoginPage"><span class="glyphicon glyphicon-Login"></span>LOGIN</a></li>
</ul>
</div>
</nav>
<br>
<p align="center"><b>${message}</b></p>
<br>
<div class="col-sm-3">
</div>
<div class="col-sm-6" style="background:rgba(0,20,0,0.2)">
<kds:form commandName="userObj" action="reqLoginCheck" method="post" align="center">



<%-- <div class="card">
    <div class="card-block">

        <!--Header-->
        <div class="form-header  purple darken-4">
            <h3><i class="fa fa-lock"></i> Login:</h3>
        </div>

        <!--Body-->
        <div class="md-form">
            <i class="fa fa-envelope prefix"></i>
            <label for="form2">Your email</label>
      <!--       <input type="text" id="form2" class="form-control"> -->
      
            <kds:input path="userid"/>
            
        </div>

        <div class="md-form">
            <i class="fa fa-lock prefix"></i>
            <input type="password" id="form4" class="form-control">
            <label for="form4">Your password</label>
        </div>

        <div class="text-center">
            <button class="btn btn-deep-purple">Login</button>
        </div>

    </div>

    <!--Footer-->
    <div class="modal-footer">
        <div class="options">
            <p>Not a member? <a href="#">Sign Up</a></p>
            <p>Forgot <a href="#">Password?</a></p>
        </div>
    </div>

</div>
 --%>
<!--/Form with header-->
 <div class="card">
    <div class="card-block">
    
    	    <!--Header-->
        <div class="form-header" >
            <h3><i class="fa fa-lock" aria-hidden="true"></i>Login:</h3>
        </div>

 <label for="userid">Enter User ID:</label>
 <div class="form-group">
<kds:input path="userid"/>
</div> 

 <label for="password">Enter Password:</label>
	 <div class="form-group">
	<kds:password path="password"/>
	</div> 
  	<div class="text-center">
            <button class="btn btn-deep-purple">Login</button>
        </div>
	<div class="modal-footer">
        <div class="options">
            <p>Not a member? <a href="reqSignUp">Sign Up</a></p>
            <p>Forgot <a href="#">Password?</a></p>
        </div>
    </div>
    </div>
    </div>
    

</kds:form>
</div>
</body>
</html>