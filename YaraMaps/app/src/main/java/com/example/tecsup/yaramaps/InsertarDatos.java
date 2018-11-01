package com.example.tecsup.yaramaps;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_datos);

    }
    private void insertarProducto(String xnom, String xcat) {
        DatabaseHelper dbh = new DatabaseHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.PRODUCTO, xnom);
        cv.put(DatabaseHelper.CATEGORIA, xcat);
        db.insert("productos", DatabaseHelper.PRODUCTO, cv);
        db.close();
    }
    public void grabar_onclick( View v ) {
        String xnom = ((EditText)findViewById(R.id.txtProductoName)).getText().toString();
        String xdir = ((EditText)findViewById(R.id.txtPrecio)).getText().toString();
        insertarProducto(xnom,xdir);
        Toast.makeText(v.getContext(),"Grabando Nuevo Producto", Toast.LENGTH_SHORT).show();
    }
    public void salir(View v){
        finish();
    }
}
