package com.example.proy_comidas_ep1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DepartamentosCostaActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamentos_costa);

        Button mbtnTumbes = findViewById(R.id.btnTumbes);
        mbtnTumbes.setOnClickListener(this);

        Button mbtnPiura = findViewById(R.id.btnPiura);
        mbtnPiura.setOnClickListener(this);

        Button mbtnLima = findViewById(R.id.btnLima);
        mbtnLima.setOnClickListener(this);

        Button mbtnRegresarMain = findViewById(R.id.btnRegresarInicio);
        mbtnRegresarMain.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnTumbes:
                startActivity(new Intent(this, PlatosTumbesActivity.class));
                break;
            case R.id.btnPiura:
                startActivity(new Intent(this, PlatosPiuraActivity.class));
                break;
            case R.id.btnLima:
                startActivity(new Intent(this, PlatosLimaActivity.class));
                break;
            case R.id.btnRegresarInicio:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }

    }



}

