package com.thoughtfocus.project.service;

import javax.naming.InvalidNameException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.project.Entity.DetailsEntity;
import com.thoughtfocus.project.dto.UpdateDobByNameDTO;
import com.thoughtfocus.project.repository.DetailsRepo;
@Service
public class UpdateDobServiceImpl implements UpdateDobService{
	static Logger logger = LoggerFactory.getLogger(UpdateDobServiceImpl.class);

	@Autowired
	DetailsRepo repo;

	@Override
	public DetailsEntity updateDobOfUserByName(UpdateDobByNameDTO dto) {
		try {
			logger.info(dto.getName());
			DetailsEntity detailsEntity = repo.getByName(dto.getName());
			if (detailsEntity != null && dto.getDob() != "" && dto.getName() != "") {
				detailsEntity.setDob(dto.getDob());
				repo.save(detailsEntity);
				return detailsEntity;
			} else {
				throw new InvalidNameException("Enter valid name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
