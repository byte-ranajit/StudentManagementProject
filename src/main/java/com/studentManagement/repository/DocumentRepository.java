package com.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentManagement.model.Documents;

public interface DocumentRepository extends JpaRepository<Documents, Long>{

}
