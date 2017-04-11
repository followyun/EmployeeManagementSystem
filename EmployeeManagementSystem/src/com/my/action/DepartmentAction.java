package com.my.action;

import com.my.entity.Department;
import com.my.entity.Employee;
import com.my.entity.Pager;
import com.my.service.DepartmentService;
import com.my.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	//ModelDriven为该对象赋上相应的属性值
	private Department department = new Department();
	private DepartmentService departmentService;
	private int currentPage = 1;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	
	//获取指定页的所有部门记录
	public String getDepartments() {
		Pager<Department> pager = departmentService.getDepartments(currentPage);
		
		if(pager != null) {
		//将pager存放到strut2的值栈中
		ActionContext.getContext().getValueStack().push(pager);
		return "findPageDepartments";
		}
		//失败什么都不返回
		return NONE;
		
	}
	
	public String addDepartment() {
		
		if(departmentService.addDepartment(department)) {
			this.addActionMessage("添加部门成功");
			return "add_success";
		}else {
			this.addActionError("添加部门失败");
		}
		return "add_failure";
	}

	public String editDepartment() {
		Department dep = departmentService.getDepartment(department);
		if(dep != null) {
			ActionContext.getContext().getSession().put("editDepartment", dep);
			return "go_edit";
		}else {
			return NONE;
		}
	}
	
	public String updateDepartment() {
		if(departmentService.updateDepartment(department)){
			return("update_success");
		}
		return NONE;
		
	}
	
	public String deleteDepartment() {
		if(departmentService.deleteDepartment(department)){
			return("delete_success");
		}
		return NONE;
		
	}
}
