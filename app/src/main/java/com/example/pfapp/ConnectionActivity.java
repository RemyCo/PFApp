package com.example.pfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ConnectionActivity extends AppCompatActivity {

    protected EditText username;
    protected String token;
    private Button buttonConnect;
    private static EditText ipServer;
    boolean bool = false;

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
                boolean connected = ConnectToServer(username, password);
                if (connected) {
                    Intent intent = new Intent(ConnectionActivity.this, MainActivity.class);
                }
            }
        });
    }


    boolean ConnectToServer(EditText username, EditText password){
        final TextView request = (TextView)findViewById(R.id.request);
        String url ="https://192.168.4.240/pfe/webservice.php?q=LOGON&user=vallovic&pass=6r654tgiKhxt";
        RequestQueue queue = Volley.newRequestQueue(this);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        request.setText("Response is: "+ response.substring(0,500));
                        bool = true;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("blabla", "Not Working");
                request.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
        return bool;
    }

}
