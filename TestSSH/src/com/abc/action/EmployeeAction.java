package com.abc.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.abc.entity.Department;
import com.abc.entity.Employee;
import com.abc.entity.PageBean;
import com.abc.service.DepartmentService;
import com.abc.service.EmployeeService;



public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

	
	private List<Department> list=null;
	public EmployeeAction() {
		super();
		list =new ArrayList<Department>();
	}

	private Employee employee = new Employee();
	private EmployeeService employeeService;

	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
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
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	private int currPage =1;
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findAll(currPage);
		System.out.println("currPage1:"+currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	
	//进入添加员工界面
	public String add(){
		
		 list =	departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		System.out.println("添加员工"+list.size());
		return "add";
	}
	public List<Department> getList() {
		return list;
	}
	public void setList(List<Department> list) {
		this.list = list;
	}
	
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	public String edit(){
		employee = employeeService.findById(employee.getEid());
		return "editSuccess";
	}
}
