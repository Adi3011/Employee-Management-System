package com.employee.emsbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// when employee with given id does not exist in database then spring boot will catch this exception with message and
// throw exception with httpStatus and message
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException{

    public ResourseNotFoundException(String message){
        super(message);
    }

}
