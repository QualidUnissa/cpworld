

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@ include file="links.jsp" %> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file="style.jsp"%>
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
<body style="background:rgba(0,0,128,0.2)" > 
<%@ include file="adminNavbar.jsp" %>
<div class="conatiner">
<table class="table table-bordered" >
<thead>
<tr>
<th>PRODUCT ID</th>
<th>PRODUCT NAME</th>
<th>PRODUCT IMAGE</th>
<th>PRODUCT DESC</th>
<th>IS AVAILABLE</th>
<th>OPTIONS</th>
</tr>

</thead>
<tbody>
<c:forEach var="prd" items="${products }">
<tr>
<td>${prd.productid }</td><td>${prd.productname }</td>
<td><img src="resources/images/products/${prd.productid}.jpg" height="200" width="250"/></td>
<td><pre>${prd.productdesc}</pre></td><td>${prd.isproductavailable}</td>
<td><a href="reqEditProductPage?prd=${prd.productid}"><span class="glyphicon glyphicon-pencil"></span></a><b>/</b><a href="reqDeleteProduct/${prd.productid}"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>

</c:forEach>
</tbody>

</table>
</div>
 
</body>
</html>
