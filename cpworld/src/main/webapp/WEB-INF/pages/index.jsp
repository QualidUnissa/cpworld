<%@ include file="links.jsp" %>
<html>
<!-- <link rel="stylesheet" href="style.css"> -->
<!-- <head>
<style type="text/css">
</style> -->
<style>


  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 100%;
      margin: auto;
     height:500px;
   
  }
	.carousel-control.left, .carousel-control.right {
  background-image:none; opacity:0.1;
}



body{
background-size:contain;
background-repeat:no-repeat;
background-attachment:fixed;
background-size:100% 100%;

}
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
    controls:autoplay 
}
<%@ include file="style.jsp"%>

  </style>
  <script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip(); 
});
</script>
</head>
<body background="resources/images/bg5.jpg">

<nav class=" container navbar navbar-inverse navbar-fixed-top" style="background-color:transparent;border-style: none;"> 
  <div class="container"  style="background-color:midnightblue;">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>

      <a class="navbar-brand " href="#"><b  style="color:white;">
      <img src="http://www.themobilestore.in/media/favicon/default/favicon.png" class="img-circle"width="30" height="30" /> CP WORLD
      </b></a>
      
    </div>
    <ul class="nav navbar-nav">
      <li><a href="home"><b  style="color:white;"><span class="glyphicon glyphicon-home " ></span></b></a></li>
      <li><a href="#"><b  style="color:white;">ABOUT US</b></a></li>
      <li><a href="#"><b  style="color:white;">CONTACT US</b></a></li>
    
      <!--  <li class=""><a href="reqLoginPage">LOGIN</a></li> -->
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <!-- <li><a href="reqSignUp"><b  style="color:white;"><span class="glyphicon glyphicon-user"></span>SignUp</b></a></li> -->
      <li><a href="reqspringloginpage"><b  style="color:white;"><span class="glyphicon glyphicon-log-in"></span>  Login</b></a></li>
       <li><a href="customerSignupForm"><b  style="color:white;"><span class="glyphicon glyphicon-user"></span>SignUp</b></a></li>
    </ul>

  </div>
</nav>
<br><br><br>
<b class="c1">
${logout}
</b>
 <video width="420" height="370" controls autoplay muted id="bgvid">
  <source src="resources/images/videos/video2.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>
<div class="container-fluid" style="background:rgba(0,0,125,0.3)">
  <br>
  <div class="col-sm-4">
  <video width="420" height="370" controls autoplay muted>
  <source src="resources/images/video1.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>
<!-- <video controls>
  <source src="resources/images/video.mp4" type="video/mp4" width=100%>
  <source src="movie.ogg" type="video/ogg">
  Your browser does not support the video tag.
</video> -->
  </div>
 <div class="col-sm-8" style="background:rgba(0,20,50,0.3)">
  <div id="myCarousel" class="carousel slide " data-ride="carousel" style="background:rgba(30,20,0,0.3)" >
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
       <li data-target="#myCarousel" data-slide-to="4"></li>
       <li data-target="#myCarousel" data-slide-to="5"></li>
       <li data-target="#myCarousel" data-slide-to="6"></li>
    </ol>


    <div class="carousel-inner" role="listbox">
      <div class="item active ">
        <img src="resources/images/carousel/sonam.jpg" alt="Chania" width="460" height="345">
      </div>
        <div class="item">
        <img src="resources/images/carousel/image3.jpg" alt="Flower" width="460" height="345">
      </div>
 	<div class="item">
        <img src="resources/images/carousel/Xiaomi-Mi-Mix.jpg" alt="Flower" width="460" height="345">
      </div>
      <div class="item">
        <img src="resources/images/carousel/htcm9.jpg" alt="Flower" width="460" height="345">
      </div>
       <div class="item">
        <img src="resources/images/carousel/image4.jpg" alt="Chania" width="460" height="345">
      </div>
       <div class="item">
        <img src="resources/images/carousel/img5.jpg" alt="Flower" width="460" height="345">
      </div>
       <div class="item">
        <img src="resources/images/carousel/image1.jpg" alt="Flower" width="460" height="345">
      </div>
    </div>

    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
    </div>
  </div>
</div>


<div class="container-fluid">
<div class="row">
 <!-- <div class="col-sm-2 zoom-effect-container" style="background-color:transparent; border-style:none; left-padding:5px;">
		<div class="thumbnail image-card" style="height:370px;border:3px;background-color:transparent; border-radius:8px; padding:5px; border-style: double;"> 
		 <img id="boxshadow" src="resources/images/products/PRD00001.jpg" style="width:220px; height:200px;" class="img-rounded"/> -->
<div class="col-sm-2" style="background-color:transparent; border-style:none; left-padding:5px;">
		<div  class="thumbnail" style="border:3px;background-color:transparent; border-radius:8px; padding:5px; border-style: double;"> 
		 <img src="resources/images/products/PRD00001.jpg"  style="width:220px; height:200px;"/>
		 <br>
		Galaxy S7 Edge
		</div>
		</div>
	
	<div class="col-sm-2" style="background-color:transparent; border-style:none; left-padding:5px">
	
		<div class="thumbnail" style="border:3px;background-color:transparent;border-radius:8px; padding:5px; border-style: double">
		 <img src="resources/images/products/PRD00002.jpg" style="width:220px; height:200px;"/>
		 <br>
			One Plus3
		
		</div>
		</div>
	
	<div class="col-sm-2" style="background-color:transparent; border-style:none; left-padding:5px">
		<div class="thumbnail" style="border:3px solid green;background-color:transparent; border-radius:8px; padding:5px; border-style: double">
		 <img src="resources/images/products/PRD00003.jpg" style="width:220px; height:200px;"/>
		<br>
		Samsung Galaxy Note5
		
		</div>
		
		</div>
		
		
	<div class="col-sm-2" style="background-color:transparent; border-style:none; left-padding:5px">
		<div class="thumbnail" style="border:3px solid green;background-color:transparent; border-radius:8px; padding:5px; border-style: double">
		 <img src="resources/images/products/PRD00004.jpg" style="width:220px; height:200px;"/>
				<br>
		Samsung Galaxy Note5
		
		</div>
		</div>
		
	<div class="col-sm-2" style="background-color:transparent; border-style:none; left-padding:5px">
		<div class="thumbnail" style="border:3px solid green; background-color:transparent;border-radius:8px; padding:5px; border-style: double">
		 <img src="resources/images/products/PRD00005.jpg" style="width:220px; height:200px;"/>
				<br>
		Samsung Galaxy Note5
		
		</div>
		</div>
		
		
	<div class="col-sm-2" style="background-color:transparent; border-style:none; left-padding:5px">
		<div class="thumbnail" style="border:3px solid green; border-radius:8px; padding:5px; border-style: double">
		 <img src="resources/images/products/PRD00006.jpg" style="width:220px; height:200px;"/>
				<br>
		Samsung Galaxy Note5
		
		</div>
	</div> 


</div>
</div>
<br>
<br>
<!-- THUMBNAILS -->
<div class="container-fluid">
<div class="row" style="background:rgba(50,30,30,0.5)">


 <c:forEach var="prdata" items="${products}">
<div class="col-sm-3 zoom-effect-container" style="background-color:transparent; border-style:none; left-padding:5px;">
		<div class="thumbnail image-card" style="height:370px;border:3px;border-radius:15px;background-color:transparent; border-radius:8px; padding:5px; border-style: none;"> 
		 <img id="boxshadow" src="resources/images/products/${prdata.productid}.jpg" style="width:300px; height:200px;border-radius:15px;" class="img-rounded"/>
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

</div> 
</div>


<%@ include file="footer.jsp" %>
</body>
</html>