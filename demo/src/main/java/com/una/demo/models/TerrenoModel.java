package com.una.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Terreno")
public class TerrenoModel  {
    @Id
    @Column(unique = true, nullable = false)
    private String numeroPlano;
    private String colindanteNorte;
    private String colindanteSur;
    private String colindanteEste;
    private String colindanteOeste;
    private double medida; 

    @ManyToOne
    @JoinColumn(name = "numeroEscritura", referencedColumnName = "numeroDocumento")
    private DocumentModel documento;

    public TerrenoModel(String colindanteNorte, String colindanteSur, String colindanteEste, String colindanteOeste,
                        double medida, String numeroPlano, DocumentModel documento) {
        this.colindanteNorte = colindanteNorte;
        this.colindanteSur = colindanteSur;
        this.colindanteEste = colindanteEste;
        this.colindanteOeste = colindanteOeste;
        this.medida = medida;
        this.numeroPlano = numeroPlano;
        this.documento = documento;
    }

    // Getters y Setters
    public String getColindanteNorte() {
        return colindanteNorte;
    }

    public void setColindanteNorte(String colindanteNorte) {
        this.colindanteNorte = colindanteNorte;
    }

    public String getColindanteSur() {
        return colindanteSur;
    }

    public void setColindanteSur(String colindanteSur) {
        this.colindanteSur = colindanteSur;
    }

    public String getColindanteEste() {
        return colindanteEste;
    }

    public void setColindanteEste(String colindanteEste) {
        this.colindanteEste = colindanteEste;
    }

    public String getColindanteOeste() {
        return colindanteOeste;
    }

    public void setColindanteOeste(String colindanteOeste) {
        this.colindanteOeste = colindanteOeste;
    }

    public double getMedida() {
        return medida;
    }

    public void setMedida(double medida) {
        this.medida = medida;
    }

    public String getNumeroPlano() {
        return numeroPlano;
    }

    public void setNumeroPlano(String numeroPlano) {
        this.numeroPlano = numeroPlano;
    }

    public DocumentModel getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentModel documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "TerrenoModel{" +
                "colindanteNorte='" + colindanteNorte + '\'' +
                ", colindanteSur='" + colindanteSur + '\'' +
                ", colindanteEste='" + colindanteEste + '\'' +
                ", colindanteOeste='" + colindanteOeste + '\'' +
                ", medida=" + medida +
                ", numeroPlano='" + numeroPlano + '\'' +
                ", documento=" + documento +
                '}';
    }
}
