package com.example.springbootapp.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor //default constructor
@AllArgsConstructor
@Builder //Builder pattern, when you have multiple properties available ,and you want to use different sets of properties always to create the objects
//suppose if you are creating the department object,and if you have 10 properties then with the help of 5 or 2 properties also u can create the object
//so it's not defined ryt,if you are going with routine approach constructor if you 10 arguments you have to pass all the 10 arguments or else you have to create lot of
//different constructors for all the different arguments available over here ryt that's really boring ryt to overcome that use builder pattrn
//we removed all the boilerplate code that was there in our application
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Please add department name")
   /* @Length(max=5,min=1)
    @Size(max=10,min = 0)
    @Email
    @PositiveOrZero
    @FutureOrPresent
    @PastOrPresent*/
    private String departmentName;
    private String deppartmentAddress;
    private String departmentCode;
}
