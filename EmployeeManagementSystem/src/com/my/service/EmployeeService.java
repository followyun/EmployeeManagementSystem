package com.my.service;

import com.my.entity.Employee;
import com.my.entity.Pager;

public interface EmployeeService {

	/**
	 * 用于作用户登陆的验证
	 * @param employee
	 * @return 成功返回true，失败返回false；
	 */
	Employee login(Employee employee);

	Pager<Employee> getEmployees(int currentPage);

	Employee getEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean deleteEmployee(Employee employee);

	boolean addEmployee(Employee employee);

}
