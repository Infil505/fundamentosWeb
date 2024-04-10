package com.una.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.una.demo.models.TerrenoModel;

@Repository
public interface TerrenoRepositorio extends CrudRepository<TerrenoModel, String>{
    
}
