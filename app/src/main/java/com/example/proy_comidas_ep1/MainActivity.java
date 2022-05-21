package com.example.proy_comidas_ep1;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_departamentos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.departamentos_costa:
                mostrarDepartamentosCosta();
                return true;
            case R.id.departamentos_sierra:
                mostrarDepartamentosSierra();
                return true;
            case R.id.departamentos_selva:
                mostrarDepartamentosSelva();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void mostrarDepartamentosCosta() {
        startActivity(new Intent(this, DepartamentosCostaActivity.class));
    }

    private void mostrarDepartamentosSierra() {
        startActivity(new Intent(this, DepartamentosSierraActivity.class));
    }

    private void mostrarDepartamentosSelva() {
        startActivity(new Intent(this, DepartamentosSelvaActivity.class));
    }
}