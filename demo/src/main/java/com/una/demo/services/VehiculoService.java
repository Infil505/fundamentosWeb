package com.una.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.demo.models.VehiculoModel;
import com.una.demo.repositories.VehiculoRepositorio;

@Service
public class VehiculoService {
    @Autowired
    VehiculoRepositorio vehiculoRepositorio;

    public ArrayList<VehiculoModel> getVehiculos(){
        return (ArrayList<VehiculoModel>) vehiculoRepositorio.findAll();
    }

    public VehiculoModel guardarVehiculo(VehiculoModel vehiculo){
        return vehiculoRepositorio.save(vehiculo);
    }

    public Optional <VehiculoModel> getById(String matricula){
        return vehiculoRepositorio.findById(matricula);
    }

    public boolean eliminarVehiculo (String matricula){
        try{
            vehiculoRepositorio.deleteById(matricula);
            return true;
        }catch(Exception err){
                return false;
        }
    }
}
