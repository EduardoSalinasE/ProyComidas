package com.example.proy_comidas_ep1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proy_comidas_ep1.R;

import java.util.ArrayList;
import java.util.HashMap;

public class IngresosAdapter extends RecyclerView.Adapter<IngresosAdapter.ViewHolder> {

    ArrayList<HashMap<String,String>> arrayList;
    public IngresosAdapter(ArrayList<HashMap<String,String>> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public IngresosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ingresos, parent, false);
        return new IngresosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngresosAdapter.ViewHolder holder, int position) {
        HashMap<String,String> map = arrayList.get(position);
        holder.mtvFechaIngresos.setText(map.get("fecha"));
        holder.mtvDescripcionIngresos.setText(map.get("descripcion"));
        holder.mtvMontoIngresos.setText(map.get("monto"));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtvFechaIngresos, mtvDescripcionIngresos, mtvMontoIngresos;
        public ViewHolder(View view) {
            super(view);
            mtvFechaIngresos = itemView.findViewById(R.id.tvFecha);
            mtvDescripcionIngresos = itemView.findViewById(R.id.tvDescripcion);
            mtvMontoIngresos = itemView.findViewById(R.id.tvMonto);

        }
    }
}
