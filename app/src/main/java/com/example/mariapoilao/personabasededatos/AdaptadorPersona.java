package com.example.mariapoilao.personabasededatos;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by mariapoilao on 13/05/17.
 */

public class AdaptadorPersona extends BaseAdapter{

    private Context contexto;
    private ArrayList<Persona> personas;

    public AdaptadorPersona(Context contexto, ArrayList<Persona> personas){
        this.contexto =contexto;
        this.personas =personas;


    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong((personas.get(position).getCedula()));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Declarar variables

        TextView cajacedula, cajanombre, cajaapellido;
        ImageView foto;
        LayoutInflater inflater;
        View itemView;

        //Uso de inflater

        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.item_personalizado,null);

        //Capturar los objetos

        cajacedula= (TextView) itemView.findViewById(R.id.txtCedulaP);
        cajanombre=(TextView)itemView.findViewById(R.id.txtNombreP);
        cajaapellido=(TextView) itemView.findViewById(R.id.txtApellidoP);
        foto=(ImageView)itemView.findViewById(R.id.imgfoto);

        //pasar la información.

        foto.setImageResource(Integer.parseInt(personas.get(position).getFoto()));
        cajacedula.setText(personas.get(position).getCedula());
        cajanombre.setText(personas.get(position).getNombre());
        cajaapellido.setText(personas.get(position).getApellido());

        //Returnar el interview

        return itemView;
    }
}
