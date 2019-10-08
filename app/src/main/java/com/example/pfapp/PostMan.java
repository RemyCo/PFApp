/*
 * Class PostMan
 * Version 0.5
 * 07/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;

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
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

public abstract class PostMan extends Application {

    private static String responseServer = "not_receiving";
    private static String IP = "192.168.4.240";

    private static RequestQueue queue;

    /**
     * LOGON Request
     * @param username : The username of a user
     * @param password : The password of the user
     * @param context : The context of the application
     * @return true if connected, false otherwise
     */
    public static boolean ConnectToServer(final EditText username, final EditText password, Context context) {
        String url = "https://" + IP + "/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        queue = Volley.newRequestQueue(context);
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
     * @param context : context of the application
     * @return List of all projects
     */
    public static boolean ListofAllProjects(Context context) {
        boolean isDoneWithoutError = false;
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=LIPRJ&user=" + username + "&token=" + token;
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here LIPRJ Request
                JSONArray jArray = jsonObj.getJSONArray("projects");
                isDoneWithoutError = true;
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return isDoneWithoutError;
    }


    /**
     * MYPRJ Request
     * @param context : context of the application
     * @return a list of all the projects where the user is the supervisor
     */
    public static boolean ListofAllProjectsUser(Context context) {
        boolean isDoneWithoutError = false;
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=MYPRJ&user=" + username + "&token=" + token;
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here MYPRJ Request
                isDoneWithoutError = true;
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return isDoneWithoutError;
    }

    /**
     * LIJUR Request
     * @param context : context of the application
     * @return a list of all the juries
     */
    public static boolean ListofAllJuries(Context context) {
        boolean isDoneWithoutError = false;
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=LIJUR&user=" + username + "&token=" + token;
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here LIJUR Request
                isDoneWithoutError = true;
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return isDoneWithoutError;
    }


    /**
     * MYJUR Request
     * @param context : context of the application
     * @return a list of all the juries where the user is a member of the jury
     */
    public static boolean ListofAllProjectsJuriesUser(Context context) {
        boolean isDoneWithoutError = false;
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=MYJUR&user=" + username + "&token=" + token;
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here MYJUR Request
                isDoneWithoutError = true;
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return isDoneWithoutError;
    }


    /**
     * JYINF Request
     * @param context : context of the application
     * @return a list of all the projects which are assessed by the Jury if and only if the identified user is a member of the jury
     */
    public static boolean ListofAllJuryMember(Context context, int jury) {
        boolean isDoneWithoutError = false;
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=JYINF&user=" + username + "&jury=" + jury  + "&token=" + token;
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here JYINF Request
                isDoneWithoutError = true;
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return isDoneWithoutError;
    }

    protected enum posterSize {FULL, THUMB, FLB64, THB64};

    /**
     * POSTR Request
     * @param context : context of the application
     * @param proj : id of the project
     * @return a PNG image of the poster
     */
    public static boolean poster (Context context, int proj) {
        return poster(context, proj, posterSize.FULL);
    }

    /**
     * POSTR Request
     * @param context : context of the application
     * @param proj : id of the project
     * @param style : Size of the image
     * @return a PNG image of the poster
     */
    public static boolean poster (Context context, int proj, posterSize style) {
        boolean isDoneWithoutError = false;
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=POSTR&user=" + username + "&proj=" +
                proj + "&style=" + style + "&token=" + token;
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here POSTR Request
                isDoneWithoutError = true;
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return isDoneWithoutError;
    }


    /**
     * NOTES Request
     * @param context : context of the application
     * @param proj : id of the project
     * @return a list of the team members for the given project, with their average note and the note given by the given user
     */
    public static boolean ListofNotesProjectMember(Context context, int proj) {
        boolean isDoneWithoutError = false;
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=NOTES&user=" + username + "&proj=" + proj + "&token=" + token;
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here NOTES Request
                isDoneWithoutError = true;
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return isDoneWithoutError;
    }


    /**
     * NEWNT Request
     * @param context : context of the application
     * @param proj : id of the project
     * @param student : id of the student
     * @param note : note that would be given to the student
     * @return true if the note have been change on the website
     */
    public static boolean UpdateNote(Context context, int proj, int student, int note) {
        boolean isDoneWithoutError = false;
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=NEWT&user=" + username + "&proj=" +
                proj + "&student=" + student + "&note=" + note + "&token=" + token;
        String response = PostRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if (!jsonObj.has("error")){
                //TODO: Developp here NEWNT Request
                isDoneWithoutError = true;
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return isDoneWithoutError;
    }

    /**
     * PORTE Request
     * @param context : context of the application
     * @return a list of up to five maximum random, non confidential projects that have a poster
     */
    public static boolean RandomProjects(Context context) {
        return RandomProjects(context, "NONE");
    }


    /**
     * PORTE Request
     * @param context : context of the application
     * @param seed : parameter that can be used to guarantee that the same random projects are chosen each time
     * @return a list of up to five maximum random, non confidential projects that have a poster
     */
    public static boolean RandomProjects(Context context, String seed) {
        boolean isDoneWithoutError = false;
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=PORTE&user=" + username + "&seed=" + seed + "&token=" + token;
        String response = GetRequest(url, queue);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here PORTE Request
                isDoneWithoutError = true;
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
        return isDoneWithoutError;
    }


    /**
     * Used to gat the sharedPreference
     * @param GetSharedPref : the SharePref that we want to get
     * @param context : context of the application
     * @return the sharedPreference
     */
    private static String GetSharedPreferences (String GetSharedPref, Context context){
        String mySharePreferenceThing = "";
        SharedPreferences sharedpreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if (sharedpreferences.contains(GetSharedPref)) {
            mySharePreferenceThing = sharedpreferences.getString("username", "");
        }
        return mySharePreferenceThing;
    }

    /**
     * Is used to make a GET request on server
     * @param url : url of the server
     * @param queue : the queue for the request
     * @return the result of the request as a String
     */
    private static String GetRequest(String url, RequestQueue queue){
        //TODO: Absolutely change that (because it's a very important security issue) :
        trustEveryone();
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
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


    /**
     * Post Request
     * @param url
     * @param queue
     * @return
     */
    private static String PostRequest(String url, RequestQueue queue){
        /*
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://...";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("Title", "Android Volley Demo");
            jsonBody.put("Author", "BNK");
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
         */
        return null;
    }

    /**
     * Class TrustEveryone
     *
     * Class that have to change, because for now it trust all certificates, so it is a major security problem
     */
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

