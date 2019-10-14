/*
 * Class PostMan
 * Version 0.5
 * 07/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.pfapp.model.ListOfAllProjects;
import com.example.pfapp.model.ListOfAllUsers;
import com.example.pfapp.model.Project;
import com.example.pfapp.model.Student;
import com.example.pfapp.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

public class PostMan {

    private static PostMan INSTANCE = null;

    private static String responseServer = "";
    private static String IP = "192.168.4.240";

    private static ListOfAllProjects projects = ListOfAllProjects.getInstance();
    private static ListOfAllUsers users = ListOfAllUsers.getInstance();

    private Context context;



    private PostMan(Context context) {
        // Private (Cause we are making a Singleton)
        this.context = context;
    }

    public static synchronized PostMan getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new PostMan(context);
        }
        return(INSTANCE);
    }


    /**
     * LOGON Request
     * @param username : The username of a user
     * @param password : The password of the user
     */
    public void ConnectToServer(final EditText username, final EditText password) {
        String url = "https://" + IP + "/pfe/webservice.php?q=LOGON&user=" + username.getText() + "&pass=" + password.getText();
        GetLOGINRequest(url, username);
    }

    private void LOGONRequest(String response, EditText username){
        Intent intent = new Intent();
        intent.setAction(ConnectionActivity.MyBroadcastReceiver.ACTION);
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                SharedPreferences pref = context.getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("username", "" + username.getText()); // Storing username
                editor.putString("token", jsonObj.getString("token")); // Storing token
                editor.apply();
                intent.putExtra("dataToPass", "VerifyLOGON");

            } else {
                Log.d("blabla", "Error on Credentials");
                intent.putExtra("dataToPass", "VerifyLOGONFalse");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
            intent.putExtra("dataToPass", "VerifyLOGONFalse");
        }
        context.sendBroadcast(intent);
    }

    /**
     * LIPRJ Request
     */
    public void ListofAllProjects() {
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=LIPRJ&user=" + username + "&token=" + token;
        GetRequest(url, "LIPRJ");
    }

    private void LIPRJRequest(String response){
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                JSONArray jArray = jsonObj.getJSONArray("projects");
                for(int i=0; i<jArray.length(); i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    if (!projects.projectIdExists(json_data.getInt("projectId"))){
                        JSONObject supervisorJson = json_data.getJSONObject("supervisor");
                        User supervisor;
                        if(!users.userNameExists(supervisorJson.getString("forename"), supervisorJson.getString("surname"))){
                            supervisor = new User(supervisorJson.getString("forename"), supervisorJson.getString("surname"));
                            users.addUser(supervisor);
                        } else {
                            supervisor = users.getUser(users.userNameExistIndex(supervisorJson.getString("forename"), supervisorJson.getString("surname")));
                        }
                        JSONArray studentsJson = json_data.getJSONArray("students");
                        ArrayList<Student> students = new ArrayList<>();
                        Student student;
                        for(int j=0; j<studentsJson.length(); j++){
                            JSONObject json_student_data = studentsJson.getJSONObject(j);
                            if(!users.userNameExists(json_student_data.getString("forename"), json_student_data.getString("surname"))){
                                student = new Student(json_student_data.getInt("userId"), json_student_data.getString("forename"), json_student_data.getString("surname"));
                                users.addUser(student);
                                students.add(student);
                            } else {
                                supervisor = users.getUser(users.userNameExistIndex(supervisorJson.getString("forename"), supervisorJson.getString("surname")));
                            }
                        }
                        Project myProject = new Project(
                                json_data.getInt("projectId"),
                                json_data.getString("title"),
                                json_data.getString("descrip"),
                                json_data.getString("confid"),
                                supervisor,
                                students
                        );
                        projects.addProject(myProject);
                    }
                }
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error : " + e.getMessage());
        }
    }


    /**
     * MYPRJ Request
     */
    public void ListofAllProjectsUser() {
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=MYPRJ&user=" + username + "&token=" + token;
        GetRequest(url,"MYPRJ");
    }

    private void MYPRJRequest (String response){
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here MYPRJ Request
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
    }

    /**
     * LIJUR Request
     */
    public void ListofAllJuries() {
        boolean isDoneWithoutError = false;
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=LIJUR&user=" + username + "&token=" + token;
        GetRequest(url, "LIJUR");
    }

    private void LIJURRequest (String response){
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here MYPRJ Request
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
    }


    /**
     * MYJUR Request
     */
    public void ListofAllProjectsJuriesUser() {
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=MYJUR&user=" + username + "&token=" + token;
        GetRequest(url, "MYJUR");
    }



    private void MYJURRequest (String response){
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here MYPRJ Request
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
    }


    /**
     * JYINF Request
     */
    public void ListofAllJuryMember(int jury) {
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=JYINF&user=" + username + "&jury=" + jury  + "&token=" + token;
        GetRequest(url, "JYINF");
    }



    private void JYINFRequest (String response){
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here MYPRJ Request
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
    }

    protected enum posterSize {FULL, THUMB, FLB64, THB64};

    /**
     * POSTR Request
     * @param proj : id of the project
     */
    public void poster (int proj) {
        poster(proj, posterSize.FULL);
    }

    /**
     * POSTR Request
     * @param proj : id of the project
     * @param style : Size of the image
     */
    public void poster (int proj, posterSize style) {
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=POSTR&user=" + username + "&proj=" +
                proj + "&style=" + style + "&token=" + token;
        GetRequest(url, "POSTR");
    }



    private void POSTRRequest (String response){
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here MYPRJ Request
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
    }


    /**
     * NOTES Request
     * @param proj : id of the project
     */
    public void ListofNotesProjectMember(int proj) {
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=NOTES&user=" + username + "&proj=" + proj + "&token=" + token;
        GetRequest(url, "NOTES");
    }

    private void NOTESRequest (String response){
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here MYPRJ Request
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
    }


    /**
     * NEWNT Request
     * @param proj : id of the project
     * @param student : id of the student
     * @param note : note that would be given to the student
     */
    public void UpdateNote(int proj, int student, int note) {
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=NEWT&user=" + username + "&proj=" +
                proj + "&student=" + student + "&note=" + note + "&token=" + token;
        String response = PostRequest(url);
    }

    private void NEWNTRequest (String response){
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here NEWNT Request
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
    }

    /**
     * PORTE Request
     */
    public void RandomProjects() {
        RandomProjects("NONE");
    }


    /**
     * PORTE Request (a list of up to five maximum random, non confidential projects that have a poster)
     * @param seed : parameter that can be used to guarantee that the same random projects are chosen each time
     */
    public void RandomProjects(String seed) {
        String username = GetSharedPreferences("username", context);
        String token = GetSharedPreferences("token", context);
        String url = "https://" + IP + "/pfe/webservice.php?q=PORTE&user=" + username + "&seed=" + seed + "&token=" + token;
        GetRequest(url, "PORTE");
    }

    private void PORTERequest (String response){
        try {
            JSONObject jsonObj = new JSONObject(response);
            if  (!jsonObj.has("error")){
                //TODO: Developp here MYPRJ Request
            } else {
                Log.d("blabla", "Error on Credentials");
            }
        } catch (JSONException e) {
            Log.d("blabla", "JSONException Error :" + e.getMessage());
        }
    }


    /**
     * Used to gat the sharedPreference
     * @param GetSharedPref : the SharePref that we want to get
     * @param context : context of the application
     * @return the sharedPreference
     */
    private String GetSharedPreferences(String GetSharedPref, Context context){
        String mySharePreferenceThing = "";
        SharedPreferences sharedpreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if (sharedpreferences.contains(GetSharedPref)) {
            mySharePreferenceThing = sharedpreferences.getString(GetSharedPref, "");
        }
        return mySharePreferenceThing;
    }

    /**
     * Is used to make a GET request on server
     * @param url : url of the request on the server
     */
    private void GetLOGINRequest(String url, final EditText username){
        //TODO: Absolutely change that (because it's a very important security issue) :
        trustEveryone();
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                LOGONRequest(response, username);
                }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("blabla", "Not Working");
            }
        });

        // Add the request to the RequestQueue.
        RequestQueueSingleton.getInstance(context).addToRequestQueue(stringRequest);
    }


    /**
     * Is used to make a GET request on server
     * @param url : url of the request on the server
     */
    private void GetRequest(String url, final String request){
        //TODO: Absolutely change that (because it's a very important security issue) :
        trustEveryone();
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        switch(request){
                            case "LIPRJ":
                                LIPRJRequest(response);
                            case "MYPRJ":
                                MYPRJRequest(response);
                            case "LIJUR":
                                LIJURRequest(response);
                            case "MYJUR":
                                MYJURRequest(response);
                            case "JYINF":
                                JYINFRequest(response);
                            case "POSTR":
                                POSTRRequest(response);
                            case "NOTES":
                                NOTESRequest(response);
                            case "NEWNT":
                                NEWNTRequest(response);
                            case "PORTE":
                                PORTERequest(response);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("blabla", "Not Working");
            }
        });

        // Add the request to the RequestQueue.
        RequestQueueSingleton.getInstance(context).addToRequestQueue(stringRequest);
    }


    /**
     * Post Request
     * @param url : url of the request
     * @return String
     */
    private static String PostRequest(String url){
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

