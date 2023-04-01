package com.ty.frozenbottle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.frozenbottle.dao.AdminDao;
import com.ty.frozenbottle.dto.Admin;
import com.ty.frozenbottle.dto.ResponseStructure;
import com.ty.frozenbottle.exception.IdNotFoundException;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		responseStructure.setData(adminDao.saveAdmin(admin));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin = adminDao.getAdminById(id);
		if (admin != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(adminDao.getAdminById(id));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found:" + id);
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin = adminDao.getAdminById(id);
		if (admin!=null) {
			adminDao.deleteAdminById(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(admin);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		}
		throw new IdNotFoundException("Id not found:" + id);

	}

}
