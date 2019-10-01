package com.example.pfapp;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

public abstract class PostMan extends Application {

    private static String responseServer = "";


    /**
     * LOGON Request
     * @param username
     * @param password
     * @param context
     * @return
     */
    public static boolean ConnectToServer(final EditText username, final EditText password, Context context) {
        String url = "https://192.168.4.240/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        RequestQueue queue = Volley.newRequestQueue(context);
        String response = GetRequest(url, queue);
        boolean connected = false;
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                String token = jsonObj.getString("token");
                SharedPreferences pref = context.getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("username", "" + username.getText()); // Storing username
                editor.putString("token", token); // Storing token
                editor.apply();
                connected = true;
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return connected;
    }

    /**
     * LIPRJ Request
     * @param username
     * @param password
     * @param context
     * @return
     */
    public static List ListofAllProjects(final EditText username, final EditText password, Context context) {
        List list = new ArrayList();
        String url = "https://192.168.4.240/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        RequestQueue queue = Volley.newRequestQueue(context);
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){

            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return list;
    }


    /**
     * MYPRJ Request
     * @param username
     * @param password
     * @param context
     * @return
     */
    public static List ListofAllProjectsUser(final EditText username, final EditText password, Context context) {
        List list = new ArrayList();
        String url = "https://192.168.4.240/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        RequestQueue queue = Volley.newRequestQueue(context);
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){

            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return list;
    }

    /**
     * LIJUR Request
     * @param username
     * @param password
     * @param context
     * @return
     */
    public static List ListofAllJuries(final EditText username, final EditText password, Context context) {
        List list = new ArrayList();
        String url = "https://192.168.4.240/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        RequestQueue queue = Volley.newRequestQueue(context);
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){

            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return list;
    }


    /**
     * MYJUR Request
     * @param username
     * @param password
     * @param context
     * @return
     */
    public static List ListofAllProjectsJuriesUser(final EditText username, final EditText password, Context context) {
        List list = new ArrayList();
        String url = "https://192.168.4.240/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        RequestQueue queue = Volley.newRequestQueue(context);
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){

            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return list;
    }


    /**
     * JYINF Request
     * @param username
     * @param password
     * @param context
     * @return
     */
    public static List ListofAllJuryMember(final EditText username, final EditText password, Context context) {
        List list = new ArrayList();
        String url = "https://192.168.4.240/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        RequestQueue queue = Volley.newRequestQueue(context);
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){

            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return list;
    }



    /**
     * POSTR Request
     * @param username
     * @param password
     * @param context
     * @return
     */
    public static boolean poster (final EditText username, final EditText password, Context context) {
        List list = new ArrayList();
        String url = "https://192.168.4.240/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        RequestQueue queue = Volley.newRequestQueue(context);
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){

            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return true;
    }


    /**
     * NOTES Request
     * @param username
     * @param password
     * @param context
     * @return
     */
    public static List ListofNotesProjectMember(final EditText username, final EditText password, Context context) {
        List list = new ArrayList();
        String url = "https://192.168.4.240/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        RequestQueue queue = Volley.newRequestQueue(context);
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){

            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return list;
    }


    /**
     * NEWNT Request
     * @param username
     * @param password
     * @param context
     * @return
     */
    public static boolean UpdateNote(final EditText username, final EditText password, Context context) {
        String url = "https://192.168.4.240/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        RequestQueue queue = Volley.newRequestQueue(context);
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){

            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return true;
    }


    /**
     * PORTE Request
     * @param username
     * @param password
     * @param context
     * @return
     */
    public static List RandomProjects(final EditText username, final EditText password, Context context) {
        List list = new ArrayList();
        String url = "https://192.168.4.240/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        RequestQueue queue = Volley.newRequestQueue(context);
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){

            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return list;
    }
















    private static String GetRequest(String url, RequestQueue queue){
        //TODO: Absolutely change that (because it's a very important security issue) :
        trustEveryone();
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        responseServer = response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("blabla", "Not Working");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
        return responseServer;
    }


    private static void trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(
                    context.getSocketFactory());
        } catch (Exception e) { // should never happen
            e.printStackTrace();
        }
    }
}

