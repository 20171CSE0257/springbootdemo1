package com.example.springbootapp.service;

import com.example.springbootapp.entity.Department;
import com.example.springbootapp.error.DepartmentNotFoundExcpetion;
import com.example.springbootapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //this is a service class Impl
public class DepartmentServiceImpl implements DepartmentService
{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);//to save the department
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();//get all the department list and it will send back
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundExcpetion {
        Optional<Department>department=
                departmentRepository.findById(departmentId);

        if(!department.isPresent()) //if department is not present
        {
            throw new DepartmentNotFoundExcpetion("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        Department depDB=departmentRepository.findById(departmentId).get();
        //if any other parameters are null then we can skip it  else we can update in depDB
        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            depDB.setDepartmentName(department.getDepartmentName());
            //if anything is not null and not blank then only set the value otherwise skip
            //we are checking here for null checks and blank checks
        }
        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        if (Objects.nonNull(department.getDeppartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDeppartmentAddress()))
        {
            depDB.setDeppartmentAddress(department.getDeppartmentAddress());
        }


        return departmentRepository.save(depDB);

        //we took the values from the DB that is depDB over here and what ever the input parameter that we got over here
        //from the end point as a request body and checking the null checks and blank checks ,which ever is non null and not blank
        //then that only we are updating to the database
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
