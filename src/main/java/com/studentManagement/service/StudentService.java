package com.studentManagement.service;

import java.util.List;
import java.util.Optional;

import com.studentManagement.model.Students;

public interface StudentService {
	
	public Students saveStudents(Students stutent);
	public List<Students> findAllStudents();
	public Optional<Students> findStudentById(Long studentId);
	public void deleteStudent(Long id);
	public void updateStudent(Long id);
	
}
