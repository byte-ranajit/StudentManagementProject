package com.studentManagement.service;

import com.studentManagement.model.DocumentType;
import org.springframework.web.multipart.MultipartFile;

import com.studentManagement.model.Documents;

public interface DocumentService {
	public Documents saveDocument(Long studentId, MultipartFile file, DocumentType documentType) throws Exception;
}
