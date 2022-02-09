package com.thoughtfocus.mvc.dao;

import java.util.List;

import com.thoughtfocus.mvc.dto.UserDTO;

public interface UserDAO {

	public boolean saveUser(UserDTO user);

	public List<UserDTO> fetchAllUsers();

	public boolean getByUserNameAndPassword(String username, String password);
	public boolean update(String username, Long mobileNumber);

	public boolean delete(String username, Long mobileNumber, Double age);

	

}
