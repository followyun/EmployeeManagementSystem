package com.my.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.my.dao.EmployeeDao;

import com.my.entity.Employee;
import com.my.entity.Pager;

@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee employee1 = employeeDao.findByUsernameAndPassword(employee);
		if(employee1 != null) {
			return employee1;
		}
		return null;
	}
	
	@Override
	public Pager<Employee> getEmployees(int currentPage) {
		// TODO Auto-generated method stub
		Pager<Employee> pager = new Pager<Employee>();
		pager.setCurrentPage(currentPage);
		int totalcount = employeeDao.findCount();
		pager.setTotalCount(totalcount);
		int pagesize = 3;
		pager.setPageSize(pagesize);
		double tc = totalcount;
		Double totalpage = Math.ceil(tc / pagesize); 
		pager.setTotalPage(totalpage.intValue());
		
		int begin = (currentPage - 1) * pagesize;
		List<Employee> list = employeeDao.findByPage(begin, pagesize);
		pager.setList(list);
		return pager;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(employeeDao.addEmployee(employee)) {
		return true;
		}
		return false;
	}

	@Override
	public Employee getEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee dep = employeeDao.getEmployeeById(employee.getEid());
		return dep;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(employeeDao.updateEmployee(employee)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(employeeDao.deleteEmployee(employee)) {
			return true;
		}
		
		return false;
	}

}
