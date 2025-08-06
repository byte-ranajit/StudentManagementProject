package com.studentManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.studentManagement.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagement.bean.StudentBean;
import com.studentManagement.model.Students;
import com.studentManagement.repository.StudentRepository;
import com.studentManagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
    @Autowired
    private StudentRepository repo;

	private DocumentService service;

	@Override
	public List<Students> findAllStudents() {
		return (List<Students>) repo.findAll();
	}

	@Override
	public Optional<Students> findStudentById(Long studentId) {
		return Optional.ofNullable(repo.findById(studentId)).orElseThrow();
	}

	@Override
	public boolean updateStudent(Long id, StudentBean bean) {
		Optional<Students> optionalStudent = findStudentById(bean.getId());
		if (optionalStudent.isPresent()) {
			Students existingStudent = optionalStudent.get();
			existingStudent.setEmail(bean.getEmail());
			existingStudent.setDepartment(bean.getDepartment());
			existingStudent.setName(bean.getName());
			existingStudent.setEnrollmentDate(bean.getEnrollmentDate());
			logger.info("update data for student id {}" + bean.getId());
			repo.save(existingStudent);
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public Students saveStudents(StudentBean bean) throws Exception {
		logger.info("create new student data");
		Students student = new Students();
		student.setName(bean.getName());
		student.setEmail(bean.getEmail());
		student.setDepartment(bean.getDepartment());
		student.setEnrollmentDate(bean.getEnrollmentDate());
		service.saveDocument(bean.getId(),bean.getDocument(), bean.getDocumentType());
		return repo.save(student);
	}

	@Override
	public boolean deleteStudent(Long id) {
		if(repo.existsById(id)){
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
		
	}
    
}
