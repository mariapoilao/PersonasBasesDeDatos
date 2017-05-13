package com.example.mariapoilao.personabasededatos;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Registrar extends AppCompatActivity {


    private EditText cajacedula;
    private EditText cajanombre;
    private EditText cajaapellido;
    private RadioButton rdmasculino;
    private RadioButton rdfemenino;
    private CheckBox chkprogramar;
    private CheckBox chkleer;
    private CheckBox chkbailar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        cajacedula = (EditText)findViewById(R.id.txtCedula);
        cajanombre = (EditText) findViewById(R.id.txtnombre);
        cajaapellido = (EditText) findViewById(R.id.txtApellido);
        rdmasculino = (RadioButton)findViewById(R.id.rdbMasculino);
        rdfemenino =(RadioButton)findViewById(R.id.rdbFemenino);
        chkprogramar=(CheckBox) findViewById(R.id.cbxProgramar);
        chkleer = (CheckBox) findViewById(R.id.cbxLeer);
        chkbailar= (CheckBox) findViewById(R.id.cbxBailar);


    }

    public boolean validarTodo(){
        if(cajacedula.getText().toString().isEmpty()){
            cajacedula.setError("Digite la cedula");
            cajacedula.requestFocus();
            return false;
        }
        if(cajanombre.getText().toString().isEmpty()){
            cajanombre.setError("Digite el nombre");
            cajanombre.requestFocus();
            return false;
        }
        if(cajaapellido.getText().toString().isEmpty()){
            cajaapellido.setError("Digite el apellido");
            cajaapellido.requestFocus();
            return false;
        }
        if ((!chkprogramar.isChecked())&&(!chkleer.isChecked())&&(!chkbailar.isChecked())){

            new AlertDialog.Builder(this).setMessage("Seleccione uno").setCancelable(true).show();
             return false;
         }

        return true;
}


    public boolean validarCedula() {
        if (cajacedula.getText().toString().isEmpty()) {
            cajacedula.setError("Digite la cedula");
            cajacedula.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(){

        cajacedula.setText("");
        cajanombre.setText("");
        cajaapellido.setText("");
        rdfemenino.setChecked(true);
        chkprogramar.setChecked(false);
        chkleer.setChecked(false);
        chkbailar.setChecked(false);
        cajacedula.requestFocus();
    }

    public void guardar (View v) {
        String foto, cedula, nombre, apellido, sexo, pasatiempo="";
        Persona p;

        if (validarTodo()) {
            foto = String.valueOf(fotoAleatoria());
            cedula = cajacedula.getText().toString();
            nombre = cajanombre.getText().toString();
            apellido = cajaapellido.getText().toString();
            if(rdfemenino.isChecked()) sexo= getResources().getString(R.string.femenino);
            else sexo = getResources().getString((R.string.femenino));

            if(chkprogramar.isChecked()){

                pasatiempo =getResources().getString(R.string.programar)+", ";
            }
            if(chkleer.isChecked()){

                pasatiempo =getResources().getString(R.string.leer)+", ";
            }
            if(chkbailar.isChecked()){

                pasatiempo =getResources().getString(R.string.bailar)+", ";
            }

            pasatiempo= pasatiempo.substring(pasatiempo.length()-1);

            p = new Persona (foto, cedula, nombre, apellido, sexo, pasatiempo);
            p.guardar(getApplicationContext());

            new AlertDialog.Builder(this).setMessage("Persona guardada").setCancelable(true).show();

            limpiar();
        }
    }

    public int fotoAleatoria(){
        int fotos[]={R.drawable.images,R.drawable.images2,R.drawable.images3};
        int numero = (int) (Math.random()*3);
        return fotos[numero];
    }
}


