package edu.training.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.training.studentmanagementsystem.dao.AdminDao;
import edu.training.studentmanagementsystem.dao.StudentDao;
import edu.training.studentmanagementsystem.entity.Admin;
import edu.training.studentmanagementsystem.entity.Student;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private StudentDao studentDao;
	
	public Admin saveAdmin(Admin admin)
	{
		return adminDao.saveAdmin(admin);
	}
	public Admin findAdminById(int adminId)
	{
		return adminDao.findAdminById(adminId);
	}
	public Admin updateAdminById(int adminId, Admin admin)
	{
		return adminDao.updateAdmin(adminId, admin);
	}
	
	public Admin deleteAdminById(int adminId)
	{
		Admin admin= adminDao.findAdminById(adminId);
		if(admin!=null)
		{
			/*
			 * List<Student> students =admin.getStudents(); for(Student student:students) {
			 * // i want to iterate over every student linked to the admin and delete the
			 * students //requirements are delete() in student Dao ,
			 * 
			 * studentDao.deleteStudent(student); }
			 */
			
			adminDao.deleteAdminById(adminId);
			return admin;
		}
		else {
			return null;
		}
	}
}
