package com.my.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.my.entity.Employee;


public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{

	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		//hql语句中指定的表名是对象名
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> employeeList = this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
		if(employeeList != null && employeeList.size() > 0) {
			return employeeList.get(0);
		}
		
		return null;

	}
	
	/**
	 * 查询员工的记录数
	 */
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list !=null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * 分页查询员工
	 */
	@Override
	public List<Employee> findByPage(int begin, int pagesize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> employeeList = this.getHibernateTemplate().findByCriteria(criteria, begin, pagesize);
		if(employeeList.size() > 0) {
			return employeeList; 
		}
		return null;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(employee);
		return true;
	}

	@Override
	public Employee getEmployeeById(Integer did) {
		// TODO Auto-generated method stub
		
		Employee dep = this.getHibernateTemplate().get(Employee.class, did);
		return dep;
		
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
	this.getHibernateTemplate().update(employee);
	
		return true;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		//删除前一定要先获取到完整的对象信息
		employee = this.getHibernateTemplate().get(Employee.class, employee.getEid());
		this.getHibernateTemplate().delete(employee);
		return true;
	}
	


}
