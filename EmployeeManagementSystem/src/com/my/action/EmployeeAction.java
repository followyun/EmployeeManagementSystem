package com.my.action;


import java.util.List;

import com.my.entity.Department;
import com.my.entity.Employee;
import com.my.entity.Pager;
import com.my.service.DepartmentService;
import com.my.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//ModelDriven为该对象赋上相应的属性值
	private Employee employee = new Employee();
	private EmployeeService employeeService;
	private int currentPage = 1;
	
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
	//进行用户登陆验证的方法
	public String login() {
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee != null) {
			System.out.println("登陆成功");
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}else {
			System.out.println("登陆失败");
			this.addActionError("用户名或密码错误");
			return INPUT;
		}
		
	}
	
	public String logout() {
		if(ActionContext.getContext().getSession().get("existEmployee")!=null) {
			ActionContext.getContext().getSession().remove("existEmployee");
			this.addActionMessage("注销成功！");
		}
		return "logout_success";
	}
	
	//获取指定页的所有部门记录
		public String getEmployees() {
			Pager<Employee> pager = employeeService.getEmployees(currentPage);
			
			if(pager != null) {
			//将pager存放到strut2的值栈中
			ActionContext.getContext().getValueStack().push(pager);
			return "findPageEmployees";
			}
			//失败什么都不返回
			return NONE;
			
		}
		
		public String addEmployee() {
			
			if(employeeService.addEmployee(employee)) {
				System.out.println("添加员工成功");
				this.addActionMessage("添加员工成功");
				return "add_success";
			}else {
				System.out.println("添加员工失败");
				this.addActionError("添加员工失败");
			}
			return "add_failure";
		}

		public String editEmployee() {
			employee = employeeService.getEmployee(employee);
			
			List<Department> departmentList = departmentService.getAllDepartments();
			if(departmentList != null) {
				//使用值栈时，集合用set，对象用put方法
				ActionContext.getContext().getValueStack().set("list", departmentList);
				return "go_edit";
			}
			
			return NONE;
		}
		
		public String updateEmployee() {
			if(employeeService.updateEmployee(employee)){
				return("update_success");
			}
			return NONE;
			
		}
		
		public String deleteEmployee() {
			if(employeeService.deleteEmployee(employee)){
				return("delete_success");
			}
			return NONE;
			
		}
		
		/**
		 * 跳到添加员工页面的执行方法
		 * 
		 * @return
		 */
		public String addUI() {
			List<Department> departmentList = departmentService.getAllDepartments();
			if(departmentList != null) {
				//使用值栈时，集合用set，对象用put方法
				ActionContext.getContext().getValueStack().set("list", departmentList);
				return "go_add";
			}
			return NONE;
		}
}
