package com.ty.frozenbottle.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.frozenbottle.dto.FoodMenu;
import com.ty.frozenbottle.dto.Product;
import com.ty.frozenbottle.repository.FoodMenuRepository;

@Repository
public class FoodMenuDao {
	@Autowired
	private FoodMenuRepository foodMenuRepository;

	public FoodMenu saveFoodMenu(FoodMenu foodMenu) {
		return foodMenuRepository.save(foodMenu);
	}

	public List<Product> getAllProducts(int id) {
		Optional<FoodMenu> optional = foodMenuRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get().getProduct();
		} else {
			return null;
		}
	}

	public FoodMenu getProductById(int id) {
		Optional<FoodMenu> optional = foodMenuRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean deleteProductById(int id) {
		Optional<FoodMenu> optional = foodMenuRepository.findById(id);
		if (optional.isPresent()) {
			foodMenuRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

	public void deleteFoodMenu(FoodMenu f) {
		foodMenuRepository.delete(f);	
	}

}
