package com.una.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.una.demo.models.DocumentModel;
import com.una.demo.services.DocumentService;

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


@RestController
@RequestMapping("/documento")
public class DocumentController {
    @Autowired
    DocumentService documentoService;
    
    @GetMapping
    public ArrayList<DocumentModel> getDocumentos(){
        return this.documentoService.obtenerDocumentos();
    }

    @PostMapping
    public DocumentModel guardarDocumento(@RequestBody DocumentModel documento){
        return this.documentoService.guardaDocumento(documento);
    }

    @GetMapping(path = "/{numeroDocumento}")
    public Optional<DocumentModel> getDocuemntByNumero(@PathVariable("numeroDocumento") String numeroDocumento){
        return this.documentoService.getById(numeroDocumento);
    }

    @DeleteMapping(path = ("/{numeroDocumento}"))
    public String eliminarCliente(@PathVariable("numeroDocumento") String numeroDocumento){
        boolean ok = this.documentoService.eliminarDocumento(numeroDocumento);
        if(ok){
            return "se ha eliminado el Documento con el numero: " + numeroDocumento;
        }else{
            return "No se ha encontrado el documento con el numero: " + numeroDocumento;
        }
    }

    @PutMapping("/{numeroDocumento}")
    public boolean actualizarDocumento(@PathVariable("numeroDocumento") String numeroDocumento,@RequestBody DocumentModel documento){
        Optional<DocumentModel> optionalDocument = documentoService.getById(numeroDocumento);
        if(optionalDocument.isPresent()){
            DocumentModel documentExistente = optionalDocument.get();
            documentExistente.setCedulaCompareciente1(documento.getCedulaCompareciente1());
            documentExistente.setCedulaCompareciente2(documento.getCedulaCompareciente2());
            documentExistente.setFechaRegistro(documento.getFechaRegistro());
            
            documentoService.guardaDocumento(documentExistente);
            return true;
        }
        return false;
    }
}
