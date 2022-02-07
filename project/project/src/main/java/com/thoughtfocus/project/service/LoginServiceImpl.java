package com.thoughtfocus.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.project.Entity.DetailsEntity;
import com.thoughtfocus.project.exception.InvalidLengthException;
import com.thoughtfocus.project.exception.UnknownUserException;
import com.thoughtfocus.project.repository.DetailsRepo;
@Service
public class LoginServiceImpl implements LoginService{
	static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	DetailsRepo repo;
	@Override
	public DetailsEntity loginUser(String email, String password) {
		DetailsEntity detailsEntity;
		detailsEntity = repo.getByEmailAndPassword(email, password);
		try {
			if (detailsEntity != null) {
				if (detailsEntity.getEmail().equals(email) && detailsEntity.getPassword().equals(password)) {
					if (email.length() < 20 && email.length() > 6) {
						return detailsEntity;
					} else {
						throw new InvalidLengthException("Email length range should be b/w 6-15");
					}
				}
			} else {
				throw new UnknownUserException("Incorrect details");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
