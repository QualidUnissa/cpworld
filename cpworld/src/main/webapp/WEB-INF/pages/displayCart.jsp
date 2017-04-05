<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
video#bgvid { 
    position: fixed;
    top: 50%;
    left: 50%;
    min-width: 100%;
    min-height: 100%;
    width: auto;
    height: auto;
    z-index: -100;
    -ms-transform: translateX(-50%) translateY(-50%);
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
    background: url(clothing.jpg) no-repeat;
    background-size: cover; 
    opacity:0.5;
}
</style>
</head>
<body>
<%@include file="userNavbar.jsp"%>
<br>
<br>
<br>
${totalprice}

 <video width="420" height="370" controls autoplay muted id="bgvid">
  <source src="resources/images/videos/video1.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>


<div class="container">
<div class="row">

<div class="col-md-2" style=" background-color:transparent; border:none">
<c:url value="/clearCart/${customerid}" var="clearcart"></c:url>
<a href="${clearcart}" class="btn btn-warning btn-large">Clear Cart</a>
</div>
<%-- <div>
<a href="${checkout}"><button class="w3-button w3-small w3-circle w3-indigo"><b>Check Out</b></button></a>
</div> --%>
<div class="col-md-6" style=" background-color:transparent; border:none"></div>

 <div class="col-md-4" align="right" style=" background-color:transparent; border:none"> 
 <b>Order Total : ${totalprice}</b>
 <c:url value="/order/${customerData.cart.cartId}" var="checkout"></c:url>
 <a href="${checkout}" style="color:yellow" class="btn btn-warning btn-large">Check Out</a>
 </div>
 </div>
 

 
 
 
 <table border="2"  class="table table-stripped fixed_headers" style="background:rgba(50,0,50,0.4)">
 <thead>
 <th>Product</th>
 <th>Supplier</th>
 <th>Quantity</th>
 <th>Price</th>
 <th>total</th>
 <th>Option</th>
 
 </thead>
 <tbody >
 <c:forEach var="itemsincart" items="${cartitems}">
 <tr>
 <td><img src="resources/images/products/${itemsincart.xmapPS.productid}.jpg" height="150" width="150"/></td>
 <td><img src="resources/images/suppliers/${itemsincart.xmapPS.supplierid}.jpg" height="150" width="150"/></td>
 <td>${itemsincart.quantity}</td>
 <td>${itemsincart.xmapPS.productsupplierprice}</td>
 <td>${itemsincart.itemwisetotal}</td>
 <td><c:url value="/removeFromCart/${itemsincart.cartitemId}" var="remove"></c:url><a href="${remove}">Remove</a>/Add to wishList</td>
 
 </tr>
 </c:forEach>
 
 </tbody>
 
 
 </table>
  </div>
</body>
</html>