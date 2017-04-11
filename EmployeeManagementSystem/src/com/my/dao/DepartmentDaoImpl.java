package com.my.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.my.entity.Department;


public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{


	/**
	 * 查询部门的记录数
	 */
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list !=null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * 分页查询部门
	 */
	@Override
	public List<Department> findByPage(int begin, int pagesize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> departmentList = this.getHibernateTemplate().findByCriteria(criteria, begin, pagesize);
		if(departmentList.size() > 0) {
			return departmentList;
		}
		return null;
	}

	@Override
	public boolean addDepartment(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
		return true;
	}

	@Override
	public Department getDepartmentById(Integer did) {
		// TODO Auto-generated method stub
		
		Department dep = this.getHibernateTemplate().get(Department.class, did);
		return dep;
		
	}

	@Override
	public boolean updateDepartment(Department department) {
		// TODO Auto-generated method stub
	this.getHibernateTemplate().update(department);
	
		return true;
	}

	@Override
	public boolean deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		department = this.getHibernateTemplate().get(Department.class, department.getDid());
		this.getHibernateTemplate().delete(department);
		return true;
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		String hql = "from Department";
		List<Department> departmentList = this.getHibernateTemplate().find(hql);
		return departmentList;
	}
	
	

}
