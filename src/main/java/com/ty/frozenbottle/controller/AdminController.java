package com.ty.frozenbottle.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.frozenbottle.dto.Admin;
import com.ty.frozenbottle.dto.ResponseStructure;
import com.ty.frozenbottle.service.AdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminservice;

	@ApiOperation(value = "save admin", notes = "Input is Admin Object and return object")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucessfully Saved"),
			@ApiResponse(code = 404, message = "input Mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody @Valid Admin admin) {
		return adminservice.saveAdmin(admin);
	}

	@ApiOperation(value = "Get admin by id", notes = "input is admin obj and return same obj with id ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@GetMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@PathVariable int id) {
		return adminservice.getAdminById(id);
	}

	@ApiOperation(value = "delete admin by id", notes = "input is admin obj and return same obj with id ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@DeleteMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(@PathVariable int id) {
		return adminservice.deleteAdminById(id);
	}

}
