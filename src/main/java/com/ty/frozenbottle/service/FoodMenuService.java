package com.ty.frozenbottle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.frozenbottle.dao.FoodMenuDao;
import com.ty.frozenbottle.dto.FoodMenu;
import com.ty.frozenbottle.dto.Product;
import com.ty.frozenbottle.dto.ResponseStructure;
import com.ty.frozenbottle.exception.IdNotFoundException;
import com.ty.frozenbottle.repository.ProductRepository;

@Service
public class FoodMenuService {

	@Autowired
	private FoodMenuDao foodMenuDao;
	
	@Autowired
	private ProductRepository repo;

	
	public ResponseEntity<ResponseStructure<FoodMenu>> saveFoodMenu(FoodMenu foodMenu) {
		ResponseStructure<FoodMenu> responseStructure = new ResponseStructure<FoodMenu>();
		List<Product> products = foodMenu.getProduct();
		for (Product product : products) {
			product.setMenu(foodMenu);
		}
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		responseStructure.setData(foodMenuDao.saveFoodMenu(foodMenu));

		return new ResponseEntity<ResponseStructure<FoodMenu>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(int id) {
		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<List<Product>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(foodMenuDao.getAllProducts(id));
		return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<FoodMenu>> getProductById(int id) {
		FoodMenu foodMenu = foodMenuDao.getProductById(id);
		ResponseStructure<FoodMenu> responseStructure = new ResponseStructure<FoodMenu>();
		if (foodMenu != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(foodMenuDao.getProductById(id));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found:" + id);
		}

	}

	public ResponseEntity<ResponseStructure<FoodMenu>> deleteProductById(int id) {
		ResponseStructure<FoodMenu> responseStructure = new ResponseStructure<FoodMenu>();
		FoodMenu f = foodMenuDao.getProductById(id);
		if (f!=null) {
			Product p = repo.getMenuById(id);
			repo.delete(p);
			foodMenuDao.deleteFoodMenu(f);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(f);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		}
		throw new IdNotFoundException("Id not found:" + id);
	}

}
