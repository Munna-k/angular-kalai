package com.eoxys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.eoxys.model.EmployeesData;
import com.eoxys.service.EmployeeService;

@Controller
public class EmployeesController {
	
	List<EmployeesData> cust = new ArrayList<EmployeesData>();
	@Autowired
	EmployeeService employeeService;
	
	//#########	working fine  ##########//
	
	/* @RequestMapping(value="/getContent",method = RequestMethod.GET,produces = {"application/json"})
     public @ResponseBody HashMap show(){
          HashMap hash = new HashMap();
          hash.put("msg", "welcome to spring angular js");
          System.out.println("This is working fine");
          return hash; // should print {msg=welcome to spring angular js} 
     }  */
	
//#########	working fine  ##########//
	
	
	@RequestMapping(value = "/PostFormDataJSONArray", method = RequestMethod.POST)
	public @ResponseBody List<EmployeesData> PostFormDataJSONArray(@RequestBody List<EmployeesData> person) {	
		
		int length = person.size();
		System.out.println("list size is = "+length);
		for(int i = 0;i<length;i++) {
			String firstName = person.get(i).getFirstName();
			String lastName = person.get(i).getLastName();
			String empId = person.get(i).getEmpId();
			String email = person.get(i).getEmail();
			String designation = person.get(i).getDesignation();
			String project = person.get(i).getProject();
			
			boolean ret = employeeService.insertEmployeeDatas(firstName,lastName,empId,email,designation,project);
			
		}
		return person;
	}

}
