package edu.training.studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.training.studentmanagementsystem.entity.Admin;
import edu.training.studentmanagementsystem.service.AdminService;

@RestController
@RequestMapping("/admin") //general mapping annotation
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping
	public Admin saveAdmin(@RequestBody Admin admin)
	{
		return adminService.saveAdmin(admin);
	}
	@PutMapping
	public Admin updateAdminById(@RequestParam int adminId, @RequestBody Admin admin)
	{
		return  adminService.updateAdminById(adminId, admin);
	}
	@GetMapping
	public Admin findAdminById( @RequestParam int adminId)
	{
		return adminService.findAdminById(adminId);
	}
	@DeleteMapping
	public Admin deleteAdminById(@RequestParam int adminId)
	{
		return adminService.deleteAdminById(adminId);
	}
	
}
