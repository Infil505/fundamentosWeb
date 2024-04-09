package com.una.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.una.demo.models.DocumentModel;

@Repository
public interface DocumentRepositorio extends CrudRepository<DocumentModel, String> {
    
}
