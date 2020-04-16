package com.info.beans.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.info.beans.model.Employee;

@Repository
public class EmployeeDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void saveEmployee(Employee eployee) {
		entityManager.merge(eployee);		
	}

	public List<Employee> getAllEMployees() {
		TypedQuery<Employee> empList=entityManager.createQuery("select emp from Employee emp",Employee.class);
		return !empList.getResultList().isEmpty()?empList.getResultList():null;
	}

}
