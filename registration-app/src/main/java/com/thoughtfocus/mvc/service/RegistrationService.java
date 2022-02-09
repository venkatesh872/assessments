package com.thoughtfocus.mvc.service;

import java.util.List;

import com.thoughtfocus.mvc.dto.UserDTO;

public interface RegistrationService {
	

	public List<UserDTO> fetchUsers();

	public boolean validateAndsaveUser(UserDTO user);

}
