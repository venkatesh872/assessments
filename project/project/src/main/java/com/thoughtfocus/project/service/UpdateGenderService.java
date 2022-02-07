package com.thoughtfocus.project.service;

import com.thoughtfocus.project.Entity.DetailsEntity;
import com.thoughtfocus.project.dto.UpdateGenderByContactDTO;

public interface UpdateGenderService {

	DetailsEntity updateGenderByContact(UpdateGenderByContactDTO dto);

}
