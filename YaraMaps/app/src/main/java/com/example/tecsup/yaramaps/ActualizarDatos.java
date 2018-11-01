package com.example.tecsup.yaramaps;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActualizarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos);
        String hola =getIntent().getExtras().getString("parametro");
        System.out.println(hola);
        EditText test,precio,stock;
        Button agragar;
        agragar=findViewById(R.id.btnAgregar);
        test = findViewById(R.id.txtProductoEdit);
        precio = findViewById(R.id.txtEdit);
        stock = findViewById(R.id.txtEdit2);


        DatabaseHelper dbh = new DatabaseHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        String query = "Select * FROM productos where _id="+hola+"";
        Cursor cursor = db.rawQuery(query, null);
        String cad = "";

        if (cursor.moveToFirst()) {
            do {
                String xid = cursor.getString(0);
                String xfec = cursor.getString(1);
                String xdes = cursor.getString(2);
                String xStock = cursor.getString(3);

                test.setText(xfec);
                precio.setText(xdes);
                stock.setText(xStock);
            } while (cursor.moveToNext());

            cursor.close();
        }
        db.close();

    }
    public void onclick_Agregar(View v){
        DatabaseHelper dbh = new DatabaseHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        String hola =getIntent().getExtras().getString("parametro");
        EditText test,precio,stock;
        test = findViewById(R.id.txtProductoEdit);
        precio = findViewById(R.id.txtEdit);
        stock = findViewById(R.id.txtEdit2);
        db.execSQL("UPDATE productos SET producto='"+test.getText()+"', precio='"+precio.getText()+"', stock='"+stock.getText()+"' WHERE _id="+hola+";");
        db.close();
    }

    public void onclicks_salir(View v){
        finish();
    }



}
