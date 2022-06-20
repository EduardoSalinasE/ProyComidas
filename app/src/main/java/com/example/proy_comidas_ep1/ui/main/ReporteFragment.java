package com.example.proy_comidas_ep1.ui.main;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proy_comidas_ep1.R;
import com.example.proy_comidas_ep1.datos.DatosSQLite;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;


public class ReporteFragment extends Fragment {

    ArrayList arrayList = new ArrayList<HashMap<String, String>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reporte, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        leerDatos();
    }

    private void leerDatos(){
        DatosSQLite datosSQLite = new DatosSQLite(getActivity());
        Cursor cursor = datosSQLite.movimientosSelect(datosSQLite);

        if(cursor != null){
            if(cursor.moveToFirst()){
                do {
                    HashMap<String,String> map = new HashMap<>();
                    map.put("idmovimiento", cursor.getString(cursor.getColumnIndexOrThrow("idmovimiento")));
                    map.put("descripcion", cursor.getString(cursor.getColumnIndexOrThrow("descripcion")));
                    map.put("monto", cursor.getString(cursor.getColumnIndexOrThrow("monto")));
                    map.put("fecha", cursor.getString(cursor.getColumnIndexOrThrow("fecha")));
                    map.put("movimiento", cursor.getString(cursor.getColumnIndexOrThrow("movimiento")));

                    arrayList.add(map);
                }while (cursor.moveToNext());
            }
        }
    }
}