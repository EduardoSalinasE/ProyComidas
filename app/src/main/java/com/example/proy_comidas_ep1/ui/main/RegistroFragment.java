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
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proy_comidas_ep1.R;
import com.example.proy_comidas_ep1.adapters.MovimientosAdapter;
import com.example.proy_comidas_ep1.datos.DatosSQLite;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;


public class RegistroFragment extends Fragment implements View.OnClickListener {


    TextInputEditText mtetDescripcion, mtetMonto;
    TextView mtvSaldoTotal, mtvGastosTotal, mtvIngresosTotal;
    Button mbtnRegistrar;
    CheckBox mchcGasto, mchcIngreso;


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
        mchcGasto = view.findViewById(R.id.chcGasto);
        mchcIngreso = view.findViewById(R.id.chcIngreso);
        mtvGastosTotal = view.findViewById(R.id.tvGastosTotal);
        mtvIngresosTotal = view.findViewById(R.id.tvIngresosTotal);
        mtvSaldoTotal = view.findViewById(R.id.tvSaldoTotal);
        mbtnRegistrar = view.findViewById(R.id.btnRegistrar);
        mbtnRegistrar.setOnClickListener(this);

        leerTotalIngresos();
        //leerTotalGastos();
        //leerTotal();
    }

    @Override
    public void onClick(View view) {
        String descripcion = mtetDescripcion.getText().toString();
        float monto = Float.parseFloat(mtetMonto.getText().toString());
        DatosSQLite datosSQLite = new DatosSQLite(getActivity());

        if (mchcGasto.isChecked()==true){
            int autonumerico = datosSQLite.movimientosInsert(datosSQLite, descripcion, monto, -1);
            Toast.makeText(getActivity(), "Se registro el movimiento" + autonumerico, Toast.LENGTH_SHORT).show();
        }
        if (mchcIngreso.isChecked()==true){
            int autonumerico = datosSQLite.movimientosInsert(datosSQLite, descripcion, monto, 1);
            Toast.makeText(getActivity(), "Se registro el movimiento" + autonumerico, Toast.LENGTH_SHORT).show();
        }
    }

    private void leerTotalIngresos(){

        DatosSQLite datosSQLite = new DatosSQLite(getActivity());
        Cursor cursor = datosSQLite.sumaIngresos(datosSQLite);

        HashMap<String,String> map = new HashMap<>();
        map.put("monto", cursor.getString(cursor.getColumnIndexOrThrow("monto")));

        mtvIngresosTotal.setText(cursor.getString(0));



    }

}