package com.example.tarea2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class QuestionsActivity extends AppCompatActivity {

    //Variables necesarias para habilitar menu
    private String[] mMenuSections;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    //Variables para manejar elementos en layout
    private EditText q1Field;
    private EditText q2Field;
    private RadioGroup q3Field;
    private ToggleButton q4Field;
    private EditText q5Field;
    private Button sendBtn;

    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            Log.d("QuestionsActivity", (String) parent.getAdapter().getItem(position));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        //Mostramos el layout
        setContentView(R.layout.formulario_pagina_1);

        //Creamos el menu
        mMenuSections = getResources().getStringArray(R.array.menu_items);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.left_drawer, mMenuSections));

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.action_accept,
                R.string.action_cancel
        ) {
            public void onDrawerClosed(View view) {
                Log.d("HomeActivity", "onDrawerClosed");
            }

            public void onDrawerOpened(View drawerView) {
                Log.d("HomeActivity", "onDrawerOpened");
            }
        };

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        //Establecemos un 'listener' para el menu izquierdo
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);

        //Manejamos la lógica de esta actividad
        q1Field = (EditText) findViewById(R.id.q1);
        q2Field = (EditText) findViewById(R.id.q2);
        q3Field = (RadioGroup) findViewById(R.id.q3);
        q4Field = (ToggleButton) findViewById(R.id.q4);
        q5Field = (EditText) findViewById(R.id.q5);
        sendBtn = (Button) findViewById(R.id.envio);

        //Cuando clickeamos el boton enviar
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q1 = q1Field.getText().toString();
                String q2 = q2Field.getText().toString();
                int q3Id = q3Field.getCheckedRadioButtonId();
                String q4 = q4Field.getText().toString();
                String q5 = q5Field.getText().toString();



                if(TextUtils.isEmpty(q1)){
                    Toast.makeText(getApplicationContext(), "Contesta la pregunta 1", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(q2)) {
                    Toast.makeText(getApplicationContext(), "Contesta la pregunta 2", Toast.LENGTH_LONG).show();
                }else if (q3Id == -1) {
                    Toast.makeText(getApplicationContext(), "Contesta la pregunta 3", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(q5)) {
                    Toast.makeText(getApplicationContext(), "Contesta la pregunta 5", Toast.LENGTH_LONG).show();
                } else {
                    String q3 = ((RadioButton) findViewById(q3Id)).getText().toString();
                    Intent fromMainActivity = getIntent();
                    String user = fromMainActivity.getStringExtra("user");
                    String phone = fromMainActivity.getStringExtra("phone");
                    String hobby = fromMainActivity.getStringExtra("hobby");

                    //Juntamos toda la información en Questionary
                    Questionary entry = new Questionary(user, phone, hobby, q1, q2, q3, q4, q5);

                    Toast.makeText(getApplicationContext(), String.format("Gracias %s por Contestar la Encuesta :)", user), Toast.LENGTH_LONG).show();
                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.fstmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings :
                Log.d("QuestionsActivity", "action_settings");
                return true;
            case R.id.action_help :
                Log.d("QuestionsActivity", "action_help");
                return true;
            case R.id.action_bug :
                Log.d("QuestionsActivity", "action_bug");
                return true;
            case R.id.action_share :
                Log.d("QuestionsActivity", "action_share");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
