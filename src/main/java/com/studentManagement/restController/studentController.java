package com.studentManagement.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentManagement.model.Students;
import com.studentManagement.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class studentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Students saveStudents(@RequestBody Students student) {
        return studentService.saveStudents(student);
    }
    
    @GetMapping()
    public List<Students> findallStudents(){
        return studentService.findAllStudents();
    }
    
    @GetMapping("/{id}")
    public Optional<Students> findStudentById(Long id) {
        return studentService.findStudentById(id);
    }

    
}
