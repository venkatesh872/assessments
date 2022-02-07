package com.thoughtfocus.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateGenderByContactDTO {
	private long contact;
	private String gender;
}
