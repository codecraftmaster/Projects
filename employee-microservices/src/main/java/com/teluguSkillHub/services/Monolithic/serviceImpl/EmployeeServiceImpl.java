package com.teluguSkillHub.services.Monolithic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.teluguSkillHub.services.Monolithic.entity.Employee;
import com.teluguSkillHub.services.Monolithic.feignclient.ProjectFeign;
import com.teluguSkillHub.services.Monolithic.payload.EmployeeDto;
import com.teluguSkillHub.services.Monolithic.payload.Project;
import com.teluguSkillHub.services.Monolithic.repository.EmployeeRepository;
import com.teluguSkillHub.services.Monolithic.service.EmployeeService;

import feign.Response;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectFeign projectFeign;
	
	
	@Override
	public EmployeeDto saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		Response response=projectFeign.getProjectByCode(savedEmployee.getEmployeeAssignedProject());
		String body=response.body().toString();
		Gson g=new Gson();
		Project project=g.fromJson(body, Project.class);
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setId(savedEmployee.getId());
		employeeDto.setEmployeeName(savedEmployee.getEmployeeName());
		employeeDto.setEmployeeEmail(savedEmployee.getEmployeeEmail());
		employeeDto.setEmployeeBaseLocation(savedEmployee.getEmployeeBaseLocation());
		employeeDto.setProjectCode(project.getProjectCode());
		employeeDto.setProjectName(project.getProjectName());
		
		return employeeDto;
	}
	
	@Override
	public EmployeeDto getEmployeeById(long id) {
		
		Employee foundEmployee=employeeRepository.findById(id).get();
		Response response=projectFeign.getProjectByCode(foundEmployee.getEmployeeAssignedProject());
		String body=response.body().toString();
		Gson g=new Gson();
		Project project=g.fromJson(body,Project.class);
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setId(foundEmployee.getId());
		employeeDto.setEmployeeName(foundEmployee.getEmployeeName());
		employeeDto.setEmployeeEmail(foundEmployee.getEmployeeEmail());
		employeeDto.setEmployeeBaseLocation(foundEmployee.getEmployeeBaseLocation());
		employeeDto.setProjectCode(project.getProjectCode());
		employeeDto.setProjectName(project.getProjectName());
		
		return employeeDto;
	}
	

}
