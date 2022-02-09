package com.thoughtfocus.mvc.service;

import java.lang.System.Logger;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.mvc.dao.UserDAO;
import com.thoughtfocus.mvc.dto.UserDTO;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	UserDAO dao;

	@Override
	public List<UserDTO> fetchUsers() {
		return null;
	}

	@Override
	public boolean validateAndsaveUser(UserDTO user) {
		try {
			if (user.getPassword().equals(user.getConfirmPassword())) {
			
				return dao.saveUser(user);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
		
	}
	
}


