<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@ include file="adminNavbar.jsp" %>
product edit page
<kds:form action="editProductstoDB" commandName="productsData" method="POST" enctype="multipart/form-data">
<div>
<label for="productid"></label>
<kds:hidden path="productid"/>
</div>
<label>Product Name:</label>
<div>
<kds:input path="productname"/>
</div>
<label>Product Desc:</label>
<div>
<kds:textarea rows="5" cols="80" path="productdesc" type="textarea"/>
</div>
<label>True:</label>
<kds:radiobutton path="isproductavailable" value="true"></kds:radiobutton>
<label>False:</label>
<kds:radiobutton path="isproductavailable" value="false"></kds:radiobutton>
<br>
<label>Select Image</label>
<div>
<kds:input type="file" path="imagefile"/>
</div>
<div>
<kds:button>Edit Product</kds:button>
</div>
</kds:form>
</body>
</html>