package com.thoughtfocus.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.mvc.dao.UserDAO;
@Service
public class DeleteServiceImpl implements DeleteService{
	@Autowired
	private UserDAO dao;
	@Override
	public boolean authenticateDelete(String username,Long mobileNumber, Double age) {
			try {
				if(username != null && mobileNumber != null && age != 0) {
					return dao.delete(username,mobileNumber,age);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	}


