package com.example.tecsup.yaramaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class perfil_usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
    }
    public void onclick_AgregarTienda(View v){
        Intent intentTienda = new Intent(v.getContext(),InsertarDatosTienda.class);
        startActivity(intentTienda);
    }
    public void onclick_AgregarProducto(View v){
        Intent intentProductos = new Intent(v.getContext(),InsertarDatos.class);
        startActivity(intentProductos);
    }
    public void onclick_ActualizarStock(View v){
        Intent intentProductos = new Intent(v.getContext(),InsertartStock.class);
        startActivity(intentProductos);
    }
}
