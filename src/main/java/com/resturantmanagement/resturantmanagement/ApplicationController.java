package com.resturantmanagement.resturantmanagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.resturantmanagement.resturantmanagement.models.User;

@Controller
public class ApplicationController {
	
	@GetMapping("/index")
	public String home() {	
		return "index";
	}
	

	@GetMapping("/login")
	public String login() {	
		return "auth/auth-login";
	}
	
	@GetMapping("/logout")
	public String logout() {	
		return "logout";
	}
	
	@GetMapping("/register")
	public String register(User user) {	
		return "auth/auth-register";
		
	}
	
	@GetMapping("/login-error")
	 public String loginError(HttpServletRequest request, Model model) {
       
		//Returns the current HttpSession associated with this request,
		//if there is no current session, returns null.
		HttpSession session = request.getSession(false);
		
		String errorMessage = null;
		
		
		//Getting bad credentials error message
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            
            if (ex != null) {
                errorMessage = ex.getMessage();
            }
            
        }
        
        
        //Setting  custom error message 2
        String errorMessage2 = "Invalid Username or Password !";
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("errorMessage2", errorMessage2);

        return "auth/auth-login";
    }
	
	
	@GetMapping("/test")
	public String a() {	
		return "order/order2";
	}

}
