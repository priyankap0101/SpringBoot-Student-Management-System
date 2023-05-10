package edu.training.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/student") //student/admin
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping
	public Student saveStudent( @RequestBody Student student ,@RequestParam int adminId)
	{
		return service.saveStudent(student,adminId);
	}
	@GetMapping
	public Student findtStudentById(@RequestParam int id)
	{
		return service.findtStudentById(id);
	}
	@PutMapping
	public Student updateStudent(@RequestBody Student student,@RequestParam int id)
	{
		return service.updateStudent(student, id);
	}
	@DeleteMapping
	public Student deleteStudentById(@RequestParam int studentId,@RequestParam int adminId)
	{
		return service.deleteStudentById(studentId, adminId);
	}
	
	@GetMapping("/admin")
	public List<Student> getAllStudents(@RequestParam int adminId)
	{
		return service.getAllStudents(adminId);
	}
}
