package com.una.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.una.demo.models.VehiculoModel;

@Repository
public interface VehiculoRepositorio extends CrudRepository<VehiculoModel, String>{
    
}
