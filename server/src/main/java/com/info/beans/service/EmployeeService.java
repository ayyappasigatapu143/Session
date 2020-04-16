package com.info.beans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.beans.dao.EmployeeDao;
import com.info.beans.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao empDao;

	public void saveEmployee(Employee eployee) {
		empDao.saveEmployee(eployee);
		
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empDao.getAllEMployees();
	}

}
