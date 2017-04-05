<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="adminNavbar.jsp"%>
<br>
<br>
<table class="container" border=1>
<thead>
<th>UserID</th>
<th>Status</th>
<th>ACTION</th>
</thead>
<tbody>
<c:forEach var="usrd" items="${userdata}">
<tr>
<td>${usrd.userid}</td>
<td>
<c:if test="${usrd.enable==true}">
Enabled
</c:if>
<c:if test="${usrd.enable==false}">
Disabled</td>
</c:if>
<td>
<c:if test="${usrd.enable==true}">
<a href="disableUser?uid=${usrd.userid}">Disable</a>
</c:if>
<c:if test="${usrd.enable==false}">
<a href="enableUser?uid=${usrd.userid}">Enable</a>
</c:if>
</td>

</tr>

</c:forEach>


</tbody>







</table>
</body>
</html>