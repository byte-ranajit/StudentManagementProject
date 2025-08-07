package com.studentManagement.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentManagement.bean.StudentBean;
import com.studentManagement.model.Students;
import com.studentManagement.service.StudentService;

@RestController
@RequestMapping("/api/students/")
public class studentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Students saveStudents(@RequestBody StudentBean bean) throws Exception {
        return studentService.saveStudents(bean);
    }
    
    @GetMapping()
    public ResponseEntity<List<Students>> findAllStudents(){
    	List<Students> students = studentService.findAll();
        return ResponseEntity.ok(students);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Students> findStudentById(@PathVariable Long id) {
        return studentService.findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deteleStudent(@PathVariable Long id) {
    	boolean isDeleted = studentService.deleteStudent(id);
    	return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<StudentBean> updateStudent(@PathVariable Long id, @RequestBody StudentBean bean) {
    	boolean isUpdated = studentService.updateStudent(id, bean);
    	return isUpdated ? ResponseEntity.ok(bean) : ResponseEntity.notFound().build();
    }
    
    
}
