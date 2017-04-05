<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="links.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="adminNavbar.jsp" %>


<kds:form action="editSupplierstoDB" commandName="supplierData" method="POST" enctype="multipart/form-data">
<kds:hidden path="supplierid"></kds:hidden>
<label>Supplier Name:</label>
<div>
<kds:input path="suppliername"/>
</div>
<label>Supplier Desc:</label>
<div>
<kds:input path="supplierdesc"/>
</div>
<label>True:</label>
<kds:radiobutton path="issupplieravailable" value="true"></kds:radiobutton>
<label>False:</label>
<kds:radiobutton path="issupplieravailable" value="false"></kds:radiobutton>
<br>
<label>Select Image</label>
<div>
<kds:input type="file" path="imagefile"/>
</div>
<div>
<kds:button>Edit Suppliers</kds:button>
</div>
</kds:form>

</body>
</html>