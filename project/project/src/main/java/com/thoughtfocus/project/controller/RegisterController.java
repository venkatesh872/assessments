package com.thoughtfocus.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.thoughtfocus.project.dto.RegisterDTO;

import com.thoughtfocus.project.exception.NullObjectRegisterException;
import com.thoughtfocus.project.service.RegisterService;

@RestController
public class RegisterController {
	@Autowired
	RegisterService service;

	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@PostMapping("/register")
	String register(@RequestBody RegisterDTO dto) {
		String saveStatus = null;
		try {
			if (dto != null) {
				saveStatus =service.saveUser(dto);
			}else {
				logger.info("Details cant be null");
				throw new NullObjectRegisterException("Details cant be null");
			}
		} catch (NullObjectRegisterException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return saveStatus;

	}

}