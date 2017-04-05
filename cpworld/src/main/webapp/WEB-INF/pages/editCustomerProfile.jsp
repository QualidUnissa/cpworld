<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
<%@ include file="style.jsp"%>
</style>
<title>Insert title here</title>
</head>
<body background="resources/images/bg8.jp">
<div class="col-sm-3">
</div>
<c:url value="/updateCustomerDataToDB" var="editprofiledata"></c:url>
<kds:form action="${editprofiledata}" commandName="customerData" method="post" enctype="multipart/form-data">
<div class="col-sm-6" style="background:rgba(0,0,50,0.3)">
 <div class="card">
    <div class="card-block">
    		
    	    <!--Header-->
        <div class="form-header">
            <h3 ><b><i class="c1">Edit Account:</i></b></h3>
        </div>
         <kds:hidden path="customerId"></kds:hidden>
Name
<kds:input path="customerName" placeholder="Enter Name"/>

<br>Email ID<kds:input path="email" placeholder="abcd@xyz.com" required="required"/>
<br>Contact No<kds:input path="mobile" pattern="[789]\d{9}" placeholder="Enter 10 digit mobile number"/>
<br>Select Image<kds:input type="file" path="imagefile"/>
<br>
<kds:hidden path="userdetails.userid"/>
<br>Password<kds:hidden path="userdetails.password" pathholder="Create password"/>


<br>Residential Details
<kds:hidden path="shippingAddress.shippingAddressId"/>
<br>Flat No.<kds:input path="shippingAddress.flatno" placeholder="Enter Flat Number"/>
<br>Street<kds:input path="shippingAddress.street" placeholder="Enter Street"/>
<br>Area<kds:input path="shippingAddress.area" placeholder="Enter Your Area"/>
<br>ZipCode<kds:input path="shippingAddress.zipcode" placeholder="Enter zipcode"/>
<br>Landmark<kds:input path="shippingAddress.landmark" placeholder="landmark for your address"/>
<br>Country<kds:input path="shippingAddress.country" placeholder="Country Name"/>
<kds:button type="submit">submit</kds:button>
<kds:hidden path="billingAddress.billingAddressId"/>

<div class="modal-footer">
        <div class="options">
            <p>Already a member? <a href="reqspringloginpage">Login</a></p>
            <p>Forgot <a href="#">Password?</a></p>
        </div>
    </div>
</div>
</div>
</div>
</kds:form>
</body>
</html>