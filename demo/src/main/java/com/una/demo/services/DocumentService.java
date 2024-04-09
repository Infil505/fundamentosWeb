package com.una.demo.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.una.demo.models.DocumentModel;
import com.una.demo.repositories.DocumentRepositorio;

@Service
public class DocumentService {
    @Autowired
    DocumentRepositorio documentoRepositorio;

    public ArrayList<DocumentModel> obtenerDocumentos(){
        return (ArrayList<DocumentModel>) documentoRepositorio.findAll();
    }

    public DocumentModel guardaDocumento(DocumentModel documento){
        return documentoRepositorio.save(documento);
    }

    public Optional <DocumentModel> getById(String numeroDocumento){
        return documentoRepositorio.findById(numeroDocumento);
    }

    public boolean eliminarDocumento (String numeroDocumento){
        try{
            documentoRepositorio.deleteById(numeroDocumento);
            return true;
        }catch(Exception err){
                return false;
        }
    }
}
