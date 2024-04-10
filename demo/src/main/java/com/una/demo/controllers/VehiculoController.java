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

import com.una.demo.models.VehiculoModel;
import com.una.demo.services.VehiculoService;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    @Autowired
    VehiculoService vehiculoService;
    
    
    @GetMapping
    public ArrayList<VehiculoModel> obtenerVehiculos(){
        return this.vehiculoService.getVehiculos();
    }

    @PostMapping
    public VehiculoModel guardarVehiculo(@RequestBody VehiculoModel vehiculo){
        return this.vehiculoService.guardarVehiculo(vehiculo);
    }

    @GetMapping(path = "/{matricula}")
    public Optional<VehiculoModel> getDocuemntByNumero(@PathVariable("matricula") String matricula){
        return this.vehiculoService.getById(matricula);
    }

    @DeleteMapping(path = ("/{matricula}"))
    public String eliminarCliente(@PathVariable("matricula") String matricula){
        boolean ok = this.vehiculoService.eliminarVehiculo(matricula);
        if(ok){
            return "se ha eliminado el vehiculo con numero de matricula: " + matricula;
        }else{
            return "No se ha encontrado el vehiculo con el numero de matricula: " + matricula;
        }
    }
    @PutMapping("/{matricula}")
    public boolean actualizarDocumento(@PathVariable("matricula") String matricula, VehiculoModel vehiculo){
        Optional<VehiculoModel> optionalVehiculo = vehiculoService.getById(matricula);
        if(optionalVehiculo.isPresent()){
            VehiculoModel vehiculoExistente = optionalVehiculo.get();
            vehiculoExistente.setCarroceria(vehiculo.getCarroceria());
            vehiculoExistente.setEstilo(vehiculo.getEstilo());
            vehiculoExistente.setMarca(vehiculo.getMarca());
            vehiculoExistente.setMarcaMotor(vehiculo.getMarcaMotor());
            vehiculoExistente.setNumeroChasis(vehiculo.getNumeroChasis());
            vehiculoExistente.setNumeroMotor(vehiculo.getNumeroMotor());
            vehiculoExistente.setValorFiscal(vehiculo.getValorFiscal());
            vehiculoExistente.setDocumento(vehiculo.getDocumento());
            
            vehiculoService.guardarVehiculo(vehiculoExistente);
            return true;
        }
        return false;
    }

}
