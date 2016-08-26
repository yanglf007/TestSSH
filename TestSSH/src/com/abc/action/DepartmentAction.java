package com.abc.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.abc.entity.Department;
import com.abc.entity.PageBean;
import com.abc.service.DepartmentService;



public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	private Department department = new Department();

	private DepartmentService departmentService;
	
	

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	private int currPage = 1;
	public String findAll(){
		
		PageBean<Department> pageBean =departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}

//跳转部门添加页面
	public String saveUI(){
		return "saveUI";
	}
	
	//保存部门信息

	public String save(){
	
		departmentService.save(department);
		return "saveSuccess";
	}

	public String edit(){
		
		department = departmentService.findById(department.getDid());
		
		return "editSuccess";
	}

	public String update(){
		departmentService.update(department);
		
		return "updateSuccess";
	}
	
}
