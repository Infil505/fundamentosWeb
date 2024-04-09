package com.una.demo.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Documento")
public class DocumentModel {
    @Id
    @Column(nullable = false)
    private String numeroDocumento;

    @Column(nullable = false)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "cedula_compareciente_1")
    private ClienteModel clienteCompareciente1;

    @ManyToOne
    @JoinColumn(name = "cedula_compareciente_2")
    private ClienteModel clienteCompareciente2;

    public DocumentModel(String numeroDocumento, Date fechaRegistro, ClienteModel clienteCompareciente1, ClienteModel clienteCompareciente2) {
        this.numeroDocumento = numeroDocumento;
        this.fechaRegistro = fechaRegistro;
        this.clienteCompareciente1 = clienteCompareciente1;
        this.clienteCompareciente2 = clienteCompareciente2;
    }

    // Getters y Setters
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public ClienteModel getClienteCompareciente1() {
        return clienteCompareciente1;
    }

    public void setClienteCompareciente1(ClienteModel clienteCompareciente1) {
        this.clienteCompareciente1 = clienteCompareciente1;
    }

    public ClienteModel getClienteCompareciente2() {
        return clienteCompareciente2;
    }

    public void setClienteCompareciente2(ClienteModel clienteCompareciente2) {
        this.clienteCompareciente2 = clienteCompareciente2;
    }

    @Override
    public String toString() {
        return "DocumentModel{" +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", clienteCompareciente1=" + clienteCompareciente1 +
                ", clienteCompareciente2=" + clienteCompareciente2 +
                '}';
    }
}
