<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<%@ include file="style.jsp"%>
</style>
</head>
<body background="resources/images/backgrounds/bg${bgnum}.jpg">
 <%@ include file="adminNavbar.jsp"%>
    <div class="col-sm-3"></div>
    <c:url value="/addProductstoDB" var="addProduct"></c:url>
<kds:form action="${addProduct}" commandName="productsObj" method="post" class="c1" enctype="multipart/form-data" align="center">
<div class="card col-sm-6" style="background:rgba(70,0,0,0.4)">
    <div class="card-block">
     <div class="form-header" >
     <br>
            <h3>Add Products:</h3>
        </div>
<label>Product Name:</label>
<div>
<kds:input path="productname"/>
<kds:errors path="productname"></kds:errors>
</div>
<label>Product Desc:</label>
<div>
<kds:textarea rows="5" cols="80" path="productdesc" type="textarea"/>
</div>
<div>
<label>True:</label>
<kds:radiobutton path="isproductavailable" value="true"></kds:radiobutton>
<label>False:</label>
<kds:radiobutton path="isproductavailable" value="false"></kds:radiobutton>
</div>
<label>Select Image</label>
<div>
<div class="col-sm-5">
</div>
<kds:input type="file" path="imagefile"/>
</div>
<div>
<kds:button class="btn success">Add Product</kds:button>
</div>

</div>
</div>
</kds:form>

</body>
</html>