package com.thoughtfocus.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.project.Entity.DetailsEntity;
import com.thoughtfocus.project.dto.UpdateDobByNameDTO;
import com.thoughtfocus.project.service.UpdateDobService;

@RestController
public class UpdateDobController {

	static Logger logger = LoggerFactory.getLogger(UpdateDobController.class);

	@Autowired
	UpdateDobService updateDobService;

	@PostMapping("updatedob/name")
	DetailsEntity updateDobByName(@RequestBody UpdateDobByNameDTO dto) {
		DetailsEntity detailsEntity = null;
		try {
			detailsEntity = updateDobService.updateDobOfUserByName(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsEntity;

	}
}
