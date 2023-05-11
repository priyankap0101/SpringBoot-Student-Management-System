package edu.training.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import edu.training.studentmanagementsystem.dao.AdminDao;
import edu.training.studentmanagementsystem.dao.StudentDao;
import edu.training.studentmanagementsystem.entity.Admin;
import edu.training.studentmanagementsystem.entity.Student;
import edu.training.studentmanagementsystem.exception.AdminNotFoundByIdException;
import edu.training.studentmanagementsystem.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private StudentDao studentDao;
	
	public  ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin)
	{
		Admin admin2 =adminDao.saveAdmin(admin);
		ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Admin Saved Successfully");
		responseStructure.setData(admin2);
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.CREATED);
	
	
	}
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(int adminId)
	{
		Admin admin= adminDao.findAdminById(adminId);
		
		if(admin!=null)
		{
			ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Admin Found");
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new AdminNotFoundByIdException("Failed to Find Admin!!");
		}
		
		
	}
	public  ResponseEntity<ResponseStructure<Admin>> updateAdminById(int adminId, Admin admin)
	{
		 Admin admin2 =adminDao.updateAdmin(adminId, admin);
		 
		 if(admin2!=null)
			{
				ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Admin Updated Successfully");
				responseStructure.setData(admin2);
				return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
			}
			else {
				throw new AdminNotFoundByIdException("Failed to Find Admin!!");
			}
			
		
	}
	
	
	
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int adminId)
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
			
			Admin admin2=adminDao.deleteAdminById(adminId);
			
			
			ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Admin Deleted Successfully");
			responseStructure.setData(admin2);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
			
		}
		else {
			return null;
		}
	}
}
