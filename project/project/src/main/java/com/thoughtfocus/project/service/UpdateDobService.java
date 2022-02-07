package com.thoughtfocus.project.service;

import com.thoughtfocus.project.Entity.DetailsEntity;
import com.thoughtfocus.project.dto.UpdateDobByNameDTO;

public interface UpdateDobService {

	DetailsEntity updateDobOfUserByName(UpdateDobByNameDTO dto);


}
