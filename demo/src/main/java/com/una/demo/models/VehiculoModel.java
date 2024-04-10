package com.una.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Vehiculo")
public class VehiculoModel {
    @Id
    private String placa;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String estilo;

    @Column(nullable = false)
    private String carroceria;

    @Column(nullable = false, name = "numero_chasis", unique = true)
    private String numeroChasis;

    @Column(nullable = false, name = "numero_motor", unique = true)
    private String numeroMotor;

    @Column(nullable = false, name = "marca_motor")
    private String marcaMotor;

    @Column(nullable = false, name = "valor_fiscal")
    private double valorFiscal;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    // Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getMarcaMotor() {
        return marcaMotor;
    }

    public void setMarcaMotor(String marcaMotor) {
        this.marcaMotor = marcaMotor;
    }

    public double getValorFiscal() {
        return valorFiscal;
    }

    public void setValorFiscal(double valorFiscal) {
        this.valorFiscal = valorFiscal;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public String toString() {
        return "VehiculoModel{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", estilo='" + estilo + '\'' +
                ", carroceria='" + carroceria + '\'' +
                ", numeroChasis='" + numeroChasis + '\'' +
                ", numeroMotor='" + numeroMotor + '\'' +
                ", marcaMotor='" + marcaMotor + '\'' +
                ", valorFiscal=" + valorFiscal +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                '}';
    }
}
