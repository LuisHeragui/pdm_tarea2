package com.example.tarea2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean verPantalla1 = false;

        if (verPantalla1) {
            // Pantalla 1
            setContentView(R.layout.main_layout);

            Spinner spinner = findViewById(R.id.hobby);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.hobbies_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            // Pantalla 2
            setContentView(R.layout.formulario_pagina_1);
        }
    }
}
