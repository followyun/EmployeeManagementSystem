package com.my.dao;

import java.util.List;

import com.my.entity.Employee;

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	boolean addEmployee(Employee employee);

	Employee getEmployeeById(Integer eid);

	boolean updateEmployee(Employee employee);

	boolean deleteEmployee(Employee employee);

	List<Employee> findByPage(int begin, int pagesize);

}
