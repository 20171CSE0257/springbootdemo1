package com.example.springbootapp.service;

import com.example.springbootapp.entity.Department;
import com.example.springbootapp.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean // when u mock this particular method what you want
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department=
                Department.builder()
                        .departmentName("IT")
                        .deppartmentAddress("Bangalore")
                        .departmentCode("IT-06")
                        .departmentId(1L)
                        .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);

    }
    @Test
    @DisplayName("Get Data based on valid Department Name")
    void fetchDepartmentByName() {
        String departmentName="IT";
        Department found=departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
    @Test
    void saveDepartment() {
    }

    @Test
    void fetchDepartmentList() {
    }

    @Test
    void fetchDepartmentById() {
    }

    @Test
    void deleteDepartmentById() {
    }

    @Test
    void updateDepartment() {
    }


}