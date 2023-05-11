package edu.training.studentmanagementsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentNotFoundById extends RuntimeException {

	private String message;
}
