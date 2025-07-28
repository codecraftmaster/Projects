package com.teluguSkillHub.services.Monolithic.service;

import com.teluguSkillHub.services.Monolithic.entity.Employee;
import com.teluguSkillHub.services.Monolithic.payload.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto saveEmployee(Employee employee);
	public EmployeeDto getEmployeeById(long id);

}
