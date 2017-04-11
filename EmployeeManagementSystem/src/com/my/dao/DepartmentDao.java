package com.my.dao;

import java.util.List;

import com.my.entity.Department;
import com.my.entity.Pager;

public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pagesize);

	boolean addDepartment(Department department);

	Department getDepartmentById(Integer did);

	boolean updateDepartment(Department department);

	boolean deleteDepartment(Department department);

	List<Department> getAllDepartments();

}
