package com.example.mariapoilao.personabasededatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Listado_Personalizado extends AppCompatActivity {

    private ListView lstpersonalizado;
    private ArrayList<Persona> personas;
    private AdaptadorPersona adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado__personalizado);

        lstpersonalizado=(ListView)findViewById(R.id.lstListado);
        personas=Datos.traerPersonas(getApplicationContext());
        adapter = new AdaptadorPersona(getApplicationContext(),personas);
        lstpersonalizado.setAdapter(adapter);


    }
}
