package com.example.tarea2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    //Variables necesarias para habilitar menu
    private String[] mMenuSections;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    //Variables para identificar elementos de MainLayout
    private EditText userNameField;
    private EditText phoneField;
    private Spinner hobbyField;
    private Button acceptBtn;
    private Button cancelBtn;
    private CheckBox tyC;



    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            Log.d("HomeActivity", (String) parent.getAdapter().getItem(position));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pantalla Principal
        setContentView(R.layout.main_layout);

        //Declaramos el la lista desplegables de hobbies
        Spinner spinner = findViewById(R.id.hobby);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hobbies_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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


        //Recopilamos informacion y pasamos a la siguiente actividad
        userNameField = (EditText) findViewById(R.id.username);
        phoneField = (EditText) findViewById(R.id.phone);
        hobbyField = (Spinner) findViewById(R.id.hobby);
        acceptBtn = (Button) findViewById(R.id.accept);
        cancelBtn = (Button) findViewById(R.id.cancel);
        tyC = (CheckBox) findViewById(R.id.tyc);

        //Agregamos el comportamiento para cancelBtn
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNameField.getText().clear();
                phoneField.getText().clear();
                spinner.setSelection(0);
                tyC.setChecked(false);
            }
        });

        //Agregamos comportamiento para acceptBtn
        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userNameField.getText().toString();
                String phone = phoneField.getText().toString();
                String hobby = hobbyField.getTransitionName();

                if (!(tyC.isChecked())){
                    Toast.makeText(getApplicationContext(), "Necesitas aceptar TyC", Toast.LENGTH_LONG).show();
                } else if (phone.length() != 10) {
                    Toast.makeText(getApplicationContext(), "Introduce un teléfono a 10 dígitos.", Toast.LENGTH_LONG).show();
                } else {
                    Intent goToQActivity = new Intent(MainActivity.this, QuestionsActivity.class);
                    goToQActivity.putExtra("user", user);
                    goToQActivity.putExtra("phone", phone);
                    goToQActivity.putExtra("hobby", hobby);

                    startActivity(goToQActivity);
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
                Log.d("HomeActivity", "action_settings");
                return true;
            case R.id.action_help :
                Log.d("HomeActivity", "action_help");
                return true;
            case R.id.action_bug :
                Log.d("HomeActivity", "action_bug");
                return true;
            case R.id.action_share :
                Log.d("HomeActivity", "action_share");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
