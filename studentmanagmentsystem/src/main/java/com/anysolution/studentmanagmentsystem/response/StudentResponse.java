package com.anysolution.studentmanagmentsystem.response;

import java.util.List;

import com.anysolution.studentmanagmentsystem.pojo.Student;

import lombok.Data;


@Data
public class StudentResponse {
	
	private String message;
	private Student student;
	private List<Student> students;
	private int status;

}
