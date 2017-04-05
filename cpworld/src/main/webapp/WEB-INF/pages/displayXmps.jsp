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
<script>

$(document).ready(function(){
	var searchCondition='${searchCondition}';
	$('.table').DataTable({
		"lengthMenu" : [[5,10,15,-1],[5,10,15,"All"]],
		"oSearch":{"sSearch":searchCondition}		
	})	
});
</script>
</head>
<body background="resources/images/backgrounds/bg${bgnum}.jpg">
<%@include file="adminNavbar.jsp" %>
<%-- ${xmpsData} --%>
<div class="container">

<table class="table table-bordered">
<thead>
<tr style="background-color:wheat;font-color:black;table-layout: fixed;">
<th>Product Id</th>
<th>Supplier Id</th>
<th>XPSID</th>
<th>Price</th>
<th>stock</th>
<th>Is Available</th>
<th>Manage</th>
</tr>
</thead>
<tbody>
<c:forEach var="xmps" items="${xmpsData }">
<tr  style="text-align:center;background:rgba(50,2,0,0.3)">
<td style="vertical-align: middle;font-weight:bold;color:yellow"><img style="border-radius:15px" src="resources/images/products/${xmps.productid}.jpg" height="70" width="90" />${xmps.productid}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow"><img style="border-radius:15px" src="resources/images/suppliers/${xmps.supplierid}.jpg" height="70" width="90" />${xmps.supplierid}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${xmps.psid}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${xmps.productsupplierprice}</td><td style="vertical-align: middle;font-weight:bold;color:yellow">${xmps.productsupplierstock}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${xmps.isproductsupplieravailable}</td>
<td><a  style="vertical-align: middle;font-weight:bold;color:yellow" href="reqEditProductSuppliersPage?prdsup=${xmps.psid }"><span class="glyphicon glyphicon-pencil"></span></a>/
<a href="reqDeleteProductSupplier/${xmps.psid}"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>