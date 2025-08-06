package com.studentManagement.service;

import java.util.List;
import java.util.Optional;

import com.studentManagement.bean.StudentBean;
import com.studentManagement.model.Students;

public interface StudentService {
	
	public Students saveStudents(StudentBean bean) throws Exception;
	public List<Students> findAllStudents();
	public Optional<Students> findStudentById(Long studentId);
	public boolean deleteStudent(Long id);
	public boolean updateStudent(Long id, StudentBean bean);
	
}
