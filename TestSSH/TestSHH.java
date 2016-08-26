package com.abc.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.abc.entity.Employee;
import com.abc.entity.PageBean;
import com.abc.service.EmployeeService;



public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

	private Employee employee = new Employee();
	private EmployeeService employeeService;
	
	


	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public String login(){
		Employee existEmployee =employeeService.login(employee);
		if(existEmployee==null){
			this.addActionError("用户名或密码错误");
			return INPUT;
		}else{
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		
	}
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
	int currPage =1;
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
}
