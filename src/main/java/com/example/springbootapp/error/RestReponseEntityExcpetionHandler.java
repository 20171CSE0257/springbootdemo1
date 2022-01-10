package com.example.springbootapp.error;

import com.example.springbootapp.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //whatever the class you are created to handle all your exceptions
// okay that particular class should be @ControllerAdvice, we are adding for all our controllers
@ResponseStatus
public class RestReponseEntityExcpetionHandler             //that will handle all the exceptions
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundExcpetion.class) //
    public ResponseEntity<ErrorMessage>
    departmentNotFoundException(DepartmentNotFoundExcpetion departmentNotFoundExcpetion,
                                                    WebRequest webRequest){
        ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,
                departmentNotFoundExcpetion.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);

    }

}
