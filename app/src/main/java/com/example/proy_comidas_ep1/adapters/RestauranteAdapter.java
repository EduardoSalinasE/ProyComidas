package com.example.proy_comidas_ep1.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proy_comidas_ep1.R;

import java.util.ArrayList;
import java.util.HashMap;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {

    ArrayList<HashMap<String,String>> arrayList;
    public RestauranteAdapter(ArrayList<HashMap<String,String>> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.item_restaurante, parent, false);
       return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HashMap<String,String> map = arrayList.get(position);
        holder.mtvRestauranteNombre.setText(map.get("name"));
        holder.mtvRestauranteEspecialidad.setText(map.get("especialidad"));
        holder.mtvRestauranteHorario.setText(map.get("horario"));
        holder.mtvRestauranteMenu.setText(map.get("menu"));
        holder.mtvRestauranteBar.setText(map.get("bar"));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtvRestauranteNombre, mtvRestauranteEspecialidad, mtvRestauranteHorario, mtvRestauranteMenu, mtvRestauranteBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mtvRestauranteNombre = itemView.findViewById(R.id.tvRestauranteNombre);
            mtvRestauranteEspecialidad = itemView.findViewById(R.id.tvRestauranteEspecialidad);
            mtvRestauranteHorario = itemView.findViewById(R.id.tvRestauranteHorario);
            mtvRestauranteMenu = itemView.findViewById(R.id.tvRestauranteMenu);
            mtvRestauranteBar = itemView.findViewById(R.id.tvRestauranteBar);
        }
    }

}
