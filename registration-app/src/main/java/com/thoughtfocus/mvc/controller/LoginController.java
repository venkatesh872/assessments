package com.thoughtfocus.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtfocus.mvc.dto.UserDTO;
import com.thoughtfocus.mvc.service.LoginService;
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@PostMapping("/login.do")
	public ModelAndView loginUser(@RequestParam String username,@RequestParam String password) {
		ModelAndView view = new ModelAndView();
		
		try {
			boolean saveStatus = loginService.authenticationUser(username,password);

			if (saveStatus) {
				view.setViewName("home.jsp");
				view.addObject("status", "login successful...");
			} else {
				view.setViewName("error.jsp");
				view.addObject("status", "login failed...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return new ModelAndView("/success.jsp","status","reg success");
		return view;
	}
}
