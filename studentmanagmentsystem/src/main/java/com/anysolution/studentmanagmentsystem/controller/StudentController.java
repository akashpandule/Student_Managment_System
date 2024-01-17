package com.anysolution.studentmanagmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anysolution.studentmanagmentsystem.pojo.Student;
import com.anysolution.studentmanagmentsystem.response.StudentResponse;
import com.anysolution.studentmanagmentsystem.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(path = "/add_student")
	public ResponseEntity<StudentResponse> addStudent(@RequestBody Student student) {
		try {
			Student studentToBeAdded = studentService.addStudent(student);
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setMessage("Student added");
			studentResponse.setStudent(studentToBeAdded);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setMessage("Student not added");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path="all_students")
	public ResponseEntity<StudentResponse> findAllStudents() {
			List<Student> students=studentService.findAllStudents();
			if(students!=null && students.size()>0) {
				StudentResponse studentResponse=new StudentResponse();
				studentResponse.setMessage("Students fatched");
				studentResponse.setStudent(null);
				studentResponse.setStudents(students);
				studentResponse.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
			}else {
				StudentResponse studentResponse=new StudentResponse();
				studentResponse.setMessage("Students not fatched");
				studentResponse.setStudent(null);
				studentResponse.setStudents(null);
				studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
			}
	}

	@PutMapping(path="/update_student")
	public ResponseEntity<StudentResponse> updateStudent(@RequestBody Student student) {
		try {
			Student studentToBeUpdated = studentService.updatStudent(student);
			if (studentToBeUpdated != null) {
				StudentResponse studentResponse = new StudentResponse();
				studentResponse.setMessage("Student updated");
				studentResponse.setStudent(studentToBeUpdated);
				studentResponse.setStudents(null);
				studentResponse.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.OK);
			} else {
				StudentResponse studentResponse = new StudentResponse();
				studentResponse.setMessage("Student not updated");
				studentResponse.setStudent(null);
				studentResponse.setStudents(null);
				studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setMessage("Student not updated");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/delete_student")
	public ResponseEntity<StudentResponse> deleteStudent(long id) {
		try {
			Student student=studentService.deleteStudent(id);
			if(student!=null) {
				StudentResponse studentResponse=new StudentResponse();
				studentResponse.setMessage("Student deleted");
				studentResponse.setStudent(student);
				studentResponse.setStudents(null);
				studentResponse.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.OK);
			}else {
				StudentResponse studentResponse=new StudentResponse();
				studentResponse.setMessage("Student not deleted");
				studentResponse.setStudent(null);
				studentResponse.setStudents(null);
				studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("Student not deleted");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="student")
	public ResponseEntity<StudentResponse> findStudentById(long id) {
		try {
			Student student=studentService.findStudentById(id);
			if (student!=null) {
				StudentResponse studentResponse=new StudentResponse();
				studentResponse.setMessage("Student fatched");
				studentResponse.setStudent(student);
				studentResponse.setStudents(null);
				studentResponse.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
			}else {
				StudentResponse studentResponse=new StudentResponse();
				studentResponse.setMessage("Student not fatched");
				studentResponse.setStudent(null);
				studentResponse.setStudents(null);
				studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("Student not fatched");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}

}
