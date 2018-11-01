package com.example.tecsup.yaramaps;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarDatosTienda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_datos_tienda);

    }
    private void insertarTienda(String xtienda, String xubicacion, String xcc) {
        DatabaseHelper dbh = new DatabaseHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.TIENDA, xtienda);
        cv.put(DatabaseHelper.UBICACION, xubicacion);
        cv.put(DatabaseHelper.CC, xcc);
        db.insert("tiendas", DatabaseHelper.TIENDA, cv);
        db.close();
    }
    public void grabar_onclick( View v ) {
        String xnom = ((EditText)findViewById(R.id.txtNombreTienda)).getText().toString();
        String xdir = ((EditText)findViewById(R.id.txtUbicacion)).getText().toString();
        String xcel = ((EditText)findViewById(R.id.txtCC)).getText().toString();
        insertarTienda(xnom,xdir,xcel);
        Toast.makeText(v.getContext(),"Grabando Nueva Tienda", Toast.LENGTH_SHORT).show();
    }
    public void salir(View v){
        finish();
    }
}
