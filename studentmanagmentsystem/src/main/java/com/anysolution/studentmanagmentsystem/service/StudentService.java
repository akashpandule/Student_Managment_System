package com.anysolution.studentmanagmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anysolution.studentmanagmentsystem.pojo.Student;
import com.anysolution.studentmanagmentsystem.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student findStudentById(long id) {
		Optional<Student> optional=studentRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public Student updatStudent(Student student) {
		if (findStudentById(student.getId())!=null) {
			Student studentToBeUpdated=studentRepository.save(student);
			return studentToBeUpdated;
		}else {
			return null;
		}
	}
	
	public Student deleteStudent(long id) {
		Student student=findStudentById(id);
		if (student!=null) {
			studentRepository.deleteById(id);
			return student;
		}else {
			return null;
		}
	}

}
