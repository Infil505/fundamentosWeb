package com.una.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.una.demo.models.DocumentModel;


public interface DocumentRepositorio extends CrudRepository<DocumentModel, String> {
    
}
