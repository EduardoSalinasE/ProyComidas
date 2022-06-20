package com.example.proy_comidas_ep1.ui.main;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proy_comidas_ep1.R;
import com.example.proy_comidas_ep1.adapters.MovimientosAdapter;
import com.example.proy_comidas_ep1.datos.DatosSQLite;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReporteFragment extends Fragment {

    ArrayList arrayList = new ArrayList<HashMap<String, String>>();
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reporte, container, false);
        recyclerView = view.findViewById(R.id.rvReporte);

        return view;
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

                    MovimientosAdapter movimientosAdapter = new MovimientosAdapter(arrayList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(movimientosAdapter);

                }while (cursor.moveToNext());
            }
        }
    }

}