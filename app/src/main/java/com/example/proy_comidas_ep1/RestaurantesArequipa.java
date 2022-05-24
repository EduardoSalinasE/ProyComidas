package com.example.proy_comidas_ep1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proy_comidas_ep1.adapters.RestauranteAdapter;
import com.example.proy_comidas_ep1.databinding.ActivityRestaurantesArequipaBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantesArequipa extends AppCompatActivity {

    private ActivityRestaurantesArequipaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantesArequipaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        leerServicio();
    }

    private void leerServicio() {
       RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://gist.githubusercontent.com/luiquy/54444ac081000e6c929310d000008883/raw/aa1a128c5265bd2eba1af79db5b89f7955e70720/restaurates_arequipa.json";
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
            for (int i=0; i< jsonArray.length(); i++){

                String name = jsonArray.getJSONObject(i).getString("name");
                String especialidad = jsonArray.getJSONObject(i).getString("especialidad");
                String horario = jsonArray.getJSONObject(i).getString("horario");
                String menu = jsonArray.getJSONObject(i).getString("menu");
                String bar = jsonArray.getJSONObject(i).getString("bar");
                HashMap<String, String> map = new HashMap<>();
                map.put("name",name);
                map.put("especialidad",especialidad);
                map.put("horario",horario);
                map.put("menu",menu);
                map.put("bar",bar);

                arrayList.add(map);
            }

            RestauranteAdapter restauranteAdapter = new RestauranteAdapter(arrayList);
            binding.rvRestaurante.setAdapter(restauranteAdapter);
            binding.rvRestaurante.setLayoutManager(new LinearLayoutManager(this));


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}