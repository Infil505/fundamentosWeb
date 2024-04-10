package com.una.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.una.demo.models.TerrenoModel;
import com.una.demo.services.TerrenoService;

@RestController
@RequestMapping("/terreno")
public class TerrenoController {
    @Autowired
    TerrenoService terrenoService;

    
    @GetMapping
    public ArrayList<TerrenoModel> obtenerTerrenos(){
        return this.terrenoService.getTerrenos();
    }

    @PostMapping
    public TerrenoModel guardarTerreno(@RequestBody TerrenoModel terreno){
        return this.terrenoService.guardarTerreno(terreno);
    }

    @GetMapping(path = "/{numeroPlano}")
    public Optional<TerrenoModel> getTerrenoByNumero(@PathVariable("numeroPlano") String numeroPlano){
        return this.terrenoService.getById(numeroPlano);
    }

    @DeleteMapping(path = ("/{numeroPlano}"))
    public String eliminarTerreno(@PathVariable("numeroPlano") String numeroPlano){
        boolean ok = this.terrenoService.eliminarTerreno(numeroPlano);        if(ok){
            return "se ha eliminado el terreno con numero de plano: " + numeroPlano;
        }else{
            return "No se ha encontrado el terreno con el numero de plano: " + numeroPlano;
        }
    }
    @PutMapping("/{numeroPlano}")
    public boolean actualizarTerreno(@PathVariable("numeroPlano") String numeroPlano, TerrenoModel terreno){
        Optional<TerrenoModel> optionalTerreno = terrenoService.getById(numeroPlano);
        if(optionalTerreno.isPresent()){
            TerrenoModel terrenoExistente = optionalTerreno.get();
            terrenoExistente.setColindanteEste(terreno.getColindanteEste());
            terrenoExistente.setColindanteNorte(terreno.getColindanteNorte());
            terrenoExistente.setColindanteOeste(terreno.getColindanteOeste());
            terrenoExistente.setColindanteSur(terreno.getColindanteSur());
            terrenoExistente.setDocumento(terreno.getDocumento());
            terrenoExistente.setMedida(terreno.getMedida());
            
            terrenoService.guardarTerreno(terrenoExistente);
            return true;
        }
        return false;
    }
}
