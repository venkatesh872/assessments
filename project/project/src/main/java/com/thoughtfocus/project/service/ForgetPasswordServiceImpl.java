package com.thoughtfocus.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.project.Entity.DetailsEntity;
import com.thoughtfocus.project.dto.UpdatePasswordByEmailDTO;
import com.thoughtfocus.project.exception.InvalidLengthException;
import com.thoughtfocus.project.exception.PasswordChangeException;
import com.thoughtfocus.project.repository.DetailsRepo;
@Service
public class ForgetPasswordServiceImpl implements ForgetPasswordService{

	static Logger logger = LoggerFactory.getLogger(ForgetPasswordServiceImpl.class);

	@Autowired
	DetailsRepo repo;

	@Override
	public DetailsEntity UpdatePasswordByEmail(UpdatePasswordByEmailDTO dto) {
		try {
			if (dto.getEmail() != null && dto.getEmail() != "") {
				String mail = dto.getEmail();
				logger.info(mail);
				if (dto.getPassword().length() > 6) {
					DetailsEntity detailsEntity = repo.getByEmail(mail);
					detailsEntity.setPassword(dto.getPassword());
					repo.save(detailsEntity);
					return detailsEntity;
				} else {
					throw new InvalidLengthException("password length should be greaterthan 5");
				}

			} else {
				throw new PasswordChangeException("Enter valid email to change the password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
