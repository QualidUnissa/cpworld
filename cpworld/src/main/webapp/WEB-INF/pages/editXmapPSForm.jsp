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
<kds:form commandName="psData" action="reqEditXmpstoDB" method="post">
<label>PSID</label>
<kds:hidden path="psid"/>
<label>Products</label>


<div>
<kds:input path="productid" readonly="true"/> 
</div>
<label>Supplier</label>

<div>
<kds:input path="supplierid" readonly="true"/> 
</div>
<div>
<label>Price</label>
<kds:input path="productsupplierprice"/>
</div>

<div>
<label>Stock</label>
<kds:input path="productsupplierstock"/>
</div>
<div>
<label>Is Available</label>
<div>
<label>True</label><kds:radiobutton path="isproductsupplieravailable" value="true"/>
<label>False</label><kds:radiobutton path="isproductsupplieravailable" value="true"/>
</div>
</div>
<kds:button>Add ProductSupplier</kds:button>
</kds:form>
</body>
</html>