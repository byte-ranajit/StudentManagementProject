package com.studentManagement.bean;

import java.time.LocalDate;
import java.util.List;

import com.studentManagement.model.DocumentType;
import com.studentManagement.model.Documents;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentBean {
	
	private Long id;
    private String name;
    private String email;
    private String department;
    private LocalDate enrollmentDate;
	private MultipartFile document;
	private DocumentType documentType;

}
