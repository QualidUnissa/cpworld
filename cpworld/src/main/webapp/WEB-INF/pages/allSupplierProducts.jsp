<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
 <%@include file="style.jsp" %>
 </style>
</head>
<body>
<%@ include file="userNavbar.jsp" %>

		 <img  src="resources/images/products/${prdid}.jpg" style="width:320px; height:200px;"/>
		 ${prdname}<br>
		 <div class="conatiner-fluid">
<table class="table table-bordered">
<thead>
<tr>
<th>SUPPLIER NAME</th><th>SUPPLIER PRICE</th><th>STOCK</th><th>Options</th>
</tr>
</thead>
	<c:forEach var="vwps" items="${allsuppliers}">
	<tr>
	<td>${vwps.suppliername}</td>
	<td>${vwps.productsupplierprice}</td>
	<td>${vwps.productsupplierstock}</td>
	<td>
	 <c:url value="/AddItemToCart/${prdata.psid}" var="addItem"></c:url>
		 <form action="${addItem}">
		  <select name="qty" id="qty">
      	<option value="1">1</option>
      	<option value="2">2</option>
      	<option value="3">3</option>
      	<option value="4">4</option>
      	<option value="5">5</option>
      		
      	</select>
		<button type="submit" class="btn btn-warning btn-large"> 
         <span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
         </button>  
		  </form>
	</td>
	</tr>
	
	</c:forEach>
	</table>
	</div>	 
		 
		 
</body>
</html>