package com.example.springbootapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Value("${welcome.message}")
    private String welcomeMessage;
    //@RequestMapping(value = "/",method = RequestMethod.GET)//i assigned one of the end point "/"
         @GetMapping("/")//it has request mapping internally that has GET method
          public String helloWorld(){
              return "welcome to java class jagadeesh!";
          }
}

/*
sample Rest API
To make this particular class as a component of spring  so that whenever  an application is started so this
particular class is added to the spring container. for that we need to add to @Component for this class that we have
created now this particular class will be in spring's reader so that whenever application context starts
this classes will be added to spring container so whenever we need this class ,spring can gives

but technically this hello controller is not simple component ryt, it's controller so we can use @RestController

if you add @controller this class will be behaved component by default
 */