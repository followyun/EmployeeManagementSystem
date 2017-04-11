package com.my.service;

import com.my.entity.Employee;
import com.my.entity.Pager;

public interface EmployeeService {

	/**
	 * �������û���½����֤
	 * @param employee
	 * @return �ɹ�����true��ʧ�ܷ���false��
	 */
	Employee login(Employee employee);

	Pager<Employee> getEmployees(int currentPage);

	Employee getEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean deleteEmployee(Employee employee);

	boolean addEmployee(Employee employee);

}
