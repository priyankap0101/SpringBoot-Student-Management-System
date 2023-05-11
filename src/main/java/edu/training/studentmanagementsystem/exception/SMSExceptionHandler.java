package edu.training.studentmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import edu.training.studentmanagementsystem.util.ResponseStructure;

@RestControllerAdvice
public class SMSExceptionHandler {

	@ExceptionHandler //handling exception in proper way 
	public ResponseEntity<ResponseStructure<String>> AdminNotFoundById(AdminNotFoundByIdException adminNotFoundByIdException)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		responseStructure.setMessage(adminNotFoundByIdException.getMessage());
		
		responseStructure.setData("Admin not Found With the requested ID!!");
		
		return new ResponseEntity<ResponseStructure <String >>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler //handling exception in proper way 
	public ResponseEntity<ResponseStructure<String>> StudentNotFoundById(StudentNotFoundById studentNotFoundByIdException)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		responseStructure.setMessage(studentNotFoundByIdException.getMessage());
		
		responseStructure.setData("Admin not Found With the requested ID!!");
		
		return new ResponseEntity<ResponseStructure <String >>(responseStructure,HttpStatus.NOT_FOUND);
	}
}
