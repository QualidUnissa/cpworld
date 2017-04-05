<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="../pages/links.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file ="../pages/userNavbar.jsp" %>
<div class="container-wrapper">
<div class="container">
<div class="page-header">
<h1>Customer</h1>



<kds:form commandName="order" class="form-control">
<h3>Basic Info:</h3>

<div class="form-group">
<label for="name">First Name</label>
<kds:input path="cart.customer.customerName" class="form-Control" />
</div>


<div class="form-group">
<label for="email">Email</label>
<kds:input path="cart.customer.email" id="custemailid" class="form-Control" />
</div>

<div class="form-group">
<label for="phone">Phone</label>
<kds:input path="cart.customer.mobile" id="custmobileno" class="form-Control" />
</div>

<br/>
<h3>Billing Address:</h3>
	<div class="form-group">
<label for="billingApartmentNumber">House No.</label>
<kds:input path="cart.customer.billingAddress.flatno" id="billingHouseno" class="form-Control" />
</div>
	
<div class="form-group">
<label for="billingStreet">Street Name</label>
<kds:input path="cart.customer.billingAddress.street" id="billingStreet" class="form-Control" />
</div>



<div class="form-group">
<label for="billingApartmentNumber">Area</label>
<kds:input path="cart.customer.billingAddress.area" id="billingArea" class="form-Control" />
</div>

<div class="form-group">
<label for="billingLandmark">Landmark</label>
<kds:input path="cart.customer.billingAddress.landmark" id="billingLandmark" class="form-Control" />
</div>


<div class="form-group">
<label for="billingCountry">Country</label>
<kds:input path="cart.customer.billingAddress.country" id="billingCountry" class="form-Control" />
</div>

<div class="form-group">
<label for="billingZip">Zipcode</label>
<kds:input path="cart.customer.billingAddress.zipcode" id="billingPincode" class="form-Control" />
</div>


<input type="hidden" name="_flowExecutionKey" />

<br/><br/>

<input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected" />

<button class="btn btn-default" name="_eventId_cancel">Cancel</button>


</kds:form>
</div>
</div>
</div>
</body>
</html>