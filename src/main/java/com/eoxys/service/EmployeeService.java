package com.eoxys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoxys.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	public boolean insertEmployeeDatas(String firstName, String lastName, String empId, String email,
			String designation, String project) {
		
		boolean ret = employeeDao.insertData(firstName,lastName,empId,email,designation,project);
		return true;
	}

}
