package com.example.springbootapp.service;

import com.example.springbootapp.entity.Department;
import com.example.springbootapp.error.DepartmentNotFoundExcpetion;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundExcpetion;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
