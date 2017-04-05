<nav class="container navbar navbar-inverse navbar-fixed-top" style="background-color:transparent;border-style: none;">
<div class="container" style="background-color:midnightblue;">
    <div class="navbar-header">
     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                              
      </button>
      <a class="navbar-brand" href="#"><b  style="color:white;">CP WORLD</b></a>
    </div>

<ul class="nav navbar-nav">
<li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><img class="img-circle" src="resources/images/users/${userid }.jpg" height="30" width="30"/><b  style="color:white;"> Welcome ${username}</b>
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="editCustomerProfileForm?uid=${userid}">Edit Profile</a></li>
          <li><a href="#">Change Password</a></li>
          <li><a href="j_spring_security_logout">Not ${username},Log Out? </a></li>
        </ul>
      </li>
<li class=""><a href="home"><span class="glyphicon glyphicon-home" style="color:white;"></span></a></li>
<li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown"><b  style="color:white;">PRODUCTS</b>
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="reqdisplaypoductsuser">Display All Products</a></li>
          <li><a href="#"></a></li>
        </ul>
      </li>
     

</ul>
<ul class="nav navbar-nav navbar-right">



<li><a href="#"><b  style="color:white;">Customer Service</b></a></li>
<li><a href="#"><b  style="color:white;">ABOUT US</b></a></li>
<li><a href="#"><b  style="color:white;">CONTACT US</b></a></li>


 <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <ul class="dropdown-menu">
          <li><a href="#">Your Orders</a></li>
          <li><a href="#"><span class="glyphicon glyphicon-heart-empty"></span>WISHLIST</a></li>
        </ul>
      </li>
      <li>
      <li>
        <a href="displayCart"><span class="glyphicon glyphicon-shopping-cart w3-large w3-text-white"  style="color:white;"><span class="badge"  style="color:white;">${cartsize}</span></span>
        </a>
        </li>
</ul>
</div>
</nav>