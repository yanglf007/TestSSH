package com.abc.dao;

import java.util.List;

import com.abc.entity.Department;
import com.abc.entity.PageBean;

public interface DepartmentDao {



	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	List<Department> findAll();



}
