package com.example.tecsup.yaramaps;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertartStock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertart_stock);
    }
    private void insertarTienda(int xtienda, int xubicacion, String xcantidad,String xprecio,String xstock) {
        DatabaseHelper dbh = new DatabaseHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.TIENDA_ID, xtienda);
        cv.put(DatabaseHelper.PRODUCTO_ID, xubicacion);
        cv.put(DatabaseHelper.CANTIDAD, xcantidad);
        cv.put(DatabaseHelper.PRECIO, xprecio);
        cv.put(DatabaseHelper.STOCK, xstock);
        db.insert("stock", DatabaseHelper.TIENDA_ID, cv);
        db.close();
    }
    public void grabar_onclick( View v ) {
        String xnom = ((EditText)findViewById(R.id.txtIDtienda)).getText().toString();
        String xdir = ((EditText)findViewById(R.id.txtIDproducto)).getText().toString();
        String xcan = ((EditText)findViewById(R.id.txtCantidad)).getText().toString();
        String xpre = ((EditText)findViewById(R.id.txtPrecio)).getText().toString();
        String xsto = ((EditText)findViewById(R.id.txtStock)).getText().toString();
        insertarTienda(Integer.parseInt(xnom),Integer.parseInt(xdir),xcan,xpre,xsto);
        Toast.makeText(v.getContext(),"Actualizando stock", Toast.LENGTH_SHORT).show();
    }
    public void salir(View v){
        finish();
    }
}
