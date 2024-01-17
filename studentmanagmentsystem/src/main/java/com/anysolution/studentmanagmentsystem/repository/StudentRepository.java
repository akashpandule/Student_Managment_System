package com.anysolution.studentmanagmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anysolution.studentmanagmentsystem.pojo.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
