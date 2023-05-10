package edu.training.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.training.studentmanagementsystem.dao.AdminDao;
import edu.training.studentmanagementsystem.dao.StudentDao;
import edu.training.studentmanagementsystem.entity.Admin;
import edu.training.studentmanagementsystem.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;

	@Autowired
	private AdminDao adminDao;

	public Student saveStudent(Student student, int adminId) {
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
		adminDao.saveAdmin(admin);

		return student2;
	}

	public Student findtStudentById(int id) {
		return dao.findtStudentById(id);
	}

	public Student updateStudent(Student student, int id) {
		return dao.updateStudent(student, id);
	}

	public Student deleteStudentById(int studentId, int adminId) {

		Student student = dao.findtStudentById(studentId);

		if (student != null) {
			Admin admin=adminDao.findAdminById(adminId);
			if(admin!=null)
			{
				List<Student> students=admin.getStudents();
				students.remove(student);
				admin.setStudents(students);
				adminDao.updateAdmin(adminId, admin);
				dao.deleteStudent(student);
				return student;
			}
			else {
				return null;
			}
			
		} else {
			return null;
		}

	}
	
	public List<Student> getAllStudents(int adminId)
	{
		return dao.getAllStudents(adminId);
	}
}
