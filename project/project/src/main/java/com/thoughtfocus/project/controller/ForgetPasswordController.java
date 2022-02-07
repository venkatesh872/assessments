package com.thoughtfocus.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.project.Entity.DetailsEntity;
import com.thoughtfocus.project.dto.UpdatePasswordByEmailDTO;
import com.thoughtfocus.project.exception.NullEmailAndPasswordException;
import com.thoughtfocus.project.service.ForgetPasswordService;

@RestController
public class ForgetPasswordController {
	static Logger logger = LoggerFactory.getLogger(ForgetPasswordController.class);

	@Autowired
	ForgetPasswordService forgetPasswordService;

	@PostMapping("/updatepassword")
	DetailsEntity updatePassword(@RequestBody UpdatePasswordByEmailDTO dto) {
		DetailsEntity detailsEntity = null;

		try {
			if (dto.getPassword() != null && dto.getPassword() != "") {
				detailsEntity = forgetPasswordService.UpdatePasswordByEmail(dto);

			} else {
				throw new NullEmailAndPasswordException("Password cant be null");
			}

		} catch (NullEmailAndPasswordException e) {
			e.printStackTrace();
		}
		return detailsEntity;
	}
}
