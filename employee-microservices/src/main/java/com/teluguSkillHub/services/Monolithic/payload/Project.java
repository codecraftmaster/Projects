package com.teluguSkillHub.services.Monolithic.payload;


import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Project {
	
	private long id;
	
	private long projectCode;
	
	private String projectName;

}
