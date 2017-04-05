<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="links.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="style.css">
<style>
<%@include file="style.jsp"%>
</style>
</head>
<body  background="resources/images/userbg1.jpg">
<%@ include file="userNavbar.jsp" %>
<c:forEach var="prdata" items="${products}">
<div class="col-sm-3 zoom-effect-container" style="background-color:transparent; border-style:none; left-padding:5px;">
		<div class="thumbnail image-card" style="height:370px;border:3px;background-color:transparent; border-radius:15px; padding:5px; border-style: none;"> 
		 <img id="boxshadow" src="resources/images/products/${prdata.productid}.jpg" style="width:320px; height:200px;border-radius:15px;" class="img-rounded"/>
		 <p class="c1"><br>
		Name:${prdata.productname}
		 <br>Price:${prdata.productsupplierprice}
		 <br>Supplier:${prdata.suppliername}
		 </p>
		 <a href="formoreSupplierProducts?prd=${prdata.productid}">More Suppliers</a>
		  <c:if test="${prdata.productsupplierstock >= 8}">
		 		<b class="c1"><br>Stock : ${ps.productsupplierstock}</b>
		  </c:if>  
		   <c:if test="${prdata.productsupplierstock < 8}">
		 		<b style="color:yellow"><br>Out of stock</b>
		  </c:if>  
		   <c:if test="${prdata.productsupplierstock >= 8}">
		 <br>
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
		  
		 </c:if>
		</div>
		</div>
</c:forEach>
</body>
</html>