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
collectShippingDetail


<kds:form commandName="order" class="form-horizontal">

<h3>Shipping Address:</h3>

<div class="form-group">
<label for="flatno">FLat No</label>
<kds:input path="cart.customer.shippingAddress.flatno" class="form-Control"/>
</div>
<%-- 
<div class="form-group">
<label for="shippingApartmentNumber">Flat No.</label>
<kds:input path="cart.customer.shippingAddress.flatno" id="shippingApartmentNumber" class="form-Control" />
</div>

<div class="form-group">
<label for="shippingStreet">Street Name</label>
<kds:input path="cart.customer.shippingAddress.street" id="shippingStreet" class="form-Control" />
</div>

<div class="form-group">
<label for="shippingStreet">Area</label>
<kds:input path="cart.customer.shippingAddress.area" id="shippingArea" class="form-Control" />
</div>


<div class="form-group">
<label for="shippingCity">Landmark</label>
<kds:input path="cart.customer.shippingAddress.landmark" id="shippingCity" class="form-Control" />
</div>

<div class="form-group">
<label for="shippingCountry">Country</label>
<kds:input path="cart.customer.shippingAddress.country" id="shippingCountry" class="form-Control" />
</div>

<div class="form-group">
<label for="shippingZip">Zipcode</label>
<kds:input path="cart.customer.shippingAddress.zipcode" id="shippingPincode" class="form-Control" />
</div>
 --%>
<input type="hidden" name="_flowExecutionKey" />

<br/><br/>

<button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>

<input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected" />

<button class="btn btn-default" name="_eventId_cancel">Cancel</button>

</kds:form>

</body>
</html>