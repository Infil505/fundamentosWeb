package com.una.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.una.demo.models.ClienteModel;
import com.una.demo.services.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
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
    
}
