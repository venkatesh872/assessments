package com.thoughtfocus.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtfocus.mvc.service.DeleteService;
@Controller
public class DeleteController {
	@Autowired
	private DeleteService deleteService;
	@PostMapping("/delete.do")
	public ModelAndView delete(@RequestParam String username,@RequestParam Long mobileNumber,@RequestParam Double age) {
		ModelAndView view = new ModelAndView();
		
		try {
			boolean saveStatus = deleteService.authenticateDelete(username,mobileNumber,age);

			if (saveStatus) {
				view.setViewName("home.jsp");
				view.addObject("status", "deleted successfully...");
			} else {
				view.setViewName("error.jsp");
				view.addObject("status", "delete failed...");
			}
		} catch (Exception e) {
			
			
		}
		return view;
	}
}
