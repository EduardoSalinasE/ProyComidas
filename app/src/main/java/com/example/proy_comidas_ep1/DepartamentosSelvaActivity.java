package com.example.proy_comidas_ep1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DepartamentosSelvaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamentos_selva);

        Button mbtnLoreto = findViewById(R.id.btnLoreto);
        mbtnLoreto.setOnClickListener(this);

        Button mbtnUcayali = findViewById(R.id.btnUcayali);
        mbtnUcayali.setOnClickListener(this);

        Button mbtnRegresarMain = findViewById(R.id.btnRegresarInicio);
        mbtnRegresarMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnLoreto:
                startActivity(new Intent(this, PlatosLoretoActivity.class));
                break;
            case R.id.btnUcayali:
                startActivity(new Intent(this, PlatosUcayaliActivity.class));
                break;
            case R.id.btnRegresarInicio:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}