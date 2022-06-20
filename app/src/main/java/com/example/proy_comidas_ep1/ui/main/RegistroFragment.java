package com.example.proy_comidas_ep1.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.proy_comidas_ep1.R;
import com.example.proy_comidas_ep1.datos.DatosSQLite;
import com.google.android.material.textfield.TextInputEditText;


public class RegistroFragment extends Fragment implements View.OnClickListener {

    TextInputEditText mtetDescripcion, mtetMonto;
    Button mbtnRegistrar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mtetDescripcion = view.findViewById(R.id.tetDescripcion);
        mtetMonto = view.findViewById(R.id.tetMonto);
        mbtnRegistrar = view.findViewById(R.id.btnRegistrar);
        mbtnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String descripcion = mtetDescripcion.getText().toString();
        float monto = Float.parseFloat(mtetMonto.getText().toString());
        DatosSQLite datosSQLite = new DatosSQLite(getActivity());
        int autonumerico = datosSQLite.movimientosInsert(datosSQLite, descripcion, monto, -1);
        Toast.makeText(getActivity(), "Se registro el movimiento" + autonumerico, Toast.LENGTH_SHORT).show();
    }
}