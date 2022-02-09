package com.thoughtfocus.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thoughtfocus.mvc.controller.RegistrationController;
import com.thoughtfocus.mvc.dao.UserDAO;
import com.thoughtfocus.mvc.dto.UserDTO;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserDAO dao;
	Logger logger =LoggerFactory.getLogger(LoginServiceImpl.class);

	@Override
	public boolean authenticationUser(String username, String password) {

		try {
			if (username != null && password != null) {
				//System.out.println(username);
				logger.info(username);
				return dao.getByUserNameAndPassword(username, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// @Override
	/*
	 * public boolean authenticationUser(String username, String password) {
	 * 
	 * RestTemplate template = new RestTemplate(); UserDTO user =
	 * template.getForObject(
	 * "http://localhost:8088/spring-rest-producer/rest/users/" + username + "/" +
	 * password, UserDTO.class); if(user!=null) { System.out.println(user); return
	 * true; } return false;
	 * 
	 * }
	 */
}
