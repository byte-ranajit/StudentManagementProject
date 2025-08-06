package com.studentManagement.serviceImpl;

import com.studentManagement.model.DocumentType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.studentManagement.model.Documents;
import com.studentManagement.model.Students;
import com.studentManagement.repository.DocumentRepository;
import com.studentManagement.repository.StudentRepository;
import com.studentManagement.service.DocumentService;

@Service
public class DocumentsServiceImpl implements DocumentService{
	
	private final DocumentRepository documentRepository;
	private final StudentRepository studentRepository;
	
	public DocumentsServiceImpl(DocumentRepository documentRepository ,
			StudentRepository studentRepository) {
		this.documentRepository = documentRepository;
		this.studentRepository = studentRepository;
	}

	@Override
	public Documents saveDocument(Long studentId, MultipartFile file, DocumentType documentType) throws Exception {
		Students student = studentRepository.findById(studentId)
				.orElseThrow(() -> new Exception("Student not found"));
		Documents document = new Documents();
		document.setFileName(file.getName());
		document.setFileType(file.getContentType());
		document.setData(file.getBytes());
		document.setDocumentType(documentType);
		document.setStudent(student);

		return documentRepository.save(document);
	}

}
