package edu.training.studentmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.training.studentmanagementsystem.entity.Student;
import edu.training.studentmanagementsystem.repository.AdminRepo;
import edu.training.studentmanagementsystem.repository.StudentRepo;



@Repository
public class StudentDao {

	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private AdminRepo adminRepo;

	
	
	public Student saveStudent(Student student)
	{
		return repo.save(student);
	}
	public Student deleteStudent(Student student)
	{
		
		repo.delete(student);  //object of student
		return student;
	}
	public Student findtStudentById(int id)
	{
		return repo.findById(id).get();
	}
	public Student updateStudent(Student student,int id)
	{
		Optional<Student>student2 =repo.findById(id);
		if(student2.isEmpty())
		{
			return null;
		}
		else {
			
			student.setStudentId(id);
			return repo.save(student);
		}
	}
	public Student deleteStudentById(int studentId)
	{
		Optional<Student>student2 =repo.findById(studentId);
		if(student2.isEmpty())
		{
			return null;
		}
		else {
			
			
			repo.deleteById(studentId);
			return student2.get();
		}
	}
	public List<Student> getAllStudents(int adminId)
	{
		Optional<List<Student>> optional=adminRepo.getAllStudents(adminId);
		
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			return optional.get();
		}
	}
	
}
