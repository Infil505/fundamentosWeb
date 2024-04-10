package com.una.demo.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Documento")
public class DocumentModel {
    @Id
    @Column(unique = true, nullable = false)
    private String numeroDocumento;

    @Column(nullable = false)
    private Date fechaRegistro;

    @Column(nullable = false)
    private String cedulaCompareciente1;

    @Column(nullable = false)
    private String cedulaCompareciente2;

    public DocumentModel(String numeroDocumento, Date fechaRegistro, String cedulaCompareciente1, String cedulaCompareciente2) {
        this.numeroDocumento = numeroDocumento;
        this.fechaRegistro = fechaRegistro;
        this.cedulaCompareciente1 = cedulaCompareciente1;
        this.cedulaCompareciente2 = cedulaCompareciente2;
    }

    public DocumentModel() {
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

    public String getCedulaCompareciente1() {
        return cedulaCompareciente1;
    }

    public void setCedulaCompareciente1(String cedulaCompareciente1) {
        this.cedulaCompareciente1 = cedulaCompareciente1;
    }

    public String getCedulaCompareciente2() {
        return cedulaCompareciente2;
    }

    public void setCedulaCompareciente2(String cedulaCompareciente2) {
        this.cedulaCompareciente2 = cedulaCompareciente2;
    }

    @Override
    public String toString() {
        return "DocumentModel{" +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", cedulaCompareciente1='" + cedulaCompareciente1 + '\'' +
                ", cedulaCompareciente2='" + cedulaCompareciente2 + '\'' +
                '}';
    }
}
