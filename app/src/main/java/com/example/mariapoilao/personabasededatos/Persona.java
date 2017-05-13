package com.example.mariapoilao.personabasededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    public void guardar (Context contexto){
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de data base pero en modo escritura

        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto, "DBPersonas", null,1);
        db = aux.getWritableDatabase();

        //Insertar la forma version 1.0

        sql = "INSERT INTO Personas values ('"+this.getFoto()+"','"+this.getCedula()+"','"+this.getNombre()+"','"+this.getApellido()+"','"+this.getSexo()+"','"+this.getPasatiempo()+"')";

        db.execSQL(sql);

        //Forma 2 de insertar

     /*   ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("foto", this.getFoto());
        nuevoRegistro.put("cedula",this.getCedula());
        nuevoRegistro.put("nombre",this.getNombre());
        nuevoRegistro.put("apellido",this.getApellido());
        nuevoRegistro.put("sexo",this.getSexo());
        nuevoRegistro.put("pasatiempo",this.getPasatiempo());

        db.insert("Personas",null,nuevoRegistro);

        //Cerrar conexion
*/
        db.close();

    }
}

