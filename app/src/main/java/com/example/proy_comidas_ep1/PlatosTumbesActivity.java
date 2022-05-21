package com.example.proy_comidas_ep1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlatosTumbesActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos_tumbes);

        Button mbtnRegresar = findViewById(R.id.btnRegresarMain);
        mbtnRegresar.setOnClickListener(this);

        Button mbtnPlato1 = findViewById(R.id.button);
        mbtnPlato1.setOnClickListener(this);

        Button mbtnPlato2 = findViewById(R.id.button2);
        mbtnPlato2.setOnClickListener(this);

        Button mbtnPlato3 = findViewById(R.id.button3);
        mbtnPlato3.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegresarMain:
                startActivity(new Intent(this, DepartamentosCostaActivity.class));
                break;
            case R.id.button:
                startActivity(new Intent(this, TumbesPlato1Activity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, TumbesPlato2Activity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, TumbesPlato3Activity.class));
                break;
        }
    }
}