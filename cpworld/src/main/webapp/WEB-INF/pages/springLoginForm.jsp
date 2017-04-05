<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<title>LogIn</title>

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="css/style.css">
	<style>
	<%@include file="loginstyle.jsp"%>
	<%@include file="style.jsp"%>
	</style>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body background="resources/images/photo_bg.jpg">

<br>
<br>
<br>
	<div class="container">
		<!-- <div class="top">
			<h1 id="title" class="hidden"><span id="logo">LOGIN<span></span></span></h1>
		</div> -->
		<h3 class="c1" align="center">${message}
${error}
${logout}</h3>
		<form action="j_spring_security_check" method="post">
		<div class="login-box animated fadeInUp">
			<div class="box-header">
				<h2>Log In</h2>
			</div>
			<label for="username">UserID</label>
			<br/>
			<input type="text" name ="j_userid">
			<br/>
			<label for="password">Password</label>
			<br/>
			<input type="password" name="j_password">
			<br/>
			<button type="submit">Sign In</button>
			<br/>
			<a href="#"><p class="small">Forgot your password?</p></a>
			<br>
			<p class="small">Not a member ?<a href="customerSignupForm"> Sign Up</a></p>
			</form>
		</div>
	</div>
</body>

<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>

</html>