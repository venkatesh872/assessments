package com.thoughtfocus.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thoughtfocus.project.Entity.DetailsEntity;
import com.thoughtfocus.project.dto.RegisterDTO;
import com.thoughtfocus.project.exception.NullEmailAndPasswordException;
import com.thoughtfocus.project.repository.DetailsRepo;
@Service
public class RegisterServiceImpl implements RegisterService{

	static Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
    @Autowired
    DetailsRepo repo;

	@Override
	public String saveUser(RegisterDTO dto) {
		try {
			if (dto.getEmail() != "" && dto.getPassword() != "" && dto.getEmail() != null) {
				DetailsEntity detailsEntity = new DetailsEntity();
				BeanUtils.copyProperties(dto, detailsEntity);
				repo.save(detailsEntity);
				return "your registration details are successfull";
			} else {
				throw new NullEmailAndPasswordException("Email or password are mandatory..");
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return "Registration failed";
	}
}
