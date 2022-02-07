package com.thoughtfocus.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thoughtfocus.project.Entity.DetailsEntity;

public interface DetailsRepo extends JpaRepository<DetailsEntity, Integer>{

	DetailsEntity getByEmail(String email);          //update password by email

	DetailsEntity getByContact(long contact);        //update gender by contact

	DetailsEntity getByName(String name);             //update dob by name

	DetailsEntity getByEmailAndPassword(String email, String password);

}
