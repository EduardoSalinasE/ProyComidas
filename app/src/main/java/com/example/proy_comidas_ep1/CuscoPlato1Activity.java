package com.example.proy_comidas_ep1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CuscoPlato1Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cusco_plato1);

        Button mbtnRegresarPlatos2 = findViewById(R.id.button4);
        mbtnRegresarPlatos2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, PlatosCuscoActivity.class));
    }
}