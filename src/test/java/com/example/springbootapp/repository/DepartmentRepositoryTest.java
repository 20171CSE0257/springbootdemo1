package com.example.springbootapp.repository;

import com.example.springbootapp.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    //test entity manager
    @Autowired
    private TestEntityManager testEntityManager;
    @BeforeEach
    void setUp() {
        Department department=Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentCode("ME-011")
                .deppartmentAddress("Bangalore")
                .build();//this is the object that i want to persist
        testEntityManager.persist(department);
        //so this particular data will be persisted before i call my actual test case over here
    }
    @Test
    public  void whenFindById_thenReturnDepartment(){
        Department department=departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Mechanical Engineering");
    }
    //we can able to test our repository layer without any changes to our database.

}