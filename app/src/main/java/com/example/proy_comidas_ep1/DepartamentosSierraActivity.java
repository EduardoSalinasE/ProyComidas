package com.example.proy_comidas_ep1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DepartamentosSierraActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamentos_sierra);

        Button mbtnArequipa = findViewById(R.id.btnArequipa);
        mbtnArequipa.setOnClickListener(this);

        Button mbtnCusco = findViewById(R.id.btnCusco);
        mbtnCusco.setOnClickListener(this);

        Button mbtnPuno = findViewById(R.id.btnPuno);
        mbtnPuno.setOnClickListener(this);

        Button mbtnRegresarMain = findViewById(R.id.btnRegresarInicio);
        mbtnRegresarMain.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnArequipa:
                startActivity(new Intent(this, PlatosArequipaActivity.class));
                break;
            case R.id.btnCusco:
                startActivity(new Intent(this, PlatosCuscoActivity.class));
                break;
            case R.id.btnPuno:
                startActivity(new Intent(this, PlatosPunoActivity.class));
                break;
            case R.id.btnRegresarInicio:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}