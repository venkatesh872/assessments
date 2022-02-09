package com.thoughtfocus.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtfocus.mvc.service.UpdateService;
@Controller
public class UpdateController {
@Autowired
 private UpdateService updateService;

	@PostMapping("/update.do")
	public ModelAndView updateMobileNumber(@RequestParam String username,@RequestParam Long mobileNumber) {
		 ModelAndView view = new  ModelAndView();
		 try {
			boolean saveStatus = updateService.authenticateUpdate(username,mobileNumber);
			if(saveStatus) {
				view.setViewName("/home.jsp");
				view.addObject("status","Updated");
			}else {
				view.setViewName("/errorlog.jsp");
				view.addObject("status","Not Updated");
			}
		} catch (Exception e) {
	
		}
		 return view;
	}
}
