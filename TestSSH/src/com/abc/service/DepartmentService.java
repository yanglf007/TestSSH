package com.abc.service;

import java.util.List;

import com.abc.entity.Department;
import com.abc.entity.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	List<Department> findAll();

}
