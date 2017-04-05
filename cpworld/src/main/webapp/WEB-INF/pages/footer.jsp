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
    $('[data-toggle="tooltip"]').tooltip();   
});

</script>

</head>
<body>



        <footer class="c1"class="page-footer" style="background:rgba(0,0,0,0.6)">
        <hr>
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text" align="center">Footer Content</h5>
                <p class="grey-text text-lighten-4" align="center">You can use rows and columns here to organize your footer content.</p>
              </div>
              </div>
              </div>
              <div class="container">
              <div class="col l4 offset-l2 s12 col-sm-4">
                <h4><b><u>Follow us on:</u></b></h4>
              
               <a href="https://www.facebook.com/" ><i class="fa fa-facebook fb"  data-toggle="tooltip"  title="Facebook"></i></a>
               <a href="https://twitter.com/login"><i class="fa fa-twitter" data-toggle="tooltip"  title="Twitter"></i></a>
				<!-- <a href="#" class="fa fa-google"></a> -->
				<a href="https://www.instagram.com/accounts/login/"><i class="fa fa-instagram" data-toggle="tooltip"  title="Instagram"></i></a>
				<a href="https://play.google.com/store"><i class="fa fa-android" data-toggle="tooltip"  title="Android"></i></a>
				<a href="https://accounts.snapchat.com/accounts/login"><i class="fa fa-snapchat-ghost" data-toggle="tooltip"  title="Snapchat"></i></a>
				<br>
				<br>
              </div>
         	 <div class="col-sm-4">
                <h4><b><u>Payment Methods</u></b></h4>
                <div><img src="http://www.themobilestore.in/skin/frontend/default/tmsmoe/images/moe/footer_logos.png" width=100%/></div>
                <br>
            </div>
            
            <div class="col-sm-4">
    <form action="#" method="post">
                <h4><b><u>Newsletter Subscription</u></b></h4>
              <h5>To stay updated with our latest offers, please enter your email:</h5>
               <input type="text" name="email" title="Sign up for our newsletter" placeholder="Enter Email ID"/>
                <button type="submit" title="Subscribe" class="btn-danger"><span class="first"><span>Subscribe</span></span></button>
    </form>
</div>

            </div>
        </div>
            
            </div>
<!-- <p class="paylogos"><img src="http://www.lotmobiles.com/skin/frontend/default/lot/images/pays.png" width="197" height="78"  alt="payment logos"/>
<h4>100% Secure Payments</h4>
</p>
<p class="allaccepted">All major credit & debit cards accepted</p>
<p><img src="http://www.lotmobiles.com/skin/frontend/default/lot/images/secure.png" alt="secure" class="securelogo" width="247" height="42" /></p> -->

          <div class="footer-copyright" align="center">
            <div class="container-fluid" style="background:rgba(0,0,0,0.7)">
            © 2012 CP World | All Rights are reserved.
            </div>
          </div>
          

          
        </footer>

</body>
</html>