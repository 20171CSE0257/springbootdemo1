package com.example.springbootapp.controller;

import com.example.springbootapp.entity.Department;
import com.example.springbootapp.error.DepartmentNotFoundExcpetion;
import com.example.springbootapp.service.DepartmentService;
import com.example.springbootapp.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired //this is particular department service i want it from you
    //Autowire the particular object that you have in the spring container,so this particular reference that i have created
    //two types of Autowiring constructor based and field based
    private  DepartmentService departmentService;

    private final Logger logger= LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    //created one Rest API using the Post mapping that is the POST Request that i will do any of the rest client
    // i will be passing the request body as well,so that will be the entire JSON object that i will be passing him
    //i want that entire JSON object to be coming over here,i need to convert entire object to my department entity

    public Department saveDepartment(@Valid @RequestBody Department department)//JSON object passing here has to be converted department for that @RequestBody
    {
        logger.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){ //get all the departments from the List of departments
        logger.info("Inside fetchDepartment of DepartmentController");
        return departmentService.fetchDepartmentList();
    }
    //fetching data by ID
    @GetMapping("/departments/{id}")//path variable ,dynamic Id that we're passing over here
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundExcpetion {
        return departmentService.fetchDepartmentById(departmentId);
    }
    //deleting by ID

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
       departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }
    @PutMapping("/departments/{id}") //updating the data
    public Department updateDepartment(@PathVariable("id")Long departmentId,@RequestBody Department department)
    {
            return  departmentService.updateDepartment(departmentId,department);
    }
    //fetch data by Name
    @GetMapping("/departments/name/{name}")
    public  Department fetchDepartmentByName(@PathVariable("name") String departmentName){

        return  departmentService.fetchDepartmentByName(departmentName);
    }

}
