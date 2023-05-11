package edu.training.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.training.studentmanagementsystem.entity.Student;
import edu.training.studentmanagementsystem.service.StudentService;
import edu.training.studentmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("/student") //student/admin
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> saveStudent( @RequestBody Student student ,@RequestParam int adminId)
	{
		return service.saveStudent(student,adminId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Student>> findtStudentById(@RequestParam int id)
	{
		return service.findtStudentById(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student,@RequestParam int id)
	{
		return service.updateStudent(student, id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Student>> deleteStudentById(@RequestParam int studentId,@RequestParam int adminId)
	{
		return service.deleteStudentById(studentId, adminId);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<ResponseStructure<Student>> getAllStudents(@RequestParam int adminId)
	{
		return service.getAllStudents(adminId);
	}
}
