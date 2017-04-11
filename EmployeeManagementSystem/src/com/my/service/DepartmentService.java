package com.my.service;

import java.util.List;

import com.my.entity.Department;
import com.my.entity.Pager;

public interface DepartmentService {

	Pager<Department> getDepartments(int currentPage);

	boolean addDepartment(Department department);

	Department getDepartment(Department department);

	boolean updateDepartment(Department department);

	boolean deleteDepartment(Department department);

	List<Department> getAllDepartments();

}
