package com.studentManagement.service;

import com.studentManagement.model.DocumentType;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
	public void saveDocument(Long studentId, MultipartFile file, DocumentType documentType) throws Exception;
}
