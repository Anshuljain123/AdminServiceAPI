package com.idexcel.AnshulJainadminservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.idexcel.AnshulJainadminservice.exception.LenderNotFoundException;

@Configuration
@ControllerAdvice
public class LenderGlobalException {
	
	@ExceptionHandler
	public ResponseEntity<LenderNotFoundException> handleException(LenderNotFoundException exec){

        //LenderErrorResponse error = new LenderErrorResponse();
       // error.setStatus(HttpStatus.NOT_FOUND.value());
        //error.setMessage(exec.getMessage());
        //error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(exec, HttpStatus.NOT_FOUND);
        // comment for testing Git
	}

}
