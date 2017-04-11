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
	//ModelDrivenΪ�ö�������Ӧ������ֵ
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
	
	//��ȡָ��ҳ�����в��ż�¼
	public String getDepartments() {
		Pager<Department> pager = departmentService.getDepartments(currentPage);
		
		if(pager != null) {
		//��pager��ŵ�strut2��ֵջ��
		ActionContext.getContext().getValueStack().push(pager);
		return "findPageDepartments";
		}
		//ʧ��ʲô��������
		return NONE;
		
	}
	
	public String addDepartment() {
		
		if(departmentService.addDepartment(department)) {
			this.addActionMessage("��Ӳ��ųɹ�");
			return "add_success";
		}else {
			this.addActionError("��Ӳ���ʧ��");
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
