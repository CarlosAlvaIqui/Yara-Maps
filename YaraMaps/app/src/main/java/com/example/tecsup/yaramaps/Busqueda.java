package com.example.tecsup.yaramaps;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Busqueda extends AppCompatActivity {
    ArrayList valores = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        final ListView lista;
        ArrayAdapter<String> adaptador;
        lista = (ListView)findViewById(R.id.listProductos);
        DatabaseHelper dbh = new DatabaseHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        String query = "Select * FROM productos";
        Cursor cursor = db.rawQuery(query, null);
        String cad = "";
        if (cursor.moveToFirst()) {
            do {
                String xid = cursor.getString(0);
                String xfec = cursor.getString(1);
                String xdes = cursor.getString(2);
                cad += xid + ": Producto: " + xfec + "\n   Precio: " + xdes + "\n";
                valores.add(cad);
                cad ="";
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,valores);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Busqueda.this, Informacion.class);
                intent.putExtra("idbus",position);
                startActivity(intent);
            }
        });
    }
    public void resultado_onclick(View v){
        Intent intentContactos = new Intent(v.getContext(),Resultado.class);
        startActivity(intentContactos);
    }
    public void agregar_onclick(View v){
        Intent intentAgregar = new Intent(v.getContext(),InsertarDatos.class);
        startActivity(intentAgregar);
    }
    public void onclick_buscar(View v){
        valores.clear();
        String dato = ((EditText) findViewById(R.id.txtArticulo)).getText().toString();
        DatabaseHelper dbh = new DatabaseHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        String query = "Select * FROM productos where producto like '"+dato+"%'";
        Cursor cursor = db.rawQuery(query, null);
        String cad = "";
        if (cursor.moveToFirst()) {
            do {
                String xid = cursor.getString(0);
                String xfec = cursor.getString(1);
                String xdes = cursor.getString(2);
                cad += xid + ": Producto: " + xfec + "\n   categoria: " + xdes + "\n";
                valores.add(cad);
                cad ="";
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        final ListView lista;
        ArrayAdapter<String> adaptador;
        lista = (ListView)findViewById(R.id.listProductos);
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,valores);
        lista.setAdapter(adaptador);
    }
}