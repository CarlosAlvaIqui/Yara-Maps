package com.example.tecsup.yaramaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.stetho.Stetho;

public class logeo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logeo);
        Stetho.initializeWithDefaults(this);
    }
    public void onclick_Entrar(View v){
        Intent intentContactos = new Intent(v.getContext(),perfil_usuario.class);
        startActivity(intentContactos);
    }
    public void onclick_BtnBuscar(View v){
        Intent intentContactos = new Intent(v.getContext(),Busqueda.class);
        startActivity(intentContactos);
    }
}
