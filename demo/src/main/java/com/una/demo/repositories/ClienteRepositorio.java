package com.una.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.una.demo.models.ClienteModel;

@Repository
public interface  ClienteRepositorio extends CrudRepository<ClienteModel, String>{
    
}
