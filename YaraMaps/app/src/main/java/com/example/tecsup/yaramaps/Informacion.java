package com.example.tecsup.yaramaps;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Informacion extends AppCompatActivity {

    int buscaid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        Bundle b = getIntent().getExtras();
        buscaid = b.getInt("idbus");
        int a = buscaid+1;
        DatabaseHelper Base_Datos= new DatabaseHelper(this);

        SQLiteDatabase db = Base_Datos.getWritableDatabase();
        String query = "Select * FROM productos WHERE _id='"+a+"'";
        Cursor cursor = db.rawQuery(query, null);
        EditText tv = findViewById(R.id.infoProducto);
        String cad;
        if (cursor.moveToFirst()) {
            do {
                String xid  = cursor.getString(0);
                String xnom = cursor.getString(1);
                String xpre = cursor.getString(2);
                cad = xid + ": " + xnom + "\n   Prec: " + xpre + "\n ";
            } while (cursor.moveToNext());
            tv.setText(cad);
            cursor.close();
        }

        String query2 = "Select * FROM tiendas WHERE _id='"+a+"'";

        Cursor cursor2 = db.rawQuery(query2, null);
        EditText tv2 = findViewById(R.id.infoTienda);
        String cad2 = "";
        if (cursor2.moveToFirst()) {
            do {
                String xid  = cursor2.getString(0);
                String xnom = cursor2.getString(1);
                String xdir = cursor2.getString(2);
                String xcon = cursor2.getString(3);
                cad2 = xid + ": " + xnom + "\n   Dire: " + xdir + "\n   Cont: " + xcon + "\n";
            } while (cursor2.moveToNext());
            tv2.setText(cad2);
            cursor2.close();
        }
        db.close();
    }

}
