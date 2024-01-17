package com.anysolution.studentmanagmentsystem.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank(message = "Name is required")
	@Size(min = 3, message = "Name must have at least 3 characters")
	private String name;

	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Column(nullable = false,unique = true)
	private String email;

	
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must have 10 digits")
	@Column(nullable = false,unique = true)
	private String mobile;

	private int age;

}
