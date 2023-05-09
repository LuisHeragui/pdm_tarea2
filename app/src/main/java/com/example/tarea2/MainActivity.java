package com.example.tarea2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    private String[] mMenuSections;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            Log.d("HomeActivity", (String) parent.getAdapter().getItem(position));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int pantalla = 1;

        if (pantalla == 1) {
            // Pantalla 1
            setContentView(R.layout.formulario_pagina_1);


        } else if (pantalla == 2) {
            // Pantalla 2
            setContentView(R.layout.formulario_pagina_2);

            Spinner spinner = findViewById(R.id.hobby);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.hobbies_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            // Pantalla 3
            setContentView(R.layout.main_layout);

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

            // Set the drawer toggle as the DrawerListener
            mDrawerLayout.addDrawerListener(mDrawerToggle);

            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setHomeButtonEnabled(true);

            Spinner spinner = findViewById(R.id.hobby);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.hobbies_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.fstmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
