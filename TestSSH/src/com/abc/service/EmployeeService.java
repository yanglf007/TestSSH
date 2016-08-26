package com.abc.service;

import com.abc.entity.Employee;
import com.abc.entity.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findAll(int currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Integer eid);

}
