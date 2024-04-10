package com.una.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.demo.models.TerrenoModel;
import com.una.demo.repositories.TerrenoRepositorio;

@Service
public class TerrenoService {
    @Autowired
    TerrenoRepositorio terrenoRepositorio;

    public ArrayList<TerrenoModel> getTerrenos(){
        return (ArrayList<TerrenoModel>) terrenoRepositorio.findAll();
    }

    public TerrenoModel guardarTerreno(TerrenoModel terreno){
        return terrenoRepositorio.save(terreno);
    }

    public Optional <TerrenoModel> getById(String numeroPlano){
        return terrenoRepositorio.findById(numeroPlano);
    }

    public boolean eliminarTerreno (String numeroPlano){
        try{
            terrenoRepositorio.deleteById(numeroPlano);
            return true;
        }catch(Exception err){
                return false;
        }
    }
}
