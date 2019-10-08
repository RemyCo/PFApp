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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectionActivity extends AppCompatActivity {

    protected EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button buttonConnect;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        username.setText("vallovic", TextView.BufferType.EDITABLE);
        password.setText("6r654tgiKhxt", TextView.BufferType.EDITABLE);

        buttonConnect = (Button)findViewById(R.id.buttonConnection);
        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                PostMan.ConnectToServer(username, password, context);
            }
        });
    }

    protected void VerifyLOGON(Context context){
        Intent intent = new Intent(ConnectionActivity.this, MainActivity.class);
        context.startActivity(intent);
    }

    protected void VerifyLOGONFalse(Context context){
        showAlertDialogButtonClicked(findViewById(android.R.id.content), context);
    }

    public void showAlertDialogButtonClicked(View view, Context context) {
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

}
