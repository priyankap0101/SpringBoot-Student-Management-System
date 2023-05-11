package edu.training.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.training.studentmanagementsystem.dao.AdminDao;
import edu.training.studentmanagementsystem.dao.StudentDao;
import edu.training.studentmanagementsystem.entity.Admin;
import edu.training.studentmanagementsystem.entity.Student;
import edu.training.studentmanagementsystem.util.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;

	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student, int adminId) {
		// finding admin present in database
		Admin admin = adminDao.findAdminById(adminId);

		// fetching the existing student list with admin
		List<Student> students = admin.getStudents();

		// assigning new student to the exising student list
		students.add(student);

		// setting the student list with new student to the admin
		admin.setStudents(students);

		// returning saving student to the database
		Student student2 = dao.saveStudent(student);

		// updating the student to the admin in database
		 ResponseStructure< Student>responseStructure=new ResponseStructure<>();
		 responseStructure.setStatusCode(HttpStatus.CREATED.value());
		 responseStructure.setMessage("Created");
		 responseStructure.setData(student);
		
		    Admin admin2 =adminDao.saveAdmin(admin);

		   return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Student>> findtStudentById(int id) {
		 Student student=dao.findtStudentById(id);
		 ResponseStructure< Student>responseStructure=new ResponseStructure<>();
		 responseStructure.setStatusCode(HttpStatus.FOUND.value());
		 responseStructure.setMessage("Found");
		 responseStructure.setData(student);
		 
		 return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student, int id) {
		Student student2 = dao.updateStudent(student, id);
		
		 ResponseStructure< Student>responseStructure=new ResponseStructure<>();
		 responseStructure.setStatusCode(HttpStatus.OK.value());
		 responseStructure.setMessage("Data Updated");
		 responseStructure.setData(student);
		
		 return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Student>>  deleteStudentById(int studentId, int adminId) {

		Student student = dao.findtStudentById(studentId);
		 ResponseStructure< Student>responseStructure=new ResponseStructure<>();
		if (student != null) {
			Admin admin=adminDao.findAdminById(adminId);
			if(admin!=null)
			{
				List<Student> students=admin.getStudents();
				students.remove(student);
				admin.setStudents(students);
				adminDao.updateAdmin(adminId, admin);
				Student student2=dao.deleteStudent(student);
				
				 responseStructure.setStatusCode(HttpStatus.OK.value());
				 responseStructure.setMessage("Data Deleted");
				 responseStructure.setData(student);
				
				 return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
			}
			else {
				return null;
			}
			
		} else {
			return null;
		}

	}
	
	public ResponseEntity<ResponseStructure<Student>> getAllStudents(int adminId)
	{
		 List<Student> student =dao.getAllStudents(adminId);
		ResponseStructure< Student>responseStructure=new ResponseStructure<>();
		
		 responseStructure.setStatusCode(HttpStatus.OK.value());
		 responseStructure.setMessage("Data Updated");
		 responseStructure.setData(student);
		
		 return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
		
	}
}
