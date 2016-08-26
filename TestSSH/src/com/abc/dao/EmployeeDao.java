package com.abc.dao;

import java.util.List;

import com.abc.entity.Employee;

public interface EmployeeDao {

	

	Employee findbyNameAndPassword(Employee employee);

	int findCount();

	List<Employee> findAll(int begin, int pageSize);

}
