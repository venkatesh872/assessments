package com.thoughtfocus.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.project.Entity.DetailsEntity;
import com.thoughtfocus.project.dto.UpdateGenderByContactDTO;
import com.thoughtfocus.project.exception.InvalidDetailsException;
import com.thoughtfocus.project.repository.DetailsRepo;
@Service
public class UpdateGenderServiceImpl implements UpdateGenderService{

	static Logger logger = LoggerFactory.getLogger(UpdateGenderServiceImpl.class);

	@Autowired
	DetailsRepo repo;

	@Override
	public DetailsEntity updateGenderByContact(UpdateGenderByContactDTO dto) {
		try {
			DetailsEntity detailsEntity = repo.getByContact(dto.getContact());
			if (detailsEntity != null && dto.getGender() != "" && dto.getContact() > 99999) {
				detailsEntity.setGender(dto.getGender());
				repo.save(detailsEntity);
				return detailsEntity;
			} else {
				throw new InvalidDetailsException("enter valid details");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
