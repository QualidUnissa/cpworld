<style>
   <%@ include file="style.jsp" %>
</style>
<nav class="container navbar navbar-inverse navbar-fixed-top" style="background-color:transparent;border-style: none;">
<div class="container"  style="background-color:midnightblue;">

<ul class="nav navbar-nav">
<li class="dropdown">
		<c:url value="/resources/images/admin/${userid}.jpg" var="image"></c:url>
        <a class="dropbtn" href="#"><img class="img-circle" src="${image}" height="50" width="50"/><b  style="color:white;"> WELCOME ${username}</b>
        <span class="caret"></span></a>
        <ul class="dropdown-content">
          <li><a href="#">Edit Profile</a></li>
          <li><a href="#">Change Password</a></li>
          <c:url value="/j_spring_security_logout" var="logout"></c:url>
          <li><a href="${logout}">Not ${username},Log Out </a></li>
        </ul>
      </li>
      <c:url value="/home" var="home"></c:url>
<li><a href="${home}"><b><span class="glyphicon glyphicon-home c1"></span></b></a></li>
<li class="dropdown">
        <a class="dropbtn" data-toggle="dropdown" href="#">PRODUCTS
        <span class="caret"></span></a>
        <ul class="dropdown-content">
        <c:url value="/reqDispalyProductsAdmin" var="displayproducts"></c:url>
          <li><a href="${displayproducts}"><b><span class="glyphicon glyphicon-option-horizontal"></span>  Display All Products</b></a></li>
          <c:url value="/reqAddProductsPage" var="addproducts"></c:url>
          <li><a href="${addproducts}"><b><span class="glyphicon glyphicon-plus-sign"></span> Add Products</b></a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">SUPPLIERS
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:url value="/reqDisplayAllSuppliers" var="displaysuppliers"></c:url>
          <li><a href="${displaysuppliers}"><b><span class="glyphicon glyphicon-option-horizontal"></span> Display Suppliers</b></a></li>
          <c:url value="/reqAddSupplierform" var="addsuppliers"></c:url>
          <li><a href="${addsuppliers}"><b><span class="glyphicon glyphicon-plus-sign"></span> Add Suppliers</b></a></li>
        </ul>
      </li>
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Product Suppliers
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:url value="/reqDisplayXmps" var="displayPS"></c:url>
          <li><a href="${displayPS}"><b><span class="glyphicon glyphicon-option-horizontal"></span>  Display Product Suppliers</b></a></li>
          <c:url value="/reqAddProductSupplierForm" var="addPS"></c:url>
          <li><a href="${addPS}"><b><span class="glyphicon glyphicon-plus-sign"></span> Add Product Suppliers</b></a></li>
        </ul>
      </li>
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Users
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="displayUserDetailsList">Display Users</a></li>
        </ul>
      </li>
</ul>
<ul class="nav navbar-nav navbar-right">
<li><a href="#">ABOUT US</a></li>
<li><a href="#">CONTACT US</a></li>
</ul>
</div>
</nav>
<br><br><br><br><br>