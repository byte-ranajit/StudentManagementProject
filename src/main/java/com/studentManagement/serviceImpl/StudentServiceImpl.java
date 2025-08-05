package com.studentManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagement.model.Students;
import com.studentManagement.repository.StudentRepository;
import com.studentManagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
    @Autowired
    private StudentRepository repo;

	@Override
	public List<Students> findAllStudents() {
		return (List<Students>) repo.findAll();
	}

	@Override
	public Optional<Students> findStudentById(Long studentId) {
		return Optional.ofNullable(repo.findById(studentId)).orElseThrow();
	}

	@Override
	public void updateStudent(Long id) {
		
	}

	@Override
	public Students saveStudents(Students stutent) {
		return null;
	}

	@Override
	public void deleteStudent(Long id) {
		
		
	}
    
}
