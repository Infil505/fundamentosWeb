package com.una.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.demo.repositories.*;
import com.una.demo.models.*;

@Service
public class ClienteService {
    @Autowired
    ClienteRepositorio ClienteRepositorio;

    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) ClienteRepositorio.findAll();
    }

    public ClienteModel guardarCliente(ClienteModel cliente){
        return ClienteRepositorio.save(cliente);
    }
}
