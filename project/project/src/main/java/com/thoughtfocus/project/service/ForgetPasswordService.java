package com.thoughtfocus.project.service;

import com.thoughtfocus.project.Entity.DetailsEntity;
import com.thoughtfocus.project.dto.UpdatePasswordByEmailDTO;

public interface ForgetPasswordService {

	DetailsEntity UpdatePasswordByEmail(UpdatePasswordByEmailDTO dto);

}
