/*
 * Class MainActivity
 * Version 0.5
 * 07/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReceiver receiver;
    private boolean isReceiverRegistered;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        receiver = new MyBroadcastReceiver();
        this.registerReceiver(receiver, new IntentFilter(ConnectionActivity.MyBroadcastReceiver.ACTION));
        Context context = getApplicationContext();
        PostMan.getInstance(context).ListofAllProjects();
        super.onCreate(savedInstanceState);

    }


    private void afterOnCreate(){
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_liste_projet, R.id.nav_mes_projets, R.id.nav_agenda,
                R.id.nav_plan, R.id.nav_accueil, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Context context = getApplicationContext();
        changeUserName(context);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isReceiverRegistered) {
            try {
                unregisterReceiver(receiver);
            } catch (IllegalArgumentException e) {
                // Do nothing
            }
            isReceiverRegistered = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isReceiverRegistered) {
            registerReceiver(receiver, new IntentFilter(MyBroadcastReceiver.ACTION));
            isReceiverRegistered = true;
        }
    }

    /**
     * Change the username on the navigation drawer
     * @param context : context of the application
     */
    private void changeUserName(Context context) {
        try {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View v = inflater.inflate(R.layout.nav_header_main, null);
            TextView username = v.findViewById(R.id.nav_header);
            SharedPreferences sharedpreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
            if (sharedpreferences.contains("username")) {
                username.setText(sharedpreferences.getString("username", ""));
            }
        } catch (InflateException e) {
            Log.d("blabla", "InflateException Error : " + e.getMessage());
        }
    }

    public void profilDescription(){
        Intent intent = new Intent(this, ProjetDescriptionActivity.class);
        startActivity(intent);
    }


    protected class MyBroadcastReceiver extends BroadcastReceiver {
        public static final String ACTION = "com.example.ACTION_SOMETHING";
        @Override
        public void onReceive(Context context, Intent intent) {
            String receiveString = intent.getStringExtra("dataToPass");
            getFromReceiver(receiveString);
        }
    }

    private void getFromReceiver(@Nullable String receiveString) {
        try {
            if (receiveString.equals("AllProjects")){
                afterOnCreate();
            } else {
                Log.d("blabla", "An error occurs, receiveString not equals to something good");
            }
        } catch (NullPointerException e){
            Log.d("blabla", "Error :" + e.getMessage());
        }
    }

}
