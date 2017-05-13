package com.example.mariapoilao.personabasededatos;

/**
 * Created by mariapoilao on 12/05/17.
 */

public class Persona {
    private String foto;
    private String Cedula;
    private  String Nombre;
    private String Apellido;
    private String sexo;
    private String pasatiempo;

    public Persona(String foto, String cedula, String nombre, String apellido, String sexo, String pasatiempo) {
        this.foto = foto;
        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        this.sexo = sexo;
        this.pasatiempo = pasatiempo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPasatiempo() {
        return pasatiempo;
    }

    public void setPasatiempo(String pasatiempo) {
        this.pasatiempo = pasatiempo;
    }
}
