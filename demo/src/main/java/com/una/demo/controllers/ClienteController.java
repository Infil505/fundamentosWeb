package com.una.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.una.demo.models.ClienteModel;
import com.una.demo.services.ClienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> getClientes() {
        return clienteService.obtenerClientes();
    }

    @PostMapping()
    public ClienteModel guardarCliente (@RequestBody ClienteModel cliente) {
        return this.clienteService.guardarCliente(cliente);
    }

    @GetMapping(path = "/{cedula}")
    public Optional<ClienteModel> getClienteByCedula(@PathVariable("cedula") String cedula){
        return this.clienteService.getById(cedula);
    }
    
    @DeleteMapping(path = ("/cedula"))
    public String eliminarCliente(@PathVariable("cedula") String cedula){
        boolean ok = this.clienteService.eliminarCliente(cedula);
        if(ok){
            return "se ha eliminado el usuario con cedula: " + cedula;
        }else{
            return "No se ha encontrado el usuario con cedula: " + cedula;
        }
    }

    public boolean actualizarCliente(String cedula, ClienteModel cliente){
        Optional<ClienteModel> optionalCliente = clienteService.getById(cedula);
        if(optionalCliente.isPresent()){
            ClienteModel clienteExistente = optionalCliente.get();
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellidos(cliente.getApellidos());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setEstadoCivil(cliente.getEstadoCivil());
            clienteExistente.setProfesion(cliente.getProfesion());
            clienteExistente.setNacionalidad(cliente.getNacionalidad());
            // Actualiza cualquier otro campo necesario
            
            clienteService.guardarCliente(clienteExistente);
            return true;
        }
        return false;
    }
}
