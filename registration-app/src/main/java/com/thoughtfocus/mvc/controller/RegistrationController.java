package com.thoughtfocus.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.thoughtfocus.mvc.dto.UserDTO;
import com.thoughtfocus.mvc.service.RegistrationService;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	Logger logger =LoggerFactory.getLogger(RegistrationController.class);
	public RegistrationController() {
		logger.info(this.getClass().getSimpleName());
		//System.out.println(this.getClass().getCanonicalName());
	} // @PostMapping("/reg.do")

	@RequestMapping("/reg.do")
	public ModelAndView registerUser(UserDTO user) {
		ModelAndView view = new ModelAndView();
		try {
			boolean saveStatus = registrationService.validateAndsaveUser(user);
			if (saveStatus) {
				view.setViewName("success.jsp");
				view.addObject("status", "Registration successful...");
			} else {
				view.setViewName("error.jsp");
				view.addObject("status", "registration failed...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return new ModelAndView("/success.jsp","status","reg success");
		return view;
	}
	
	

}
