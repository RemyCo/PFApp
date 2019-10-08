/*
 * Class ConnectionActivity
 * Version 0.5
 * 07/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ConnectionActivity extends AppCompatActivity {

    protected EditText username;
    protected String token;
    private Button buttonConnect;

    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        buttonConnect = (Button)findViewById(R.id.buttonConnection);

        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Change that, because it has no sense to do that here : for testing only

                Context context = getApplicationContext();

                boolean connected = PostMan.ConnectToServer(username, password, context);
                if (connected) {
                    Intent intent = new Intent(ConnectionActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    showAlertDialogButtonClicked(findViewById(android.R.id.content));
                }
            }
        });
    }

    public void showAlertDialogButtonClicked(View view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.error_credentials);
        builder.setMessage(R.string.error_credentials_explication);
        // add a button
        builder.setPositiveButton("OK", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
