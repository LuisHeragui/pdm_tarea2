package com.example.tarea2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

public class QuestionsActivity extends Activity {

    //Variables necesarias para habilitar menu
    private String[] mMenuSections;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        setContentView(R.layout.formulario_pagina_1);
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
