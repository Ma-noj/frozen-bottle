package com.ty.frozenbottle.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(unique = true)
	@NotBlank(message = "Enter the email")
	private String email;

	@Column(unique = true)
	@NotNull
	private Long phone;

	@NotNull
	private LocalDate dob;

	@OneToOne(mappedBy = "customer")
	private FoodOrder foodOrder;

	@ManyToOne
	@JoinColumn
	private Admin admin;

}