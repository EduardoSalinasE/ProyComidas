package com.example.proy_comidas_ep1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proy_comidas_ep1.databinding.ActivityRecetasAdicionalesBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class recetasAdicionales extends AppCompatActivity {

    private ActivityRecetasAdicionalesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecetasAdicionalesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        leerServicio();
    }

    private void leerServicio() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://raw.githubusercontent.com/ekha186/ekha/main/recetasadicionales.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DATOS", response);
                        llenarLista(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DATOS", error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    private void llenarLista(String response) {
        ArrayList arrayList = new ArrayList<HashMap<String,String>>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i= 0; i< jsonArray.length(); i++){
                //getJSONObject permite obtener la fila de un JSONArray
                String nombre = jsonArray.getJSONObject(i).getString("nombre");
                String lugar = jsonArray.getJSONObject(i).getString("lugar");
                String rating = jsonArray.getJSONObject(i).getString("rating");
                String picante = jsonArray.getJSONObject(i).getString("picante");
                String receta = jsonArray.getJSONObject(i).getString("receta");
                HashMap<String,String> map = new HashMap<>();
                map.put("nombre",nombre);
                map.put("lugar",lugar);
                map.put("rating",rating);
                map.put("picante",picante);
                map.put("receta",receta);

                arrayList.add(map);//Asi se añade el HashMap al arraylist
            }

            String[] origen = {"nombre","lugar","rating","picante","receta"};
            int[] destino = {R.id.tvRecetaNombre, R.id.tvRecetaLugar, R.id.tvRecetaRating, R.id.tvRecetaPicante, R.id.tvRecetaReceta};

            ListAdapter listAdapter = new SimpleAdapter(
                    this,
                    arrayList,
                    R.layout.item_recetas,
                    origen,
                    destino
            );
            binding.lvAdicionales.setAdapter(listAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}