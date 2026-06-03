package com.example.springboot;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//This can handle any exception related to validation
//general code
//Error->cant be handled, Exception->can be handled
//@RestControllerAdvice tells springboot that this class is going to handle exception by coontroller
@RestControllerAdvice
public class GlobalExceptionHandler {

    //MethodArgumentNotValidException catches all exception.MethodArgumentNotValidException happens when our validation condition is violated
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String>handleValidation(MethodArgumentNotValidException ex) {

        //stores all errors and returns it
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()//binds all errors into one
                .getFieldErrors() //checks every field for error
                .forEach(error ->
                        errors.put(
                                error.getField(), //eg:name
                                error.getDefaultMessage() //eg:Name Cannot be empty
                        ));

        return errors; //returns it
    }
}


//Exception Hierarchy
//Throwable -> Exception -> error (everything is a object)
//in ex exception object is passed (MethodArgumentNotValidException's object)