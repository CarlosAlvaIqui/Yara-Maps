package com.example.tecsup.yaramaps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "prueba4.db";
    private static final int VERSION = 1;
    //Campos de la tabla productos
    public static final String PRODUCTO = "producto";
    public static final String CATEGORIA = "categoria";


    //Campos de la tabla tiendas

    public static final String TIENDA = "tienda";
    public static final String UBICACION = "ubicacion";
    public static final String CC = "cc";

    //Campos de la tabla stock

    public static final String CANTIDAD = "cantidad";
    public static final String PRECIO = "precio";


    public static final String TIENDA_ID = "tienda_id";
    public static final String PRODUCTO_ID = "producto_id";
    public static final String STOCK = "stock";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE productos (_id INTEGER PRIMARY KEY AUTOINCREMENT, producto TEXT, categoria TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE tiendas (_id INTEGER PRIMARY KEY AUTOINCREMENT, tienda TEXT, ubicacion TEXT,cc TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE stock (_id INTEGER PRIMARY KEY AUTOINCREMENT,tienda_id INTEGER,producto_id INTEGER ,cantidad TEXT, precio TEXT,stock TEXT,FOREIGN KEY(tienda_id) REFERENCES tiendas(tienda_id),FOREIGN KEY(producto_id) REFERENCES productos(producto_id));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        android.util.Log.v("prueba4", "actualizando la base de datos, se destruiran los datos existentes");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS productos");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tiendas");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS stock");
        onCreate(sqLiteDatabase);
    }
}