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
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainJuryActivity extends AppCompatActivity{

    private MyBroadcastReceiver receiver;
    private boolean isReceiverRegistered;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        receiver = new MyBroadcastReceiver();
        this.registerReceiver(receiver, new IntentFilter(ConnectionActivity.MyBroadcastReceiver.ACTION));
        Context context = getApplicationContext();
        PostMan.getInstance(context).ListofAllProjects();
        Log.i("test", "onCreate: 1");
        super.onCreate(savedInstanceState);
    }

    private void afterOnCreate(){
        Log.i("test", "onCreate: 2");
        setContentView(R.layout.activity_jury_main);
        Toolbar toolbar = findViewById(R.id.toolbarJury);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_jury_layout);
        NavigationView navigationView = findViewById(R.id.nav_jury_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_liste_projet, R.id.nav_mes_jurys, R.id.nav_agenda,
                R.id.nav_plan, R.id.nav_accueil, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_jury_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        Log.i("test", "onCreate: 3");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_jury_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Context context = getApplicationContext();
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
            } else if (receiveString.equals("myProjects")){
                Log.d("blabla", "myProjects");
            } else {
                Log.d("blabla", "An error occurs, receiveString not equals to something good");
            }
        } catch (NullPointerException e){
            Log.d("blabla", "Error :" + e.getMessage());
        }
    }

}
