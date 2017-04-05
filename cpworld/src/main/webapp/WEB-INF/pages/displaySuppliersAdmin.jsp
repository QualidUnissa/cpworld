<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<body>
<%@ include file="adminNavbar.jsp" %>
<%-- ${supplier } --%>
<div class="conatiner">
<table class="table table-bordered">
<thead>
<tr>
<th>SUPPLIER ID</th><th>SUPPLIER NAME</th><th>SUPPLIER IMAGE</th><th>SUPPLIER DESC</th><th>IS AVAILABLE</th><th>OPTIONS</th>
</tr>

</thead>
<tbody>
<c:forEach var="sup" items="${supplier}">
<tr>
<td>${sup.supplierid }</td><td>${sup.suppliername }</td><td><img src="resources/images/suppliers/${sup.supplierid }.jpg" height="200" width="250"/></td><td>${sup.supplierdesc }</td><td>${sup.issupplieravailable}</td>
<td><a href="reqEditSuppliersPage?spid=${sup.supplierid }"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;/
&nbsp;<a href="reqDeleteSupplier/${sup.supplierid}"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>
</c:forEach>

</tbody>
</table>
</div>

</body>
</html>