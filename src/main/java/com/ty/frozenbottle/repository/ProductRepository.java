package com.ty.frozenbottle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.frozenbottle.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query(value = "SELECT u FROM Product u WHERE u.menu.id= ?1")
     Product getMenuById(int id);
}
