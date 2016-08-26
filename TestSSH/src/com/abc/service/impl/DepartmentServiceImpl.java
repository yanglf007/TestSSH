package com.abc.service.impl;

import java.util.List;

import com.abc.dao.DepartmentDao;
import com.abc.entity.Department;
import com.abc.entity.PageBean;
import com.abc.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao;



	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	

	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Department> pageBean = new PageBean();
				
		int pageSize=3;
		
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		int totalCount =departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage ;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//∑÷“≥≤È—Ø≤È—Ø
		int begin = (currPage -1)*pageSize;
		List <Department> list =departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean; 
	}


	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		
		departmentDao.save(department);
		
	}


	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		Department department = departmentDao.findById(did);
		return department;
	}


	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
		
	}


	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		
	List<Department> list =	departmentDao.findAll();
		return list;
	}
	

}
