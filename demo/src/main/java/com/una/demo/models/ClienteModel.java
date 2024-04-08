package com.una.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
public class ClienteModel {
    @Id
    @Column(unique = true, nullable = false)
    private String cedula;
    
    private String nombre;
    private String apellidos;
    private String estadoCivil;
    private String direccion;
    private String profesion;
    private String nacionalidad;

    public ClienteModel(String nombre, String apellidos, String estadoCivil, String cedula, String direccion, String profesion, String nacionalidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estadoCivil = estadoCivil;
        this.cedula = cedula;
        this.direccion = direccion;
        this.profesion = profesion;
        this.nacionalidad = nacionalidad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", profesion='" + profesion + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
