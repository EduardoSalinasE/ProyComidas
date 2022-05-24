package com.example.proy_comidas_ep1;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.proy_comidas_ep1.fragments.CuartoFragmento;
import com.example.proy_comidas_ep1.fragments.PrimerFragmento;
import com.example.proy_comidas_ep1.fragments.SegundoFragmento;
import com.example.proy_comidas_ep1.fragments.TercerFragmento;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    PrimerFragmento primerFragmento = new PrimerFragmento();
    SegundoFragmento segundoFragmento = new SegundoFragmento();
    TercerFragmento tercerFragmento = new TercerFragmento();
    CuartoFragmento cuartoFragmento = new CuartoFragmento();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(primerFragmento);
    }

    private final BottomNavigationView.OnItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.firstFragment:
                    loadFragment(primerFragmento);
                    return true;
                case R.id.secondFragment:
                    loadFragment(segundoFragmento);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(tercerFragmento);
                    return true;
                case R.id.fourthFragment:
                    loadFragment(cuartoFragmento);
                    return true;
            }
            return false;
        }
    };



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

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}