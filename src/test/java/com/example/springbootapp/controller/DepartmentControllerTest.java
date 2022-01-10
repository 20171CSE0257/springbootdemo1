package com.example.springbootapp.controller;

import com.example.springbootapp.entity.Department;
import com.example.springbootapp.error.DepartmentNotFoundExcpetion;
import com.example.springbootapp.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
  //we need to mock that MVC
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;
    private Department department;
    @BeforeEach
    void setUp(){
      department=Department.builder()
              .deppartmentAddress("Chennai")
              .departmentCode("IT-06")
              .departmentName("IT")
              .departmentId(1L)
              .build();

    }
    @Test
    void saveDepartment() throws Exception {
      Department inputDepartment=Department.builder()
              .deppartmentAddress("Chennai")
              .departmentCode("IT-06")
              .departmentName("IT")
              .departmentId(1L)
              .build();

      Mockito.when(departmentService.saveDepartment(inputDepartment))
              .thenReturn(department);
      mockMvc.perform(post("/departments")
              .contentType(MediaType.APPLICATION_JSON)
              .content("{\n" +
                      "    \"departmentName\":\"IT\",\n" +
                      "    \"deppartmentAddress\":\"Chennai\",\n" +
                      "    \"departmentCode\":\"IT-06\"\n" +
                      "\n" +
                      "}"))
              .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
      Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);

      mockMvc.perform(get("/departments/1")
              .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$.departmentName")
                      .value(department.getDepartmentName()));

    }
}
//To test this controller layer is little different
//controller has been called when you hit any of end points so for here also we have to hit our end points
