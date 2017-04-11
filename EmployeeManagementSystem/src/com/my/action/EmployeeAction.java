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
	//ModelDrivenΪ�ö�������Ӧ������ֵ
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
	
	//�����û���½��֤�ķ���
	public String login() {
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee != null) {
			System.out.println("��½�ɹ�");
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}else {
			System.out.println("��½ʧ��");
			this.addActionError("�û������������");
			return INPUT;
		}
		
	}
	
	public String logout() {
		if(ActionContext.getContext().getSession().get("existEmployee")!=null) {
			ActionContext.getContext().getSession().remove("existEmployee");
			this.addActionMessage("ע���ɹ���");
		}
		return "logout_success";
	}
	
	//��ȡָ��ҳ�����в��ż�¼
		public String getEmployees() {
			Pager<Employee> pager = employeeService.getEmployees(currentPage);
			
			if(pager != null) {
			//��pager��ŵ�strut2��ֵջ��
			ActionContext.getContext().getValueStack().push(pager);
			return "findPageEmployees";
			}
			//ʧ��ʲô��������
			return NONE;
			
		}
		
		public String addEmployee() {
			
			if(employeeService.addEmployee(employee)) {
				System.out.println("���Ա���ɹ�");
				this.addActionMessage("���Ա���ɹ�");
				return "add_success";
			}else {
				System.out.println("���Ա��ʧ��");
				this.addActionError("���Ա��ʧ��");
			}
			return "add_failure";
		}

		public String editEmployee() {
			employee = employeeService.getEmployee(employee);
			
			List<Department> departmentList = departmentService.getAllDepartments();
			if(departmentList != null) {
				//ʹ��ֵջʱ��������set��������put����
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
		 * �������Ա��ҳ���ִ�з���
		 * 
		 * @return
		 */
		public String addUI() {
			List<Department> departmentList = departmentService.getAllDepartments();
			if(departmentList != null) {
				//ʹ��ֵջʱ��������set��������put����
				ActionContext.getContext().getValueStack().set("list", departmentList);
				return "go_add";
			}
			return NONE;
		}
}
