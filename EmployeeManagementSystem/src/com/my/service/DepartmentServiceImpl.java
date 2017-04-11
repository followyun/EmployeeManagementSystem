package com.my.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.my.dao.DepartmentDao;
import com.my.entity.Department;
import com.my.entity.Pager;

@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public Pager<Department> getDepartments(int currentPage) {
		// TODO Auto-generated method stub
		Pager<Department> pager = new Pager<Department>();
		pager.setCurrentPage(currentPage);
		int totalcount = departmentDao.findCount();
		pager.setTotalCount(totalcount);
		int pagesize = 3;
		pager.setPageSize(pagesize);
		double tc = totalcount;
		Double totalpage = Math.ceil(tc / pagesize); 
		pager.setTotalPage(totalpage.intValue());
		
		int begin = (currentPage - 1) * pagesize;
		List<Department> list = departmentDao.findByPage(begin, pagesize);
		pager.setList(list);
		return pager;
	}

	@Override
	public boolean addDepartment(Department department) {
		// TODO Auto-generated method stub
		if(departmentDao.addDepartment(department)) {
		return true;
		}
		return false;
	}

	@Override
	public Department getDepartment(Department department) {
		// TODO Auto-generated method stub
		Department dep = departmentDao.getDepartmentById(department.getDid());
		return dep;
	}

	@Override
	public boolean updateDepartment(Department department) {
		// TODO Auto-generated method stub
		if(departmentDao.updateDepartment(department)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		if(departmentDao.deleteDepartment(department)) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		List<Department> departmentList = departmentDao.getAllDepartments();
		return departmentList;
	}

}
