/*
 * Class ConnectionActivity
 * Version 0.5
 * 07/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ConnectionActivity extends AppCompatActivity {

    private MyBroadcastReceiver receiver;
    private boolean isReceiverRegistered;

    protected EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button buttonConnect;
        Button buttonVisit;
        receiver = new MyBroadcastReceiver();
        this.registerReceiver(receiver, new IntentFilter(MyBroadcastReceiver.ACTION));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        username.setText("vallovic", TextView.BufferType.EDITABLE);         //TODO: remove this when release
        password.setText("6r654tgiKhxt", TextView.BufferType.EDITABLE);     //TODO: remove this when release

        buttonConnect = findViewById(R.id.buttonConnection);

        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                PostMan.getInstance(context).ConnectToServer(username, password);
            }
        });

        buttonVisit = findViewById(R.id.buttonVisit);

        buttonVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(ConnectionActivity.this, VisitorActivity.class);
                startActivity(intent3);
            }
        });
    }

    protected void VerifyLOGON(){
        Log.d("blabla", "VerifyLOGON : True");

        //todo : si c'est un jury alors selectionner le deuxième intent

        //Intent intent = new Intent(ConnectionActivity.this, MainActivity.class);
        //this.startActivity(intent);

        Intent intent2 = new Intent(ConnectionActivity.this, MainJuryActivity.class);
        this.startActivity(intent2);
    }


    protected void VerifyLOGONFalse(){
        showAlertDialogButtonClicked(this);
    }

    public void showAlertDialogButtonClicked(Context context) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.error_credentials);
        builder.setMessage(R.string.error_credentials_explication);
        // add a button
        builder.setPositiveButton("OK", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
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

    protected class MyBroadcastReceiver extends BroadcastReceiver{
        public static final String ACTION = "com.example.ACTION_SOMETHING";
        @Override
        public void onReceive(Context context, Intent intent) {
            String receiveString = intent.getStringExtra("dataToPass");
            getFromReceiver(receiveString);
        }
    }

    private void getFromReceiver(@Nullable String receiveString) {
        try {
            if (receiveString.equals("VerifyLOGON")) {
                VerifyLOGON();
            } else if (receiveString.equals("VerifyLOGONFalse")){
                VerifyLOGONFalse();
            } else {
                Log.d("blabla", "An error occurs, receiveString not equals to something good");
            }
        } catch (NullPointerException e){
            Log.d("blabla", "Error :" + e.getMessage());
        }
    }

}
