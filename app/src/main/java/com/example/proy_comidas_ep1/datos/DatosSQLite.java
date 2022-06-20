package com.example.proy_comidas_ep1.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatosSQLite extends SQLiteOpenHelper {

    public DatosSQLite(@Nullable Context context) {
        super(context, "caja", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE movimientos(" +
                "idmovimiento INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fecha DATETIME DEFAULT CURRENT_TIMESTAMP," +
                "descripcion TEXT," +
                "monto float," +
                "movimiento int)"
                );
    }

    public int movimientosInsert (DatosSQLite datosSQLite, String descripcion, float monto, int movimiento){
        SQLiteDatabase sqLiteDatabase = datosSQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("descripcion", descripcion);
        contentValues.put("monto", monto);
        contentValues.put("movimiento", movimiento);

        int autonumerico = (int) sqLiteDatabase.insert("movimiento",null, contentValues);
        return autonumerico;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
