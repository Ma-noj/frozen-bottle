package com.ty.frozenbottle.controller;

import java.util.List;

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

import com.ty.frozenbottle.dto.FoodMenu;
import com.ty.frozenbottle.dto.Product;
import com.ty.frozenbottle.dto.ResponseStructure;
import com.ty.frozenbottle.service.FoodMenuService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/foodMenus")
public class FoodMenuController {

	@Autowired
	private FoodMenuService foodMenuService;

	@ApiOperation(value = "Save foodMenu ", notes = "Input is FoodMenu Obj and returns obj ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "FoodMenu Objected saved") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<FoodMenu>> saveFoodMenu(@RequestBody FoodMenu foodMenu) {

		return foodMenuService.saveFoodMenu(foodMenu);

	}

	@ApiOperation(value = "Find Food Menu products ", notes = "get all products ")
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(@PathVariable int id) {

		return foodMenuService.getAllProducts(id);
	}

	@ApiOperation(value = "delete food menu ", notes = "delete menu ")
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<FoodMenu>> deleteProductById(@PathVariable int id) {
		return foodMenuService.deleteProductById(id);
	}

}
