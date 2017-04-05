package com.mobiles.controller;



import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobiles.model.Customer;
import com.mobiles.model.UserDetails;
import com.mobiles.model.UserDetailsNew;
import com.mobiles.model.ViewXmapPS;
import com.mobiles.service.CustomerService;
import com.mobiles.service.UserDetailsNewService;
import com.mobiles.service.UserDetailsService;
import com.mobiles.service.ViewPsUserService;


@Controller
public class HomeController {
	@Autowired
	private UserDetailsService userdetailsservice;

	@Autowired
	private ViewPsUserService viewpsService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserDetailsNewService userServiceNew;
	
	
	//default requesst
	@RequestMapping("/")
	public String displayWelcomepage(Model m){
		List<ViewXmapPS> prd=viewpsService.getBestViewProducts();
		m.addAttribute("products",prd);
		return "index";
	}
	
	//request for diplaying home page
	@RequestMapping("/home")
	public String Homepage(Model m){
		List<ViewXmapPS> prd=viewpsService.getBestViewProducts();
		m.addAttribute("products",prd);
		m.addAttribute("bgnumforT",RandomController.randomNumforThumbnails());
		return "index";
	}
	
	//request for displaying sign up page
	@RequestMapping("/reqSignUp")
	public String displaySignupPage(Model m){
		m.addAttribute("userObj",new UserDetails());
		return "signuppage";
	}

	
	//request to send sign up data to DB and return login page
	@RequestMapping("/reqSendSignUpData")
	public String reqSignUpdetails(@Valid@ModelAttribute("userObj")UserDetails u,Model m,BindingResult result){
			if(result.hasErrors()){
				System.out.println("found error");
				return "signuppage";
			}
	//@RequestMapping("/reqSendSignUpData")
	//public String reqSignUpdetails(@ModelAttribute("userObj")UserDetails u,Model m){
		System.out.println("before Controller");
		String uid= userdetailsservice.addUser(u);
		m.addAttribute("message", "Signup Successfull,UserID:"+uid);
		//m.addAttribute("userObj",new UserDetails());
		System.out.println("after Controller");
		m.addAttribute("userObj", new UserDetails());
		return "springLoginForm";
	
	}
	
	
	//request  to display login form without spring security
	@RequestMapping("/reqLoginPage")
	public String reqLoginpage(Model m){
		m.addAttribute("userObj",new UserDetails());
		return "login";
	}
	
	
	//request  to check login details form without spring security
	@RequestMapping("/reqLoginCheck")
    public String loginAuthentication(@ModelAttribute("userObj")UserDetails ud,Model m,HttpSession hses){
		UserDetails result=userdetailsservice.loginCheck(ud);
		if(result==null){
			m.addAttribute("message","Authentication Failed, Retry..!!");
			return "login";
		}
		else{//success
			if(result.getRole().equals("ROLE_ADMIN")){
				m.addAttribute("admin",ud);
				hses.setAttribute("userlogin", result.getFirstname());
				m.addAttribute("username",result.getFirstname());
				hses.setAttribute("userimage", result.getUserid());
				m.addAttribute("userid",result.getUserid());
				return "loginAdmin";
			}
				
			else{
				m.addAttribute("user",ud);
				hses.setAttribute("userlogin", result.getFirstname());
				m.addAttribute("username",result.getFirstname());
				hses.setAttribute("userimage", result.getUserid());
				m.addAttribute("userid",result.getUserid());
				List<ViewXmapPS> prd=viewpsService.getBestViewProducts();
				m.addAttribute("products",prd);
				return "loginUser";
			}
			
		}
	
	}
	
	
	
	
	/*@RequestMapping("/logout")
	public String logout(HttpSession hsession,@RequestParam(value="logout",required=false)String logout,Model m){
		if(logout!=null){
			m.addAttribute("logout","Loged out..!!");
		hsession.setAttribute("userlogin",null);
		hsession.setAttribute("userimage",null);
		}
		return "redirect:/home";
	}*/
	
	
	//request for editing profile form
	@RequestMapping("/editProfileForm")
	//public  String displayEditProfileForm(@RequestParam("uid")String usrid,Model m)
	public  String displayEditProfileForm(HttpSession hses,Model m)
	{
		//UserDetails data=userdetailsservice.getUserById(usrid);
		UserDetails data=userdetailsservice.getUserById(hses.getAttribute("userimage").toString());
		m.addAttribute("username",hses.getAttribute("userlogin"));
		m.addAttribute("userid",hses.getAttribute("userimage"));
		m.addAttribute("userData",data);
		return "editProfileForm";
		
	}
	
	
	//request to send edited data to DB
	@RequestMapping("/reqSendEditDatatoDB")
	public String editProfiletoDB(@ModelAttribute("userData")UserDetails usrd,HttpSession hses){
		userdetailsservice.editProfileToDB(usrd);
		hses.setAttribute("userlogin",usrd.getFirstname());
		return "redirect:/reqLoginCheck";
	}
	
	
	//Request to send login form with spring security
	@RequestMapping("/reqspringloginpage")
	public String displaySpringLoginPage(@RequestParam(value="error",required=false)String error,
			@RequestParam(value="logout",required=false)String logout,Model m,HttpSession hsession){
		if(error!=null)
			m.addAttribute("error","Invalid UserID And PAssword..ENter valid Credentials");
		if(logout!=null){	
		hsession.setAttribute("userlogin",null);
		hsession.setAttribute("userimage",null);
			m.addAttribute("logout","Loged out..!!");
			List<ViewXmapPS> prd=viewpsService.getBestViewProducts();
			m.addAttribute("products",prd);
		return "index";
		}
			return "springLoginForm";
	}
	
	
	//request to login check with spring security
	@RequestMapping("/loginCheck1")
	public String loginCheck(Principal princ,HttpSession hses,Model m){
		System.out.println("/n Name:"+princ.getName());
		Authentication authenticate=SecurityContextHolder.getContext().getAuthentication();
		String role=authenticate.getAuthorities().toString().substring(1,10);
		System.out.println(role);
	
		
		UserDetailsNew usrd=userServiceNew.getUserById(princ.getName());
		Customer cstmr=customerService.getCustomerById(usrd.getUserid());

		/*hses.setAttribute("userlogin",cstmr.getCustomerName());
			m.addAttribute("username",cstmr.getCustomerName());
			hses.setAttribute("userimage",cstmr.getCustomerId());
			m.addAttribute("userid",cstmr.getCustomerId());*/
		 
		 
		 
		if(role.equals("ROLE_USER")){
			List<ViewXmapPS> prd=viewpsService.getBestViewProducts();
			m.addAttribute("products",prd);
			hses.setAttribute("userlogin",cstmr.getCustomerName());
			m.addAttribute("username",cstmr.getCustomerName());
			hses.setAttribute("userimage",cstmr.getCustomerId());
			m.addAttribute("userid",cstmr.getCustomerId());
			
			
			hses.setAttribute("sizeofcart",cstmr.getCart().getCartItems().size());
			m.addAttribute("cartsize",hses.getAttribute("sizeofcart"));
			//hses.setAttribute("user", arg1);
		 
		return "loginUser";
		}
		else{ 
			hses.setAttribute("userlogin",usrd.getUserid());
			m.addAttribute("username",usrd.getUserid());
			hses.setAttribute("userimage",usrd.getUserid());
			m.addAttribute("userid",usrd.getUserid());
			return "loginAdmin";	
		}
	}
	
	@RequestMapping("/logincheck")
	public String logicheck(){
		return "logincheck";
	}
	
	
	
	
}
